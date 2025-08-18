# Challenge Fórum Hub

![Endpoint Badge](https://img.shields.io/endpoint?url=https%3A%2F%2Fforumhub.vm3.arbly.com%2Fcheck%2Fhealth&color=%2346c118&cacheSeconds=60)
![Status](https://img.shields.io/badge/dev-alpha-orange)
![GitHub License](https://img.shields.io/github/license/rrbotlab/challenge-java-forumhub-one-g8)
![GitHub commit activity](https://img.shields.io/github/commit-activity/t/rrbotlab/challenge-java-forumhub-one-g8)
![GitHub last commit](https://img.shields.io/github/last-commit/rrbotlab/challenge-java-forumhub-one-g8)

![capa](/assets/images/capa.png)

## Oracle Next Education (ONE) e Alura - G8 2025

Desafio proposto no programa ONE (Oracle Next Education). Uma parceria entre Alura e Oracle. 

![capa](/assets/images/splash.gif)

### Objetivo

Desenvolver em Java com Spring Boot uma API Rest para um fórum fictício. Deve implementar 
CRUD de tópicos, controle stateless e acesso via token [JWT](https://jwt.io/)

## Instancia de Demontração com Swagger UI

[![swagger](/assets/images/swagger.png)](https://forumhub.vm3.arbly.com)

### https://forumhub.vm3.arbly.com

## Uso

URL base da API: https://forumhub.vm3.arbly.com

Vários endpoints não requerem autenticação. 

| email          |  senha |
|:---------------|-------:|
| usuario1@e.com | 123456 |
| usuario2@e.com | 123456 |
| usuario3@e.com | 123456 |


Para obter um token, envie uma requisição do tipo POST para o endpoint **/login** com o 
corpo contendo os dados acima (exemplo):

```
{
    "email":"usuario1@e.com",
    "senha":"123456"
}
```

Exemplo via curl
```
curl https://forumhub.vm3.arbly.com/login -H 'Content-Type: application/json' -d '{"email":"usuario1@e.com","senha":"123456"}'
```
Retorno (exemplo):
```
{"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJmb3J1bWh1YiIsInN1YiI6InVzdWFyaW8yQGUuY29tIiwiZXhwIjoxNzU1MzUzNzA5fQ.EB6Gul4Cnzpi6osY3izCv86unqOFRbTfuZUG7TlNT1c"}
```
Você também pode utilizar o Insomnia, Postman, etc., para acessar os endpoints. 

> [!NOTE]
> Somente o texto do token (sem aspas) deverá ser enviado como header **Authorization** do tipo 
**Bearer** nas próximas requisições que exijam autenticação.

Todos os enpoints estão na documentação Swagger.

## Executando localmente

### Requisitos

>* MySql disponível (local, remoto ou Docker).
>* Java JDK 17+ 
>* Maven 3

Baixe o arquivo **.jar** em [releases](https://github.com/rrbotlab/challenge-java-forumhub-one-g8/releases)

Dados default do banco de dados MySql

| servidor                | database | usuario | senha |
|-------------------------|----------|---------|-------|
| jdbc:mysql://localhost/ | forumhub | root    | root  |

Se o seu banco de dados utilizar os dados default, simplesmente execute:

```
java -jar forumhub-{versao}.jar
```
A API estará acessivel em http://localhost:8080

Em outros casos é necessário setar as váriaveis de ambiente (edite segundo os seus dados):

Windows PowerShell:

```
$env:FORUMHUB_DATASOURCE_DEV="jdbc:mysql://host/database_name" 
$env:FORUMHUB_USERNAME_DEV="usuario"
$env:FORUMHUB_PASSWORD_DEV="senha"
$env:FORUMHUB_JWT_SECRET_DEV="frase-secreta-com-no-minimo-32-caracteres" # opcional
$env:FORUMHUB_PATH_DEV="/api" # opcional
```

Linux:

```
export FORUMHUB_DATASOURCE_DEV="jdbc:mysql://host/database_name"
export FORUMHUB_USERNAME_DEV="usuario"
export FORUMHUB_PASSWORD_DEV="senha"
export FORUMHUB_JWT_SECRET_DEV="frase-secreta-com-no-minimo-32-caracteres" # opcional
export FORUMHUB_PATH_DEV="/api" # opcional
```

Ou diretamente na linha de comando:
```
java -DFORUMHUB_DATASOURCE_DEV=jdbc:mysql://localhost/forumhub -DFORUMHUB_USERNAME_DEV=root -DFORUMHUB_PASSWORD_DEV=root -jar .\target\forumhub-{versao}.jar
```

### Se preferir, clone o repositório, compile e execute

> [!NOTE]
> Declare as variáveis de ambiente antes de executar, caso os dados do seu MySql sejam diferentes
do default.

```
git clone https://github.com/rrbotlab/challenge-java-forumhub-one-g8.git
cd challenge-java-forumhub-one-g8
mvn spring-boot:run 
```

## Tecnologias utilizadas

![logos](/assets/images/logos.png)


## Agradecimentos

* A Oracle por disponibilizar o programa ONE;
* A Alura, e toda a equipe de scubas, instrutores e coodenadores, todos sempre solícitos e prontos para ajudar;
* Ao grupo de alunos G8 que na medida do possivel e conhecimento, ajudaram-se mutuamente;

Muito Obrigado.


## Disclaimer

Esse é um projeto educacional e disponibilizado como está. Pode conter erros.


***
![Static Badge](https://img.shields.io/badge/Made_with_%F0%9F%92%99_in_SP-by_Ricardo_G_(aka_ricardo4nic%2C_rrbotlab%2C_arbly)-blue?style=for-the-badge)



