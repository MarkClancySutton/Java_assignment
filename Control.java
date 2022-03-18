package com_file.OO;

public class Control {
	
	public  static void main(String[] args) 
	{
		FileProcessor fileProcess = new FileProcessor("example.txt");
		fileProcess.openFile();
		String line = fileProcess.readLine();
		
		
		
	}

}
