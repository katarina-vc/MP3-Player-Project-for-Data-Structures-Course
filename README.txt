**************** READ ME ****************************************************

Project 1 for Data Structures COP3530
by Katarina Capalbo
Student ID: n01399315
Date: 6/1/2019

*****Description:************************************************************

This project consists of a functional MP3 player that originally used an ArrayList
as its underlying data structure, but I have converted it to a Linked List.

The MP3 source code can be found in MP3.java and the Linked List source code can be found in List.java
**NOTE**: You can safely ignore the compiler warning that states Mp3Player.java uses or overrides a deprecated API.


***** BEFORE COMPILING ******************************************************
I am using the Eclipse 2019 IDE for this project if you are following step by step and word for word.

Before compiling: 
You must extract the "Project 1 Input Files" and place them in your project folder in your IDE before continuing. 
This project is using the javazoom MP3 decoder and can be imported in the following way:

javac -cp jl1.0.1.jar Mp3Player.java 
java -cp ./jl1.0.1.jar:. Mp3Player 

OR, you can follow these steps if you are using Eclipse 2019:
1. Open your project in your IDE. 
2. Right click on your project name and select "Properties"
3. Select "Java Build Path" on the left and then select the "Libraries" tab
4. Select "Add External JARs"
5. Select the jl1.0.1.jar file that you placed in your Project folder earlier
6. Select "Apply and Close"


***** HOW TO RUN **********************************************************
Once the input files have been extracted and properly placed in your Project folder,
and the jar file has been added, you may run the source code in an IDE of your choice.



****** EXPECTED OUTPUT ****************************************************
An MP3 GUI will appear with 6 songs listed. You may play the song, stop the song, and skip to the next song. 
Additionally, output of a list of songs will appear in your console. 

**Please see the "Screenshots of Output" folder for further examples**
