@demo
Feature: Oracle demo scenarios

  @scenario1
  Scenario Outline: Create new doucment and verify
    Given Open Aconex application
    When Login to application with <username> and <password>
    Then Page with title "<homepagetitle>" should be displayed
    Then Select "<project>" from project menu
    Then Click on "Documents" tab
    And Click on "Upload a New Document" link
    Then Enter new document details from "<documentname>"
    Then Click on "Documents" tab
    And Click on "Document Register" link
    And Search new document in "Document Register" page
    When Logout from application
    Then Page with title "<logoffpagetitle>" should be displayed

    Examples:
      | username   | password       | homepagetitle | logoffpagetitle | project          | documentname     |
      | challenge1 | dEMO12345!@#$% | Aconex        | Log off         | Hotel VIP Resort | NewDocument.json |


  @scenario2
  Scenario Outline: Verify workflow count for my organization
    Given Open Aconex application
    When Login to application with <username> and <password>
    Then Page with title "<homepagetitle>" should be displayed
    Then Select "<project>" from project menu
    Then Click on "Workflows" tab
    And Click on "Assigned to my organization" link
    Then Verify result count is not "zero"
    When Logout from application
    Then Page with title "<logoffpagetitle>" should be displayed

    Examples:
      | username   | password       | homepagetitle | logoffpagetitle | project     |
      | challenge1 | dEMO12345!@#$% | Aconex        | Log off         | World Games |


  @scenario3
  Scenario Outline: Send Transmittal mail to Mr Lewis
    Given Open Aconex application
    When Login to application with <username> and <password>
    Then Page with title "<homepagetitle>" should be displayed
    Then Click on "Mail" tab
    And Click on "Blank Mail" link
    Then Select "Type" as "<mailtype>"
    And Enter transmittal mail details from "<maildetailsfile>" and send
    And Verify sent mail content
    When Logout from application
    Then Page with title "<logoffpagetitle>" should be displayed

    Examples:
      | username   | password       | homepagetitle | logoffpagetitle | project     | mailtype    | maildetailsfile      |
      | challenge1 | dEMO12345!@#$% | Aconex        | Log off         | World Games | Transmittal | TransmittalMail.json |
 
    
