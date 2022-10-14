$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Include/features/Intermediate/5_JQuery_List_Box/5_JQuery_List_Box.feature");
formatter.feature({
  "name": "As an PO, i want to view new elements named in UI, then i can add/remove it",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Verify elements in UI",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AC1.1"
    }
  ]
});
formatter.step({
  "name": "Easyselenium page is launched",
  "keyword": "Given "
});
formatter.step({
  "name": "I navigate to Immediate level then JQuery List Box",
  "keyword": "When "
});
formatter.step({
  "name": "I verify item \u003citem\u003e is visible in UI",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "item"
      ]
    },
    {
      "cells": [
        "Isis"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify elements in UI",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AC1.1"
    }
  ]
});
formatter.step({
  "name": "Easyselenium page is launched",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition_JQueryListBox.launchEasyseleniumPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to Immediate level then JQuery List Box",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition_JQueryListBox.navigateToImmediateLevel()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify item Isis is visible in UI",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition_JQueryListBox.verifyElementsInUI(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Select item in left panel then click Add and verify it is moved to right",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AC1.2"
    }
  ]
});
formatter.step({
  "name": "Easyselenium page is launched",
  "keyword": "Given "
});
formatter.step({
  "name": "I navigate to Immediate level then JQuery List Box",
  "keyword": "When "
});
formatter.step({
  "name": "I select item \u003citem\u003e in the left panel then click Add button",
  "keyword": "And "
});
formatter.step({
  "name": "The item \u003citem\u003e is moved to the right panel",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "item"
      ]
    },
    {
      "cells": [
        "Isis"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Select item in left panel then click Add and verify it is moved to right",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AC1.2"
    }
  ]
});
formatter.step({
  "name": "Easyselenium page is launched",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition_JQueryListBox.launchEasyseleniumPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to Immediate level then JQuery List Box",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition_JQueryListBox.navigateToImmediateLevel()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select item Isis in the left panel then click Add button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition_JQueryListBox.addSingleItem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The item Isis is moved to the right panel",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition_JQueryListBox.verifySingleItemIsAdded(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Select item in right panel then click Remove and verify it is moved to left",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AC1.3"
    }
  ]
});
formatter.step({
  "name": "Easyselenium page is launched",
  "keyword": "Given "
});
formatter.step({
  "name": "I navigate to Immediate level then JQuery List Box",
  "keyword": "When "
});
formatter.step({
  "name": "I select item \u003citem\u003e in the left panel then click Add button",
  "keyword": "And "
});
formatter.step({
  "name": "I select item \u003citem\u003e in the right panel then click Remove button",
  "keyword": "And "
});
formatter.step({
  "name": "The item \u003citem\u003e is moved to the left panel",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "item"
      ]
    },
    {
      "cells": [
        "Isis"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Select item in right panel then click Remove and verify it is moved to left",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AC1.3"
    }
  ]
});
formatter.step({
  "name": "Easyselenium page is launched",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition_JQueryListBox.launchEasyseleniumPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to Immediate level then JQuery List Box",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition_JQueryListBox.navigateToImmediateLevel()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select item Isis in the left panel then click Add button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition_JQueryListBox.addSingleItem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select item Isis in the right panel then click Remove button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition_JQueryListBox.removeSingleItem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The item Isis is moved to the left panel",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition_JQueryListBox.verifySingleItemIsRemoved(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("Include/features/Intermediate/5_JQuery_List_Box/ACM_Login.feature");
formatter.feature({
  "name": "login feature",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "login is failed if input incorrect password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AC1.1"
    }
  ]
});
formatter.step({
  "name": "launch ACM page",
  "keyword": "Given "
});
formatter.step({
  "name": "Input \u003cusername\u003e and incorrect \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "Click Login button",
  "keyword": "And "
});
formatter.step({
  "name": "Login is failed with message",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "itnv",
        "1_Abc_1234_5678"
      ]
    }
  ]
});
formatter.scenario({
  "name": "login is failed if input incorrect password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AC1.1"
    }
  ]
});
formatter.step({
  "name": "launch ACM page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition_ACMLogin.launchPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Input itnv and incorrect 1_Abc_1234_5678",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition_ACMLogin.provideInvalidValue(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click Login button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition_ACMLogin.clickLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Login is failed with message",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition_ACMLogin.showFailedMessage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "login is successful if input correct password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AC1.2"
    }
  ]
});
formatter.step({
  "name": "launch ACM page",
  "keyword": "Given "
});
formatter.step({
  "name": "Input \u003cusername\u003e and correct \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "Click Login button",
  "keyword": "And "
});
formatter.step({
  "name": "Login is successful",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "itnv",
        "1_Abc_1234_567"
      ]
    }
  ]
});
formatter.scenario({
  "name": "login is successful if input correct password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AC1.2"
    }
  ]
});
formatter.step({
  "name": "launch ACM page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition_ACMLogin.launchPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Input itnv and correct 1_Abc_1234_567",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition_ACMLogin.provideValidValue(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click Login button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition_ACMLogin.clickLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Login is successful",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition_ACMLogin.showSuccessMessage()"
});
formatter.result({
  "status": "passed"
});
});