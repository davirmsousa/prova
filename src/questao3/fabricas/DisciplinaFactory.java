package questao3.fabricas;

import questao3.produtos.Disciplina;
import questao3.produtos.Produto;

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
