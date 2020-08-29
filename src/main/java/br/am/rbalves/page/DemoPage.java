package br.am.rbalves.page;

import static br.am.rbalves.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.am.rbalves.core.BasePage;

public class DemoPage extends BasePage {

	private String xpath_button_add_customer = "//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a";
	private String xpath_search_name = "//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[3]/input";
	private String xpath_button_delete = "//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a";
	private String xpath_check_under_actions = "//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[1]/div/input";
	private String xpath_div_table = "/html/body/div[2]";
	private String xpath_body_modal = "/html/body/div[2]/div[2]/div[3]/div/div/div[2]";
	private String xpath_button_delete_modal = "/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]";
	private String xpath_message_modal = "/html/body/div[3]/span[3]";

	private String selector_message_delete = "body > div.container-fluid.gc-container > div.row > div.delete-multiple-confirmation.modal.fade.in.show > div > div > div.modal-body > p.alert-delete-multiple-one";

	public void selectVersion(String version) {
		click(By.xpath("//*[@id=\"switch-version-select\"]/option[. = '" + version + "']"));
	}

	public void clickAddCustomer() {
		click(By.xpath(xpath_button_add_customer));
	}

	public void clickSearchNameColumn() {
		click(By.xpath(xpath_search_name));
	}

	public void enterName(String name) {
		enterText(By.xpath(xpath_search_name), name);

		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		wait.until(ExpectedConditions.attributeContains(By.xpath(xpath_div_table), "class", "loading-opacity"));
		wait.until(ExpectedConditions
				.not(ExpectedConditions.attributeContains(By.xpath(xpath_div_table), "class", "loading-opacity")));
	}

	public void clickCheckboxUnderActions() {
		click(By.xpath(xpath_check_under_actions));
	}

	public void clickButtonPageDelete() {
		waitElement(By.xpath(xpath_button_delete));
		click(By.xpath(xpath_button_delete));
	}

	public String getMessageModalDelete() {
		waitElement(By.xpath(xpath_body_modal));
		return getText(By.cssSelector(selector_message_delete));
	}

	public void clickButtonDeleteModal() {
		click(By.xpath(xpath_button_delete_modal));
	}

	public String getMessageSuccessDelete() {
		waitElement(By.xpath(xpath_message_modal));
		return getText(By.xpath(xpath_message_modal));
	}

}
