// Declaração do pacote org.pazzini.dao, que contém a classe CursoDaoTest
package org.pazzini.dao;

// Importação das classes relacionadas a testes
import org.junit.Test;
// Importação da classe Curso do pacote org.pazzini.domain
import org.pazzini.domain.Curso;
// Importação da classe de assertividade para testes
import static org.junit.Assert.assertNotNull;

// Classe de teste para a classe CursoDao
public class CursoDaoTest {

    // Instância de ICursoDao para realizar os testes
    private ICursoDao cursoDao;

    // Construtor que inicializa a instância de CursoDao
    public CursoDaoTest() {
        cursoDao = new CursoDao();
    }

    // Método de teste para o método cadastrar da classe CursoDao
    @Test
    public void cadastrar() {
        // Criação de uma instância de Curso para o teste
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("CURSO TESTE");
        curso.setNome("Curso de Java Backend");
        
        // Chamada do método cadastrar da instância de ICursoDao
        curso = cursoDao.cadastrar(curso);

        // Verifica se a instância de Curso não é nula após o cadastro
        assertNotNull(curso);
        // Verifica se o ID da instância de Curso não é nulo após o cadastro
        assertNotNull(curso.getId());
    }
}
