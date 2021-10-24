package questao3.builders;

import questao3.fabricas.ProdutoFactory;
import questao3.produtos.Disciplina;
import questao3.produtos.Livro;
import questao3.util.TipoProdutoEnum;

// DIRETOR CONCRETO DE ADS
public class ADSDiretor implements IDiretor {

    // ao invés de implmentar uma interface e ter classes diferentes,
    // para cada curso poderiam ter metodos diferentes. eg.: construirADS, construirENG

    @Override
    public void construir(IBuilder builder) {
        Disciplina dPadroes = (Disciplina) ProdutoFactory.obterProduto(TipoProdutoEnum.DISCIPLINA,
            "INF001", "PADROES DE PROJETO");
        dPadroes.setChTotal(200);

        Disciplina dSO = (Disciplina) ProdutoFactory.obterProduto(TipoProdutoEnum.DISCIPLINA,
            "INF002", "SISTEMAS OPERACIONAIS");
        dSO.setChTotal(300);

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
