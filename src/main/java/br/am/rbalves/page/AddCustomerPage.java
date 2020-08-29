package br.am.rbalves.page;

import static br.am.rbalves.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.am.rbalves.core.BasePage;
import br.am.rbalves.core.Customer;

public class AddCustomerPage extends BasePage {
	
	public void register(Customer customer) {
		waitElement(By.id("field-customerName"));
		this.enterName(customer.getName());
		this.enterLastName(customer.getLast_name());
		this.enterFirstName(customer.getFirst_name());
		this.enterPhone(customer.getPhone());
		this.enterAddressLine1(customer.getAddress_line1());
		this.enterAddressLine2(customer.getAddress_line2());
		this.enterCity(customer.getCity());
		this.enterState(customer.getState());
		this.enterPostalCode(customer.getPostal_code());
		this.enterCountry(customer.getCountry());
		this.enterFromEployeer(customer.getFrom_employeer());
		this.enterCreditLimit(customer.getCredit_limit());
	}
	
	public void clickGoBackToList() {
		click(By.xpath("//*[@id=\"report-success\"]/p/a[2]"));
	}
	
	public void enterName(String name) {
		enterText(By.id("field-customerName"), name);
	}
	
	public void enterLastName(String last_name) {
		enterText(By.id("field-contactLastName"), last_name);
	}
	
	public void enterFirstName(String first_name) {
		enterText(By.id("field-contactFirstName"), first_name);
	}
	
	public void enterPhone(String phone) {
		enterText(By.id("field-phone"), phone);
	}
	
	public void enterAddressLine1(String address_line1) {
		enterText(By.id("field-addressLine1"), address_line1);
	}
	
	public void enterAddressLine2(String address_line2) {
		enterText(By.id("field-addressLine2"), address_line2);
	}
	
	public void enterCity(String city) {
		enterText(By.id("field-city"), city);
	}
	
	public void enterState(String state) {
		enterText(By.id("field-state"), state);
	}
	
	public void enterPostalCode(String postal_code) {
		enterText(By.id("field-postalCode"), postal_code);
	}
	
	public void enterCountry(String country) {
		enterText(By.id("field-country"), country);
	}
	
	public void enterFromEployeer(String from_employeer) {
		click(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/a"));
	    
	    WebElement select = getDriver().findElement(By.id("field-salesRepEmployeeNumber"));
	    List<WebElement> options = select.findElements(By.tagName("option"));
	    for (WebElement option : options) {
	    	if(option.getText() == from_employeer) {
	    		option.click();
	    	}
	    }
	}
	
	public void enterCreditLimit(String credit_limit) {
		enterText(By.id("field-creditLimit"), credit_limit);
	}
	
	public void clickButtonSave() {
		click(By.id("form-button-save"));
	}
	
	public String getReportSuccess() {
		waitElement(By.id("report-success"));
		return getText(By.id("report-success"));
	}

}
