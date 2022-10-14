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

WebUI.click(findTestObject('Intermediate/option_BootstrapListBox'))

//Check the checkbox "Select All" in left panel:
WebUI.click(findTestObject('Intermediate/4_Bootstrap_List_Box/checkbox_select_all_in_left'))

//Click button move to right:
WebUI.click(findTestObject('Intermediate/4_Bootstrap_List_Box/button_move_right'))

WebUI.delay(5)

//Verify empty list in left panel:
WebUI.verifyElementNotPresent(findTestObject('Intermediate/4_Bootstrap_List_Box/static_li_items_in_left'), 2)

//Verify all 10 items are visible in right panel:
for (int i = 1; i <= 10; i++) {
    WebUI.verifyElementPresent(findTestObject('Intermediate/4_Bootstrap_List_Box/dynamic_li_items_in_right', [('n') : i]), 2)
}
//===========================================================================================================================================================
//Check the checkbox "Select All" in right panel:
WebUI.click(findTestObject('Intermediate/4_Bootstrap_List_Box/checkbox_select_all_in_right'))

//Click button move to left:
WebUI.click(findTestObject('Intermediate/4_Bootstrap_List_Box/button_move_left'))

WebUI.delay(5)

//Verify empty list in right panel:
WebUI.verifyElementNotPresent(findTestObject('Intermediate/4_Bootstrap_List_Box/static_li_items_in_right'), 2)

//Verify all 10 items are visible in left panel:
for (int i = 1; i <= 10; i++) {
	WebUI.verifyElementPresent(findTestObject('Intermediate/4_Bootstrap_List_Box/dynamic_li_items_in_left', [('n') : i]), 2)
}

WebUI.closeBrowser()







