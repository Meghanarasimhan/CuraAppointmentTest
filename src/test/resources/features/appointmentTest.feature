Feature: Cura Healthcare Appointment

  Scenario: Book an appointment successfully
    Given I am on the Cura Healthcare homepage
    When I click on the "Make Appointment" button
    And I login with username "John Doe" and password "ThisIsNotAPassword"
    And I fill the appointment form with facility "Tokyo CURA Healthcare Center"
    And I check the box for "Apply for hospital readmission"
    And I choose "Medicare" as the healthcare program
    And I choose visit Date "25-12-2025"
    And I click the "Book Appointment" button
    Then I should see the confirmation message "Appointment Confirmation"
