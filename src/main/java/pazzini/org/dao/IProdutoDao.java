// Declaração do pacote org.pazzini.dao, que contém a interface IProdutoDao
package org.pazzini.dao;

// Importação das classes Curso e Produto do pacote org.pazzini.domain
import org.pazzini.domain.Curso;
import org.pazzini.domain.Produto;

// Importação de classes relacionadas a listas
import java.util.List;

// Definição da interface IProdutoDao
public interface IProdutoDao {

    // Método para cadastrar um Produto no banco de dados
    public Produto cadastrar(Produto produto);

    // Método para excluir um Produto do banco de dados
    public void excluir(Produto produto);

    // Método para buscar todos os Produtos no banco de dados
    public List<Produto> buscarTodos();
}
