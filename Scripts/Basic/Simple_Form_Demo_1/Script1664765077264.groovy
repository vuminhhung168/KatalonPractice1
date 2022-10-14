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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.url)

if (WebUI.verifyElementVisible(findTestObject('Main_page/Button_Start_Practicing'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Main_page/Button_Start_Practicing'))
}

WebUI.enhancedClick(findTestObject('Basic/Simple_Form_Demo'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Basic/Simple_Form_Demo/Textbox_Single_Input_Field_Enter_Message'))

WebUI.verifyElementVisible(findTestObject('Basic/Simple_Form_Demo/Button_Single_Input_Field_Show_Message'))

WebUI.verifyElementVisible(findTestObject('Basic/Simple_Form_Demo/Textbox_Two_Input_Fields_a'))

WebUI.verifyElementVisible(findTestObject('Basic/Simple_Form_Demo/Textbox_Two_Input_Fields_b'))

WebUI.verifyElementVisible(findTestObject('Basic/Simple_Form_Demo/Button_Two_Input_Fields_Get_Total'))

WebUI.setText(findTestObject('Basic/Simple_Form_Demo/Textbox_Single_Input_Field_Enter_Message'), GlobalVariable.value_input)

WebUI.click(findTestObject('Basic/Simple_Form_Demo/Button_Single_Input_Field_Show_Message'))

WebUI.verifyTextPresent(GlobalVariable.value_input, false, FailureHandling.STOP_ON_FAILURE)

