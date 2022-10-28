Feature: HotelApp login
Description: This test is to check the login functionality of the HotelApp

Scenario Outline: Login Successful
Given User is on HotelApp homepage 
When User enters Username as <"<username>">
And User enters Password as <"<password>">
And User clicks on Login Button
Then Login is Successful

Examples: 
| username | password |
| vasuvespag | vasu1234 |
| aryan1207 | Aryan@120799 | 