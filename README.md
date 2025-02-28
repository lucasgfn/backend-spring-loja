# Instruções da aplicação
> O presente projeto é uma aplicação back-end que se integra com [Front-end da Loja Saines](https://github.com/lucasgfn/loja-saines-front) - Loja Fictícia 


## Tecnologia Usadas e Bibliotecas
  - **Java** 
  - **SpringBoot**
  - **PostgreSQL**
  - **JPA** Hibernet

## Pré-Requisitos
- PgAdmin (versão 4.0 ou superior)
- PostgreSQL (versão 13 ou superior)
- Java JDK (versão 11 ou superior)
- Maven (versão 3.6 ou superior)
- Insomnia

## Instalação
  1. **Criar um banco de dados no PgAdmim:**
     - Nome do banco: ``loja_saines``
    
  2. **Clonar esse repotório:**
     ```bash
     git clone https://github.com/lucasgfn/backend-spring-loja.git
     ```
     Entre na pasta:
     ```
     cd backend-spring-loja
     ```
     
  3. **Instale as dependências:**
     ```bash
     mvn install

  4. **Configure as propriedades do banco:**
     - Em ``src/main/resources/application.properties`` coloque seuas credencias
  
  5. **Execute a aplicação:**
     ```bash
     mvn spring-boot-run
