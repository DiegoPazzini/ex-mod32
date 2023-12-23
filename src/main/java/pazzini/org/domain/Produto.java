// Declaração do pacote org.pazzini.domain, que contém a classe Produto
package org.pazzini.domain;

// Importação das classes relacionadas a persistência JPA (Java Persistence API)
import javax.persistence.*;

// Anotação indicando que a classe é uma entidade JPA
@Entity
// Mapeamento para a tabela "TB_PRODUTO" no banco de dados
@Table(name = "TB_PRODUTO")
public class Produto {
    // Identificador da entidade Produto
    @Id
    // Geração de valores automáticos usando uma sequência no banco de dados
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="produto_seq")
    // Definição da sequência associada à geração de valores
    @SequenceGenerator(name="produto_seq", sequenceName="sq_produto", initialValue = 1, allocationSize = 1)
    private Long id;

    // Coluna "CODIGO_PRODUTO" na tabela com restrições de tamanho, não nula e única
    @Column(name = "CODIGO_PRODUTO", length = 10, nullable = false, unique = true)
    private String codigo;

    // Coluna "NOME" na tabela com restrição de tamanho e não nula
    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    // Coluna "DESCRICAO" na tabela com restrição de tamanho e não nula
    @Column(name = "DESCRICAO", length = 100, nullable = false)
    private String descricao;

    // Método getter para o ID
    public Long getId() {
        return id;
    }

    // Método setter para o ID
    public void setId(Long id) {
        this.id = id;
    }

    // Método getter para o Código
    public String getCodigo() {
        return codigo;
    }

    // Método setter para o Código
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Método getter para o Nome
    public String getNome() {
        return nome;
    }

    // Método setter para o Nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para a Descrição
    public String getDescricao() {
        return descricao;
    }

    // Método setter para a Descrição
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
