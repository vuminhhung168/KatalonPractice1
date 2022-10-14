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

String FileTestData = 'TestData_Sheet5'

//Count total row:
def totalRow = findTestData(FileTestData).getRowNumbers()

def totalColumn = findTestData(FileTestData).getColumnNumbers()

def rowNum = 1

def arrayLength = 0

def unselectColor = "rgba(255, 255, 255, 1)"
def selectColor = "rgba(51, 122, 183, 1)"
//======================================================================================================================
//Define row will be used===============================================================================================
for (rowNum; rowNum < totalRow; rowNum++) {
	if (findTestData(FileTestData).getValue(1, rowNum) == TestID) break
}
println('Row number is: ' + rowNum)
//======================================================================================================================
//Define number of sheets will be used==================================================================================
for (i = 0; i < (totalColumn - 1); i++) {
	if (findTestData(FileTestData).getValue(i + 2, rowNum) == '') break
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

WebUI.click(findTestObject('Intermediate/option_BootstrapListBox'))

WebUI.verifyElementVisible(findTestObject('Intermediate/4_Bootstrap_List_Box/panel_Left'))

WebUI.verifyElementVisible(findTestObject('Intermediate/4_Bootstrap_List_Box/panel_Right'))

for (int i = 0; i < arrayLength; i++) {
	//Find element:
    WebUI.verifyElementVisible(findTestObject('Intermediate/4_Bootstrap_List_Box/dynamic_li_items_unselect', [('item') : listData[i]]))
	
	//Verify border color of unselected item:
	WebUI.verifyEqual(WebUI.getCSSValue(findTestObject('Intermediate/4_Bootstrap_List_Box/dynamic_li_items_unselect', [('item') : listData[i]]), 'background-color'), unselectColor)
	WebUI.delay(2)
	
	//Select item:
	WebUI.click(findTestObject('Intermediate/4_Bootstrap_List_Box/dynamic_li_items_unselect', [('item') : listData[i]]))
	
	//Verify border color of selected item:
	WebUI.verifyEqual(WebUI.getCSSValue(findTestObject('Intermediate/4_Bootstrap_List_Box/dynamic_li_items_select', [('item') : listData[i]]), 'background-color'), selectColor)
	WebUI.delay(2)
}

for (int i = 0; i < arrayLength; i++) {
	WebUI.verifyElementVisible(findTestObject('Intermediate/4_Bootstrap_List_Box/dynamic_li_items_select', [('item') : listData[i]]))
	WebUI.click(findTestObject('Intermediate/4_Bootstrap_List_Box/dynamic_li_items_select', [('item') : listData[i]]))
	WebUI.verifyEqual(WebUI.getCSSValue(findTestObject('Intermediate/4_Bootstrap_List_Box/dynamic_li_items_unselect', [('item') : listData[i]]), 'background-color'), unselectColor)
	WebUI.delay(2)
}

WebUI.closeBrowser()

