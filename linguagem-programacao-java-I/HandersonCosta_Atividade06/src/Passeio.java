public final class Passeio extends Veiculo implements Calc {
    private int qtdadePassageiros;
    private final static float METROS_POR_SEGUNDO = 3.6f;

    public Passeio() {
        this.qtdadePassageiros = 0;
    }

    public int getQtdadePassageiros() {
        return this.qtdadePassageiros;
    }

    public void setQtdadePassageiros(int qtdadePassageiros) {
        this.qtdadePassageiros = qtdadePassageiros;
    }

    public int calc() {
        int totalLetras = 0;
        totalLetras += getPlaca().length();
        totalLetras += getModelo().length();
        totalLetras += getMarca().length();
        totalLetras += getCor().length();

        return totalLetras;

    }

    @Override
    float calcVel(float velocMax) throws VelocExecpetion {

        if (velocMax < 80 || velocMax > 110) {
            throw  new VelocExecpetion();

        }

        return velocMax / METROS_POR_SEGUNDO;
    }

}
