public class ListaEncadeada {
    private NoLista cabeca;
    
    public ListaEncadeada() {
     this.cabeca = null; 
}

    public void inserirInicio(NoArvore bloco) {
        NoLista novo = new NoLista(bloco);
        novo.setProximo(cabeca);
        cabeca = novo;
    }

    public void remover(NoArvore bloco) {

        if (cabeca == null) return;

        if (cabeca.getBloco() == bloco) {
            cabeca = cabeca.getProximo();
            return;
        }

        NoLista anterior = cabeca;
        NoLista atual = cabeca.getProximo();

        while (atual != null) {

            if (atual.getBloco() == bloco) {
                anterior.setProximo(atual.getProximo());
                return;
            }

            anterior = atual;
            atual = atual.getProximo();
        }
    }
    
    public NoArvore removerPrimeiro() {

        if (cabeca == null) return null;
        NoArvore bloco = cabeca.getBloco();
        cabeca = cabeca.getProximo();
        return bloco;
    }
    
    public NoArvore primeiro() {
    if (cabeca == null) {
        return null;
    }
    return cabeca.getBloco();
    }

    public boolean estaVazia() {
     return cabeca == null; 
    }

    public int tamanho() {
        int cont = 0;
        NoLista atual = cabeca;

        while (atual != null) {
            cont++; 
            atual = atual.getProximo(); 
    }

        return cont;
    }
}

