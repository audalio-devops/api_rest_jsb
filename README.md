<h1>Projeto API-Rest</h1>

Projeto desenvolvido em Java, durante o curso [Projeto Web API Java Spring Boot](https://www.youtube.com/playlist?list=PLC8TqXFuvRUQt9fX5qeqjuGxuo_dM9Wvv) ministrado pelo instrutor [Moto Code](https://www.instagram.com/devmoto.code/)

<p>Projeto simples onde é criado um Front-End para fazer cadastro através de um Back-End usando Java Spring Boot e MySQL.</p>

<h2>🔖 Tecnologias estudadas</h2>

- FRONT-END
  - HTML
  - CSS
  - Javascript
  
- BACK-END
  - Java Spring Boot
  - API REST / JSON
  - Banco de Dados MySQL

![](https://github.com/audalio-devops/api_rest_jsb/blob/main/DiagramaProjetoAPIRest.png)

<h2>🚀 Versões</h2>

<p>1.0 - Na versão inicial, não existem validações e nem retorno do cadastramento.</p>

<p>2.0 - Inclusão da validação de usuário e senha utilizando token</p>


<h2>🚀 Funcionamento</h2>

<h3>Versão 1.0</h3>
Através do formulário de cadastro (via plugin Live Server, o formulário é exibido em http://127.0.0.1:5500/index.html), preenche-se os campos e deve-se clicar no botão cadastrar.

O resultado pode ser visto através do endpoint http://localhost:8080/usuarios que aceita os métodos GET, POST, UPDATE e DELETE.

<h3>Versão 2.0</h3>
Utilizando o aplicativo Postman ou similar, enviar um POST para o endpoint http://localhost:8080/usuarios/login , com Body da mensagem contendo nome, email e senha.
Se o usuário for validado, será retornado o Status 200 e o token.
Para executar as operações do CRUD, será necessário informar, na aba Authorizathion o Type = Bearer e o Token = token retornado ao fazer login.


