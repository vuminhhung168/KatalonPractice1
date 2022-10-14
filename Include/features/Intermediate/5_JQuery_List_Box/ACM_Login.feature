#Author: vminhhung@tma.com.vn
#Project: ACM

Feature: login feature

@AC1.1
Scenario Outline: login is failed if input incorrect password
	Given launch ACM page
  When  Input <username> and incorrect <password>
  And   Click Login button
  Then  Login is failed with message
  
Examples: 
      | username | password |
      | itnv      | 1_Abc_1234_5678 |
      
@AC1.2
Scenario Outline: login is successful if input correct password
	Given launch ACM page
  When  Input <username> and correct <password>
  And   Click Login button
  Then  Login is successful
  
Examples: 
      | username | password |
      | itnv      | 1_Abc_1234_567 |
