import java.util.Scanner;
import java.io.File;

public class AlocadorBuddy {
    private NoArvore raiz;
    private ListaEncadeada[] listasLivres;
    private FilaPendentes filaPendentes;
    private PilhaHistorico pilhaUndo;
    
    private final int memoriaTotalKB = 32768;
    private final int buddyMinimoKB = 4;
    private final int totalNiveis;
    
    public AlocadorBuddy() {
        int niveis = 0;
        int tam = buddyMinimoKB;

        while (tam <= memoriaTotalKB) {
            niveis++; 
            tam *= 2; 
        }

        totalNiveis = niveis;
        listasLivres = new ListaEncadeada[totalNiveis];

        for (int i = 0; i < totalNiveis; i++) {
            listasLivres[i] = new ListaEncadeada();
        }
        raiz = new NoArvore(memoriaTotalKB);
        listasLivres[tamanhoParaIndice(memoriaTotalKB)].inserirInicio(raiz);
        filaPendentes = new FilaPendentes();
        pilhaUndo = new PilhaHistorico();
    }
    
    private int tamanhoParaIndice(int tamKB) {
        int indice = 0;
        int tamanho = buddyMinimoKB;
        while (tamanho < tamKB) {
            tamanho *= 2;
            indice++;
        }
        if (tamanho == tamKB && indice < totalNiveis) {
            return indice;
        }
        return -1;
    }
    
    private int proximaPotenciaDe2(int tamKB) {
        int tamanho = buddyMinimoKB;

        while (tamanho < tamKB) {
            tamanho *= 2;
        }
        return tamanho;
    }
    
    private NoArvore buscarNoPorId(NoArvore no, String id) {
        if (no == null) {
            return null;
        }

        if (no.estaOcupado() && id.equals(no.getId())) {
            return no;
        }
        
        NoArvore encontrado = buscarNoPorId(no.getEsquerdo(), id);

        if (encontrado != null) {
            return encontrado;
        }

        return buscarNoPorId(no.getDireito(), id);
    }
    
    private NoArvore split(NoArvore no, int tamanhoDesejado) {
        if (no.getTamanhoKB() == tamanhoDesejado) {
            return no;
        }

        int tamanhoMetade = no.getTamanhoKB() / 2;
        NoArvore noEsquerdo = new NoArvore(tamanhoMetade);
        NoArvore noDireito = new NoArvore(tamanhoMetade);
        noEsquerdo.setPai(no); 
        noDireito.setPai(no);
        no.setEstado(NoArvore.DIVIDIDO);
        no.setEsquerdo(noEsquerdo);
        no.setDireito(noDireito);
        listasLivres[tamanhoParaIndice(tamanhoMetade)].inserirInicio(noDireito);

        return split(noEsquerdo, tamanhoDesejado);
    }
    
    private void merge(NoArvore no) {
        NoArvore noPai = no.getPai();

        if (noPai == null) {
            return;
        }

        NoArvore buddy;

        if (noPai.getEsquerdo() == no) {
            buddy = noPai.getDireito();

        } else {
            buddy = noPai.getEsquerdo();
        }

        if (buddy != null && buddy.estaLivre() && buddy.ehFolha()) {

            int indice = tamanhoParaIndice(no.getTamanhoKB());
            listasLivres[indice].remover(no);
            listasLivres[indice].remover(buddy);
            noPai.setEstado(NoArvore.LIVRE);
            noPai.setId(null);
            noPai.setEsquerdo(null);
            noPai.setDireito(null);
            listasLivres[tamanhoParaIndice(noPai.getTamanhoKB())].inserirInicio(noPai);
            merge(noPai);
        }
    }
    
    private boolean tentarAlocar(String id, int tamanhoSolicitado, boolean regUndo) {
        if (buscarNoPorId(raiz, id) != null) {
            return false;
        }
        int tamanhoAlocado = proximaPotenciaDe2(tamanhoSolicitado);

        if (tamanhoAlocado > memoriaTotalKB) {
            return false;
        }
        int indiceLista = tamanhoParaIndice(tamanhoAlocado);

        for (int i = indiceLista; i < totalNiveis; i++) {
            if (!listasLivres[i].estaVazia()) {
                NoArvore bloco = listasLivres[i].removerPrimeiro();

                if (bloco.getTamanhoKB() > tamanhoAlocado) {
                    bloco = split(bloco, tamanhoAlocado);
                }
                bloco.setEstado(NoArvore.OCUPADO);
                bloco.setId(id);

                if (regUndo) {
                    pilhaUndo.empilhar("ALOCAR", id, tamanhoAlocado);
                }
                return true;
            }
        }

        return false;
    }
    
    public boolean alocar(String id, int tamanhoKB) {
        boolean sucesso = tentarAlocar(id, tamanhoKB, true);

        if (!sucesso) {
            int tamReal = proximaPotenciaDe2(tamanhoKB);

            if (buscarNoPorId(raiz, id) == null && tamReal <= memoriaTotalKB) {
                if (filaPendentes.contem(id)) {
                    System.out.println("ID " + id + " já está pendente na fila");
                } else {
                    filaPendentes.enfileirar(id, tamReal);
                }
            }
        }

        return sucesso;
    }
   
    public boolean liberar(String id) {
        boolean resultado = liberar(id, true);
        return resultado;
    }
    
    private boolean liberar(String id, boolean regUndo) {
        NoArvore no = buscarNoPorId(raiz, id);

        if (no == null) {
            return false;
        }
        int tam = no.getTamanhoKB();
        no.setEstado(NoArvore.LIVRE);
        no.setId(null);
        listasLivres[tamanhoParaIndice(tam)].inserirInicio(no);
        merge(no);
        processarFila();

        if (regUndo) {
            pilhaUndo.empilhar("LIBERAR", id, tam);
        }
        return true;
    }
    
    private void processarFila() {
        int tamanhoOriginal = filaPendentes.getTamanho();

        for (int i = 0; i < tamanhoOriginal; i++) {
            NoFila req = filaPendentes.desenfileirar();

            if (req == null) {
                continue;
            }
            if (buscarNoPorId(raiz, req.getId()) != null) {
                continue;
            }
            boolean sucesso = tentarAlocar(req.getId(), req.getTamanhoKB(), false);

            if (!sucesso) {
                filaPendentes.enfileirar(req.getId(), req.getTamanhoKB());
            }
        }
    }

    public boolean desfazer() {
        if (pilhaUndo.estaVazia()) {
            return false;
        }
        NoPilha ultimo = pilhaUndo.desempilhar();

        if (ultimo.getTipo().equals("ALOCAR")) {
            boolean resultado = liberar(ultimo.getId(), false);
            return resultado;
        } else if (ultimo.getTipo().equals("LIBERAR")) {
            boolean sucesso = tentarAlocar(ultimo.getId(), ultimo.getTamanhoKB(), false);

            if (!sucesso) {
                pilhaUndo.empilhar(ultimo.getTipo(), ultimo.getId(), ultimo.getTamanhoKB());
                System.out.println("Memória insuficiente");
            }
            return sucesso;
        }

        return false;
    }
    
    public void exibirArvore() {
        System.out.println("\n\n=== Árvore Buddy ===\n");
        exibirArvoreRec(raiz, 0);
    }
    
    private void exibirArvoreRec(NoArvore no, int nivel) {
        if (no == null) {
            return;
        }

        for (int i = 0; i < nivel; i++) {
            System.out.print("  ");
        }
        String estado;

        if (no.estaLivre()) {
            estado = "LIVRE";
        } else if (no.estaOcupado()) {
            estado = "OCUPADO(" + no.getId() + ")";
        } else {
            estado = "DIVIDIDO";
        }
        System.out.println(no.getTamanhoKB() + "KB [" + estado + "]");
        exibirArvoreRec(no.getEsquerdo(), nivel + 1);
        exibirArvoreRec(no.getDireito(), nivel + 1);
    }
    
    public void exibirFila() {
        System.out.println("\n\n=== Fila de pendentes ===\n");
        filaPendentes.imprimir();
    }
    
    public void exibirListasLivres() {
        System.out.println("\n\n=== Listas de blocos livres ===\n");
        int tamanhoAtual = buddyMinimoKB;
        for (int i = 0; i < totalNiveis; i++) {
            System.out.printf("%4dKB: %d blocos livres%n", tamanhoAtual, listasLivres[i].tamanho());
            tamanhoAtual *= 2;
        }
    }
    
    public void carregarDataset(String caminho) {

        try (Scanner scanner = new Scanner(new File(caminho))) {
            int numeroLinha = 0;

            while (scanner.hasNextLine()) {
                numeroLinha++;
                String linha = scanner.nextLine().trim();

                if (linha.isEmpty() || linha.startsWith("#")) {
                    continue;
                }
                String[] tokens = linha.split("\\s+");

                if (tokens.length < 2) {
                    System.out.println("Linha " + numeroLinha + " ignorada"); 
                    continue; 
                }

                try {

                    if (tokens[0].equalsIgnoreCase("ALOCAR") && tokens.length >= 3) {
                        String id = tokens[1];
                        int tam = Integer.parseInt(tokens[2]);
                        boolean sucesso = alocar(id, tam);
                        String mensagem;

                        if (sucesso) {
                            mensagem = "sucesso";
                        } else {
                            mensagem = "falha (enfileirado)";
                        }

                        System.out.println("ALOCAR " + id + " " + tam + " -> " + mensagem);

                    } else if (tokens[0].equalsIgnoreCase("LIBERAR") && tokens.length >= 2) {
                        String id = tokens[1];
                        boolean sucesso = liberar(id);
                        String mensagem;

                        if (sucesso) {
                            mensagem = "sucesso";
                        } else {
                            mensagem = "ID não encontrado";
                        }

                        System.out.println("LIBERAR " + id + " -> " + mensagem);

                    } else {
                        System.out.println("Linha " + numeroLinha + " ignorada (comando inválido)");
                    }

                    System.out.println();
                    exibirArvore();
                    exibirListasLivres();
                    exibirFila();
                    System.out.println("\n\n\n");

                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}