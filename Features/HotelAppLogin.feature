Feature: HotelApp login Param
Description: This test is to check the login functionality of the HotelApp

Scenario: Login Successful
Given User is on HotelApp homepage 
When User enters username "vasuvespag"
And User enters password "vasu1234"
And User clicks on Login Button
Then Login is Successful