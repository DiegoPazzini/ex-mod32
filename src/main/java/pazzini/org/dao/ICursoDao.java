// Declaração do pacote org.pazzini.dao, que contém a interface ICursoDao
package org.pazzini.dao;

// Importação da classe Curso do pacote org.pazzini.domain
import org.pazzini.domain.Curso;

// Importação de classes relacionadas a listas
import java.util.List;

// Definição da interface ICursoDao
public interface ICursoDao {

    // Método para cadastrar um Curso no banco de dados
    public Curso cadastrar(Curso curso);

    // Método para excluir um Curso do banco de dados
    public void excluir(Curso cur);

    // Método para buscar todos os Cursos no banco de dados
    public List<Curso> buscarTodos();
}
