package questao2.produtos;

// PRODUTO CONCRETO
public class Livro extends Produto {
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public double getPreco() {
        return 0;
    }
}