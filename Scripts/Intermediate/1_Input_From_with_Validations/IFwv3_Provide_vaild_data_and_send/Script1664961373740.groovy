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

totalRow = findTestData('TestData_Sheet1').getRowNumbers()

for (def rowNum = 1; rowNum <= totalRow; rowNum++) {
    if (findTestData('TestData_Sheet1').getValue(1, rowNum) == TestID) {
        WebUI.callTestCase(findTestCase('Intermediate/Prerequisite1_Access_Immediate'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Intermediate/option_InputFormValidations'))

        WebUI.setText(findTestObject('Intermediate/1_Input_Form_With_Validations/textbox_First_Name'), findTestData('TestData_Sheet1').getValue(
                2, rowNum))

        WebUI.setText(findTestObject('Intermediate/1_Input_Form_With_Validations/textbox_Last_Name'), findTestData('TestData_Sheet1').getValue(
                3, rowNum))

        WebUI.setText(findTestObject('Intermediate/1_Input_Form_With_Validations/textbox_Email'), findTestData('TestData_Sheet1').getValue(
                4, rowNum))

        WebUI.setText(findTestObject('Intermediate/1_Input_Form_With_Validations/textbox_Phone'), findTestData('TestData_Sheet1').getValue(
                5, rowNum))

        WebUI.setText(findTestObject('Intermediate/1_Input_Form_With_Validations/textbox_Address'), findTestData('TestData_Sheet1').getValue(
                6, rowNum))

        WebUI.setText(findTestObject('Intermediate/1_Input_Form_With_Validations/textbox_City'), findTestData('TestData_Sheet1').getValue(
                7, rowNum))

        WebUI.selectOptionByLabel(findTestObject('Intermediate/1_Input_Form_With_Validations/select_State'), findTestData(
                'TestData').getValue(8, rowNum), false)

        WebUI.setText(findTestObject('Intermediate/1_Input_Form_With_Validations/textbox_Zip_Code'), findTestData('TestData_Sheet1').getValue(
                9, rowNum))

        WebUI.setText(findTestObject('Intermediate/1_Input_Form_With_Validations/textbox_Website_Or_Domain_Name'), findTestData(
                'TestData').getValue(10, rowNum))

        WebUI.click(findTestObject('Intermediate/1_Input_Form_With_Validations/ratio_hosting_Yes'))

        WebUI.setText(findTestObject('Intermediate/1_Input_Form_With_Validations/textarea_Project_Description'), findTestData(
                'TestData').getValue(12, 1))

        WebUI.verifyElementVisible(findTestObject('Intermediate/1_Input_Form_With_Validations/icon_status_ok'))

        WebUI.click(findTestObject('Intermediate/1_Input_Form_With_Validations/button_Send'))

        WebUI.verifyElementNotPresent(findTestObject('Intermediate/1_Input_Form_With_Validations/icon_status_ok'), 0)

        rowNum = (totalRow + 1)
    }
}

