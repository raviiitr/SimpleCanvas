# SimpleCanvas
This is a simple Command line Canvas Program. It supports following commands 

1. C w h --> Create a new canvas of width w and height h
2. L x1 y1 x2 y2 --> Draw a new line from coordinates (x1, y1) to (x2, y2) horizontally or vertically. Lines are made up of the x character
3. R x1 y1 x2 y2 --> Draw a new rectangle, with upper left corner at coordinate (x1, y1) and lower right coordinate at (x2, y2). Lines are made up of the x character
4. Q --> Quit the program

**Few Important Points**
1. Program uses Java 11 or higher.
2. All the coordinates have to be in positive integers
3. Main Class is CanvasApp.java
4. CanvasManagerImplTest.java has most of the e2e unit tests
5. Junit Coverage is around 90%.


**Usage:** Use either of below options 
1. Run CanvasApp.java (as it is the main class) from IntelliJ or any Java based IDE
2. Build the Program with **mvn clean install -U**. This will create a jar with dependencies named SimpleCanvas-1.0-SNAPSHOT-jar-with-dependencies.jar. Then from command prompt run command --> java -jar add_path_of_jar\SimpleCanvas-1.0-SNAPSHOT-jar-with-dependencies.jar
