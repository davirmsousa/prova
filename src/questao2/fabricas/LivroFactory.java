package questao2.fabricas;

import questao2.produtos.Livro;
import questao2.produtos.Produto;

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
