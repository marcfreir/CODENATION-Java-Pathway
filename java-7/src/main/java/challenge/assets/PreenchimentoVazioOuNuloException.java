package challenge.assets;

public class PreenchimentoVazioOuNuloException extends NullPointerException {

    public PreenchimentoVazioOuNuloException() {
        super("Valor não pode ficar vazio ou nulo!");
    }
}
