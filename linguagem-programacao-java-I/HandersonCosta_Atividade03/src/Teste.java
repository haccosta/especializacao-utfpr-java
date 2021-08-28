import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teste {

    private static final int LIMITE_CRIACAO_VEICULO = 5;

    public static void main(String args[]) {
        boolean coletarDados = true;
        int totalEntradaDados = 0;
        int limiteCadastroVeiculos = 0;
        Carga carga = null;
        Passeio passeio = null;

        System.out.println("Bem vindo ao cadastro de veículos!");
        System.out.println("*****************************************************");

        limiteCadastroVeiculos = coletarQuantidadeParaCadastro();

        while (!isQuantidadeVeiculoValida(limiteCadastroVeiculos)) {
            System.out.println("O limite para criação de veiculos e: " + LIMITE_CRIACAO_VEICULO);
            limiteCadastroVeiculos = coletarQuantidadeParaCadastro();
            System.out.println("*****************************************************");
        }

        System.out.println("*****************************************************");

        Veiculo listaVeiculo[] = new Veiculo[limiteCadastroVeiculos * 2];


        while (coletarDados) {
            carga = new Carga();
            passeio = new Passeio();

            int identificadorCadastro = (totalEntradaDados + 1);

            preencherPlacaVeiculo(carga, identificadorCadastro);
            preencherModeloVeiculo(carga, identificadorCadastro);
            preencherMarcaVeiculo(carga, identificadorCadastro);
            preencherVelMaxVeiculo(carga, identificadorCadastro);
            preencherDadosAdicionaisVeiculo(carga, identificadorCadastro);
            preencherMotorVeiculo(carga, identificadorCadastro);

            System.out.print("***Finalizando o cadastro do veiculo de carga " + (totalEntradaDados + 1) + "***\n\n\n\n\n\n");

            preencherPlacaVeiculo(passeio, identificadorCadastro);
            preencherModeloVeiculo(passeio, identificadorCadastro);
            preencherMarcaVeiculo(passeio, identificadorCadastro);
            preencherVelMaxVeiculo(passeio, identificadorCadastro);
            preencherDadosAdicionaisVeiculo(passeio, identificadorCadastro);
            preencherMotorVeiculo(passeio, identificadorCadastro);

            System.out.print("***Finalizando o cadastro do veiculo de passageiro " + (totalEntradaDados + 1) + "***\n\n\n\n\n\n");

            listaVeiculo[totalEntradaDados] = carga;
            totalEntradaDados++;

            listaVeiculo[totalEntradaDados] = passeio;
            totalEntradaDados++;

            if (totalEntradaDados == (limiteCadastroVeiculos * 2)) {
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

    private static Veiculo preencherPlacaVeiculo(Veiculo veiculo, int identificadorVeiculo) {
        System.out.print("Informe a placa do veículo" + getTipoVeiculo(veiculo, identificadorVeiculo));
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

    private static Veiculo preencherMarcaVeiculo(Veiculo veiculo, int identificadorVeiculo) {
        System.out.print("Informe a marca do veículo" + getTipoVeiculo(veiculo, identificadorVeiculo));
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

    private static Veiculo preencherModeloVeiculo(Veiculo veiculo, int identificadorVeiculo) {
        System.out.print("Informe a modelo do veículo" + getTipoVeiculo(veiculo, identificadorVeiculo));
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

    private static Veiculo preencherVelMaxVeiculo(Veiculo veiculo, int identificadorVeiculo) {
        System.out.print("Informe a velocidade máxima do veículo" + getTipoVeiculo(veiculo, identificadorVeiculo));
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


    private static Veiculo preencherMotorVeiculo(Veiculo veiculo, int identificadorVeiculo) {
        try {
            System.out.print("Informe a quantidade de pistão do motor" + getTipoVeiculo(veiculo, identificadorVeiculo));
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader entradaDados = new BufferedReader(inputStreamReader);

            String aux = entradaDados.readLine();
            veiculo.getMotor().setQtdPistao(Integer.parseInt(aux));

            System.out.print("Informe a quantidade de potência do motor" + getTipoVeiculo(veiculo, identificadorVeiculo));
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


    private static Veiculo preencherDadosAdicionaisVeiculo(Veiculo veiculo, int identificadorVeiculo) {
        try {

            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader entradaDados = new BufferedReader(inputStreamReader);

            InputStreamReader inputStreamReader2 = new InputStreamReader(System.in);
            BufferedReader entradaDados2 = new BufferedReader(inputStreamReader);

            if (veiculo instanceof Passeio) {
                System.out.print("Informe a quantidade de passageiros do veiculo" + getTipoVeiculo(veiculo, identificadorVeiculo));

                String aux = entradaDados.readLine();
                Passeio passeio = (Passeio) veiculo;
                passeio.setQtdadePassageiros(Integer.parseInt(aux));

            } else if (veiculo instanceof Carga) {

                System.out.print("Informe a quantidade de carga máxima do veiculo" + getTipoVeiculo(veiculo, identificadorVeiculo));

                String aux = entradaDados.readLine();
                Carga carga = (Carga) veiculo;
                carga.setCargaMax(Integer.parseInt(aux));

                System.out.print("Informe a tara do veiculo" + getTipoVeiculo(veiculo, identificadorVeiculo));

                aux = entradaDados2.readLine();
                carga.setTara(Integer.parseInt(aux));

            }

        } catch (NumberFormatException e) {
            System.out.println("Formato de número invalido!");
        } catch (IOException e) {
            System.out.println("Erro no preenchimento do numero");
        }

        return veiculo;
    }

    private static boolean isQuantidadeVeiculoValida(int totalDigitadoUsuario) {
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

    private static String getTipoVeiculo(Veiculo veiculo, int identificadorVeiculo) {
        if (veiculo instanceof Carga) {
            return " de carga " + identificadorVeiculo + ": ";
        } else {
            return " de passageiro " + identificadorVeiculo + ": ";
        }
    }
}
