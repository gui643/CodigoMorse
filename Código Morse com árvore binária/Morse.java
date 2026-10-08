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

     
    public void codificar(String texto) {
        texto = texto.trim().toUpperCase();
 
        if (texto.isEmpty()) {
            System.out.println("Texto vazio. Digite algo para codificar.");
            return;
        }
 
        StringBuilder resultado = new StringBuilder();
        boolean espacoAnterior = false;
 
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
 
            if (c == ' ') {
                if (!espacoAnterior) {
                    resultado.append("/ "); 
                }
                espacoAnterior = true;
            } else {
                String codigo = buscarCodigo(raiz, c, "");
                if (codigo == null) {
                    System.out.println("Símbolo inválido: '" + c + "'. Use apenas letras de A a Z (sem acento), números de 0 a 9 e espaços.");
                    return;
                }
                resultado.append(codigo).append(" ");
                espacoAnterior = false;
            }
        }
        System.out.println(resultado.toString().trim());
    }
 
    public void decodificar(String entrada) {
        if (entrada.trim().isEmpty()) {
            System.out.println("Entrada vazia. Digite o código Morse.");
            return;
        }
 
        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);
            if (c != '.' && c != '-' && c != '/' && c != ' ') {
                System.out.println("Entrada inválida: o caractere '" + c + "' não é permitido. Use apenas ponto (.), traço (-), barra (/) e espaço.");
                return;
            }
        }
 
        String[] partes = entrada.trim().split(" ");
        StringBuilder resultado = new StringBuilder();
 
        for (int i = 0; i < partes.length; i++) {
            String parte = partes[i];
 
            if (parte.isEmpty()) {
                continue; 
            }
 
            if (parte.equals("/")) {
                resultado.append(' '); 
            } else {
                char letra = buscarLetra(parte);
                if (letra == ' ') {
                    System.out.println("Código Morse inválido: " + parte);
                    return;
                }
                resultado.append(letra);
            }
        }
        System.out.println(resultado);
    }
 
    private char buscarLetra(String codigo) {
        MorseNode atual = raiz;
 
        for (int i = 0; i < codigo.length(); i++) {
            char simbolo = codigo.charAt(i);
 
            if (simbolo == '.') {
                atual = atual.getEsquerda();
            } else if (simbolo == '-') {
                atual = atual.getDireita();
            } else {
                atual = null;
            }
 
            if (atual == null) {
                return ' ';
            }
        }
        return atual.getValor();
    }
 
    private String buscarCodigo(MorseNode no, char letra, String caminho) {
        if (no.getValor() == letra) {
            return caminho;
        }
 
        if (no.getEsquerda() != null) {
            String codigo = buscarCodigo(no.getEsquerda(), letra, caminho + ".");
            if (codigo != null) {
                return codigo;
            }
        }
 
        if (no.getDireita() != null) {
            String codigo = buscarCodigo(no.getDireita(), letra, caminho + "-");
            if (codigo != null) {
                return codigo;
            }
        }
        return null;
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


