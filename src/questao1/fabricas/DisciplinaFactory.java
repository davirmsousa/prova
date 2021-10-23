package questao1.fabricas;

import questao1.produtos.Disciplina;
import questao1.produtos.Produto;

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
