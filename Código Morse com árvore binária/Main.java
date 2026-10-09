import java.util.Scanner;

public class Main {
    private static Scanner teclado = new Scanner(System.in);
    private static Morse morse = new Morse();
    private static FileService arquivos = new FileService();

    public static void main(String[] args) {
        morse.arvoreMorse();

        int opcao = -1;
        while (opcao != 0) {
            mostrarMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o texto: ");
                    morse.codificar(teclado.nextLine());
                    break;
                case 2:
                    System.out.print("Digite o Morse: ");
                    morse.decodificar(teclado.nextLine());
                    break;
                case 5:
                    morse.mostrarArvore();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Digite um número de 0 a 5.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("Código morse");
        System.out.println("1 - Codificar texto digitado");
        System.out.println("2 - Decodificar Morse digitado");
        System.out.println("3 - Codificar arquivo de texto");
        System.out.println("4 - Decodificar arquivo Morse");
        System.out.println("5 - Mostrar árvore");
        System.out.println("0 - Encerrar");
        System.out.print("Opção: ");
    }

    private static int lerOpcao() {
        String linha = teclado.nextLine().trim();
        try {
            return Integer.parseInt(linha);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
