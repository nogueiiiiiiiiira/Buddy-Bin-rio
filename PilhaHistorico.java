public class PilhaHistorico {
    private NoPilha topo;
    private int tamanho;
    
    public PilhaHistorico() {
        topo = null;
        tamanho = 0;
    }

    public void empilhar(String tipo, String id, int tamanhoKB) {
        NoPilha novo = new NoPilha(tipo, id, tamanhoKB);
        novo.setProximo(topo);
        topo = novo;
        tamanho++;
    }

    public NoPilha desempilhar() {

        if (estaVazia()) return null;
        NoPilha removido = topo;
        topo = topo.getProximo();
        tamanho--;
        removido.setProximo(null);
        return removido;
    }

    public NoPilha topo() {
     return topo; 
}

    public boolean estaVazia() {
     return topo == null; 
}

    public int getTamanho() {
     return tamanho; 
}
}

