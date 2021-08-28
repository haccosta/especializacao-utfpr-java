public abstract class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private float velocMax;
    private Motor motor;

    public Veiculo(){
        placa = "";
        modelo = "";
        marca = "";
        velocMax = 0;
        motor = new Motor();

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

    abstract float calcVec(float velocMax);

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
    public Motor getMotor(){
        return motor;
    }

}
