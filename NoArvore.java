public class NoArvore {
    public static final int LIVRE = 0;
    public static final int OCUPADO = 1;
    public static final int DIVIDIDO = 2;
    
    private int tamanhoKB;
    private int estado;
    private String id;
    private NoArvore pai;
    private NoArvore esquerdo;
    private NoArvore direito;
    
    public NoArvore(int tamanhoKB) {
        this.tamanhoKB = tamanhoKB;
        this.estado = LIVRE;
        this.id = null;
        this.pai = null;
        this.esquerdo = null;
        this.direito = null;
    }

    public int getTamanhoKB() {
     return tamanhoKB; 
}

    public int getEstado() {
     return estado; 
}

    public void setEstado(int estado) {
     this.estado = estado; 
}

    public String getId() {
     return id; 
}

    public void setId(String id) {
     this.id = id; 
}

    public NoArvore getPai() {
     return pai; 
}

    public void setPai(NoArvore pai) {
     this.pai = pai; 
}

    public NoArvore getEsquerdo() {
     return esquerdo; 
}

    public void setEsquerdo(NoArvore esquerdo) {
     this.esquerdo = esquerdo; 
}

    public NoArvore getDireito() {
     return direito; 
}

    public void setDireito(NoArvore direito) {
     this.direito = direito; 
}

    public boolean estaLivre() {
     return estado == LIVRE; 
}

    public boolean estaOcupado() {
     return estado == OCUPADO; 
}

    public boolean estaDividido() {
     return estado == DIVIDIDO; 
}

    public boolean ehFolha() {
     return esquerdo == null && direito == null; 
}
}

