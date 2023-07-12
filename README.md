# Springboot-CRUD

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
