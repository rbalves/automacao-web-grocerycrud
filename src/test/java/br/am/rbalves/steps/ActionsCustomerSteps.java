package br.am.rbalves.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import br.am.rbalves.core.Customer;
import br.am.rbalves.core.DriverFactory;
import br.am.rbalves.page.AddCustomerPage;
import br.am.rbalves.page.DemoPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ActionsCustomerSteps {
	
	WebDriver driver;
	
	private static Customer customer = new Customer();

	DemoPage demo = new DemoPage();
	AddCustomerPage add_customer = new AddCustomerPage();
	
	@Given("^que estou acessando o sistema$")
	public void que_estou_acessando_o_sistema() throws Throwable {
	    driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
	}

	@When("^mudar o valor da combo select version para \"([^\"]*)\"$")
	public void mudar_o_valor_da_combo_select_version_para(String version) throws Throwable {
	    demo.selectVersion(version);
	}
	
	@When("^clicar no botao Add Customer$")
	public void clicarNoBotaoAddCustomer() throws Throwable {
		demo.clickAddCustomer();
	}

	@When("^preencher os campos do formulario com as seguintes informacoes: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void preencherOsCamposDoFormularioComAsSeguintesInformacoes(String name, String last_name, String first_name, String phone, String address_line1, String address_line2, String city, String state, String postal_code, String country, String from_employeer, String credit_limit) throws Throwable {
		customer.setName(name);
		customer.setFirst_name(first_name);
		customer.setLast_name(last_name);
		customer.setPhone(phone);
		customer.setAddress_line1(address_line1);
		customer.setAddress_line2(address_line2);
		customer.setCity(city);
		customer.setState(state);
		customer.setPostal_code(postal_code);
		customer.setCountry(country);
		customer.setFrom_employeer(from_employeer);
		customer.setCredit_limit(credit_limit);
		
		add_customer.register(customer);
	}
	
	@When("^clicar no botao Save$")
	public void clicarNoBotaoSave() throws Throwable {
		add_customer.clickButtonSave();
	}

	@Then("^visualizo a mensagem de sucesso \"([^\"]*)\"$")
	public void visualizoAMensagemDeSucesso(String message) throws Throwable {
	    assertEquals(message, add_customer.getReportSuccess());
	}
	
	@Given("^que cliquei no link Go back to list$")
	public void queCliqueiNoLinkGoBackToList() throws Throwable {
	    add_customer.clickGoBackToList();
	}
	
	@When("^clicar na coluna Search Name$")
	public void clicarNaColunaSearchName() throws Throwable {
	    demo.clickSearchNameColumn();
	}

	@When("^digitar o conteudo do Name$")
	public void digitarOConteudoDoName() throws Throwable {
	    demo.enterName(customer.getName());
	}

	@When("^clicar no checkbox abaixo da palavra Actions$")
	public void clicarNoCheckboxAbaixoDaPalavraActions() throws Throwable {
	    demo.clickCheckboxUnderActions();
	}

	@When("^clicar no botao Delete$")
	public void clicarNoBotaoDelete() throws Throwable {
	    demo.clickButtonPageDelete();
	}

	@Then("^visualizo um popup com a mensagem \"([^\"]*)\"$")
	public void visualizoUmPopupComAMensagem(String message) throws Throwable {
		assertEquals(message, demo.getMessageModalDelete());
	}

	@When("^clicar no botao Delete da popup$")
	public void clicarNoBotaoDeleteDaPopup() throws Throwable {
	    demo.clickButtonDeleteModal();
	}

	@Then("^visualizo um box de sucesso com a mensagem  \"([^\"]*)\"$")
	public void visualizoUmBoxDeSucessoComAMensagem(String message) throws Throwable {
		assertEquals(message, demo.getMessageSuccessDelete());
	}
	
	@Before
	public void startDriver() {
		driver = DriverFactory.getDriver();
	}
	
	@After
	public void closeBrowser() {
		DriverFactory.killDriver();
	}

}
