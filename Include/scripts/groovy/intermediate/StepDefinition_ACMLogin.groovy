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

class StepDefinition_ACMLogin {

	@Given("launch ACM page")
	def launchPage(){
		println("Code is executed for step name: launch ACM page")
		WebUI.openBrowser('')
		WebUI.navigateToUrl("https://100.30.8.68/ACCCMPortal/")
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/browser/message_YourConnectionIsNotPrivate'))) {
			
			WebUI.click(findTestObject('Object Repository/browser/button_Advanced'))
			
			WebUI.click(findTestObject('Object Repository/browser/button_Proceed_to'))
				
		}
	}

	@When("Input (.*) and incorrect (.*)")
	def provideInvalidValue(String username, String password){
		println("Code is executed for step name: provide value")
		WebUI.setText(findTestObject('ACM/textbox_Username'), username)
		WebUI.setText(findTestObject('ACM/textbox_Password'), password)
	}

	@When("Input (.*) and correct (.*)")
	def provideValidValue(String username, String password){
		println("Code is executed for step name: provide value")
		WebUI.setText(findTestObject('ACM/textbox_Username'), username)
		WebUI.setText(findTestObject('ACM/textbox_Password'), password)
	}

	@And("Click Login button")
	def clickLogin(){
		println("User is checking...")
		WebUI.click(findTestObject('ACM/button_Login'))
	}

	@Then("Login is failed with message")
	def showFailedMessage(){
		println("Show message Login Failed")
		WebUI.verifyElementVisible(findTestObject('ACM/message_Authentication_Failed'), FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(5)
		WebUI.closeBrowser()
	}

	@Then("Login is successful")
	def showSuccessMessage(){
		println("Login successfully")
		WebUI.verifyElementPresent(findTestObject('ACM/span_Home'), 3)
		WebUI.delay(5)
		WebUI.closeBrowser()
	}
}