package questao2.builders;

import questao2.fabricas.ProdutoFactory;
import questao2.produtos.Disciplina;
import questao2.produtos.Livro;
import questao2.util.TipoProdutoEnum;

// DIRETOR CONCRETO DE ADS
public class ADSDiretor implements IDiretor {

    // ao invés de implmentar uma interface e ter classes diferentes,
    // para cada curso poderiam ter metodos diferentes. eg.: construirADS, construirENG

    @Override
    public void construir(IBuilder builder) {
        Disciplina dPadroes = (Disciplina) ProdutoFactory.obterProduto(TipoProdutoEnum.DISCIPLINA,
            "INF001", "PADROES DE PROJETO");

        Disciplina dSO = (Disciplina) ProdutoFactory.obterProduto(TipoProdutoEnum.DISCIPLINA,
            "INF002", "SISTEMAS OPERACIONAIS");

        Livro lPadroes = (Livro) ProdutoFactory.obterProduto(TipoProdutoEnum.LIVRO,
            "LV001", "PADROES DE PROJETO - GoF");

        Livro lSO = (Livro) ProdutoFactory.obterProduto(TipoProdutoEnum.LIVRO,
            "LV002", "SISTEMAS OPERACIONAIS MODERNOS - TANENBAUM");

        builder.resetar()
            .setCodigo("ADS")
            .setNome("ANALISE E DESENVOLVIMENTO DE SISTEMAS")
            .addDisciplina(dPadroes)
            .addDisciplina(dSO)
            .addLivro(lPadroes)
            .addLivro(lSO);
    }
}
