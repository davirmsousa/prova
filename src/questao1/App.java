package questao1;

import questao1.fabricas.ProdutoFactory;
import questao1.produtos.Produto;
import questao1.util.TipoProdutoEnum;

public class App {
    public static void main(String[] args) throws Exception {
        App.criarProduto(TipoProdutoEnum.DISCIPLINA, "DIS001", "DIS001");
        App.criarProduto(TipoProdutoEnum.LIVRO, "LIVRO001", "LIVRO001");
    }

    private static void criarProduto(TipoProdutoEnum tipo, String codigo, String nome) {
        Produto produto = ProdutoFactory.obterProduto(tipo, codigo, nome);
        System.out.println("[Q1 PRODUTO] Nome: " + produto.getNome() + "; Codigo: " + produto.getCodigo());
    }
}
