public final class Passeio extends Veiculo {
    private int qtdadePassageiros;
    private final static float METROS_POR_SEGUNDO = 3.6f;

    public Passeio(){
        this.qtdadePassageiros = 0;
    }

    public int getQtdadePassageiros(){
        return this.qtdadePassageiros;
    }

    public void setQtdadePassageiros(int qtdadePassageiros){
        this.qtdadePassageiros = qtdadePassageiros;
    }

    @Override
    float calcVec(float velocMax) {
        return velocMax / METROS_POR_SEGUNDO;
    }

    @Override
    public String toString(){
        return "Modelo: " + this.getModelo() + " Marca: " + this.getMarca() + " Placa: " + this.getPlaca() + " Velocidade Max (m/s):  " + this.calcVec(this.getVelocMax()) +
                " Quantidade Passageiros: " + this.getQtdadePassageiros() +
                " Motor: " + this.getMotor().toString();
    }
}
