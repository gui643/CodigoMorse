public class MorseNode {
    private char valor;
    private MorseNode esquerda;
    private MorseNode direita;

    public MorseNode(char valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
    public char getValor() {
        return valor;
    }
    public MorseNode getEsquerda() {
        return esquerda;
    }
    public MorseNode getDireita() {
        return direita;
    }
    public void setValor(char valor) {
        this.valor = valor;
    }
    public void setEsquerda(MorseNode esquerda) {
        this.esquerda = esquerda;
    }
    public void setDireita(MorseNode direita) {
        this.direita = direita;
    }
}
