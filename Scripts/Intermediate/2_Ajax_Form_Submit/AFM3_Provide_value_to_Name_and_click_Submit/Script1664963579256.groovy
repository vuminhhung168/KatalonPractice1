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

WebUI.callTestCase(findTestCase('Intermediate/Prerequisite1_Access_Immediate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Intermediate/option_Ajax_Form_Submit'))

WebUI.delay(3)

WebUI.setText(findTestObject('Intermediate/2_Ajax_Form_Submit/textbox_Name'), 'Example Valueeeeeee')

WebUI.click(findTestObject('Intermediate/2_Ajax_Form_Submit/button_Submit'))

def message = WebUI.getText(findTestObject('Intermediate/2_Ajax_Form_Submit/element_submit_control'))

WebUI.verifyElementNotPresent(findTestObject('Intermediate/2_Ajax_Form_Submit/button_Submit'), 0)

WebUI.verifyEqual(message, 'Ajax Request is Processing!')

WebUI.verifyElementVisible(findTestObject('Intermediate/2_Ajax_Form_Submit/message_Form_Submitted_Successfully'))

WebUI.verifyElementNotPresent(findTestObject('Intermediate/2_Ajax_Form_Submit/button_Submit'), 0)

