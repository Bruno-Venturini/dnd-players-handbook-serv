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

## 🚀 Instalação e Execução

### Pré-requisitos

* Java 17
* Maven 3.8+
* PostgreSQL
* Redis
