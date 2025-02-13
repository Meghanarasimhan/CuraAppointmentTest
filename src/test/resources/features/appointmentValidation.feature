Feature: Appointment Form Validation

  Background:
    Given I am on the Cura Healthcare homepage
    When I click on the "Make Appointment" button
    And I login with username "John Doe" and password "ThisIsNotAPassword"
    And I click the "Book Appointment" button

  Scenario: User cannot book an appointment without required fields
    When the user books appointment without selecting Visit Date
    Then the visit date field should be required
