# README #

## Project: Personal Library ##
#### Author: Alvaro Espinoza ####

### What is this repository for? ###

* Store the content of the program developed for academic purposes for 
  the object-oriented programming course of the _Universidad Creativa_ of Costa Rica.

* Version 1.0

* [Project Repository](https://github.com/Wow1986CR/Proyecto)

### Dependencies ###
* Java SDK 15.0.2
* Project encoding UTF-8

The program makes use of the following libraries:
* javax.swing
* java.awt
* java.util.Date
* java.util.List
* java.io
* java.text.SimpleDateFormat
* java.util.stream.Collectors


### Description ###

#### Problem to be solved: ####
_As the owner of a personal bookstore of works of universal and academic literature, 
I want to register each book that I lend and each borrowed book that is returned to me, so as not to lose more 
books without knowing who to make the claim._

#### Solution description: ####

Through a graphical interface, the user can:
* Register the loan of a book, capturing personal data of the person who receives it.
  The program automatically stamps the date and time of the registration.
* Register the return of a borrowed book, capturing only basic data plus some review of
  the reading of the person who had the book.
  
#### Architectural design of the program ####
The program has 4 entities that abstract the problem to be solved:
* Persona (abstract)
* Libro
* Deudor
* Retornante

In its logical sense, the program is organized in 3 packages that represent the graphical 
representation capabilities (GUI), business rules and storage:
* ui
* services
* repositories

The program runs from a single main method organized outside the project packages.

For this first version of the program, all data recording is done only in a .txt file

![Entities Diagram](https://github.com/Wow1986CR/Proyecto/blob/master/Diagrama%20de%20Clases%20-%20Proyecto%20OOP.png)

### Who do I talk to? ###

* Repo owner **Alvaro Espinoza**
* _alvaro5218@gmail.com_