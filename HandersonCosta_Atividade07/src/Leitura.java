import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {
    public String lerDados(String rotulo) {
        System.out.println(rotulo);
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader bufferEntrada = new BufferedReader(entrada);

        String textoEntrada = "";
        try {
            textoEntrada = bufferEntrada.readLine();

        } catch (IOException e) {
            System.out.println("Erro na entrada de dados");
        }

        return textoEntrada;

    }
}
