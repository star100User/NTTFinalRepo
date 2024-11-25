Feature: verify all teh careers page functionality

  Background: 
    Given I launched the the career page

  @frame
  Scenario Outline: verify the careers page form submission functionality
    Given I am on a careers page verified title "Haldirams Nagpur | []Careers"
    When I entered all the details in form
      | name   | email     | mobileNumber   | position   | qualification   | message   |
      | <Name> | <EmailID> | <MobileNumber> | <Position> | <Qualification> | <Message> |
    And I checked the checkbox for I am not a robot
    Then I verified it shows capcha window to user with below message
      | capchaMsg   |
      | <capchaMsg> |

    Examples: 
      | Name | EmailID        | MobileNumber | Position | Qualification | Message                       | capchaMsg             |
      | Arti | Arti@gmail.com |   9999999999 | QA Lead  | BE            | Test Message Scenario outline | Select all squares with |
