package questao2.builders;

import questao2.produtos.Disciplina;
import questao2.produtos.Livro;

// INTERFACE DO BUILDER
public interface IBuilder {
    IBuilder resetar();
    IBuilder setNome(String nome);
    IBuilder setCodigo(String codigo);
    IBuilder addDisciplina(Disciplina disciplina);
    IBuilder addLivro(Livro livro);
}