public final class Carga extends Veiculo implements Calc {
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
    float calcVel(float velocMax) {
        return velocMax / CENTIMENTROS_POR_SEGUNDO;
    }

    public int calc(){
        int totalNumero = 0;

        totalNumero += getMotor().getQtdPistao();
        totalNumero += getMotor().getQtdPotencia();
        totalNumero += getQtdadeRodas();
        totalNumero += getVelocMax();
        totalNumero += getTara();
        totalNumero += getCargaMax();

        return totalNumero;

    }

}
