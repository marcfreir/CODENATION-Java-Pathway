package challenge;

import challenge.assets.Validacao;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private List<Carro> carrosEstacionados = new ArrayList<>();
    private int limiteVagas = 10;
    private int idadePreferencial = 55;

    public void estacionar(Carro carro) {
        Validacao.validarVagaEstacionamento(carro);
        if (this.carrosEstacionados.size() == this.limiteVagas) {
            checarVagaEstacionamentoLotado(carro);
        } else {
            this.carrosEstacionados.add(carro);
        }
    }

    private void checarVagaEstacionamentoLotado(Carro carro) {
        for (int index = 0; index < this.limiteVagas; index++) {
            if (this.carrosEstacionados.get(index).getMotorista().getIdade() <= idadePreferencial) {
                this.carrosEstacionados.set(index, carro);
                break;
            }
            if (index == this.limiteVagas - 1) {
                throw new EstacionamentoException("Não temos vagas (todos os motoristas possuem 55 anos ou mais)!");
            }
        }
    }

    public int carrosEstacionados() {
        return this.carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        for (Carro carroEstacionado : carrosEstacionados) {
            if (carroEstacionado.equals(carro)) {
                return true;
            }
        }
        return false;
    }
}
