package questao3.prototype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import questao3.produtos.Curso;

public class RegistroDeCursos {
    private static RegistroDeCursos instancia;
    private Collection<Curso> cursos;

    private RegistroDeCursos() {
        this.cursos = new ArrayList<>();
    }

    public static RegistroDeCursos instanciar() {
        if (RegistroDeCursos.instancia == null) {
            RegistroDeCursos.instancia = new RegistroDeCursos();
        }

        return RegistroDeCursos.instancia;
    }

    public void registrar(Curso curso) {
        this.cursos.add(curso);
    }

    public Curso obterPorNome(String nome) {
        for (Curso curso : this.cursos) {
            if (curso.getNome().equalsIgnoreCase(nome)) {
                return curso.clonar();
            }
        }

        throw new NoSuchElementException(nome);
    }
}
