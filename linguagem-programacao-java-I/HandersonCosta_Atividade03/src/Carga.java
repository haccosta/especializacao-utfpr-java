public final class Carga extends Veiculo {
    private int tara;
    private int cargaMax;
    private final static float CENTIMENTROS_POR_SEGUNDO = 0.036f;

    public Carga(){
        this.tara = 0;
        this.cargaMax = 0;
    }

    public int getTara() {
        return this.tara;
    }

    public int getCargaMax() {
        return this.cargaMax;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    float calcVec(float velocMax) {
        return velocMax / CENTIMENTROS_POR_SEGUNDO;
    }

    @Override
    public String toString(){
        return "Modelo: " + this.getModelo() + " Marca: " + this.getMarca() + " Placa: " + this.getPlaca() + " Velocidade Max (cm/s):  " + this.calcVec(this.getVelocMax()) +
                " Tara: " + this.getTara() +
                " Carga Maxima: " + this.getCargaMax() +
                " Motor: " + this.getMotor().toString();
    }
}
