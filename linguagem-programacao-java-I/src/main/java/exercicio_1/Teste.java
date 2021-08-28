package exercicio_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Teste {

    private static final int LIMITE_CRIACAO_VEICULO = 5;

    public static void main(String args[]) {
        boolean coletarDados = true;
        int totalEntradaDados = 0;
        int limiteCadastroVeiculos = 0;
        Veiculo veiculo = null;

        System.out.println("Bem vindo ao cadastro de veículos!");
        System.out.println("*****************************************************");

        limiteCadastroVeiculos = coletarQuantidadeParaCadastro();

        while(!isQuantidadeVeiculoValida(limiteCadastroVeiculos)){
            System.out.println("O limite para criação de veiculos e: " + LIMITE_CRIACAO_VEICULO);
            limiteCadastroVeiculos = coletarQuantidadeParaCadastro();
            System.out.println("*****************************************************");
        }

        Veiculo listaVeiculo[] = new Veiculo[limiteCadastroVeiculos];


        while (coletarDados) {
            veiculo = new Veiculo();

            preencherPlacaVeiculo(veiculo);
            preencherModeloVeiculo(veiculo);
            preencherMarcaVeiculo(veiculo);
            preencherVelMaxVeiculo(veiculo);
            preencherMotorVeiculo(veiculo);

            listaVeiculo[totalEntradaDados] = veiculo;
            totalEntradaDados++;

            if (totalEntradaDados == limiteCadastroVeiculos) {
                coletarDados = false;

            }

        }

        imprimirValoresVeiculos(listaVeiculo);

    }

    private static int coletarQuantidadeParaCadastro() {
        System.out.print("Informe a quantidade de veículos que deseja cadastrar: ");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader entradaDados = new BufferedReader(inputStreamReader);
        try {
            String aux = entradaDados.readLine();

            return Integer.parseInt(aux);
        } catch (NumberFormatException e) {
            System.out.println("Formato de número invalido!");
        } catch (IOException e) {
            System.out.println("Erro no preenchimento do numero");
        }

        return 0;
    }

    private static Veiculo preencherPlacaVeiculo(Veiculo veiculo) {
        System.out.print("Informe a placa do veículo: ");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader entradaDados = new BufferedReader(inputStreamReader);
        try {
            String aux = entradaDados.readLine();
            veiculo.setPlaca(aux);

        } catch (IOException e) {
            System.out.println("Erro no preenchimento do numero");
        }

        return veiculo;
    }

    private static Veiculo preencherMarcaVeiculo(Veiculo veiculo) {
        System.out.print("Informe a marca do veículo: ");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader entradaDados = new BufferedReader(inputStreamReader);
        try {
            String aux = entradaDados.readLine();
            veiculo.setMarca(aux);
        } catch (IOException e) {
            System.out.println("Erro no preenchimento do numero");
        }

        return veiculo;
    }

    private static Veiculo preencherModeloVeiculo(Veiculo veiculo) {
        System.out.print("Informe a modelo do veículo: ");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader entradaDados = new BufferedReader(inputStreamReader);
        try {
            String aux = entradaDados.readLine();
            veiculo.setModelo(aux);
        } catch (IOException e) {
            System.out.println("Erro no preenchimento do numero");
        }

        return veiculo;
    }

    private static Veiculo preencherVelMaxVeiculo(Veiculo veiculo) {
        System.out.print("Informe a velocidade máxima do veículo: ");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader entradaDados = new BufferedReader(inputStreamReader);
        try {
            String aux = entradaDados.readLine();
            veiculo.setVelocMax(Float.parseFloat(aux));

        } catch (NumberFormatException e) {
            System.out.println("Formato de número invalido!");
        } catch (IOException e) {
            System.out.println("Erro no preenchimento do numero");
        }

        return veiculo;
    }


    private static Veiculo preencherMotorVeiculo(Veiculo veiculo) {
        try {
            System.out.print("Informe a quantidade de pistão do motor: ");
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader entradaDados = new BufferedReader(inputStreamReader);

            String aux = entradaDados.readLine();
            veiculo.getMotor().setQtdPistao(Integer.parseInt(aux));

            System.out.print("Informe a quantidade de potência do motor: ");
            InputStreamReader inputStreamReader2 = new InputStreamReader(System.in);
            BufferedReader entradaDados2 = new BufferedReader(inputStreamReader);

            aux = entradaDados2.readLine();
            veiculo.getMotor().setQtdPotencia(Integer.parseInt(aux));

        } catch (NumberFormatException e) {
            System.out.println("Formato de número invalido!");
        } catch (IOException e) {
            System.out.println("Erro no preenchimento do numero");
        }

        return veiculo;
    }

    private static boolean isQuantidadeVeiculoValida(int totalDigitadoUsuario){
        return totalDigitadoUsuario <= LIMITE_CRIACAO_VEICULO;
    }

    private static void imprimirValoresVeiculos(Veiculo listaVeiculo[]) {

        System.out.println("Imprimindo os Valores: ");
        System.out.println("*****************************************************");

        if (listaVeiculo.length == 0) {
            System.out.println("Veículo nao preenchidos");
        } else {
            for (int i = 0; i < listaVeiculo.length; i++) {
                System.out.println(listaVeiculo[i].toString());
                System.out.println("*****************************************************");
            }
        }
    }
}
