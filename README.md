# NotesApp FrontEnd

- This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 15.2.1. The title of the project is NOTES-APP. This is a notes application where a user can register and login and store his/her notes and also view and delete them if needed. 

## Components 

- LAND : This component consists of two buttons login and register buttons. The login button redirects to the login component and register component redirects to the register component.

- REGISTER : This component allows the user to register his details and use the email and password for logging in by redirecting to the login component.

- LOGIN : This component allows user to login and access the notes manager component.

- NOTESMANAGER : This component contains two buttons for viewing notes and adding notes. This addnotes buttons redirects to the add-note component and view-notes buttons redirects to the view-note component.

- ADD-NOTE : This component allows user to add notes to the database.

- VIEW-NOTES : This component allows user to view all the notes which the user has stored in the database.

## Development server

- Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

# Notes App BackEnd 

- create a spring starter app and give the title 'backend' . 

- install the dependencies in the pom.xml file which are listed below
  - spring-boot-starter-parent
  - spring-boot-starter-data-jpa
  - spring-boot-starter-web
  - spring-boot-starter-web-services
  - spring-boot-devtools
  - mysql-connector-j
  - spring-boot-starter-test

## Database Details

- server port = 8090
- url = jdbc:mysql://localhost:3306/mini_test
- username = root
- password = root

## Development Server

- Right click on the project folder and then click run as and then click the spring boot app option.

## Database deletion using cron expression

- I have used " 0 0 * * * * " cron expression to run the cron job or method on an hourly basis. I have used @scheduled annotation to run this method.




