Feature: Login into Application

Scenario Outline: Positive Test validating Login
Given Initialize the browser with chrome
And Navigate to "http://qaclickacademy.com" Site
And Click on Login Link on HomePage to land on Secure sign in Page
When User Enter <Username> and login <Password> and logs in
Then verify user has successfully logged in
And close browser

Examples:
|Username           	|Password	|
|test99@gmail.com		|123456		|
|test123@gmail.com		|1234		|
