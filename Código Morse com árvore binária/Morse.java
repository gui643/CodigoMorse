public class Morse{
    private MorseNode raiz;

    public Morse() {
        raiz = new MorseNode(' ');
    }

    public void inserir(String codigo, char valor) {

        MorseNode atual = raiz;

        for(int i = 0; i < codigo.length();i++) {

            char simbolo = codigo.charAt(i);

            if ( simbolo == '.') {
                if (atual.getEsquerda() == null) {
                atual.setEsquerda (new MorseNode(' ')); 
            }
        
        atual = atual.getEsquerda();
        }
        if (simbolo == '-') {
            if (atual.getDireita() == null) {
            atual.setDireita(new MorseNode(' '));
            }
        
        atual = atual.getDireita();
        }
    }

    atual.setValor(valor);
    }

}
