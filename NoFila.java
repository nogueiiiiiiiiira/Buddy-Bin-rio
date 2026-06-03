public class NoFila {
    private String id;
    private int tamanhoKB;
    private NoFila proximo;
    
    public NoFila(String id, int tamanhoKB) {
        this.id = id;
        this.tamanhoKB = tamanhoKB;
        this.proximo = null;
    }

    public String getId() {
     return id; 
}

    public int getTamanhoKB() {
     return tamanhoKB; 
}

    public NoFila getProximo() {
     return proximo; 
}

    public void setProximo(NoFila proximo) {
     this.proximo = proximo; 
}
}

