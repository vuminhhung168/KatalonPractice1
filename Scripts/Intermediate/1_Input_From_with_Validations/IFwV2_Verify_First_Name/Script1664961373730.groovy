import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Variables:
WebUI.callTestCase(findTestCase('Intermediate/Prerequisite1_Access_Immediate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Intermediate/option_InputFormValidations'))

WebUI.verifyElementPresent(findTestObject('Intermediate/1_Input_Form_With_Validations/label_First_Name'), 2, FailureHandling.STOP_ON_FAILURE)

//Scenario 1: input single character and verify message:
WebUI.setText(findTestObject('Intermediate/1_Input_Form_With_Validations/textbox_First_Name'), 'a')

WebUI.verifyElementVisible(findTestObject('Intermediate/1_Input_Form_With_Validations/message_Please_enter_more_than_2_characters'), 
    FailureHandling.STOP_ON_FAILURE)

css_color = WebUI.getCSSValue(findTestObject('Intermediate/1_Input_Form_With_Validations/label_First_Name'), 'color')

WebUI.verifyEqual(css_color, 'rgb(169, 68, 66)')

WebUI.verifyElementNotClickable(findTestObject('Intermediate/1_Input_Form_With_Validations/button_Send'), FailureHandling.STOP_ON_FAILURE)

//Scenario 2: remove all characters and verify message:
WebUI.sendKeys(findTestObject('Intermediate/1_Input_Form_With_Validations/textbox_First_Name'), Keys.chord(Keys.BACK_SPACE))

WebUI.verifyElementNotVisible(findTestObject('Intermediate/1_Input_Form_With_Validations/message_Please_enter_more_than_2_characters'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Intermediate/1_Input_Form_With_Validations/message_Please_supply_your_first_name'), 
    FailureHandling.STOP_ON_FAILURE)

css_color = WebUI.getCSSValue(findTestObject('Intermediate/1_Input_Form_With_Validations/label_First_Name'), 'color')

WebUI.verifyEqual(css_color, 'rgb(169, 68, 66)')

iconStatus = WebUI.getAttribute(findTestObject('Intermediate/1_Input_Form_With_Validations/icon_First_Name_status'), 'class')

WebUI.verifyEqual(iconStatus, 'form-control-feedback bv-icon-input-group glyphicon glyphicon-remove')

WebUI.verifyElementNotClickable(findTestObject('Intermediate/1_Input_Form_With_Validations/button_Send'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

//Scenario 3: input valid value
WebUI.setText(findTestObject('Intermediate/1_Input_Form_With_Validations/textbox_First_Name'), 'aaa')

WebUI.verifyElementNotVisible(findTestObject('Intermediate/1_Input_Form_With_Validations/message_Please_supply_your_first_name'), 
    FailureHandling.STOP_ON_FAILURE)

css_color = WebUI.getCSSValue(findTestObject('Intermediate/1_Input_Form_With_Validations/label_First_Name'), 'color')

WebUI.verifyEqual(css_color, 'rgb(60, 118, 61)')

iconStatus = WebUI.getAttribute(findTestObject('Intermediate/1_Input_Form_With_Validations/icon_First_Name_status'), 'class')

WebUI.verifyEqual(iconStatus, 'form-control-feedback bv-icon-input-group glyphicon glyphicon-ok')

WebUI.verifyElementClickable(findTestObject('Intermediate/1_Input_Form_With_Validations/button_Send'), FailureHandling.STOP_ON_FAILURE)

