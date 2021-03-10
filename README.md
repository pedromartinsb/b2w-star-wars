<h1 align="center"> Desafio B2W </h1>
<p align="justify"> Uma API real simples contendo  CRUD de classes, Spring Security e JWT, Spring Cache, Paginação e ordenação dos resultados da API, monitoramento dos endpoints com Spring Boot Actuator e Admin, e documentação da API com Swagger. </p>

![Badge](https://img.shields.io/static/v1?label=java&message=language&color=red&style=for-the-badge&logo=JAVA)
![Badge](https://img.shields.io/static/v1?label=spring+boot&message=framework&color=green&style=for-the-badge&logo=SPRING)
![Badge](https://img.shields.io/static/v1?label=postman&message=testing+apis&color=orange&style=for-the-badge&logo=POSTMAN)
![Badge](https://img.shields.io/static/v1?label=mongodb&message=data+base&color=green&style=for-the-badge&logo=mongodb)
![Badge](https://img.shields.io/static/v1?label=swagger&message=api+documentation&color=green&style=for-the-badge&logo=SWAGGER)
![Badge](https://img.shields.io/static/v1?label=jwt+token&message=spring+security&color=blue&style=for-the-badge&logo=JWT+TOKEN)
![Badge](https://img.shields.io/static/v1?label=docker&message=container&color=blue&style=for-the-badge&logo=DOCKER)
![Badge](https://img.shields.io/static/v1?label=travis+ci&message=continuous+integration&color=yellow&style=for-the-badge&logo=TRAVIS+CI)

### Funcionalidades da Aplicação  

- CRUD de classes
    - Classe de Planeta
- Spring Security e JWT
    - Habilitando o Spring Security 
    - Liberando acesso aos endpoints públicos
    - Restringindo acesso aos endpoints privados
    - Autenticando o usuário
 - Spring Cache
    - Anotação @Cacheable
    - Boas práticas no uso de Cacheable
- Paginação e Ordenação
- Spring Boot Actuator e Admin
    - Monitoramento com Spring Boot Actuator
    - Monitoramento da API com Spring Admin Client
- Documentação da API com Swagger
    - SpringFox Swagger
    - Enviando token JWT no Swagger
    - Classe SwaggerConfigurations
    
    
## O que a plataforma é capaz de fazer :checkered_flag:

:trophy: Cadastrar, Listar, Excluir e Alterar a classe de Planeta 

:trophy: Autenticar e Autorizar um Usuário para acessar a aplicação 

:trophy: Permite que o usuário pesquise uma certa Planeta através do nome ou do ID

:trophy: Pesquisar na API pública do Star Wars a quantidade de aparições em filmes

## Status do Projeto

> API Rest - Backend: Desenvolvimento :warning:

> Docker e deploy: Concluido :heavy_check_mark:

## Deploy da Aplicação com Heroku: :dash:

> Aguardando finalizar todo o desenvolvimento backend :warning:

## Como rodar a aplicação

No terminal, clone o projeto:
git clone https://github.com/pedromartinsb/b2w-star-wars.git

Entre na pasta do projeto:
cd b2w-star-wars

Rodar a aplicação:
-> Abrir a árvore de arquivos src/main/java/br.com.pedrom.apirest -> Abrir o arquivo ApiRestApplication.java -> Botão direito dentro do arquivo -> Run As -> Java Application

Pronto, agora é possível rodar a aplicação a partir da rota http://localhost:8080/

### Monitoramento dos Endpoints  

> Dashboard para uso da equipe de Suporte e Desenvolvedores :warning:

> Acompanhar a saúde da aplicação :warning:

> Para startar o projeto e acompanhar: -> Importar o projeto Monitoramento dentro do Eclipse -> Abrir classe main -> Run As Java Application :warning:

> Acesso: http://localhost:8081/ :heavy_check_mark:

## Linguagens e libs utilizadas :books:

- [Java Download](https://www.java.com/pt_BR/download/): versão 8

- [Spring Boot Tutorial](https://spring.io/guides/gs/spring-boot/): versão 2.3.1

Frameworks utilizados:

- [Eclipse IDE](https://www.eclipse.org/downloads/): versão 2020‑06

- [Postman](https://www.postman.com/)

### Classe Ferramenta: 
|name|climate|terrain|
| -------- | -------- | -------- |
|Tatooine|arid|desert|


## Desenvolvedor
[<img src="https://avatars0.githubusercontent.com/u/33515329?s=460&u=251d4ef587ca509428d495ef98c0f6f1887dc3de&v=4" width=200 > <br> <sub> Pedro Campos </sub>](https://github.com/pedromartinsb)
| :---: |


### Esteira de Entrega  

:shipit: Desenvolvedor commita seu código no Github

:computer: Github percebe alteração na branch master e faz a chamada ao Travis CI

:construction_worker: Travis CI build a imagem e faz o push do Dockerhub

:floppy_disk: Dockerhub recebe as imagens e publica no servidor
