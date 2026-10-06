public class MorseNode {
    private char valor;
    private MorseNode esquerda;
    private MorseNode direita;

    public MorseNode(char valor) {
        this.valor = valor;
    }
    public char getValor() {
        return valor;
    }
    public void setValor(char valor) {
        System.out.println(valor);
    }
}
