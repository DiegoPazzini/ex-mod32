// Declaração do pacote org.pazzini.dao, que contém a classe MatriculaDao
package org.pazzini.dao;

// Importação de classes relacionadas a listas
import java.util.List;

// Importação de classes relacionadas a persistência JPA (Java Persistence API)
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

// Importação das classes Curso e Matricula do pacote org.pazzini.domain
import org.pazzini.domain.Curso;
import org.pazzini.domain.Matricula;

// Declaração da classe MatriculaDao que implementa a interface IMatriculaDao
public class MatriculaDao implements IMatriculaDao {

    // Método para cadastrar uma Matrícula no banco de dados
    @Override
    public Matricula cadastrar(Matricula mat) {
        // Criação da fábrica de EntityManager
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        // Criação do EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Início da transação
        entityManager.getTransaction().begin();
        // Persistência do objeto Matricula no banco de dados
        entityManager.persist(mat);
        // Commit da transação
        entityManager.getTransaction().commit();

        // Fechamento do EntityManager
        entityManager.close();
        // Fechamento da fábrica de EntityManager
        entityManagerFactory.close();
        
        // Retorno do objeto Matricula
        return mat;
    }

    // Método para buscar uma Matrícula pelo código do Curso
    @Override
    public Matricula buscarPorCodigoCurso(String codigoCurso) {
        // Criação da fábrica de EntityManager
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        // Criação do EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Construção da consulta JPQL
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT m FROM Matricula m ");
        sb.append("INNER JOIN Curso c on c = m.curso ");
        sb.append("WHERE c.codigo = :codigoCurso");

        // Início da transação
        entityManager.getTransaction().begin();
        // Criação da consulta tipada
        TypedQuery<Matricula> query =
                entityManager.createQuery(sb.toString(), Matricula.class);
        // Parâmetro da consulta
        query.setParameter("codigoCurso", codigoCurso);
        // Obtenção do resultado
        Matricula matricula = query.getSingleResult();

        // Fechamento do EntityManager
        entityManager.close();
        // Fechamento da fábrica de EntityManager
        entityManagerFactory.close();

        // Retorno do objeto Matricula
        return matricula;
    }

    // Método para buscar uma Matrícula pelo Curso
    @Override
    public Matricula buscarPorCurso(Curso curso) {
        // Criação da fábrica de EntityManager
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        // Criação do EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Construção da consulta JPQL
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT m FROM Matricula m ");
        sb.append("INNER JOIN Curso c on c = m.curso ");
        sb.append("WHERE c = :curso");

        // Início da transação
        entityManager.getTransaction().begin();
        // Criação da consulta tipada
        TypedQuery<Matricula> query =
                entityManager.createQuery(sb.toString(), Matricula.class);
        // Parâmetro da consulta
        query.setParameter("curso", curso);
        // Obtenção do resultado
        Matricula matricula = query.getSingleResult();

        // Fechamento do EntityManager
        entityManager.close();
        // Fechamento da fábrica de EntityManager
        entityManagerFactory.close();

        // Retorno do objeto Matricula
        return matricula;
    }

    // Método para buscar uma Matrícula pelo código do Curso usando Criteria API
    @Override
    public Matricula buscarPorCodigoCursoCriteria(String codigoCurso) {
        // Criação da fábrica de EntityManager
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        // Criação do EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Criação do construtor de critérios
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // Criação da consulta de critérios para a classe Matricula
        CriteriaQuery<Matricula> query = builder.createQuery(Matricula.class);
        // Ponto de partida da consulta
        Root<Matricula> root = query.from(Matricula.class);
        // Join com a classe Curso usando Criteria API
        Join<Object, Object> join = root.join("curso", JoinType.INNER);
        // Seleção dos resultados
        query.select(root).where(builder.equal(join.get("codigo"), codigoCurso));

        // Criação da consulta tipada
        TypedQuery<Matricula> tpQuery =
                entityManager.createQuery(query);
        // Obtenção do resultado
        Matricula matricula = tpQuery.getSingleResult();

        // Fechamento do EntityManager
        entityManager.close();
        // Fechamento da fábrica de EntityManager
        entityManagerFactory.close();

        // Retorno do objeto Matricula
        return matricula;
    }

    // Método para buscar uma Matrícula pelo Curso usando Criteria API
    @Override
    public Matricula buscarPorCursoCriteria(Curso curso) {
        // Criação da fábrica de EntityManager
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        // Criação do EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Criação do construtor de critérios
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // Criação da consulta de critérios para a classe Matricula
        CriteriaQuery<Matricula> query = builder.createQuery(Matricula.class);
        // Ponto de partida da consulta
        Root<Matricula> root = query.from(Matricula.class);
        // Join com a classe Curso usando Criteria API
        Join<Object, Object> join = root.join("curso", JoinType.INNER);
        // Seleção dos resultados
        query.select(root).where(builder.equal(join, curso));

        // Criação da consulta tipada
        TypedQuery<Matricula> tpQuery =
                entityManager.createQuery(query);
        // Obtenção do resultado
        Matricula matricula = tpQuery.getSingleResult();

        // Fechamento do EntityManager
        entityManager.close();
        // Fechamento da fábrica de EntityManager
        entityManagerFactory.close();

        // Retorno do objeto Matricula
        return matricula;
    }

    // Método para buscar todas as Matrículas no banco de dados
    @Override
    public List<Matricula> buscarTodos() {
        // Criação da fábrica de EntityManager
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        // Criação do EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Criação do construtor de critérios
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // Criação da consulta de critérios para a classe Matricula
        CriteriaQuery<Matricula> query = builder.createQuery(Matricula.class);
        // Ponto de partida da consulta
        Root<Matricula> root = query.from(Matricula.class);
        // Seleção dos resultados
        query.select(root);

        // Criação da consulta tipada
        TypedQuery<Matricula> tpQuery =
                entityManager.createQuery(query);
        // Obtenção da lista de resultados
        List<Matricula> list = tpQuery.getResultList();

        // Fechamento do EntityManager
        entityManager.close();
        // Fechamento da fábrica de EntityManager
        entityManagerFactory.close();
        
        // Retorno da lista de Matriculas
        return list;
    }

    // Método para excluir uma Matrícula do banco de dados
    @Override
    public void excluir(Matricula matricula) {
        // Criação da fábrica de EntityManager
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        // Criação do EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Início da transação
        entityManager.getTransaction().begin();
        // Atualização do objeto Matricula no contexto de persistência
        matricula = entityManager.merge(matricula);
        // Remoção do objeto Matricula do banco de dados
        entityManager.remove(matricula);
        // Commit da transação
        entityManager.getTransaction().commit();

        // Fechamento do EntityManager
        entityManager.close();
        // Fechamento da fábrica de EntityManager
        entityManagerFactory.close();
    }
}
