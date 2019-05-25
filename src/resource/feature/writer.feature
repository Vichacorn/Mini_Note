Feature: user can write a note
    As a user
    I want write the note
    so that I the content of note are save

Scenario: write text
    	When user write note "KU" with content "We're love KU"
    	Then the file "KU" is saved



