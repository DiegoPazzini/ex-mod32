// Declaração do pacote org.pazzini.domain, que contém a classe Matricula
package org.pazzini.domain;

// Importação das classes relacionadas a persistência JPA (Java Persistence API) e manipulação de datas
import javax.persistence.*;
import java.time.Instant;

// Anotação indicando que a classe é uma entidade JPA
@Entity
// Mapeamento para a tabela "TB_MATRICULA" no banco de dados
@Table(name = "TB_MATRICULA")
public class Matricula {

    // Identificador da entidade Matricula
    @Id
    // Geração de valores automáticos usando uma sequência no banco de dados
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="matri_seq")
    // Definição da sequência associada à geração de valores
    @SequenceGenerator(name="matri_seq", sequenceName="sq_matricula", initialValue = 1, allocationSize = 1)
    private Long id;

    // Coluna "CODIGO" na tabela com restrições de tamanho, não nula e única
    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;

    // Coluna "DATA_MATRICULA" na tabela com restrição de não nula
    @Column(name = "DATA_MATRICULA", nullable = false)
    private Instant dataMatricula;

    // Coluna "valor" na tabela com restrição de não nula
    @Column(name = "valor", nullable = false)
    private Double valor;

    // Coluna "status" na tabela com restrição de não nula
    @Column(name = "status", nullable = false)
    private String status;

    // Relacionamento de várias Matrículas para um Curso (muitos para um)
    @ManyToOne
    // Mapeamento da chave estrangeira "id_curso_fk"
    @JoinColumn(name = "id_curso_fk",
            // Definição do nome da chave estrangeira
            foreignKey = @ForeignKey(name = "fk_curso_matricula"),
            // Referência à coluna "id" da tabela Curso
            referencedColumnName = "id", nullable = false)
    private Curso curso;

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

    // Método getter para a Data de Matrícula
    public Instant getDataMatricula() {
        return dataMatricula;
    }

    // Método setter para a Data de Matrícula
    public void setDataMatricula(Instant dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    // Método getter para o Valor
    public Double getValor() {
        return valor;
    }

    // Método setter para o Valor
    public void setValor(Double valor) {
        this.valor = valor;
    }

    // Método getter para o Status
    public String getStatus() {
        return status;
    }

    // Método setter para o Status
    public void setStatus(String status) {
        this.status = status;
    }

    // Método getter para o Curso
    public Curso getCurso() {
        return curso;
    }

    // Método setter para o Curso
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
