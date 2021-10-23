package questao2.builders;

import questao2.produtos.Disciplina;
import questao2.produtos.Livro;
import questao2.produtos.Curso;

// BUILDER CONCRETO
public class CursoBuilder implements IBuilder {

    private Curso curso;

    public CursoBuilder() {
        this.resetar();
    }

    @Override
    public CursoBuilder resetar() {
        this.curso = new Curso();
        return this;
    }

    @Override
    public CursoBuilder setNome(String nome) {
        this.curso.setNome(nome);
        return this;
    }

    @Override
    public CursoBuilder setCodigo(String codigo) {
        this.curso.setCodigo(codigo);
        return this;
    }

    @Override
    public CursoBuilder addDisciplina(Disciplina disciplina) {
        this.curso.addDisciplina(disciplina);
        return this;
    }

    @Override
    public CursoBuilder addLivro(Livro livro) {
        this.curso.addLivro(livro);
        return this;
    }
    
    public Curso construir() {
        return this.curso;
    }
}
