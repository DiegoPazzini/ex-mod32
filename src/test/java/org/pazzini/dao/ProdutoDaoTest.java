// Declaração do pacote org.pazzini.dao, que contém a classe ProdutoDaoTest
package org.pazzini.dao;

// Importação de classes de teste
import org.junit.Test;
// Importação de classes do pacote org.kaly.domain
import org.kaly.domain.Curso;
import org.kaly.domain.Produto;
// Importação de assertivas para testes
import static org.junit.Assert.assertNotNull;

// Classe de teste para a classe ProdutoDao
public class ProdutoDaoTest  {

    // Instância de IProdutoDao para realizar os testes
    private IProdutoDao produtoDao;

    // Construtor que inicializa a instância de ProdutoDao
    public ProdutoDaoTest() {
        produtoDao = new ProdutoDao();
    }

    // Método de teste para o método cadastrar da classe ProdutoDao
    @Test
    public void cadastrar() {
        // Criação de uma instância de Produto para o teste
        Produto produto = new Produto();
        produto.setCodigo("XXX");
        produto.setDescricao("Aula de JPA");
        produto.setNome("Aula Particular");
        // Chamada do método cadastrar da instância de IProdutoDao
        produto = produtoDao.cadastrar(produto);

        // Verifica se a instância de Produto não é nula após o cadastro
        assertNotNull(produto);
        // Verifica se o ID da instância de Produto não é nulo após o cadastro
        assertNotNull(produto.getId());
    }

}
