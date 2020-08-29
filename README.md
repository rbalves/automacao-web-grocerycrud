# Automação Web GroceryCRUD
Projeto de automação web usando JUnit, Cucumber e Selenium.

## Funcionalidades
A automação web desenvolvida neste projeto contempla dois cenários: no primeiro cenário, é possível adicionar um cliente e confirmar o sucesso do cadastro.
No segundo cenário, é possível excluir o cliente cadastrado e confirmar a exclusão.

## Preparando o ambiente

Para executar o projeto, foi necessário instalar e configurar os seguintes programas:

- [JDK](https://www.oracle.com/technetwork/java/javase/14-0-1-relnotes-5972653.html)
	
Após a instalação do JDK, foi necessário executar as seguintes etapas:
1. Criar a variável JAVA_HOME com o caminho JDK padrão, que geralmente é C: \ Arquivos de Programas \ Java \ <versão do jdk>
2. Editar a variável Path adicionando %JAVA_HOME% \ bin;
3. Confirmar a instalação usando o comando java -version

- [Eclipse](https://www.eclipse.org/downloads/packages/)

- [ChromeDriver 83.0.4103.39](https://chromedriver.storage.googleapis.com/index.html?path=83.0.4103.39/)


Após o download, foi necessário adicionar o caminho a variável de ambiente Path. Com isso, não foi necessário incluir o caminho nos scripts do projeto.

## Criando e executando o projeto
Um projeto Maven padrão foi criado. As dependências são gerenciadas pelo Maven através do arquivo pom.xml.
Os trechos XML das instalações foram consultadas em [MVNRepository](https://mvnrepository.com/).

Para executar as etapas de teste, dentro da classe Runner.java, é necessário  acessar Run > Run as > JUnit Test.

## Estrutura do projeto
Além dos pacotes e arquivos padrões, é importante destacar alguns elementos importantes:
1. **src/main/java**: neste local, foram criados dois pacotes ("core" e "page"). 
	- No primeiro pacote, foram adicionadas as classes responsáveis: 
		- instanciar driver de conexão,que usa os padrões Factory e Singleton(DriverFactory.java);
		- fornecer métodos padrões a todas as pages (BasePage.java);
		- modelo de cliente (Customer.java)
	- No segundo pacote, foram adicionadas as classes que representam as páginas da aplicação.
2. **src/test/java**: neste local, foram criados dois pacotes ("runners" e "steps"):
	- No primeiro pacote, foi adicionada uma classe que seta os parâmetros Cucumber e inicia os testes (Runner.java)
	- No segundo pacote, foi adicionada uma classe com os steps da feature (ActionsCustomerSteps.java)
3. **src/test/resources**: Este pacote possui uma pasta chamada "features", que por sua vez contém os arquivos com a extensão .feature. Estes arquivos
                       possuem a lista de passos que devem ser executados, seguindo o padrão BDD.

## Dependências
- JUnit 4.12
- Cucumber Java 1.2.6
- Cucumber JUnit 1.2.6
- Selenium Java 3.11.0
