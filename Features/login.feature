Feature: Login


Scenario: Successful login with valid credentials
   Given User launch Chrome browser
   When User opens url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
   And User enters Username as "Admin" and Password as "admin@123"
   And Click on login
   Then User should be on Dashboard page
   When User click on log out link
   Then User should be on Login page
   And close browser
   