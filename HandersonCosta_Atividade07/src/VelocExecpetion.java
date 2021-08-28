public class VelocExecpetion extends Exception{
    public VelocExecpetion(){
        System.out.println("A velocidade maxima esta fora dos limites brasileiros");
    }

    public void imprimirErroValidacaoVelocidade(){
        System.out.println("Validação de velocidade máxima");
    }
}
