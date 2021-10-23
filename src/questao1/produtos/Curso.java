package questao1.produtos;

import java.util.Collection;

// PRODUTO CONCRETO
public class Curso extends Produto {
    private Collection<Disciplina> disciplinas;
    private Collection<Livro> livros;

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
}