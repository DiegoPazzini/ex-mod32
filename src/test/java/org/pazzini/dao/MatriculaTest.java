// Declaração do pacote org.pazzini.dao, que contém a classe MatriculaTest
package org.pazzini.dao;

// Importação de classes de assertividade para testes
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// Importação de classes de manipulação de data e hora
import java.time.Instant;
// Importação de listas
import java.util.List;

// Importação de anotações para testes
import org.junit.After;
import org.junit.Test;
// Importação de classes do pacote org.kaly.domain
import org.kaly.domain.Curso;
import org.kaly.domain.Matricula;

// Classe de teste para a classe MatriculaDao
public class MatriculaTest {
    
    // Instâncias de interfaces para realizar os testes
    private IMatriculaDao matriculaDao;
    private ICursoDao cursoDao;

    // Construtor que inicializa as instâncias
    public MatriculaTest() {
        matriculaDao = new MatriculaDao();
        cursoDao = new CursoDao();
    }

    // Método executado após cada teste para realizar a limpeza de dados de teste no banco
    @After
    public void end() {
        List<Matricula> list = matriculaDao.buscarTodos();
        list.forEach(mat -> matriculaDao.excluir(mat));

        List<Curso> listCursos = cursoDao.buscarTodos();
        listCursos.forEach(cur -> cursoDao.excluir(cur));
    }

    // Método de teste para o método cadastrar da classe MatriculaDao
    @Test
    public void cadastrar() {
        // Criação de um curso de teste
        Curso curso = criarCurso("A1");
        // Criação de uma instância de Matricula para o teste
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat.setCurso(curso);
        // Chamada do método cadastrar da instância de IMatriculaDao
        mat = matriculaDao.cadastrar(mat);

        // Verifica se a instância de Matricula não é nula após o cadastro
        assertNotNull(mat);
        // Verifica se o ID da instância de Matricula não é nulo após o cadastro
        assertNotNull(mat.getId());
    }

    // Método de teste para o método buscarPorCurso da classe MatriculaDao
    @Test
    public void pesquisarPorCurso() {
        // Criação de um curso de teste
        Curso curso = criarCurso("A1");
        // Criação de uma instância de Matricula para o teste
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat.setCurso(curso);
        // Chamada do método cadastrar da instância de IMatriculaDao
        mat = matriculaDao.cadastrar(mat);

        // Verifica se a instância de Matricula não é nula após o cadastro
        assertNotNull(mat);
        // Verifica se o ID da instância de Matricula não é nulo após o cadastro
        assertNotNull(mat.getId());

        // Chamada do método buscarPorCurso da instância de IMatriculaDao
        Matricula matricBD = matriculaDao.buscarPorCurso(curso);
        // Verifica se a instância de Matricula encontrada não é nula
        assertNotNull(matricBD);
        // Verifica se o ID da instância de Matricula encontrada é igual ao ID da instância de Matricula cadastrada
        assertEquals(mat.getId(), matricBD.getId());
    }

    // Método de teste para o método buscarPorCodigoCurso da classe MatriculaDao
    @Test
    public void pesquisarPorCodigoCurso() {
        // Criação de um curso de teste
        Curso curso = criarCurso("A1");
        // Criação de uma instância de Matricula para o teste
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat.setCurso(curso);
        // Chamada do método cadastrar da instância de IMatriculaDao
        mat = matriculaDao.cadastrar(mat);

        // Verifica se a instância de Matricula não é nula após o cadastro
        assertNotNull(mat);
        // Verifica se o ID da instância de Matricula não é nulo após o cadastro
        assertNotNull(mat.getId());

        // Chamada do método buscarPorCodigoCurso da instância de IMatriculaDao
        Matricula matricBD = matriculaDao.buscarPorCodigoCurso(curso.getCodigo());
        // Verifica se a instância de Matricula encontrada não é nula
        assertNotNull(matricBD);
        // Verifica se o ID da instância de Matricula encontrada é igual ao ID da instância de Matricula cadastrada
        assertEquals(mat.getId(), matricBD.getId());
    }

    // Método de teste para o método buscarPorCodigoCursoCriteria da classe MatriculaDao
    @Test
    public void pesquisarPorCodigoCursoCriteria() {
        // Criação de um curso de teste
        Curso curso = criarCurso("A1");
        // Criação de uma instância de Matricula para o teste
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat.setCurso(curso);
        // Chamada do método cadastrar da instância de IMatriculaDao
        mat = matriculaDao.cadastrar(mat);

        // Verifica se a instância de Matricula não é nula após o cadastro
        assertNotNull(mat);
        // Verifica se o ID da instância de Matricula não é nulo após o cadastro
        assertNotNull(mat.getId());

        // Chamada do método buscarPorCodigoCursoCriteria da instância de IMatriculaDao
        Matricula matricBD = matriculaDao.buscarPorCodigoCursoCriteria(curso.getCodigo());
        // Verifica se a instância de Matricula encontrada não é nula
        assertNotNull(matricBD);
        // Verifica se o ID da instância de Matricula encontrada é igual ao ID da instância de Matricula cadastrada
        assertEquals(mat.getId(), matricBD.getId());
    }

    // Método de teste para o método buscarPorCursoCriteria da classe MatriculaDao
    @Test
    public void pesquisarPorCursoCriteria() {
        // Criação de um curso de teste
        Curso curso = criarCurso("A1");
        // Criação de uma instância de Matricula para o teste
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat.setCurso(curso);
        // Chamada do método cadastrar da instância de IMatriculaDao
        mat = matriculaDao.cadastrar(mat);

        // Verifica se a instância de Matricula não é nula após o cadastro
        assertNotNull(mat);
        // Verifica se o ID da instância de Matricula não é nulo após o cadastro
        assertNotNull(mat.getId());

        // Chamada do método buscarPorCursoCriteria da instância de IMatriculaDao
        Matricula matricBD = matriculaDao.buscarPorCursoCriteria(curso);
        // Verifica se a instância de Matricula encontrada não é nula
        assertNotNull(matricBD);
        // Verifica se o ID da instância de Matricula encontrada é igual ao ID da instância de Matricula cadastrada
        assertEquals(mat.getId(), matricBD.getId());
    }

    // Método privado para criar um curso de teste
    private Curso criarCurso(String codigo) {
        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setDescricao("CURSO TESTE");
        curso.setNome("Curso de Java Backend");
        // Chamada do método cadastrar da instância de ICursoDao para cadastrar o curso
        return cursoDao.cadastrar(curso);
    }

}
