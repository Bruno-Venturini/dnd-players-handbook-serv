# Dnd-players-handbook-serv

API desenvolvida para prover acesso estruturado às informações do *Player’s Handbook* de Dungeons & Dragons (D\&D). Fornece endpoints para consultar classes, raças, habilidades, magias e demais elementos do universo D\&D 5e, com foco em desempenho e extensibilidade.
- Projeto da disciplina de Back-end na Faculdade de Engenharia de Software 2023/02.
- Desenvolvido por Bruno Venturini, Eduardo Freitas, Sofia Martins e Thiago Casagrande.
- Professor Bruno Kurzawe.
---

## 🧹 Funcionalidades Principais

* CRUD completo para entidades do livro do jogador.
* Suporte a cache com Redis.
* Integração com banco de dados PostgreSQL.
* Documentação automática via Swagger (Springfox).
* Autenticação e autorização com Spring Security e JWT.
* Suporte a queries dinâmicas com QueryDSL.

---

## 🛠️ Problemas Detectados

Durante a análise do código legado, foram identificados os seguintes problemas:

* Uso excessivo do **Lombok**, gerando conflitos com QueryDSL e dificultando a leitura.
* Ausência de **linter** e padrão de código, gerando inconsistência na indentação e nos imports.
* **Abstrações excessivas** nas entidades dificultando a manutenção e extensibilidade.
* Falta de **comentários** explicativos em trechos críticos.
* Diversos **imports não utilizados** e má organização dos arquivos.
* Ausência de **constantes** para valores fixos ou reutilizáveis.
* Falta de **testes unitários**, comprometendo a confiabilidade.
* **Métodos longos e complexos**, dificultando a leitura e manutenção.

---

## 🔁 Estratégia de Refatoração

A refatoração do projeto será realizada com as seguintes etapas:

1. **Remoção do Lombok** manualmente, substituindo por getters, setters e construtores explícitos.
2. **Configuração do Checkstyle** para padronizar indentação e identificar imports não utilizados.
3. **Revisão e simplificação de abstrações**, eliminando heranças desnecessárias.
4. **Adição de comentários** explicativos em rotinas complexas.
5. **Extração de constantes** para melhorar a reutilização e facilitar mudanças.
6. **Criação de testes unitários** e validação com cobertura usando o **SonarQube**.

---

## 📋 CHANGELOG

As mudanças estão documentadas em [CHANGELOG.md](./CHANGELOG.md).

# ⚙️ Requisitos para Executar o Projeto

## ✅ Pré-requisitos

- **Java 17**: Certifique-se de que o Java 17 está instalado.
- **Maven 3.6+**: Necessário para compilar e gerenciar as dependências do projeto.
- **PostgreSQL**: Banco de dados relacional utilizado na aplicação.
- **Redis**: Utilizado para cache e armazenamento de dados em memória.

## 🧩 Dependências Principais

- **Spring Boot 2.7.15**: Framework principal para construção da aplicação.
- **Spring Data JPA**: Para interação com o banco de dados PostgreSQL.
- **Spring Data Redis**: Para integração com o Redis.
- **Jedis 3.7.0**: Cliente Redis utilizado pela aplicação.
- **QueryDSL**: Para construção de consultas dinâmicas no banco de dados.
- **Springfox 3.0.0**: Para geração de documentação Swagger da API.
- **Spring Security**: Para gerenciamento de autenticação e autorização.
- **JJWT 0.9.1**: Para criação e validação de tokens JWT.
- **Hibernate Validator 6.2.5.Final**: Para validação de dados.

## 🔧 Configuração

1. **Configurar o Banco de Dados PostgreSQL**:
    - Criar um banco de dados e usuário com as permissões adequadas.
    - Criar e atualizar o arquivo `application.properties` ou `application.yml` com as credenciais e URL do banco.

2. **Configurar o Redis**:
    - Instalar e iniciar o servidor Redis.
    - Garantir que a aplicação possa se conectar ao Redis na porta e host configurados.

3. **Compilar o Projeto**:
    - Executar o comando `mvn clean install` para compilar o projeto e baixar as dependências.

4. **Executar a Aplicação**:
    - Utilizar o comando `mvn spring-boot:run` para iniciar a aplicação.

## 🧪 Testes

- Para executar os testes, utilize o comando `mvn test`.
- Certifique-se de que o banco de dados e o Redis estão em execução antes de rodar os testes.

## 📚 Documentação da API

- Após iniciar a aplicação, a documentação Swagger estará disponível em: `http://localhost:8080/swagger-ui/`

## 🛠️ Observações

- O projeto utiliza o plugin `apt-maven-plugin` para geração de código do QueryDSL. Certifique-se de que o diretório `target/generated-sources/java` está incluído nas fontes do projeto.
- Em ambientes de desenvolvimento, é recomendável utilizar ferramentas como Docker para facilitar a configuração do PostgreSQL e Redis.

