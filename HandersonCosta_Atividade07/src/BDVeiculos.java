import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {

    private List<Passeio> vetorVeiculoPasseio;
    private List<Carga> vetorVeiculoCarga;

    public BDVeiculos() {
        vetorVeiculoCarga = new ArrayList<Carga>();
        vetorVeiculoPasseio = new ArrayList<Passeio>();
    }

    public void validarCadastroVeiculoCarga(Carga carga) throws VeicExistException {
        boolean encontradoVeiculoPlaca = false;


        for (Carga veiculoCarga : vetorVeiculoCarga) {

            if (veiculoCarga != null
                    && !veiculoCarga.getPlaca().isEmpty()
                    && veiculoCarga.getPlaca().equalsIgnoreCase(carga.getPlaca())) {
                encontradoVeiculoPlaca = true;

            }
        }
        if (encontradoVeiculoPlaca) {
            throw new VeicExistException();
        }
    }

    public void validarCadastroVeiculoPasseio(Passeio passeio) throws VeicExistException {
        boolean encontradoVeiculoPlaca = false;

        for (Passeio veiculoPasseio : vetorVeiculoPasseio) {
            if (veiculoPasseio != null
                    && !veiculoPasseio.getPlaca().isEmpty()
                    && veiculoPasseio.getPlaca().equalsIgnoreCase(passeio.getPlaca())) {
                encontradoVeiculoPlaca = true;

            }
        }

        if (encontradoVeiculoPlaca) {
            throw new VeicExistException();
        }

    }

    public void addVeiculoPasseio(Passeio passeio) {
        this.vetorVeiculoPasseio.add(passeio);

    }

    public void addVeiculoCarga(Carga carga) {
        this.vetorVeiculoCarga.add(carga);

    }

    public List<Carga> getVetorVeiculoCarga() {
        return this.vetorVeiculoCarga;
    }

    public List<Passeio> getVetorVeiculoPasseio() {
        return this.vetorVeiculoPasseio;
    }
}
