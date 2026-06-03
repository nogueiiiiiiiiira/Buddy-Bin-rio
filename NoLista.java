public class NoLista {
    private NoArvore bloco;
    private NoLista proximo;
    
    public NoLista(NoArvore bloco) {
        this.bloco = bloco;
        this.proximo = null;
    }

    public NoArvore getBloco() {
     return bloco; 
}

    public void setBloco(NoArvore bloco) {
     this.bloco = bloco; 
}

    public NoLista getProximo() {
     return proximo; 
}

    public void setProximo(NoLista proximo) {
     this.proximo = proximo; 
}
}

