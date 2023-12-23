// Importação do pacote org.pazzini.dao, que contém a classe CursoDao
package org.pazzini.dao;

// Importação da classe Curso do pacote org.pazzini.domain
import org.pazzini.domain.Curso;

// Importação de classes relacionadas a listas
import java.util.List;

// Importação de classes relacionadas a persistência JPA (Java Persistence API)
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

// Declaração da classe CursoDao que implementa a interface ICursoDao
public class CursoDao implements ICursoDao {

    // Método para cadastrar um Curso no banco de dados
    @Override
    public Curso cadastrar(Curso curso) {
        // Criação da fábrica de EntityManager
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        
        // Criação do EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Início da transação
        entityManager.getTransaction().begin();

        // Persistência do objeto Curso no banco de dados
        entityManager.persist(curso);

        // Commit da transação
        entityManager.getTransaction().commit();

        // Fechamento do EntityManager
        entityManager.close();

        // Fechamento da fábrica de EntityManager
        entityManagerFactory.close();

        // Retorno do objeto Curso
        return curso;
    }

    // Método para excluir um Curso do banco de dados
    @Override
    public void excluir(Curso cur) {
        // Criação da fábrica de EntityManager
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");

        // Criação do EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Início da transação
        entityManager.getTransaction().begin();

        // Mescla o objeto Curso com o EntityManager
        cur = entityManager.merge(cur);

        // Remove o objeto Curso do banco de dados
        entityManager.remove(cur);

        // Commit da transação
        entityManager.getTransaction().commit();

        // Fechamento do EntityManager
        entityManager.close();

        // Fechamento da fábrica de EntityManager
        entityManagerFactory.close();
    }

    // Método para buscar todos os Cursos no banco de dados
    @Override
    public List<Curso> buscarTodos() {
        // Criação da fábrica de EntityManager
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");

        // Criação do EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Criação do construtor de critérios para consulta
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        // Criação da consulta de critérios para a classe Curso
        CriteriaQuery<Curso> query = builder.createQuery(Curso.class);

        // Criação do ponto de partida da consulta
        Root<Curso> root = query.from(Curso.class);

        // Seleciona todos os registros da tabela Curso
        query.select(root);

        // Criação da consulta tipada
        TypedQuery<Curso> tpQuery =
                entityManager.createQuery(query);

        // Execução da consulta e obtenção da lista de resultados
        List<Curso> list = tpQuery.getResultList();

        // Fechamento do EntityManager
        entityManager.close();

        // Fechamento da fábrica de EntityManager
        entityManagerFactory.close();

        // Retorno da lista de Cursos
        return list;
    }
}