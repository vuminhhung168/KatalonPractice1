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

//Require data:
String TestID = 'TEST-00001'

String FileTestData = 'TestData_Sheet4'

//Count total row:
def totalRow = findTestData(FileTestData).getRowNumbers()

def totalColumn = findTestData(FileTestData).getColumnNumbers()

def arrayLength = 0

//Define row will be used:
for (int rowNum = 1; rowNum < totalRow; rowNum++) {
    if (findTestData(FileTestData).getValue(1, rowNum) == TestID) {
        //Define length of array (total columns):
        for (int i = 0; i < (totalColumn - 1); i++) {
            //If sheet is empty, end count:
            if (findTestData(FileTestData).getValue(i + 2, rowNum) == '') {
                break
            }
            
            arrayLength++
        }
    }
}

println(('\n\nArray length is: ' + arrayLength) + '\n\n')

//Create array and get values from data file:
String[] listOptionGroups = new String[arrayLength]

for (int rowNum = 1; rowNum < totalRow; rowNum++) {
    if (findTestData(FileTestData).getValue(1, rowNum) == TestID) {
        for (int i = 0; i < arrayLength; i++) {
            if (findTestData(FileTestData).getValue(i + 2, 1) == '') {
                break
            }
            
            (listOptionGroups[i]) = findTestData(FileTestData).getValue(i + 2, rowNum)
        }
    }
}

println(listOptionGroups)

WebUI.callTestCase(findTestCase('Intermediate/Prerequisite1_Access_Immediate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Intermediate/option_JQuerySelectDropdown'))

for (int i = 0; i < listOptionGroups.length; i++) {
    result = WebUI.verifyElementPresent(findTestObject('Intermediate/3_JQuery_Select _Dropdown/option_group_Files', [('optionGroup') : listOptionGroups[
                i]]), 3)

    if (result == true) {
        println(('Option group named ' + (listOptionGroups[i])) + ' is present')
    } else {
        println(('Option group named ' + (listOptionGroups[i])) + ' is NOT present')
    }
}

//==========================================>VERIFY LIST OF SCRIPTING LANGUAGE:<============================================
TestID = 'TEST-00002'

def optionGroup = 'Scripting languages'

arrayLength = 0

//Define row will be used:
for (int rowNum = 1; rowNum < totalRow; rowNum++) {
    if (findTestData(FileTestData).getValue(1, rowNum) == TestID) {
        //Define length of array (total columns):
        for (int i = 0; i < (totalColumn - 1); i++) {
            //If sheet is empty, end count:
            if (findTestData(FileTestData).getValue(i + 2, rowNum) == '') {
                break
            }
            
            arrayLength++
        }
    }
}

println(('\n\nArray length is: ' + arrayLength) + '\n\n')

//Create array and get values from data file:
String[] listOptionScriptings = new String[arrayLength]

for (int rowNum = 1; rowNum < totalRow; rowNum++) {
    if (findTestData(FileTestData).getValue(1, rowNum) == TestID) {
        for (int i = 0; i < arrayLength; i++) {
            if (findTestData(FileTestData).getValue(i + 2, 1) == '') {
                break
            }
            
            (listOptionScriptings[i]) = findTestData(FileTestData).getValue(i + 2, rowNum)
        }
    }
}

println("/n/n" + listOptionScriptings + "/n/n")


for (int i = 0; i < listOptionScriptings.length; i++) {
	result = WebUI.verifyElementPresent(findTestObject('Intermediate/3_JQuery_Select _Dropdown/option_Files', [('optionGroup') : optionGroup, ('type') : listOptionScriptings[i]]), 
    3)

	if (result == true) {
		println(('Option named ' + (listOptionScriptings[i])) + ' is present')
	} else {
		println(('Option named ' + (listOptionScriptings[i])) + ' is NOT present')
	}
}

//==========================================>VERIFY LIST OF PROGRAMMING LANGUAGE:<============================================
TestID = 'TEST-00003'
optionGroup = 'Programming languages'

arrayLength = 0

//Define row will be used:
for (int rowNum = 1; rowNum < totalRow; rowNum++) {
	if (findTestData(FileTestData).getValue(1, rowNum) == TestID) {
		//Define length of array (total columns):
		for (int i = 0; i < (totalColumn - 1); i++) {
			//If sheet is empty, end count:
			if (findTestData(FileTestData).getValue(i + 2, rowNum) == '') {
				break
			}
			
			arrayLength++
		}
	}
}

println(('\n\nArray length is: ' + arrayLength) + '\n\n')

//Create array and get values from data file:
String[] listOptionProgrammings = new String[arrayLength]

for (int rowNum = 1; rowNum < totalRow; rowNum++) {
	if (findTestData(FileTestData).getValue(1, rowNum) == TestID) {
		for (int i = 0; i < arrayLength; i++) {
			if (findTestData(FileTestData).getValue(i + 2, 1) == '') {
				break
			}
			
			(listOptionProgrammings[i]) = findTestData(FileTestData).getValue(i + 2, rowNum)
		}
	}
}

println("/n/n" + listOptionProgrammings + "/n/n")


for (int i = 0; i < listOptionProgrammings.length; i++) {
	result = WebUI.verifyElementPresent(findTestObject('Intermediate/3_JQuery_Select _Dropdown/option_Files', [('optionGroup') : optionGroup, ('type') : listOptionProgrammings[i]]),
	3)

	if (result == true) {
		println(('Option named ' + (listOptionProgrammings[i])) + ' is present')
	} else {
		println(('Option named ' + (listOptionProgrammings[i])) + ' is NOT present')
	}
}

//==========================================>VERIFY LIST OF OTHER:<============================================
TestID = 'TEST-00004'
optionGroup = 'Other'

arrayLength = 0

//Define row will be used:
for (int rowNum = 1; rowNum < totalRow; rowNum++) {
	if (findTestData(FileTestData).getValue(1, rowNum) == TestID) {
		//Define length of array (total columns):
		for (int i = 0; i < (totalColumn - 1); i++) {
			//If sheet is empty, end count:
			if (findTestData(FileTestData).getValue(i + 2, rowNum) == '') {
				break
			}
			
			arrayLength++
		}
	}
}

println(('\n\nArray length is: ' + arrayLength) + '\n\n')

//Create array and get values from data file:
String[] listOptionOthers = new String[arrayLength]

for (int rowNum = 1; rowNum < totalRow; rowNum++) {
	if (findTestData(FileTestData).getValue(1, rowNum) == TestID) {
		for (int i = 0; i < arrayLength; i++) {
			if (findTestData(FileTestData).getValue(i + 2, 1) == '') {
				break
			}
			
			(listOptionOthers[i]) = findTestData(FileTestData).getValue(i + 2, rowNum)
		}
	}
}

println("\n\n" + listOptionOthers + "\n\n")


for (int i = 0; i < listOptionOthers.length; i++) {
	result = WebUI.verifyElementPresent(findTestObject('Intermediate/3_JQuery_Select _Dropdown/option_Files', [('optionGroup') : optionGroup, ('type') : listOptionOthers[i]]),
	3)

	if (result == true) {
		println(('Option named ' + (listOptionOthers[i])) + ' is present')
	} else {
		println(('Option named ' + (listOptionOthers[i])) + ' is NOT present')
	}
}

println(listOptionScriptings)
println(listOptionProgrammings)
println(listOptionOthers)

not_run: WebUI.selectOptionByLabel(findTestObject('Intermediate/3_JQuery_Select _Dropdown/select_Files'), 'PHP', false)



