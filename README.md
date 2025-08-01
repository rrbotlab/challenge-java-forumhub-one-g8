![Status](https://img.shields.io/badge/status-devlopment-orange)
![GitHub License](https://img.shields.io/github/license/rrbotlab/challenge-java-forumhub-one-g8)
![GitHub commit activity](https://img.shields.io/github/commit-activity/t/rrbotlab/challenge-java-forumhub-one-g8)
![GitHub last commit](https://img.shields.io/github/last-commit/rrbotlab/challenge-java-forumhub-one-g8)

# Challenge Fórum Hub
![capa](/assets/images/capa.png)

[//]: # (## Alura Latam & Oracle Next Education - ONE - G8)

[//]: # ()
[//]: # (Desafio proposto no programa ONE &#40;Oracle Next Education&#41;. Uma parceria entre Alura Latam e Oracle. )

[//]: # (Grupo G8 &#40;2025&#41;.)

[//]: # ()
[//]: # (## Objetivo)

[//]: # ()
[//]: # (Desenvolver uma API Rest em Java com Spring Boot, que implemente CRUD, stateless e controle o acesso )

[//]: # (via [JWT]&#40;https://jwt.io/&#41;)

[//]: # ()
[//]: # (A API gerencia o cadastro de médicos e pacientes, bem como o controle de marcação de consultas em uma clínica)

[//]: # (médica.)

[//]: # ()
[//]: # (## Demontração)

[//]: # ()
[//]: # (**API DOCS**)

[//]: # ()
[//]: # (https://spring.vm3.arbly.com/vollmed/v3/api-docs)

[//]: # ()
[//]: # (URL base da API &#40;não acessível via browser&#41;:)

[//]: # (https://spring.vm3.arbly.com/vollmed/ )

[//]: # ()
[//]: # (| Método              | Endpoint |Teste via browser|)

[//]: # (|---------------------|----------|-----------------|)

[//]: # (| GET                 |/status |https://spring.vm3.arbly.com/vollmed/status|)

[//]: # (| POST                | /login|)

[//]: # (| GET/POST/PUT/DELETE |/medicos|)

[//]: # (| GET/POST/PUT/DELETE |/pacientes|)

[//]: # (| POST/DELETE         | /consultas|)

[//]: # ()
[//]: # (Utilize Insomnia, Postman, etc., para acessar os endpoints. )

[//]: # ()
[//]: # (**Swagger UI**)

[//]: # ()
[//]: # (**Infelizmente, devido ao redirecionamento do proxy reverso usado no servidor, o)

[//]: # (Swagger UI não está funcionando**.)

[//]: # ()
[//]: # (https://spring.vm3.arbly.com/vollmed/swagger-ui/index.html)

[//]: # ()
[//]: # (## Tecnologias utilizadas)

[//]: # ()
[//]: # (* Java SDK 21)

[//]: # (* SpringBoot 3.5.0)

[//]: # (  * DevTools)

[//]: # (  * Lombok)

[//]: # (  * SpringSecurity JWT)

[//]: # (  * Springdoc)

[//]: # (  * Flyway)

[//]: # (* Maven)

[//]: # (* MySql remoto)

[//]: # ()
[//]: # (## Dependências)

[//]: # ()
[//]: # (Todas as dependencias são gerenciadas pelo Maven.)

[//]: # ()
[//]: # (## Variáveis de ambiente no application.properties)

[//]: # ()
[//]: # (```)

[//]: # (spring.datasource.url=${VOLLMED_DATASOURCE})

[//]: # (spring.datasource.username=${VOLLMED_USERNAME})

[//]: # (spring.datasource.password=${VOLLMED_PASSWORD})

[//]: # (api.security.token.secret=${VOLLMED_JWT_SECRET})

[//]: # (server.servlet.context-path=${VOLLMED_PATH:} # opcional, caso queira alterar a url base )

[//]: # (do servidor '/' &#40;ex.: /api&#41;)

[//]: # (```)

[//]: # ()
[//]: # (Esses variáveis precisam ser setadas antes de iniciar a aplicação.)

[//]: # ()
[//]: # (Windows PowerShell:)

[//]: # (```)

[//]: # ($env:VOLLMED_DATASOURCE="jdbc:[driver]://host/database_name" # jdbc:mysql://localhost/vollmed )

[//]: # ($env:VOLLMED_USERNAME="usuario")

[//]: # ($env:VOLLMED_PASSWORD="senha")

[//]: # ($env:VOLLMED_JWT_SECRET="frase-secreta-com-no-minimo-32-caracteres")

[//]: # ($env:VOLLMED_PATH="/api" # opcional)

[//]: # (```)

[//]: # ()
[//]: # (Linux:)

[//]: # (```)

[//]: # (export VOLLMED_DATASOURCE="jdbc:[driver]://host/database_name" # jdbc:mysql://localhost/vollmed)

[//]: # (export VOLLMED_USERNAME="usuario")

[//]: # (export VOLLMED_PASSWORD="senha")

[//]: # (export VOLLMED_JWT_SECRET="frase-secreta-com-no-minimo-32-caracteres")

[//]: # (export VOLLMED_PATH="/api" # opcional)

[//]: # (```)


