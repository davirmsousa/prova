package questao2.fabricas;

import questao2.produtos.Disciplina;
import questao2.produtos.Produto;

// FABRICA CONCRETA
public class DisciplinaFactory extends ProdutoFactory {

    @Override
    protected Produto criarProduto(String codigo, String nome) {
        Disciplina disciplina = new Disciplina();

        disciplina.setCodigo(codigo);
        disciplina.setNome(nome);

        return disciplina;
    }
}
