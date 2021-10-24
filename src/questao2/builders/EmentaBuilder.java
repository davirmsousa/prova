package questao2.builders;

import questao2.produtos.Disciplina;
import questao2.produtos.Ementa;
import questao2.produtos.Livro;

// BUILDER CONCRETO DE EMENTA
public class EmentaBuilder implements IBuilder {

    private Ementa ementa;

    @Override
    public IBuilder resetar() {
        this.ementa = new Ementa();
        return this;
    }

    @Override
    public IBuilder setNome(String nome) {
        this.ementa.setNome(nome);
        return this;
    }

    @Override
    public IBuilder setCodigo(String codigo) {
        this.ementa.setCodigo(codigo);
        return this;
    }

    @Override
    public IBuilder addDisciplina(Disciplina disciplina) {
        this.ementa.addDisciplina(disciplina);
        return this;
    }

    @Override
    public IBuilder addLivro(Livro livro) {
        this.ementa.addLivro(livro);
        return this;
    }

    public Ementa construir() {
        Ementa ementa = this.ementa;
        this.resetar();
        return ementa;
    }
    
}