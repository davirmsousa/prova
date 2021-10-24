package questao3.produtos;

// PRODUTO
public abstract class Produto {
    protected String codigo;
    protected String nome;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract double getPreco();
}