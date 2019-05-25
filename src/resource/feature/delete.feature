Feature: user can delete a note
    As a user
    I want delete the note
    so that I the note are gone

Scenario: delete text
	Given user have note "EXAM"
    	When user delete node "EXAM"
    	Then the file is deleted



