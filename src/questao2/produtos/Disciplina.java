package questao2.produtos;

// PRODUTO CONCRETO
public class Disciplina extends Produto {
    private double pctCumprido;
    private int chTotal;

    public double getPctCumprido() {
        return pctCumprido;
    }

    public void setPctCumprido(double pctCumprido) {
        this.pctCumprido = pctCumprido;
    }

    public int getChTotal() {
        return chTotal;
    }

    public void setChTotal(int chTotal) {
        this.chTotal = chTotal;
    }

    @Override
    public double getPreco() {
        return 0;
    }
}