Feature: user can read a note
    As a user
    I want open the note
    so that I can read the note

Scenario: Header exit
    	When user open the note that exits
    	Then user can read the note "StarLord"

Scenario: Header doesn't exit
    	When user open the note that does not exits
    	Then user can not read the note "FireFly"


