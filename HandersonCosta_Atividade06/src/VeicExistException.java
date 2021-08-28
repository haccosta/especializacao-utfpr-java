public class VeicExistException extends Exception{
    public VeicExistException(){
        System.out.println("Já existe um veículo com essa placa");
    }

    public void imprimirErroValidacaoVeiculoExiste(){
        System.out.println("Validação de velocidade máxima");
    }

}


