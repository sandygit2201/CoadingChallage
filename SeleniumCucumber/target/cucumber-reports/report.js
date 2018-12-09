$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/WorkSpaceUpdated/SeleniumCucumber/Features/AconexDemo.feature");
formatter.feature({
  "name": "Oracle demo scenarios",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@demo"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Create new doucment and verify",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@scenario1"
    }
  ]
});
formatter.step({
  "name": "Open Aconex application",
  "keyword": "Given "
});
formatter.step({
  "name": "Login to application with \u003cusername\u003e and \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "Page with title \"\u003chomepagetitle\u003e\" should be displayed",
  "keyword": "Then "
});
formatter.step({
  "name": "Select \"\u003cproject\u003e\" from project menu",
  "keyword": "Then "
});
formatter.step({
  "name": "Click on \"Documents\" tab",
  "keyword": "Then "
});
formatter.step({
  "name": "Click on \"Upload a New Document\" link",
  "keyword": "And "
});
formatter.step({
  "name": "Enter new document details from \"\u003cdocumentname\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "Click on \"Documents\" tab",
  "keyword": "Then "
});
formatter.step({
  "name": "Click on \"Document Register\" link",
  "keyword": "And "
});
formatter.step({
  "name": "Search new document in \"Document Register\" page",
  "keyword": "And "
});
formatter.step({
  "name": "Logout from application",
  "keyword": "When "
});
formatter.step({
  "name": "Page with title \"\u003clogoffpagetitle\u003e\" should be displayed",
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
        "password",
        "homepagetitle",
        "logoffpagetitle",
        "project",
        "documentname"
      ]
    },
    {
      "cells": [
        "challenge1",
        "dEMO12345!@#$%",
        "Aconex",
        "Log off",
        "Hotel VIP Resort",
        "NewDocument.json"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Create new doucment and verify",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@demo"
    },
    {
      "name": "@scenario1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Open Aconex application",
  "keyword": "Given "
});
