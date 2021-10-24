package questao3.builders;

import questao3.fabricas.ProdutoFactory;
import questao3.produtos.Disciplina;
import questao3.produtos.Livro;
import questao3.util.TipoProdutoEnum;

// DIRETOR CONCRETO DE ENGENHARIA
public class EngenhariaDiretor implements IDiretor {

    @Override
    public void construir(IBuilder builder) {
        Disciplina disciplina1 = (Disciplina) ProdutoFactory.obterProduto(TipoProdutoEnum.DISCIPLINA,
            "ENG001", "DISC ENG 001");

        Disciplina disciplina2 = (Disciplina) ProdutoFactory.obterProduto(TipoProdutoEnum.DISCIPLINA,
            "ENG002", "DISC ENG 002");

        Livro livro1 = (Livro) ProdutoFactory.obterProduto(TipoProdutoEnum.LIVRO,
            "LV001", "LIVRO ENG 001");

        Livro livro2 = (Livro) ProdutoFactory.obterProduto(TipoProdutoEnum.LIVRO,
            "LV002", "LIVRO ENG 002");

        builder.resetar()
            .setCodigo("ENG")
            .setNome("ENGENHARIA DE ALGUMA COISA")
            .addDisciplina(disciplina1)
            .addDisciplina(disciplina2)
            .addLivro(livro1)
            .addLivro(livro2);
    }
    
}
