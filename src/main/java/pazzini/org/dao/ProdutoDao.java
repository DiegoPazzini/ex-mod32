// Declaração do pacote org.pazzini.dao, que contém a classe ProdutoDao
package org.pazzini.dao;

// Importação das classes relacionadas a persistência JPA (Java Persistence API)
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

// Importação da classe Produto do pacote org.pazzini.domain
import org.pazzini.domain.Produto;

// Declaração da classe ProdutoDao que implementa a interface IProdutoDao
public class ProdutoDao implements IProdutoDao {

    // Método para cadastrar um Produto no banco de dados
    @Override
    public Produto cadastrar(Produto produto) {
        // Criação da fábrica de EntityManager
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        // Criação do EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Início da transação
        entityManager.getTransaction().begin();
        // Persistência do objeto Produto no banco de dados
        entityManager.persist(produto);
        // Commit da transação
        entityManager.getTransaction().commit();

        // Fechamento do EntityManager
        entityManager.close();
        // Fechamento da fábrica de EntityManager
        entityManagerFactory.close();

        // Retorno do objeto Produto
        return produto;
    }

    // Método para excluir um Produto do banco de dados
    @Override
    public void excluir(Produto produto) {
        // Criação da fábrica de EntityManager
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        // Criação do EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Início da transação
        entityManager.getTransaction().begin();
        // Atualização do objeto Produto no contexto de persistência
        produto = entityManager.merge(produto);
        // Remoção do objeto Produto do banco de dados
        entityManager.remove(produto);
        // Commit da transação
        entityManager.getTransaction().commit();

        // Fechamento do EntityManager
        entityManager.close();
        // Fechamento da fábrica de EntityManager
        entityManagerFactory.close();
    }

    // Método para buscar todos os Produtos no banco de dados
    @Override
    public List<Produto> buscarTodos() {
        // Criação da fábrica de EntityManager
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        // Criação do EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Criação do construtor de critérios
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // Criação da consulta de critérios para a classe Produto
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        // Ponto de partida da consulta
        Root<Produto> root = query.from(Produto.class);
        // Seleção dos resultados
        query.select(root);

        // Criação da consulta tipada
        TypedQuery<Produto> tpQuery =
                entityManager.createQuery(query);
        // Obtenção da lista de resultados
        List<Produto> list = tpQuery.getResultList();

        // Fechamento do EntityManager
        entityManager.close();
        // Fechamento da fábrica de EntityManager
        entityManagerFactory.close();

        // Retorno da lista de Produtos
        return list;
    }
}
