package questao3.produtos;

import java.util.ArrayList;
import java.util.Collection;

public class Ementa {
    private Collection<Disciplina> disciplinas;
    private Collection<Livro> livros;
    private String codigo;
    private String nome;

    public Ementa() {
        this.disciplinas = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void addLivro(Livro livro) {
        this.livros.add(livro);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
