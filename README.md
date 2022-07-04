

#### Autor
- [Miriam Mendes](https://www.linkedin.com/in/miriam-mendes/)

## Spring Rest API - BackEnd do SD Conecta
Implementação de API REST para operações CRUD com persistência em DB H2.
O sistema possui duas entidades, usuários que são os médicos e os CRMs que são uma lista com atributos 
que indetificam a especialidade e a unidade federativa do médico. 

![](/model.jpg "Entidades")

#### Conceitos do Projeto

| Nome         | Descrição                                                                     |
|--------------|-------------------------------------------------------------------------------|
| persistência | Dados são armazenados no engine de memória do H2 para facilitar a execução.   |
| configuração | Configuração padrão .properties situada na pasta resources.                   |
| infra        | Implementação de Exceptions especializadas para facilitar filtragem nos logs. |
| model        | Classes de modelo da aplicação.                                               |
| dto          | Layer de transferência de objetos para a integração de diferentes camadas.    |
| repository   | Camada de acesso aos dados em um servidor de base relacional.                 |
| service      | Layer de negócio da aplicação.                                                |
| controller   | Endpoints HTTP utilizando arquitetura REST.                                   |

#### Tecnologias

* Java
* JPA / Hibernate
* JPA Annotations
* Spring Boot Web
* Spring Boot Data JPA
* Spring Boot Starter Validation
* Project Lombok
* BeansUtils (data mapping)
* H2 Database (in memory)
* Spring Exception Handler


#### Funcionalidades
1. Inclusão de Usuário
```
POST: http://localhost:8080/api/users/create
```
```
{
  "name": "Lorenzo",
  "email": "lorenzo-monteiro82@gmail.com",
  "password": "KsQWtWkdme",
  "surname": "André Monteiro",
  "mobilePhone": "998952598",
  "crmList": [
    {
      "crm": "148852",
      "uf": "MT",
      "specialty": "Pediatria"
    }
  ]
}
```
2. Listagem de Usuários
```
GET: http://localhost:8080/api/users/list
```
```
{
"userId": 1,
"email": "lorenzo-monteiro82@gmail.com",
"password": "KsQWtWkdme",
"name": "Lorenzo",
"surname": "André Monteiro",
"mobilePhone": "99658412",
"crmCollection": [
    "crm": "148852",
    "uf": "MT",
    "specialty": "Pediatria"
]
}


```
3. Alteração de Usuário
```
PUT: http://localhost:8080/api/users/update/1
```
```
{
  "name": "Lorenzo",
  "email": "lorenzo-monteiro82@gmail.com",
  "password": "KsQWtWkdme",
  "surname": "André Monteiro",
  "mobilePhone": "998952598",
  "crmList": [
    {
      "crm": "148852",
      "uf": "SP",
      "specialty": "Cardiologia"
    }
  ]
}
```
4. Consultar um usuário por ID
```
GET: http://localhost:8080/api/users/search/1
```
```
{
    "userId": 1,
    "email": "lorenzo-monteiro82@gmail.com",
    "password": "KsQWtWkdme",
    "name": "Lorenzo",
    "surname": "André Monteiro",
    "mobilePhone": "99658412",
    "crmCollection": [
        "crm": "148852",
        "uf": "SP",
        "specialty": "Cardiologia"
    ]
}

```

5. Exclusão de friend
```
DELETE: http://localhost:8080/api/users/delete/1
```
```
{
}
```
### Segurança
Para a implementação de segurança resta instalar e configurar os seguintes packages:
- spring-boot-starter-oauth2-resource-server
- spring-boot-starter-oauth2-client
- spring-boot-starter-security


#### Referências
- http://www.h2database.com/html/tutorial.html
- https://www.baeldung.com/spring-data-jpa-query#2-custom-repositories-and-the-jpa-criteria-api
- https://www.baeldung.com/jpa-queries#criteria-api-query
- https://www.baeldung.com/spring-data-jpa-query
- https://www.baeldung.com/jpa-query-parameters
- https://www.baeldung.com/spring-unsatisfied-dependency
- https://stackoverflow.com/questions/52444082/how-to-persist-data-in-h2-database



