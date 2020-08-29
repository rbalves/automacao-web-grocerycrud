Feature: Adicionar cliente
  Como um usuario 
  Gostaria de cadastrar um cliente
  Para que eu possa ter as informacoes persistidas
  
  Background:
  	Given que estou acessando o sistema
    When mudar o valor da combo select version para "Bootstrap V4 Theme"
    And clicar no botao Add Customer
	
	@cadastro
  Scenario Outline: Deve cadastrar um cliente com sucesso
  	And preencher os campos do formulario com as seguintes informacoes: "<name>", "<last_name>", "<contact_first_name>", "<phone>", "<addressline1>", "<addressline2>", "<city>", "<state>", "<postal_code>", "<country>", "<from_employeer>", "<credit_limit>"
    And clicar no botao Save
    Then visualizo a mensagem de sucesso "Your data has been successfully stored into the database. Edit Customer or Go back to list"

    Examples: 
      | name          | last_name | contact_first_name   | phone        | addressline1          | addressline2 | city         | state | postal_code | country | from_employeer | credit_limit |
      | Teste Sicredi | Teste     | Rafael Barbosa Alves | 51 9999-9999 | Av Assis Brasil, 3970 | Torre D      | Porto Alegre | RS    | 91000-000   | Brasil  | Fixter         |          200 |
	
	@exclusao
  Scenario Outline: Deve remover o cliente cadastrado
    And preencher os campos do formulario com as seguintes informacoes: "<name>", "<last_name>", "<contact_first_name>", "<phone>", "<addressline1>", "<addressline2>", "<city>", "<state>", "<postal_code>", "<country>", "<from_employeer>", "<credit_limit>"
    And clicar no botao Save
    Then visualizo a mensagem de sucesso "Your data has been successfully stored into the database. Edit Customer or Go back to list"
    Given que cliquei no link Go back to list
    When clicar na coluna Search Name 
    And digitar o conteudo do Name
    And clicar no checkbox abaixo da palavra Actions
    And clicar no botao Delete
    Then visualizo um popup com a mensagem "Are you sure that you want to delete this 1 item?"
		When clicar no botao Delete da popup
		Then visualizo um box de sucesso com a mensagem  "Your data has been successfully deleted from the database."
		
		Examples: 
      | name          | last_name | contact_first_name   | phone        | addressline1          | addressline2 | city         | state | postal_code | country | from_employeer | credit_limit |
      | Teste Sicredi | Teste     | Rafael Barbosa Alves | 51 9999-9999 | Av Assis Brasil, 3970 | Torre D      | Porto Alegre | RS    | 91000-000   | Brasil  | Fixter         |          200 |