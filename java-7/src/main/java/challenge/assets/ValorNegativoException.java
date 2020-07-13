package challenge.assets;

public class ValorNegativoException extends IllegalArgumentException {

    public ValorNegativoException () {
        super("Valor não pode ser negativo!");
    }
}
