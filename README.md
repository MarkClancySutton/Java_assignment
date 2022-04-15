# Java_assignment BY Mark CLancy Sutton C20437052

List of classes:
Fileprocesor: Will open the file and read and count the words in a file and place those values into a hashmap accordingly.
           Readwords Method <br />
           - Readwords will be used to place the words of the file into a hashmap with the count values and count how many match up to the second file. 
           PrintHashmap Methods 
           <br />-Print hashmap will print the hashmap in descending order based on the count of the words to the console and is run in the GUI later aswell.

MyFirstGUI: <br />
- Button1 will let you choose the file1 <br />
- Button2 will let you choose file2 <br />
- Button3 will add the entry form the stopwords textfield to the stopwords thus not allowing it to be a valid word used in the hashmaps of wither file 
- Button4 Will then run the file processor class and the readwords method and will then calculate the percentage of likely hood. This will thne be displayed to the user in a pop up window
- Button 5 will take the value of the nsize textfield and this will then be passed to an integer and used in button 4 and button 6 
- Button 6 will then use the method printhashmap and print the top n words and their counts from bot file 1 and 2 to the console 

The Core functionality of the program is that you can choose 2 different files using the gui and run the data modeler to showcase the top n words and of the 2 files while also removing stopwords that are placed within the stopwords.txt file. Then it will give the user a percentage of how many of the words and counts match up in each different file. 

The Optional functionality that I included was the use of Jfile chooser in the Gui to allow the user to easily select the 2 files when they push button 1 and button 2. The GUI is also a higher quality using both color and a nice layout for the viewing pleasure of the user. I also have in the GUI by using the textfield stopwords and button 3 you can add a stop word one at a time to the stopword lsit thus when you hit button 4 those words will be now taken out of the equation thus lowering the percentage if the words were indeed in either of the 2 files.I also displayed the top n words in the console using button 6 

If I had more time, I would add some form of file percistency to this project if I had more time probably something along the lines of a text file to store the previous values of the data modleer to be restored lter if the user would wnat to see that. 

URL to my GitHub is https://github.com/MarkClancySutton/Java_assignment <br/>
URl to my vidoe is https://www.youtube.com/watch?v=i34-pOIKEVQ
