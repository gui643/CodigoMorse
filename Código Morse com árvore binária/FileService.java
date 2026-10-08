import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileService {

    public String lerTexto(String caminho) throws IOException {
        ArrayList<String> linhas = lerLinhas(caminho);
        StringBuilder texto = new StringBuilder();

        for (int i = 0; i < linhas.size(); i++) {
            if (i > 0) {
                texto.append(' ');
            }
            texto.append(linhas.get(i));
        }
        return texto.toString();
    }

    public String lerLinhaMorse(String caminho) throws IOException {
        ArrayList<String> linhas = lerLinhas(caminho);

        if (linhas.size() == 0) {
            throw new IOException("O arquivo está vazio.");
        }
        if (linhas.size() > 1) {
            throw new IOException("O arquivo Morse deve ter uma única linha.");
        }
        return linhas.get(0);
    }

    private ArrayList<String> lerLinhas(String caminho) throws IOException {
        File arquivo = new File(caminho);
        if (!arquivo.exists() || !arquivo.isFile()) {
            throw new IOException("Arquivo não encontrado: " + caminho);
        }

        ArrayList<String> linhas = new ArrayList<>();
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            String linha = leitor.readLine();
            while (linha != null) {
                if (linhas.size() == 0 && linha.startsWith("\uFEFF")) {
                    linha = linha.substring(1); 
                }
                linhas.add(linha);
                linha = leitor.readLine();
            }
        }
        return linhas;
    }
}