package questao2.builders;

import questao2.produtos.Disciplina;
import questao2.produtos.Ementa;
import questao2.produtos.Livro;

// BUILDER CONCRETO
public class EmentaBuilder implements IBuilder {

    private Ementa ementa;

    public EmentaBuilder() {
        this.resetar();
    }

    @Override
    public EmentaBuilder resetar() {
        this.ementa = new Ementa();
        return this;
    }

    @Override
    public EmentaBuilder setNome(String nome) {
        this.ementa.setNome(nome);
        return this;
    }

    @Override
    public EmentaBuilder setCodigo(String codigo) {
        this.ementa.setCodigo(codigo);
        return this;
    }

    @Override
    public EmentaBuilder addDisciplina(Disciplina disciplina) {
        this.ementa.addDisciplina(disciplina);
        return this;
    }

    @Override
    public EmentaBuilder addLivro(Livro livro) {
        this.ementa.addLivro(livro);
        return this;
    }
    
    public Ementa construir() {
        return this.ementa;
    }
}
