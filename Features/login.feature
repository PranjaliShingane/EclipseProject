Feature: Login


Scenario: Successful login with valid credentials
   Given User launch Chrome browser
   When User opens url "https://admin-demo.nopcommerce.com/login?returnUrl=%2Fadmin%2F"
   And User enters Email as "admin@yourstore.com" and Password as "admin"
   And Click on login
   Then page title should be "Dashboard / nopCommerce administration"
   When User click on log out link
   Then Page Title should be "Your store. Login"
   And close browser
   