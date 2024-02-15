<h1 align="center">
  Lista de Tarefas (TODO LIST)
</h1>

<br>

## Descrição do projeto

Um sistema em java para gerenciar tarefas (To-do List), uma ferramenta simples
para dividir atividades maiores em etapas menores.

## Tecnologias utilizadas

- Git : Controle de versionamento do sistema.
- Spring Boot : framework mais usado e mais completo hoje em dia para desenvolvimento Web Java.
- Spring MVC : é um framework que ajuda no desenvolvimento de aplicações web, com ele podemos construir aplicações web robustas e flexíveis.
- Spring Data JPA : framework que faz parte do conjunto de projetos do Spring Data que tem como finalidade tornar a integração de aplicações Spring com a JPA.
- Spring Tool Suite : IDE para desenvolvimento Java feito para usar o Spring Boot.
- Maven 4 : disponibiliza várias bibliotecas e Api que facilitam o desenvolvimento.
- PostgreSQL :  sistema gerenciador de banco de dados objeto relacional (SGBD), fácil de usar com a sua interface gráfica.
- Thymeleaf : é uma template engine para projetos Java que facilita a criação de páginas HTML.
- HTML : é uma linguagem de marcação utilizada na construção de páginas na Web.
- Bootstrap :  é um framework web com código-fonte aberto para desenvolvimento de componentes de interface e front-end para sites e aplicações web

## Instruções para Executar o sistema
<p>Pré-requisitos</p>

- Git
- Spring Tool Suite
- PgAdmin

## Passos

- Abrir um terminal (Ctrl + Shift + T (No ubuntu)) ou linha de comando(Botão Windows + R, digitar cmd e apertar Enter (no Windows))
- Navegar até onde quiser baixar o repositório
- No terminal, colar essa linha e apertar Enter

```
git clone https://github.com/Alison-silva/listatarefas.git
```

- Abrir O PgAdmin e criar um banco de dados com o nome todolistdb 
- Abrir o Spring Tool Suite e clicar em File e depois em Import
- Na nova janela que aparece, escrever no campo do pesquisa maven
- Uma pasta com o nome Maven aparece. Dentro dessa pasta, clicar em Existing Maven Projects e clicar em Next
- Na próxima página, clicar em Browse... e navegar até a pasta listatarefas e clicar abrir.
- Clicar em Finish
- Esperar o download das dependências do Maven
- Clique com o botão direito no projeto e escolhe a opção 'Run as' e depois escolher 'Spring Boot App'
- O projeto está agora rodando.

O sistema poderá ser acessado em [localhost:8080](http://localhost:8080).

Se ele apresentar um erro, abra o pacote src/main/resources e depois abra o arquivo application.properties. 
Coloque o usuário e a senha que você atribuiu ao postgres

```
spring.datasource.username= <coloque seu username>
spring.datasource.password= <coloque sua senha>
```

## Funcionalidades (CRUD)

- Registrar anotação;
- Listar anotações;
- Ver detalhes das anotações;
- Editar;
- Excluir;
- Concluir(Mover a anotação para um histórico de anotações finalizadas);
- Listar histórico de anotações finalizadas;
