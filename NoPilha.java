public class NoPilha {
    private String tipo;
    private String id;
    private int tamanhoKB;
    private NoPilha proximo;
    
    public NoPilha(String tipo, String id, int tamanhoKB) {
        this.tipo = tipo;
        this.id = id;
        this.tamanhoKB = tamanhoKB;
        this.proximo = null;
    }

    public String getTipo() {
     return tipo; 
}

    public String getId() {
     return id; 
}

    public int getTamanhoKB() {
     return tamanhoKB; 
}

    public NoPilha getProximo() {
     return proximo; 
}

    public void setProximo(NoPilha proximo) {
     this.proximo = proximo; 
}
}

