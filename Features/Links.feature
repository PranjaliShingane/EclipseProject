Feature: Links on Homepage


Scenario: Find all the active and broken links on homepage
   Given User launch Chrome browser and login with valid credentials
   When User lands on homepage
   Then Find all the broken and active links on homepage
  