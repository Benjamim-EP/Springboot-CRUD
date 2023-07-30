# Springboot-CRUD
## Documentação da API

A seguir está a documentação da API para os recursos disponíveis.

### Books

#### Listar todos os livros

Retorna uma lista paginada de todos os livros.

- **URL**: `/books/all`
- **Método**: GET
- **Parâmetros de consulta**:
  - `page` (opcional): Número da página (padrão: 0)
  - `linesPerPage` (opcional): Número de livros por página (padrão: 12)
  - `direction` (opcional): Direção de ordenação dos resultados (ASC ou DESC) (padrão: ASC)
  - `orderBy` (opcional): Campo utilizado para ordenação (padrão: name)
- **Retorno**: Retorna uma lista paginada de livros no corpo da resposta.

Exemplo de requisição:
```
GET /books/all?page=0&linesPerPage=12&direction=ASC&orderBy=name
```

#### Buscar livro por ID

Retorna os detalhes de um livro específico com base no ID.

- **URL**: `/books/{id}`
- **Método**: GET
- **Parâmetros de URL**:
  - `id`: ID do livro
- **Retorno**: Retorna os detalhes do livro no corpo da resposta.

Exemplo de requisição:
```
GET /books/123
```

#### Inserir um novo livro

Insere um novo livro na base de dados.

- **URL**: `/books`
- **Método**: POST
- **Corpo da solicitação**: Deve conter os dados do livro a ser inserido.
- **Retorno**: Retorna os detalhes do livro recém-inserido no corpo da resposta, juntamente com o cabeçalho "Location" contendo o URL para acessar os detalhes do livro.

Exemplo de requisição:
```
POST /books

{
  "title": "Livro 1",
  "author": "Autor 1",
  "year": 2023
}
```

#### Atualizar livro existente

Atualiza os dados de um livro existente com base no ID.

- **URL**: `/books/{id}`
- **Método**: PUT
- **Parâmetros de URL**:
  - `id`: ID do livro a ser atualizado
- **Corpo da solicitação**: Deve conter os novos dados do livro.
- **Retorno**: Retorna os detalhes do livro atualizado no corpo da resposta.

Exemplo de requisição:
```
PUT /books/123

{
  "title": "Livro Atualizado",
  "author": "Autor Atualizado",
  "year": 2022
}
```

#### Excluir livro

Exclui um livro da base de dados com base no ID.

- **URL**: `/books/{id}`
- **Método**: DELETE
- **Parâmetros de URL**:
  - `id`: ID do livro a ser excluído
- **Retorno**: Retorna uma resposta vazia com o código de status 204 (No Content) em caso de sucesso.

Exemplo de requisição:
```
DELETE /books/123
```

### Categorias

#### Listar todas as categorias

Retorna uma lista paginada de todas as categorias.

- **URL**: `/categorias/all`
- **Método**: GET
- **Parâmetros de consulta**:
  - `page` (opcional): Número da página (padrão: 0)
  - `linesPerPage` (opcional): Número de categorias por página (padrão: 12)
  - `direction` (opcional): Direção de ordenação dos resultados (ASC ou DESC) (padrão: ASC)
  - `orderBy` (opcional): Campo utilizado para ordenação (padrão: name)
- **Retorno**: Retorna uma lista paginada de categorias no corpo da resposta.

Exemplo de requisição:
```
GET /categorias/all?page=0&linesPerPage=12&direction=ASC&orderBy=name
```

#### Buscar categoria por ID

Retorna os detalhes de uma categoria específica com base no ID.

- **URL**: `/categorias/{id}`
- **Método**: GET
- **Parâmetros de URL**:
  - `id`: ID da categoria
- **Retorno**: Retorna os detalhes da categoria no corpo da resposta.

Exemplo de requisição:
```
GET /categorias/123
```

#### Inserir uma nova categoria

Insere uma nova categoria na base de dados.

- **URL**: `/categorias`
- **Método**: POST
- **Corpo da solicitação**: Deve conter os dados da categoria a ser inserida.
- **Retorno**: Retorna os detalhes da categoria recém-inserida no corpo da resposta, juntamente com o cabeçalho "Location" contendo o URL para acessar os detalhes da categoria.

Exemplo de requisição:
```
POST /categorias

{
  "name": "Categoria 1"
}
```

#### Atualizar categoria existente

Atualiza os dados de uma categoria existente com base no ID.

- **URL**: `/categorias/{id}`
- **Método**: PUT
- **Parâmetros de URL**:
  - `id`: ID da categoria a ser atualizada
- **Corpo da solicitação**: Deve conter os novos dados da categoria.
- **Retorno**: Retorna os detalhes da categoria atualizada no corpo da resposta.

Exemplo de requisição:
```
PUT /categorias/123

{
  "name": "Categoria Atualizada"
}
```

#### Excluir categoria

Exclui uma categoria da base de dados com base no ID.

- **URL**: `/categorias/{

id}`
- **Método**: DELETE
- **Parâmetros de URL**:
  - `id`: ID da categoria a ser excluída
- **Retorno**: Retorna uma resposta vazia com o código de status 204 (No Content) em caso de sucesso.

Exemplo de requisição:
```
DELETE /categorias/123
```

Lembre-se de substituir `localhost` pelo endereço do servidor onde a API está hospedada.

Certifique-se de fornecer exemplos adicionais de payload e parâmetros de solicitação conforme necessário.

## Estrutura do projeto
![estrutura dos arquivos](tree.png)


- **controller**: Este diretório contém as classes responsáveis por receber as requisições HTTP e lidar com a lógica de negócio relacionada às requisições. 
- **dto**: Este diretório contém as classes que representam objetos de transferência de dados (DTO) utilizados para transportar dados entre a camada de controle e serviço. 
- **entities**: Este diretório contém as classes de entidades que representam objetos persistentes no banco de dados. Exemplo: 
- **repositories**: Este diretório contém as interfaces responsáveis por definir as operações de acesso a dados para as entidades.
- **resources**: Este diretório contém recursos estáticos, como arquivos de propriedades de configuração. Exemplo: application.properties.
- **resources/exceptions**: Este diretório contém as classes de exceção personalizadas para tratamento de erros específicos da aplicação. Exemplo: CustomException.java.
- **services**: Este diretório contém as classes que implementam a lógica de negócio da aplicação. Exemplo: ProductService.java.
- **services/exceptions**: Este diretório contém as classes de exceção personalizadas relacionadas aos serviços. Exemplo: ServiceException.java.
- **test**: Este diretório contém os arquivos de teste para as classes do projeto.

## **Requisitos para rodar o projeto:**

1. Java 11: Certifique-se de ter o JDK (Java Development Kit) 11 instalado em sua máquina. Você pode verificar a versão do Java digitando o seguinte comando no terminal ou prompt de comando:
   ```
   java -version
   ```

2. Maven: O projeto utiliza o Maven como gerenciador de dependências. Verifique se você tem o Maven instalado executando o seguinte comando:
   ```
   mvn -version
   ```

3. Banco de dados: O projeto utiliza o banco de dados H2 para desenvolvimento e teste. Certifique-se de ter o H2 Database instalado ou configure seu próprio banco de dados PostgreSQL.

### **Setup do ambiente:**

1. Clone o projeto: Inicialmente, clone o projeto do repositório Git para sua máquina local usando o seguinte comando:
   ```
   git clone https://github.com/Benjamim-EP/Springboot-CRUD
   ```

2. Importe o projeto: Abra sua IDE preferida (por exemplo, IntelliJ IDEA, Eclipse) e importe o projeto como um projeto Maven existente.

3. Aguarde a importação: A IDE irá baixar todas as dependências do Maven e configurar o projeto automaticamente. Isso pode levar alguns minutos, dependendo da velocidade da sua conexão com a internet.

4. Configuração do banco de dados (opcional): Se você preferir usar o banco de dados PostgreSQL em vez do H2, atualize as configurações de conexão do banco de dados no arquivo `application.properties` ou `application.yml` do projeto.

### **Como rodar na minha máquina?**

1. Execute o aplicativo: A partir da sua IDE, localize a classe principal `bookcatalogApplication` e execute-a como uma aplicação Java. Isso iniciará o servidor embutido do Spring Boot e implantará o projeto.

2. Acesse o aplicativo: Depois que o aplicativo for iniciado com sucesso, você pode acessá-lo em seu navegador da web usando a seguinte URL:
   ```
   http://localhost:8080
   ```

   A partir daí, você poderá interagir com o aplicativo por meio da interface do usuário ou fazer chamadas para a API REST, dependendo do propósito do projeto.
