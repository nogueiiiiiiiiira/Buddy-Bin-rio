public class FilaPendentes {
    private NoFila cabeca;
    private NoFila cauda;
    private int tamanho;
    
    public FilaPendentes() {
        cabeca = null;
        cauda = null;
        tamanho = 0;
    }

    public void enfileirar(String id, int tamanhoKB) {
        NoFila novo = new NoFila(id, tamanhoKB);

        if (estaVazia()) {
            cabeca = novo;
            cauda = novo;
        } else {
            cauda.setProximo(novo);
            cauda = novo;
        }

        tamanho++;
    }
    
    public NoFila desenfileirar() {

        if (estaVazia()) return null;
        NoFila removido = cabeca;
        cabeca = cabeca.getProximo();

        if (cabeca == null) cauda = null;
        tamanho--;
        removido.setProximo(null);
        return removido;
    }
    
    public NoFila espiar() {
     return cabeca; 
}

    public boolean estaVazia() {
     return tamanho == 0; 
}

    public int getTamanho() {
     return tamanho; 
}

    public boolean contem(String id) {
        NoFila atual = cabeca;

        while (atual != null) {

            if (atual.getId().equals(id)) return true;
            atual = atual.getProximo();
        }

        return false;
    }
    
    public void imprimir() {

        if (estaVazia()) {
            System.out.println("\t(vazia)");
            return;
        }

        NoFila atual = cabeca;

        while (atual != null) {
            System.out.println("  ID: " + atual.getId() + ", " + atual.getTamanhoKB() + "KB");
            atual = atual.getProximo();
        }
    }
}

