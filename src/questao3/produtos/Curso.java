package questao3.produtos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import questao3.prototype.IPrototipavel;

// PRODUTO CONCRETO
public class Curso extends Produto implements IPrototipavel {
    private Collection<Disciplina> disciplinas;
    private Collection<Livro> livros;

    public Curso() {
        this.disciplinas = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    public Curso(Curso prototipo) {
        this();

        this.setCodigo(prototipo.getCodigo());
        this.setNome(prototipo.getNome());

        for (Disciplina disciplina : prototipo.disciplinas) {
            this.addDisciplina(disciplina.clonar());
        }

        for (Livro livro : prototipo.livros) {
            this.addLivro(livro.clonar());
        }
    }

    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void addLivro(Livro livro) {
        this.livros.add(livro);
    }

    @Override
    public double getPreco() {
        double precoDoCurso = 0;
        
        if (livros != null && livros.size() > 0) {
            for (Livro livro : livros) {
                precoDoCurso += livro.getPreco();
            }
        }
        
        if (disciplinas != null && disciplinas.size() > 0) {
            for (Disciplina disciplina : disciplinas) {
                precoDoCurso += disciplina.getPreco();
            }
        }

        return precoDoCurso * 1.1;
    }

    public int getChTotal() {
        int chTotal = 0;

        if (disciplinas != null && disciplinas.size() > 0) {
            for (Disciplina disciplina : disciplinas) {
                chTotal += disciplina.getChTotal();
            }
        }

        return chTotal;
    }

    public double getPctCumprido() {
        int chTotal = this.getChTotal();
        double horasCumpridas = 0;

        if (disciplinas != null && disciplinas.size() > 0) {
            for (Disciplina disciplina : disciplinas) {
                horasCumpridas += (disciplina.getPctCumprido() * disciplina.getChTotal()) / 100;
            }
        } 

        return horasCumpridas / chTotal * 100;
    }

    public void atualizarProgresso(String codigoDisciplina, double pctCumprido) {
        if (disciplinas != null && disciplinas.size() > 0) {
            for (Disciplina disciplina : disciplinas) {
                if (disciplina.getCodigo().equalsIgnoreCase(codigoDisciplina)) {
                    disciplina.setPctCumprido(pctCumprido);
                    return;
                }
            }
        }

        throw new NoSuchElementException(codigoDisciplina);
    }

    @Override
    public Curso clonar() {
        return new Curso(this);
    }
}