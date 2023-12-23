# Projetos de Exemplo usando JPA (Java Persistence API) e Hibernate

1. Descrição Geral:
Este repositório contém projetos de exemplo que demonstram o uso da API de Persistência Java (JPA) em conjunto com o framework Hibernate para interação com bancos de dados relacionais. Cada projeto aborda diferentes aspectos do uso dessas tecnologias, incluindo cadastro, pesquisa e exclusão de entidades.

2. Estrutura do Repositório:
src/main/java/org.pazzini.dao: Pacote que contém as interfaces e implementações dos DAOs (Data Access Objects), responsáveis pela interação com o banco de dados.
src/main/java/org.pazzini.domain: Pacote que contém as classes de domínio, representando entidades do banco de dados.
src/test/java/org.pazzini.dao: Pacote que inclui classes de teste JUnit para os DAOs.

3. Projetos:
ProjetoCursoMatricula: Demonstração de relacionamento um-para-muitos entre as entidades Curso e Matricula, utilizando JPA e Hibernate.
ProjetoProduto: Exemplo de CRUD (Create, Read, Update, Delete) para a entidade Produto usando JPA e Hibernate.
ProjetoProdutoCursoMatricula: Combinação dos conceitos anteriores, mostrando como lidar com múltiplas entidades relacionadas.

4. Tecnologias Utilizadas:
JPA (Java Persistence API): Padrão de persistência de dados Java que fornece uma interface de programação para gerenciar entidades relacionais.
Hibernate: Framework de mapeamento objeto-relacional (ORM) para Java, implementando a especificação JPA.

5. Instruções de Uso:
Cada projeto possui uma classe Main no pacote principal, que contém um exemplo simples de utilização.
Os testes JUnit em src/test/java fornecem casos de teste para os DAOs.

6. Requisitos:
JDK (Java Development Kit) instalado.
Configuração adequada do ambiente para acessar um banco de dados PostgreSQL (ou outro banco, dependendo da configuração do arquivo persistence.xml).

7. Observações:
Certifique-se de ajustar as configurações do banco de dados no arquivo persistence.xml para refletir sua configuração local.
Os projetos são simples e focam nos conceitos básicos de JPA e Hibernate, facilitando a compreensão e modificação para atender às necessidades específicas do usuário.

8. Autor:
Este repositório foi criado por [Diego Pazzini].
