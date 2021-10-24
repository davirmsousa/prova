package questao3;

import questao3.produtos.Curso;
import questao3.produtos.Disciplina;
import questao3.produtos.Ementa;
import questao3.produtos.Livro;
import questao3.builders.CursoBuilder;
import questao3.builders.EmentaBuilder;
import questao3.fabricas.DisciplinaFactory;
import questao3.fabricas.ProdutoFactory;
import questao3.produtos.Produto;
import questao3.prototype.RegistroDeCursos;
import questao3.util.TipoProdutoEnum;

public class App {
    public static void main(String[] args) throws Exception {
        App.criarProduto(TipoProdutoEnum.DISCIPLINA, "DIS001", "DIS001");
        App.criarProduto(TipoProdutoEnum.LIVRO, "LIVRO001", "LIVRO001");
        
        App.criarEmenta();

        Curso curso = App.criarCurso();

        RegistroDeCursos registro = RegistroDeCursos.instanciar();
        registro.registrar(curso);

        Curso curso2 = registro.obterPorNome(curso.getNome());
        curso2.atualizarProgresso("D002", 50);

        System.out.println("Id1: " + curso + "; Id2" + curso2);
        System.out.println("CHTOTAL1: " + curso.getChTotal() + "; CHTOTAL2: " + curso2.getChTotal());
        System.out.println("PROGRESSO1: " + curso.getPctCumprido() + "; PROGRESSO2: " + curso2.getPctCumprido());
    }

    private static void criarProduto(TipoProdutoEnum tipo, String codigo, String nome) {
        Produto produto = ProdutoFactory.obterProduto(tipo, codigo, nome);
        System.out.println("[Q3 PRODUTO] Nome: " + produto.getNome() + "; Codigo: " + produto.getCodigo());
    }

    private static Curso criarCurso() {
        Disciplina dFM = (Disciplina)DisciplinaFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "D001", "Factory Method");
        dFM.setChTotal(200);

        Disciplina dAF = (Disciplina)DisciplinaFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "D002", "Abstract Factory");
        dAF.setChTotal(300);

        Curso curso = new CursoBuilder().resetar()
            .setCodigo("CRUSO001")
            .setNome("padroes criacionais")
            .addDisciplina(dFM)
            .addDisciplina(dAF)
            .addLivro((Livro)DisciplinaFactory.obterProduto(TipoProdutoEnum.LIVRO, "L001", "Padrões de Projeto"))
            .construir();
        
        System.out.println("[Q3 CURSO] Nome: " + curso.getNome() + "; Codigo: " + curso.getCodigo());

        return curso;
    }

    private static Ementa criarEmenta() {
        Disciplina dFM = (Disciplina)DisciplinaFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "D001", "Factory Method");
        dFM.setChTotal(200);

        Disciplina dAF = (Disciplina)DisciplinaFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "D002", "Abstract Factory");
        dAF.setChTotal(300);

        Ementa ementa = new EmentaBuilder().resetar()
            .setCodigo("EMT001")
            .setNome("Ementa de ADS")
            .addDisciplina(dFM)
            .addDisciplina(dAF)
            .addLivro((Livro)DisciplinaFactory.obterProduto(TipoProdutoEnum.LIVRO, "L001", "Livro da Ementa 1"))
            .addLivro((Livro)DisciplinaFactory.obterProduto(TipoProdutoEnum.LIVRO, "L001", "Livro da Ementa 2"))
            .construir();
        
        System.out.println("[Q3 EMENTA] Nome: " + ementa.getNome() + "; Codigo: " + ementa.getCodigo());

        return ementa;
    }
}
