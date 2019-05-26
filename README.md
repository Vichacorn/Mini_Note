# Mini_Note
## Description
___Mini Note___ is any word processing program that you can use to type and edit text.
## How to run & Installation Instructions
### 1.Java version
- Java11
- Javafx11<br>

### 2.Clone The Project
>git clone https://github.com/VichakornNewaz/Mini_Note.git

### 3.Run the program
run file Main.java in src/application

## Feature
![MiniNote](/uml/MiniNote.png)

1. ___save___ text to file .txt
2. ___delete___ file text form storage
3. ___search___ file text form storage
4. ___sort file___ sort file by name,size, and last modified(default is sort by last modified)

## Design Pattern

__Singleton__ Define the ReaderFile,WriteFile, and DeleteFile class as the class that use singleton pattern for avoid program calling many time.<br><br>
__Stategy__ Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from the clients that use it in this project controller is the class that change behavior of sort feature.<br><br>

__Front controller__ Controller class is used to provide a centralized request handling mechanism so that all requests will be handled by a single handler.

![UML](/uml/UML_Diagram.png)

