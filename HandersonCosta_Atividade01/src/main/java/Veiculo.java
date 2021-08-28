public class Veiculo {
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

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public void setVelocMax(float velocMax){
        this.velocMax = velocMax;
    }

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

    public String toString(){
        return "Modelo: " + this.modelo + " Marca: " + this.marca + " Placa: " + this.placa + " Velocidade Max:  " + this.velocMax +
               " Motor: " + this.motor.toString();
    }
}
