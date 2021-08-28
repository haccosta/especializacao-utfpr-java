public class BDVeiculos {

    private Passeio vetorVeiculoPasseio[];
    private Carga vetorVeiculoCarga[];

    public BDVeiculos(){
        vetorVeiculoCarga = new Carga[5];
        vetorVeiculoPasseio = new Passeio[5];
    }

    public void validarCadastroVeiculoCarga(Carga carga) throws VeicExistException{
        boolean encontradoVeiculoPlaca = false;

        for (int i = 0; i < vetorVeiculoCarga.length; i++) {
            if (vetorVeiculoCarga[i].getPlaca().equalsIgnoreCase(carga.getPlaca())) {
                encontradoVeiculoPlaca = true;

            }
        }
        if (!encontradoVeiculoPlaca) {
           throw new VeicExistException();
        }
    }

    public void validarCadastroVeiculoPasseio(Passeio passeio) throws VeicExistException{
        boolean encontradoVeiculoPlaca = false;

        for (int i = 0; i < vetorVeiculoPasseio.length; i++) {
            if (vetorVeiculoPasseio[i].getPlaca().equalsIgnoreCase(passeio.getPlaca())) {
                encontradoVeiculoPlaca = true;

            }
        }

        if (!encontradoVeiculoPlaca) {
            throw new VeicExistException();
        }
    }

    public void addVeiculoPasseio(Passeio passeio, int i){
        this.vetorVeiculoPasseio[i] = passeio;

    }

    public void addVeiculoCarga(Carga carga, int i) {
        this.vetorVeiculoCarga[i] = carga;

    }

        public Carga[] getVetorVeiculoCarga() {
        return this.vetorVeiculoCarga;
    }

    public Passeio[] getVetorVeiculoPasseio() {
        return this.vetorVeiculoPasseio;
    }
}
