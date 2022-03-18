package com_file.OO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileProcessor {
	
	//Attributes
	String filename;
	File myFile;
	
	//Constructor
	public FileProcessor(String filename) 
	{
		this.filename=filename;
	}

	
	//Methods/behaviors
	public void openFile()
	{
		myFile  = new File(filename);
	}
	
	public String readLine() {
		
		String line = "";
		
		
		try {
			Scanner myScanner = new Scanner(myFile);
			while(myScanner.hasNextLine())
			{
				line = myScanner.nextLine();
				System.out.println("This line is  "+line);
			}
			
			myScanner.close();
		
		
		
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("error caught"+e.getMessage());
			
		}
		return line;
	}
	
	public void writeToFile(String lineToBeWritten) 
	{
		PrintWriter writer;
		try {
			File newFile = new File("example.txt");
			writer = new PrintWriter(newFile);
			writer.println(lineToBeWritten);
			writer.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Couldn't find the file to write to"+e.getMessage());
			
		}
			}
}
