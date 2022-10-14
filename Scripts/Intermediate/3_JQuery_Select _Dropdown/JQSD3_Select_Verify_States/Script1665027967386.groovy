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

String TestID = 'TEST-00001'

//Count total row:
def totalRow = findTestData('TestData_Sheet2').getRowNumbers()

for (int rowNum = 1; rowNum < totalRow; rowNum++)
{
	if (findTestData('TestData_Sheet2').getValue(1, rowNum) == TestID)
	{
		def totalColumn = findTestData('TestData_Sheet2').getColumnNumbers()
		println("Total column is: " + totalColumn)
		
		//Define length of array (total columns):
		def arrayLength = 0
		
		for (int i = 0; i < (totalColumn - 1); i++) {
			if (findTestData('TestData_Sheet2').getValue(i + 2, rowNum) == '') {
				break
			}
			arrayLength++
		}
		
		println("Array length is: " + arrayLength)
		
		//Create array and get values from data file:
		String[] selectedStates = new String[arrayLength]
		
		for (int i = 0; i < arrayLength; i++) {
			if (findTestData('TestData_Sheet2').getValue(i + 2, 1) == '') {
				break
			}
			
			(selectedStates[i]) = findTestData('TestData_Sheet2').getValue(i + 2, rowNum)
		}
		
		println(selectedStates)
		
		WebUI.callTestCase(findTestCase('Intermediate/Prerequisite1_Access_Immediate'), [:], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.click(findTestObject('Intermediate/option_JQuerySelectDropdown'))
		
		WebUI.click(findTestObject('Intermediate/3_JQuery_Select _Dropdown/input_Select_States'))
		
		//Select states:
		for (int i = 0; i < arrayLength; i++) {
			WebUI.selectOptionByLabel(findTestObject('Intermediate/3_JQuery_Select _Dropdown/select_Select_State'), selectedStates[
				i], false)
		}
		
		def verifiedText = WebUI.getText(findTestObject('Intermediate/3_JQuery_Select _Dropdown/verify_selected_states'))
		
		//println(verifiedText)
		for (int i = 0; i < arrayLength; i++) {
			println(selectedStates[i])
			WebUI.verifyElementVisible(findTestObject('Intermediate/3_JQuery_Select _Dropdown/verify_selected_states_dynamic', [
						('verifiedState') : selectedStates[i]]))
		
		}
	}
}


//WebUI.closeBrowser()