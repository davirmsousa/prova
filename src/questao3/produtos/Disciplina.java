package questao3.produtos;

import questao3.prototype.IPrototipavel;

// PRODUTO CONCRETO
public class Disciplina extends Produto implements IPrototipavel {
    private double pctCumprido;
    private int chTotal;

    public Disciplina() {
    }

    public Disciplina(Disciplina prototipo) {
        this();

        this.setPctCumprido(prototipo.getPctCumprido());
        this.setChTotal(prototipo.getChTotal());
        this.setCodigo(prototipo.getCodigo());
        this.setNome(prototipo.getNome());
    }

    public double getPctCumprido() {
        return this.pctCumprido;
    }

    public void setPctCumprido(double pctCumprido) {
        this.pctCumprido = pctCumprido;
    }

    public int getChTotal() {
        return this.chTotal;
    }

    public void setChTotal(int chTotal) {
        this.chTotal = chTotal;
    }

    @Override
    public double getPreco() {
        return 0;
    }

    @Override
    public Disciplina clonar() {
        return new Disciplina(this);
    }
}