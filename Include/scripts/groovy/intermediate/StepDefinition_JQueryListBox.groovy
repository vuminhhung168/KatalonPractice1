package intermediate
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class StepDefinition_JQueryListBox {
	@Given("Easyselenium page is launched")
	def launchEasyseleniumPage(){

		WebUI.callTestCase(findTestCase('Launch_seleniumeasy_page'), [:], FailureHandling.STOP_ON_FAILURE)
	}

	@When("I navigate to Immediate level then JQuery List Box")
	def navigateToImmediateLevel() {

		if (WebUI.verifyElementVisible(findTestObject('Main_page/Button_Start_Practicing'), FailureHandling.OPTIONAL)) {

			WebUI.click(findTestObject('Main_page/Button_Start_Practicing'))
		}

		WebUI.enhancedClick(findTestObject('Main_page/option_Intermediate'))

		WebUI.verifyElementVisible(findTestObject('Intermediate/text_Intermediate'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('Intermediate/option_JQueryListBox'))
	}

	@Then("I verify item Isis is visible in UI")
	def verifyElementsInUI() {

		WebUI.verifyElementNotPresent(findTestObject('Intermediate/5_JQuery_List_Box/dynamic_items_in_right', [('item') : 'Isis']), 2)

		WebUI.click(findTestObject('Intermediate/5_JQuery_List_Box/dynamic_items_in_left', ['item' : 'Isis']))

		WebUI.delay(3)

		WebUI.closeBrowser()
	}

	@And("I select item (.*) in the left panel then click Add button")
	def addSingleItem(String item) {

		WebUI.click(findTestObject('Intermediate/5_JQuery_List_Box/dynamic_items_in_left', ['item' : item]))

		WebUI.delay(2)

		WebUI.click(findTestObject('Intermediate/5_JQuery_List_Box/button_Add'))
	}

	@Then("The item (.*) is moved to the right panel")
	def verifySingleItemIsAdded(String item) {

		//Verify item is no longer visible in left panel:
		WebUI.verifyElementNotPresent(findTestObject('Intermediate/5_JQuery_List_Box/dynamic_items_in_left', ['item' : item]), 2)

		//Verify item is visible in right panel:
		WebUI.verifyElementPresent(findTestObject('Intermediate/5_JQuery_List_Box/dynamic_items_in_right', ['item' : item]), 2)

		WebUI.delay(3)

		WebUI.closeBrowser()

	}

	@And("I select item (.*) in the right panel then click Remove button")
	def removeSingleItem(String item) {

		WebUI.click(findTestObject('Intermediate/5_JQuery_List_Box/dynamic_items_in_right', ['item' : item]))

		WebUI.delay(2)

		WebUI.click(findTestObject('Intermediate/5_JQuery_List_Box/button_Remove'))
	}

	@Then("The item (.*) is moved to the left panel")
	def verifySingleItemIsRemoved(String item) {

		//Verify item is no longer visible in right panel:
		WebUI.verifyElementNotPresent(findTestObject('Intermediate/5_JQuery_List_Box/dynamic_items_in_right', ['item' : item]), 2)

		//Verify item is visible in left panel:
		WebUI.verifyElementPresent(findTestObject('Intermediate/5_JQuery_List_Box/dynamic_items_in_left', ['item' : item]), 2)

		WebUI.delay(3)

		WebUI.closeBrowser()

	}
}