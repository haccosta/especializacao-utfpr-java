public abstract class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private float velocMax;
    private String cor;
    private int qtdadeRodas;
    private Motor motor;

    public Veiculo(){
        placa = "";
        modelo = "";
        marca = "";
        velocMax = 0;
        motor = new Motor();
        cor = "";
        qtdadeRodas = 0;

    }

    public final void setPlaca(String placa) {
        this.placa = placa;
    }
    public final void setMarca(String marca){
        this.marca = marca;
    }
    public final void setModelo(String modelo){
        this.modelo = modelo;
    }
    public final void setVelocMax(float velocMax){
        this.velocMax = velocMax;
    }
    public final void setCor(String cor) {this.cor = cor; }
    public final void setQtdadeRodas (int qtdadeRodas) {this.qtdadeRodas = qtdadeRodas; }

    abstract float calcVel(float velocMax) throws VelocExecpetion;

    public String getPlaca(){
        return placa;
    }
    public String getMarca(){
        return  marca;
    }
    public String getModelo(){
        return modelo;
    }
    public float getVelocMax(){
        return velocMax;
    }
    public String getCor(){return cor; }
    public int getQtdadeRodas(){ return qtdadeRodas ;}
    public Motor getMotor(){
        return motor;
    }

}
