package br.am.rbalves.core;

import static br.am.rbalves.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public void click(By by) {
		getDriver().findElement(by).click();
	}
	
	public void enterText(By by, String text) {
		getDriver().findElement(by).sendKeys(text);
	}
	
	public String getText(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void waitElement(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
}
