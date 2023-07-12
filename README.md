# Springboot-CRUD

![estrutura dos arquivos](caminho/para/imagem.png)


- controller: Este diretório contém as classes responsáveis por receber as requisições HTTP e lidar com a lógica de negócio relacionada às requisições. Exemplo: ProductController.java.
dto: Este diretório contém as classes que representam objetos de transferência de dados (DTO) utilizados para transportar dados entre a camada de controle e serviço. Exemplo: ProductDTO.java.
entities: Este diretório contém as classes de entidades que representam objetos persistentes no banco de dados. Exemplo: Product.java.
repositories: Este diretório contém as interfaces responsáveis por definir as operações de acesso a dados para as entidades. Exemplo: ProductRepository.java.
resources: Este diretório contém recursos estáticos, como arquivos de propriedades de configuração. Exemplo: application.properties.
resources/exceptions: Este diretório contém as classes de exceção personalizadas para tratamento de erros específicos da aplicação. Exemplo: CustomException.java.
services: Este diretório contém as classes que implementam a lógica de negócio da aplicação. Exemplo: ProductService.java.
services/exceptions: Este diretório contém as classes de exceção personalizadas relacionadas aos serviços. Exemplo: ServiceException.java.
test: Este diretório contém os arquivos de teste para as classes do projeto.
Essa estrutura segue as melhores práticas de organização de um projeto Spring Boot, onde as classes estão agrupadas em pacotes de acordo com suas responsabilidades. Lembre-se de substituir [Classe.java] pelos nomes apropriados das suas classes.
