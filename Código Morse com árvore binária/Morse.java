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


    public void arvoreMorse() {
        inserir(".-", 'A');
        inserir("-...", 'B');
        inserir("-.-.", 'C');
        inserir("-..", 'D');
        inserir(".", 'E');
        inserir("..-.",'F');
        inserir("--.",'G');
        inserir("....",'H');
        inserir("..", 'I');
        inserir(".---", 'J');
        inserir("-.-",'K');
        inserir(".-..", 'L');
        inserir("--", 'M');
        inserir("-.", 'N');
        inserir("---", 'O');
        inserir(".--.", 'P');
        inserir("--.-", 'Q');
        inserir(".-.",'R');
        inserir("...", 'S');
        inserir("-", 'T');
        inserir("..-",'U');
        inserir("...-", 'V');
        inserir(".--", 'W');
        inserir("-..-", 'X');
        inserir("-.--", 'Y');
        inserir("--..", 'Z');

        inserir(".----", '1');
        inserir("..---", '2');
        inserir("...--", '3');
        inserir("....-", '4');
        inserir(".....", '5');
        inserir("-....", '6');
        inserir("--...", '7');
        inserir("---..", '8');
        inserir("----.", '9');
        inserir("-----", '0');
    }

    public void mostrarArvore() {
        System.out.println("Legenda: (.) ponto = filho da esquerda | (-) traço = filho da direita");
        System.out.println("RAIZ");
        mostrarNo(raiz, "");
    }
 
    private void mostrarNo(MorseNode no, String prefixo) {
        MorseNode esquerda = no.getEsquerda();
        MorseNode direita = no.getDireita();
 
        if (esquerda != null) {
            String conector = "`-- ";
            String continuacao = "    ";
            if (direita != null) {
                conector = "|-- ";
                continuacao = "|   ";
            }
            System.out.println(prefixo + conector + rotulo('.', esquerda));
            mostrarNo(esquerda, prefixo + continuacao);
        }
 
        if (direita != null) {
            System.out.println(prefixo + "`-- " + rotulo('-', direita));
            mostrarNo(direita, prefixo + "    ");
        }
    }
    private String rotulo(char simbolo, MorseNode no) {
        String texto = "(" + simbolo + ")";
        if (no.getValor() != ' ') {
            texto += " " + no.getValor();
        }
        return texto;
    }

}
