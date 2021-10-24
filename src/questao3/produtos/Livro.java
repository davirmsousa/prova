package questao3.produtos;

import questao3.prototype.IPrototipavel;

// PRODUTO CONCRETO
public class Livro extends Produto implements IPrototipavel {
    private double preco;
    private String isbn;

    public Livro() {
    }

    public Livro(Livro prototipo) {
        this();
        
        this.setCodigo(prototipo.getCodigo());
        this.setPreco(prototipo.getPreco());
        this.setNome(prototipo.getNome());
        this.setIsbn(prototipo.getIsbn());
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    @Override
    public Livro clonar() {
        return new Livro(this);
    }
}