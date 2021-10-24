package questao3.fabricas;

import questao3.produtos.Livro;
import questao3.produtos.Produto;

// FABRICA CONCRETA
public class LivroFactory extends ProdutoFactory {

    @Override
    protected Produto criarProduto(String codigo, String nome) {
        Livro livro = new Livro();

        livro.setCodigo(codigo);
        livro.setNome(nome);

        return livro;
    }
}
