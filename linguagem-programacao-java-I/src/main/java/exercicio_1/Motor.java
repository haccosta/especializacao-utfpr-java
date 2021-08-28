package exercicio_1;

public class Motor {
    private int qtdPistao;
    private int qtdPotencia;

    public Motor(){
        qtdPistao = 0;
        qtdPotencia = 0;
    }

    public void setQtdPistao(int qtdPistao){
        this.qtdPistao = qtdPistao;
    }

    public void setQtdPotencia(int qtdPotencia){
        this.qtdPotencia = qtdPotencia;
    }

    public int getQtdPistao(){
        return this.qtdPistao;
    }
    public int getQtdPotencia(){
        return this.qtdPotencia;
    }

    public String toString(){
        return " [ Configurações do Motor: Potência: " + this.qtdPotencia + " Pistão: " + this.qtdPistao + " ] ";
    }

}
