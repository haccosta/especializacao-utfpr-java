public class Teste {

    private static Passeio veiculoPasseio = new Passeio();
    private static Carga veiculoCarga = new Carga();
    private static BDVeiculos bdVeiculos = new BDVeiculos();

    private static final int VETOR_ESTA_CHEIO = -1;

    private static Leitura entrada = new Leitura();

    public static void main(String args[]) {
        boolean continuaPrograma = true;
        int opcaoEscolhida = 0;

        while (continuaPrograma) {
            System.out.println("\n\t\t\t Sistema de Gestão de Veículos - Menu Inicial");
            System.out.println("\t (1) Cadastrar veiculo de PASSEIO");
            System.out.println("\t (2) Cadastrar veiculo de CARGA");
            System.out.println("\t (3) Imprimir todos os veiculos de PASSEIO");
            System.out.println("\t (4) Imprimir todos os veiculos de CARGA");
            System.out.println("\t (5) Imprimir veiculo de PASSEIO pela placa");
            System.out.println("\t (6) Imprimir veiculo de CARGA pela placa");
            System.out.println("\t (7) Excluir veiculo de PASSEIO pela placa");
            System.out.println("\t (8) Excluir veiculo de CARGA pela placa");
            System.out.println("\t (9) Sair do Sistema");


            try {
                opcaoEscolhida = Integer.parseInt(entrada.lerDados("\t Escolha uma opçao"));

            } catch (NumberFormatException e) {
                System.out.println("O valor informado deve ser um numero inteiro -  pressione a tecla ENTER");
                entrada.lerDados("");

            }

            switch (opcaoEscolhida) {
                case 1:
                    String continuarCadastroPasseio = "s";

                    while (continuarCadastroPasseio.equalsIgnoreCase("s")) {
                        veiculoPasseio = new Passeio();
                        veiculoPasseio = cadastrarVeiculoPasseio(veiculoPasseio);

                        try {
                            bdVeiculos.validarCadastroVeiculoPasseio(veiculoPasseio);
                            bdVeiculos.addVeiculoPasseio(veiculoPasseio);
                        } catch (VeicExistException e) {
                            e.imprimirErroValidacaoVeiculoExiste();
                        }

                        entrada.lerDados("\n Veiculo de passeio armazenado na posicao " + bdVeiculos.getVetorVeiculoPasseio().indexOf(veiculoPasseio) + " do vetor - pressione a tecla <ENTER>");

                        continuarCadastroPasseio = entrada.lerDados("\n Deseja continuar o cadastro de outro veiculo de passeio? [s|n]");

                    }

                    break;

                case 2:

                    String continuarCadastroCarga = "s";

                    while (continuarCadastroCarga.equalsIgnoreCase("s")) {
                        veiculoCarga = new Carga();
                        veiculoCarga = cadastrarVeiculoCarga(veiculoCarga);

                        try {
                            bdVeiculos.validarCadastroVeiculoCarga(veiculoCarga);
                            bdVeiculos.addVeiculoCarga(veiculoCarga);

                        } catch (VeicExistException e) {
                            e.imprimirErroValidacaoVeiculoExiste();
                        }
                        entrada.lerDados("\n Veiculo de carga armazenado na posicao " + bdVeiculos.getVetorVeiculoCarga().indexOf(veiculoCarga) + " do vetor - pressione a tecla <ENTER>");

                        continuarCadastroCarga = entrada.lerDados("\n Deseja continuar o cadastro de outro veiculo de carga? [s|n]");

                    }

                    break;

                case 3:
                    System.out.println("\n Imprimindo todos os veiculos de PASSEIO");
                    System.out.println("\n\n=========================================================");

                    for (Passeio veiculo : bdVeiculos.getVetorVeiculoPasseio()) {
                        if (veiculo != null) {
                            imprimirDadosVeiculoPasseio(veiculo, bdVeiculos.getVetorVeiculoPasseio().indexOf(veiculo));
                        } else {
                            entrada.lerDados("Nao existem veiculos de PASSEIO para serem impressos -  pressione a tecla <ENTER>");
                        }

                    }
                    System.out.println("\n\n=========================================================");

                    break;

                case 4:
                    System.out.println("\n Imprimindo todos os veiculos de CARGA");
                    System.out.println("\n\n=========================================================");

                    for (Carga veiculo : bdVeiculos.getVetorVeiculoCarga()) {
                        if (veiculo != null) {
                            imprimirDadosVeiculoCarga(veiculo, bdVeiculos.getVetorVeiculoCarga().indexOf(veiculo));
                        } else {
                            entrada.lerDados("Nao existem veiculos de CARGA para serem impressos -  pressione a tecla <ENTER>");
                        }
                    }
                    System.out.println("\n\n=========================================================");

                    break;

                case 5:
                    System.out.println("\n Consulta por placa dos veiculos de PASSEIO");
                    System.out.println("\n\n=========================================================");


                    boolean encontradoVeiculoPasseioPlaca = false;

                    String placaDesejadaPasseio = entrada.lerDados("\n Digite a placa desejada: ");

                    for (Passeio veiculo : bdVeiculos.getVetorVeiculoPasseio()) {
                        if (veiculo.getPlaca().equalsIgnoreCase(placaDesejadaPasseio)) {
                            imprimirDadosVeiculoPasseio(veiculo, bdVeiculos.getVetorVeiculoPasseio().indexOf(veiculo));
                            encontradoVeiculoPasseioPlaca = true;
                        }

                    }

                    if (!encontradoVeiculoPasseioPlaca) {
                        entrada.lerDados("\n\n\n\t\t\t=========Veiculo de PASSEIO na encontrado com a PLACA informada! -  pressione a tecla <ENTER>");
                    }

                    break;


                case 6:
                    System.out.println("\n Consulta por placa dos veiculos de CARGA");
                    System.out.println("\n\n=========================================================");


                    boolean encontradoVeiculoCargaPlaca = false;

                    String placaDesejadaCarga = entrada.lerDados("\n Digite a placa desejada: ");

                    for (Carga veiculo : bdVeiculos.getVetorVeiculoCarga()) {
                        if (veiculo.getPlaca().equalsIgnoreCase(placaDesejadaCarga)) {
                            imprimirDadosVeiculoCarga(veiculo, bdVeiculos.getVetorVeiculoCarga().indexOf(veiculo));
                            encontradoVeiculoCargaPlaca = true;

                        }

                    }

                    if (!encontradoVeiculoCargaPlaca) {
                        entrada.lerDados("\n\n\n\t\t\t=========Veiculo de CARGA na encontrado com a PLACA informada! -  pressione a tecla <ENTER>");

                    }
                    break;

                case 7:
                    System.out.println("\n Excluir por placa dos veiculos de CARGA");
                    System.out.println("\n\n=========================================================");


                    encontradoVeiculoCargaPlaca = false;

                    placaDesejadaCarga = entrada.lerDados("\n Digite a placa desejada: ");

                    System.out.println(bdVeiculos.getVetorVeiculoCarga().size());
                    for (Carga veiculo : bdVeiculos.getVetorVeiculoCarga()) {
                        if (veiculo.getPlaca().equalsIgnoreCase(placaDesejadaCarga)) {
                            bdVeiculos.getVetorVeiculoCarga().remove(veiculo);
                            encontradoVeiculoCargaPlaca = true;

                        }

                    }

                    if (!encontradoVeiculoCargaPlaca) {
                        entrada.lerDados("\n\n\n\t\t\t=========Veiculo de CARGA na encontrado com a PLACA informada! -  pressione a tecla <ENTER>");

                    }
                    break;

                case 8:
                    System.out.println("\n Excluir por placa dos veiculos de PASSEIO");
                    System.out.println("\n\n=========================================================");


                    boolean encontradoVeiculoCargaPasseio = false;

                    placaDesejadaCarga = entrada.lerDados("\n Digite a placa desejada: ");

                    for (Passeio veiculo : bdVeiculos.getVetorVeiculoPasseio()) {
                        if (veiculo.getPlaca().equalsIgnoreCase(placaDesejadaCarga)) {
                            bdVeiculos.getVetorVeiculoCarga().remove(veiculo);
                            encontradoVeiculoCargaPasseio = true;

                        }

                    }

                    if (!encontradoVeiculoCargaPasseio) {
                        entrada.lerDados("\n\n\n\t\t\t=========Veiculo de PASSEIO na encontrado com a PLACA informada! -  pressione a tecla <ENTER>");

                    }
                    break;

                case 9:
                    continuaPrograma = false;
                    break;
                default:
                    entrada.lerDados("\n As opções informadas deverão estar entre os valores inteiros de 1 a 7 -  pressione a tecla <ENTER>");
                    break;

            }

        }
    }

    public static Passeio cadastrarVeiculoPasseio(Passeio passeio) {
        System.out.println("\n\n=========================================================");
        System.out.println("Cadastro de Veiculos de PASSEIO");
        System.out.println("\n\n=========================================================");

        passeio.setQtdadePassageiros(Integer.parseInt(entrada.lerDados("Quantidade de passageiros: ")));
        passeio.setPlaca(entrada.lerDados("\nPlaca: "));
        passeio.setMarca(entrada.lerDados("Marca: "));
        passeio.setModelo(entrada.lerDados("\nModelo: "));
        passeio.setCor(entrada.lerDados("\nCor: "));
        passeio.setQtdadeRodas(Integer.parseInt(entrada.lerDados("Quantidade de rodas: ")));
        passeio.setVelocMax(Float.parseFloat(entrada.lerDados("Velocidade Maxima: ")));
        passeio.getMotor().setQtdPistao(Integer.parseInt(entrada.lerDados("Quantidade de pistoes do motor: ")));
        passeio.getMotor().setQtdPotencia(Integer.parseInt(entrada.lerDados("Potencia do motor: ")));

        try {
            passeio.calcVel(passeio.getVelocMax());
        } catch (VelocExecpetion e) {
            passeio.setVelocMax(110);
            e.imprimirErroValidacaoVelocidade();
        }


        return passeio;

    }

    public static void imprimirDadosVeiculoPasseio(Passeio passeio, int posicaoVetor) {
        System.out.println("\n Veiculo de passeio armazenado no endereco..." + posicaoVetor + "(do vetor vetorVeiculoPasseio)");
        System.out.println("Quantidade de passageiros...." + passeio.getQtdadePassageiros());
        System.out.println("Placa........................" + passeio.getPlaca());
        System.out.println("Marca........................" + passeio.getMarca());
        System.out.println("Modelo......................." + passeio.getModelo());
        System.out.println("Cor.........................." + passeio.getCor());
        System.out.println("Qtdade de Rodas.............." + passeio.getQtdadeRodas());
        System.out.println("Velocidade Maxima............" + passeio.getVelocMax());
        System.out.println("Qtdade Pistões Motor........." + passeio.getMotor().getQtdPistao());
        System.out.println("Potencia do Motor............" + passeio.getMotor().getQtdPotencia());
        System.out.println("Qtdade Total de Letras......." + passeio.calc());
    }

    public static Carga cadastrarVeiculoCarga(Carga carga) {
        System.out.println("\n\n=========================================================");
        System.out.println("Cadastro de Veiculos de Carga");
        System.out.println("\n\n=========================================================");

        carga.setCargaMax(Integer.parseInt(entrada.lerDados("Carga Maxima: ")));
        carga.setTara(Integer.parseInt(entrada.lerDados("Tara: ")));
        carga.setPlaca(entrada.lerDados("\nPlaca: "));
        carga.setMarca(entrada.lerDados("Marca: "));
        carga.setModelo(entrada.lerDados("\nModelo: "));
        carga.setCor(entrada.lerDados("\nCor: "));
        carga.setQtdadeRodas(Integer.parseInt(entrada.lerDados("Quantidade de rodas: ")));
        carga.setVelocMax(Float.parseFloat(entrada.lerDados("Velocidade Maxima: ")));
        carga.getMotor().setQtdPistao(Integer.parseInt(entrada.lerDados("Quantidade de pistoes do motor: ")));
        carga.getMotor().setQtdPotencia(Integer.parseInt(entrada.lerDados("Potencia do motor: ")));

        try {
            carga.calcVel(carga.getVelocMax());
        } catch (VelocExecpetion e) {
            carga.setVelocMax(90);
            e.imprimirErroValidacaoVelocidade();
        }


        return carga;

    }

    public static void imprimirDadosVeiculoCarga(Carga carga, int posicaoVetor) {
        System.out.println("\n Veiculo de carga armazenado no endereco..." + posicaoVetor + "(do vetor vetorVeiculoCarga)");
        System.out.println("Tara........................." + carga.getTara());
        System.out.println("Carga Maxima................." + carga.getTara());
        System.out.println("Placa........................" + carga.getPlaca());
        System.out.println("Marca........................" + carga.getMarca());
        System.out.println("Modelo......................." + carga.getModelo());
        System.out.println("Cor.........................." + carga.getCor());
        System.out.println("Qtdade de Rodas.............." + carga.getQtdadeRodas());
        System.out.println("Velocidade Maxima............" + carga.getVelocMax());
        System.out.println("Qtdade Pistões Motor........." + carga.getMotor().getQtdPistao());
        System.out.println("Potencia do Motor............" + carga.getMotor().getQtdPotencia());
        System.out.println("Qtdade Total de caracteristicas......." + carga.calc());
    }

}
