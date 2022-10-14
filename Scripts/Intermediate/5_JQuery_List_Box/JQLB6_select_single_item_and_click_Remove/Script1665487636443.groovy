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

String TestID = 'TEST-00006'

String FileTestData = 'TestData_Sheet6'

//Count total row:
def totalRow = findTestData(FileTestData).getRowNumbers()

def totalColumn = findTestData(FileTestData).getColumnNumbers()

def rowNum = 1

def arrayLength = 0

//======================================================================================================================
//Define row will be used===============================================================================================
for (rowNum; rowNum < totalRow; rowNum++) {
	if (findTestData(FileTestData).getValue(1, rowNum) == TestID) {
		break
	}
}

println('Row number is: ' + rowNum)

//======================================================================================================================
//Define number of sheets will be used==================================================================================
for (i = 0; i < (totalColumn - 1); i++) {
	if (findTestData(FileTestData).getValue(i + 2, rowNum) == '') {
		break
	}
	
	arrayLength++
}

println('Array length is: ' + arrayLength)

//======================================================================================================================
//Create array and get values from data file:===========================================================================
String[] listData = new String[arrayLength]

for (rowNum = 1; rowNum < totalRow; rowNum++) {
	if (findTestData(FileTestData).getValue(1, rowNum) == TestID) {
		for (int i = 0; i < arrayLength; i++) {
			if (findTestData(FileTestData).getValue(i + 2, 1) == '') {
				break
			}
			
			(listData[i]) = findTestData(FileTestData).getValue(i + 2, rowNum)
		}
	}
}

println(listData)

//======================================================================================================================

WebUI.callTestCase(findTestCase('Intermediate/Prerequisite1_Access_Immediate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Intermediate/option_JQueryListBox'))


//Click Add All button:
WebUI.click(findTestObject('Intermediate/5_JQuery_List_Box/button_Add_All'))

//Select single item and click Remove:
for (i = 0; i < listData.length; i++) {
	WebUI.click(findTestObject('Intermediate/5_JQuery_List_Box/dynamic_items_in_right', ['item' : listData[i]]))
	WebUI.click(findTestObject('Intermediate/5_JQuery_List_Box/button_Remove'))
	
	//Verify item is no longer visible in right panel:
	WebUI.verifyElementNotPresent(findTestObject('Intermediate/5_JQuery_List_Box/dynamic_items_in_right', ['item' : listData[i]]), 2)
	
	//Verify item is visible in left panel:
	WebUI.verifyElementPresent(findTestObject('Intermediate/5_JQuery_List_Box/dynamic_items_in_left', ['item' : listData[i]]), 2)
}

WebUI.closeBrowser()