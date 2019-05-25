package test;


import application.DeleteFile;
import application.ReaderFile;
import application.WriteFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


public class StepDefNote {
    WriteFile writer;
    ReaderFile reader;
    DeleteFile delete;

    @Before
    public void init() {
        writer = new WriteFile();
        reader = new ReaderFile();
        delete = new DeleteFile();
    }

    @Given("^user have note \"([^\"]*)\"$")
    public void create_note_exam(String header){
        writer.writeToFile("",header);
        reader.getFileName();
    }
    @When("user open the note that exits")
    public void user_open_the_note_with_header_exits(){
        writer.writeToFile("","StarLord");
        reader.getFileName();
    }

    @When("user open the note that does not exits")
    public void user_open_the_note_with_header_does_not_exits(){
        reader.getFileName();
    }

    @When("^user write note \"([^\"]*)\" with content \"([^\"]*)\"$")
    public void user_write_note_with_content(String header, String content){
        writer.writeToFile(content,header);
        reader.getFileName();
    }

    @When("^user delete node \"([^\"]*)\"$")
    public void user_delete_note(String header){
        delete.deleteSelectFile(header);
        reader.getFileName();
    }



    @Then("^user can read the note \"([^\"]*)\"$")
    public void user_can_read_the_note_that(String header){
        assertTrue(reader.getListName().contains(header));
        delete.deleteSelectFile(header);
    }

    @Then("^user can not read the note \"([^\"]*)\"$")
    public void user_can_not_read_the_note(String header){
        assertFalse(reader.getListName().contains(header));
    }


    @Then("^the file \"([^\"]*)\" is saved$")
    public void the_file_KU_is_saved(String header){
        reader.readerFile(header);
        assertEquals("We're love KU",reader.getContain());
        delete.deleteSelectFile(header);
    }

    @Then("the file is deleted")
    public void the_file_is_deleted(){
        File f = new File("./src/data/EXAM.txt");
        assertFalse(f.exists());
    }

}
