package questao3;

import questao3.produtos.Curso;
import questao3.produtos.Disciplina;
import questao3.produtos.Ementa;
import questao3.produtos.Livro;
import questao3.builders.ADSDiretor;
import questao3.builders.CursoBuilder;
import questao3.builders.EmentaBuilder;
import questao3.fabricas.DisciplinaFactory;
import questao3.fabricas.ProdutoFactory;
import questao3.produtos.Produto;
import questao3.prototype.RegistroDeCursos;
import questao3.util.TipoProdutoEnum;

public class App {
    public static void main(String[] args) throws Exception {
        App.factoryDeProduto();
        System.out.println();

        App.buildSemDiretor();
        System.out.println();

        App.buildComDiretor();
        System.out.println();

        App.prototypeDeCurso();
        System.out.println();
    }

    private static void factoryDeProduto() {
        Produto produto = ProdutoFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "DIS001", "DIS001");
        System.out.println("[Q2 PRODUTO] Nome: " + produto.getNome() + "; Codigo: " + produto.getCodigo());

        produto = ProdutoFactory.obterProduto(TipoProdutoEnum.LIVRO, "LIVRO001", "LIVRO001");
        System.out.println("[Q2 PRODUTO] Nome: " + produto.getNome() + "; Codigo: " + produto.getCodigo());
    }

    private static void buildSemDiretor() {
        CursoBuilder cursoBuilder = (CursoBuilder) new CursoBuilder().resetar()
            .setCodigo("CRUSO001")
            .setNome("padroes criacionais")
            .addDisciplina((Disciplina)DisciplinaFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "D001", "Factory Method"))
            .addDisciplina((Disciplina)DisciplinaFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "D002", "Abstract Factory"))
            .addLivro((Livro)DisciplinaFactory.obterProduto(TipoProdutoEnum.LIVRO, "L001", "Padrões de Projeto"));
        
        Curso curso = cursoBuilder.construir();
        System.out.println("[Q2 CURSO S/D] Nome: " + curso.getNome() + "; Codigo: " + curso.getCodigo());

        EmentaBuilder ementaBuilder = (EmentaBuilder) new EmentaBuilder().resetar()
            .setCodigo("EMT001")
            .setNome("Ementa de ADS")
            .addDisciplina((Disciplina)DisciplinaFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "D001", "Disciplina da Ementa 1"))
            .addDisciplina((Disciplina)DisciplinaFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "D002", "Disciplina da Ementa 2"))
            .addLivro((Livro)DisciplinaFactory.obterProduto(TipoProdutoEnum.LIVRO, "L001", "Livro da Ementa 1"))
            .addLivro((Livro)DisciplinaFactory.obterProduto(TipoProdutoEnum.LIVRO, "L001", "Livro da Ementa 2"));
        
        Ementa ementa = ementaBuilder.construir();
        System.out.println("[Q2 EMENTA S/D] Nome: " + ementa.getNome() + "; Codigo: " + ementa.getCodigo());
    }

    private static void buildComDiretor() {
        ADSDiretor adsDiretor = new ADSDiretor();

        CursoBuilder cursoBuilder = new CursoBuilder();
        adsDiretor.construir(cursoBuilder);
        Curso curso = cursoBuilder.construir();
        System.out.println("[Q2 CURSO C/D] Nome: " + curso.getNome() + "; Codigo: " + curso.getCodigo());

        EmentaBuilder ementaBuilder = new EmentaBuilder();
        adsDiretor.construir(ementaBuilder);
        Ementa ementa = ementaBuilder.construir();
        System.out.println("[Q2 EMENTA C/D] Nome: " + ementa.getNome() + "; Codigo: " + ementa.getCodigo());
    }

    private static void prototypeDeCurso() {
        CursoBuilder cursoBuilder = new CursoBuilder();
        (new ADSDiretor()).construir(cursoBuilder);
        Curso curso = cursoBuilder.construir();

        RegistroDeCursos registro = RegistroDeCursos.instanciar();
        registro.registrar(curso);

        Curso curso2 = registro.obterPorNome(curso.getNome());
        curso2.atualizarProgresso("INF001", 50);

        System.out.println("Id1: " + curso + "; Id2" + curso2);
        System.out.println("CHTOTAL1: " + curso.getChTotal() + "; CHTOTAL2: " + curso2.getChTotal());
        System.out.println("PROGRESSO1: " + curso.getPctCumprido() + "; PROGRESSO2: " + curso2.getPctCumprido());
    }
}
