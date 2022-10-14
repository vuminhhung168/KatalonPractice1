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

//Run all feature files in features folder:
//Run everything in feature file:
not_run: CucumberKW.runFeatureFile('Include/features/Intermediate/5_JQuery_List_Box/5_JQuery_List_Box.feature')

//Run Acceptance Criteria 1.2 (tag @AC1.2):
not_run: CucumberKW.runFeatureFileWithTags('Include/features/Intermediate/5_JQuery_List_Box/5_JQuery_List_Box.feature', 
    '@AC1.2')

//Run Acceptance Criteria 1.2 and 1.3 (tag @AC1.2 and @AC1.3):
not_run: CucumberKW.runFeatureFileWithTags('Include/features/Intermediate/5_JQuery_List_Box/5_JQuery_List_Box.feature', 
    '@AC1.2, @AC1.3')

not_run: CucumberKW.runFeatureFolder('Include/features/Intermediate/5_JQuery_List_Box')

not_run: CucumberKW.runFeatureFolderWithTags('Include/features/Intermediate/5_JQuery_List_Box', '@AC1.2')

CucumberKW.runWithCucumberRunner(Hung_Cucumber_Runner_Class.class)

