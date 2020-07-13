package challenge.assets;

import challenge.Carro;
import challenge.EstacionamentoException;

public class Validacao {

    public static int idadeMinima = 18;
    public static int numeroMaximoPontos = 20;

    public static void validarVagaEstacionamento(Carro carro) {
        if (carro.getMotorista() == null) {
            throw new EstacionamentoException("O carro não deve ser autônomo, ou seja, é necessário que exista um motorista.");
        }
        if (carro.getMotorista().getIdade() < idadeMinima) {
            throw new EstacionamentoException("O motorista precisa ter idade suficiente para dirigir e possuir uma habilitação.");
        }
        if (carro.getMotorista().getPontos() > numeroMaximoPontos) {
            throw new EstacionamentoException("A habilitação não pode está suspensa (ou superior a 20 pontos).");
        }
    }
}
