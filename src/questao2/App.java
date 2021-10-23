package questao2;

import questao2.produtos.Curso;
import questao2.produtos.Disciplina;
import questao2.produtos.Ementa;
import questao2.produtos.Livro;
import questao2.builders.CursoBuilder;
import questao2.builders.EmentaBuilder;
import questao2.fabricas.DisciplinaFactory;
import questao2.fabricas.ProdutoFactory;
import questao2.produtos.Produto;
import questao2.util.TipoProdutoEnum;

public class App {
    public static void main(String[] args) throws Exception {
        App.criarProduto(TipoProdutoEnum.DISCIPLINA, "DIS001", "DIS001");
        App.criarProduto(TipoProdutoEnum.LIVRO, "LIVRO001", "LIVRO001");

        Curso curso = new CursoBuilder().resetar()
            .setCodigo("CRUSO001")
            .setNome("padroes criacionais")
            .addDisciplina((Disciplina)DisciplinaFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "D001", "Factory Method"))
            .addDisciplina((Disciplina)DisciplinaFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "D002", "Abstract Factory"))
            .addLivro((Livro)DisciplinaFactory.obterProduto(TipoProdutoEnum.LIVRO, "L001", "Padrões de Projeto"))
            .construir();
        
            System.out.println("[Q2 CURSO] Nome: " + curso.getNome() + "; Codigo: " + curso.getCodigo());

        Ementa ementa = new EmentaBuilder().resetar()
            .setCodigo("EMT001")
            .setNome("Ementa de ADS")
            .addDisciplina((Disciplina)DisciplinaFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "D001", "Disciplina da Ementa 1"))
            .addDisciplina((Disciplina)DisciplinaFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "D002", "Disciplina da Ementa 2"))
            .addLivro((Livro)DisciplinaFactory.obterProduto(TipoProdutoEnum.LIVRO, "L001", "Livro da Ementa 1"))
            .addLivro((Livro)DisciplinaFactory.obterProduto(TipoProdutoEnum.LIVRO, "L001", "Livro da Ementa 2"))
            .construir();

            System.out.println("[Q2 EMENTA] Nome: " + ementa.getNome() + "; Codigo: " + ementa.getCodigo());
    }

    private static void criarProduto(TipoProdutoEnum tipo, String codigo, String nome) {
        Produto produto = ProdutoFactory.obterProduto(tipo, codigo, nome);
        System.out.println("[Q2 PRODUTO] Nome: " + produto.getNome() + "; Codigo: " + produto.getCodigo());
    }
}
