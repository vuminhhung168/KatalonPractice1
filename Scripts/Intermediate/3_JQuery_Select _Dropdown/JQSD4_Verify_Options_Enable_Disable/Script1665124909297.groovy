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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as Keys

String TestID = 'TEST-00001'

String FileTestData = 'TestData_Sheet3'

String[] territoriesList = ['American Samoa', 'Guam', 'Northern Mariana Islands', 'Puerto Rico', 'United States Minor Outlying Islands'
    , 'Virgin Islands']

String enableColor1 = "rgba(255, 255, 255, 1)"
String enableColor2 = "rgba(53, 53, 53, 1)"
String disableColor = "rgba(153, 153, 153, 1)"

//Count total row:
int totalRow = findTestData(FileTestData).getRowNumbers()

int arrayLength

int rowNum

//Define row will be used (condition == TestID) then count number of values:
for (rowNum = 1; rowNum < totalRow; rowNum++) {
    if (findTestData(FileTestData).getValue(1, rowNum) == TestID) {
        def totalColumn = findTestData(FileTestData).getColumnNumbers()
        println('Total column is: ' + totalColumn)
        //Define length of array (total columns):
        for (int i = 0; i < (totalColumn - 1); i++) {
            if (findTestData(FileTestData).getValue(i + 2, rowNum) == '') {
                break
            }
            arrayLength++
        }
    }
}
println('Array length is: ' + arrayLength)

//Create array and get values from data file:
String[] listOptions = new String[arrayLength]
for (int i = 0; i < arrayLength; i++) {
	if (findTestData(FileTestData).getValue(i + 2, rowNum) == '') continue
	listOptions[i] = findTestData(FileTestData).getValue(i + 2, rowNum)
	println("Value is: " + findTestData(FileTestData).getValue(i + 2, rowNum))
}

WebUI.callTestCase(findTestCase('Intermediate/Prerequisite1_Access_Immediate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Intermediate/option_JQuerySelectDropdown'))

WebUI.click(findTestObject('Intermediate/3_JQuery_Select _Dropdown/span_Select_US_Outlying_Territories'))

//Create array to store attribute value get from UI:
String[] getAttributeValue = new String[territoriesList.length]

for (int i = 0; i < territoriesList.length; i++) {
    getAttributeValue[i] = WebUI.getAttribute(findTestObject('Intermediate/3_JQuery_Select _Dropdown/li_territory_dynamic', [('territory') : territoriesList[
                i]]), 'aria-disabled')
	if (getAttributeValue[i] == "true") getAttributeValue[i] = "disable"
	else getAttributeValue[i] = "enable"
}

//Create array to store CSS value get from UI:
String[] getCSSValue = new String[territoriesList.length]

for (int i = 0; i < territoriesList.length; i++) {
	getCSSValue[i] = WebUI.getCSSValue(findTestObject('Intermediate/3_JQuery_Select _Dropdown/li_territory_dynamic', [('territory') : territoriesList[
                i]]), 'color')
	if      (getCSSValue[i] == enableColor1 || getCSSValue[i] == enableColor2) getCSSValue[i] = "enable"
	else if (getCSSValue[i] == disableColor) getCSSValue[i] = "disable"
}
//println(getAttribute)
//println(listOptions)
//println(getCSSValue)

//Verification:
for (int i = 0; i < territoriesList.length; i++) {
	WebUI.verifyEqual(getAttributeValue[i], listOptions[i])
	WebUI.verifyEqual(getCSSValue[i], listOptions[i])
}

