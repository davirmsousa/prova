package questao3.builders;

import questao3.produtos.Disciplina;
import questao3.produtos.Livro;

// INTERFACE DO BUILDER
public interface IBuilder {
    IBuilder resetar();
    IBuilder setNome(String nome);
    IBuilder setCodigo(String codigo);
    IBuilder addDisciplina(Disciplina disciplina);
    IBuilder addLivro(Livro livro);
}