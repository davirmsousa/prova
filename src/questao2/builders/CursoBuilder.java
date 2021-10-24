package questao2.builders;

import questao2.produtos.Curso;
import questao2.produtos.Disciplina;
import questao2.produtos.Livro;

// BUILDER CONCRETO DE CURSO
public class CursoBuilder implements IBuilder {

    private Curso curso;

    @Override
    public IBuilder resetar() {
        this.curso = new Curso();
        return this;
    }

    @Override
    public IBuilder setNome(String nome) {
        this.curso.setNome(nome);
        return this;
    }

    @Override
    public IBuilder setCodigo(String codigo) {
        this.curso.setCodigo(codigo);
        return this;
    }

    @Override
    public IBuilder addDisciplina(Disciplina disciplina) {
        this.curso.addDisciplina(disciplina);
        return this;
    }

    @Override
    public IBuilder addLivro(Livro livro) {
        this.curso.addLivro(livro);
        return this;
    }

    public Curso construir() {
        Curso curso = this.curso;
        this.resetar();
        return curso;
    }

}