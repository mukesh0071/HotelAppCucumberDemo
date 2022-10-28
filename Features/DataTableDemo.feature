Feature: HotelApp login
Description: This test is to check the login functionality of the HotelApp

Scenario: Login Successful
Given User is on HotelApp homepage 
When User enters Username and Password 
| username | password |
| vasuvespag | vasu1234 |
| aryan1207 | Aryan@120799 | 
And User clicks on Login Button
Then Login is Successful