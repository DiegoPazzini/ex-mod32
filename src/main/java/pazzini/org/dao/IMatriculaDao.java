// Declaração do pacote org.pazzini.dao, que contém a interface IMatriculaDao
package org.pazzini.dao;

// Importação das classes Curso e Matricula do pacote org.pazzini.domain
import org.pazzini.domain.Curso;
import org.pazzini.domain.Matricula;

// Importação de classes relacionadas a listas
import java.util.List;

// Definição da interface IMatriculaDao
public interface IMatriculaDao {

    // Método para cadastrar uma Matrícula no banco de dados
    Matricula cadastrar(Matricula mat);

    // Método para buscar uma Matrícula pelo código do Curso
    Matricula buscarPorCodigoCurso(String codigoCurso);

    // Método para buscar uma Matrícula pelo Curso
    Matricula buscarPorCurso(Curso curso);

    // Método para buscar uma Matrícula pelo código do Curso usando Criteria API
    Matricula buscarPorCodigoCursoCriteria(String codigoCurso);

    // Método para buscar uma Matrícula pelo Curso usando Criteria API
    Matricula buscarPorCursoCriteria(Curso curso);

    // Método para buscar todas as Matrículas no banco de dados
    List<Matricula> buscarTodos();

    // Método para excluir uma Matrícula do banco de dados
    void excluir(Matricula matricula);
}
