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

def selectedCountry = 'Bangladesh'

WebUI.callTestCase(findTestCase('Intermediate/Prerequisite1_Access_Immediate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Intermediate/option_JQuerySelectDropdown'))

WebUI.click(findTestObject('Intermediate/3_JQuery_Select _Dropdown/dropdown_Select_Country'))

WebUI.setText(findTestObject('Intermediate/3_JQuery_Select _Dropdown/searchbox_Select_Country'), 'a')

println(findTestObject('Intermediate/3_JQuery_Select _Dropdown/li_country_dynamic'))

WebUI.click(findTestObject('Intermediate/3_JQuery_Select _Dropdown/li_country_dynamic', [('selectedCountry') : selectedCountry]))

WebUI.verifyElementVisible(findTestObject('Intermediate/3_JQuery_Select _Dropdown/verify_country_dynamic', [('selectedCountry') : selectedCountry]))

