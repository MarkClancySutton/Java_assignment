package assignment;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFirstGUI extends Fileprocessor  implements ActionListener{
	
	//Declare attributes
	JLabel label1;
	JButton button1, button2,button3,button4,button5,button6;
	JPanel panel1,pannel2,panel3,panel4,panel5,panle6;
	JTextField nsize,stopword;
	JFileChooser file = new JFileChooser();
	JFileChooser files = new JFileChooser();
	String tempn;
	int n = 0;
	static int counter =0;
	static int i = 0;
	int correct =1;
	int checkbutton4 = 1;

	public MyFirstGUI()  
	{
		JFrame frame1= new JFrame("My First GUI");
	
	//Title of site
	
	
	frame1.setTitle("GUI-First");
	frame1.setVisible(true);
	frame1.setSize(400,350);
	FlowLayout experimentLayout = new FlowLayout();
	frame1.setLayout(experimentLayout);
	
	//Background and panel creation
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();
	frame1.add(panel1);
	frame1.add(panel2);
	frame1.add(panel3);
	frame1.add(panel4);
	frame1.add(panel5);
	frame1.add(panel6);
	 
	//Creates all the buttons we will need 
	button1 = new JButton();
	button2 = new JButton();
	button3 = new JButton();
	button4 = new JButton();
	button5 = new JButton();
	button6 = new JButton();
	
	//create the first button to read in the first file
	panel2.add(button1);
	button1.setText("File1");
	button1.setToolTipText("Open the first file ");
	button1.addActionListener(this);
	
	//create the second button to read in the second file
	panel2.add(button2);
	button2.setText("File2");
	button2.setToolTipText("open the second file");
	button2.addActionListener(this);
	
	//create a textfield to set the value of n amount of top words you wish to see
	nsize = new JTextField("How many of the top words do you want to see");
	panel3.add(nsize);
	
	//Add a textfield to input any new stopword that you would like
	stopword = new JTextField("Add a word to the stop words");
	panel4.add(stopword);
	
	//Submit the value in the stopword textfield
	panel4.add(button3);
	button3.setText("Add stopword");
	button3.setToolTipText("Add a word to teh stop words");
	button3.addActionListener(this);
	
	//Starts the modeler
	panel5.add(button4);
	button4.setText("Start Modeller");
	button4.setToolTipText("Saves from the text fields and runs the modeler");
	button4.addActionListener(this);
	
	//Submits an input for n
	panel3.add(button5);
	button5.setText("Enter n ");
	button5.setToolTipText("Select the amount of top words to see");
	button5.addActionListener(this);
	
	//Displays in the console the top n words
	panel6.add(button6);
	button6.setText("See the top n words");
	button6.setToolTipText("Select to see teh top n word and the count ");
	button6.addActionListener(this);
	
	
	}



	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1)
		{
			//Selects the first file and saves its path to f
		    file.setMultiSelectionEnabled(true);
		    file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		    file.setFileHidingEnabled(false);
		    if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		       java.io.File f = file.getSelectedFile();
		      
		    }
		    

			
		}
		else if (e.getSource() == button2)
		{
			//Selects the first file and saves its path to h
			files.setMultiSelectionEnabled(true);
		    files.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		    files.setFileHidingEnabled(false);
		    if (files.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		       java.io.File h = files.getSelectedFile();
	
		       
		    }
		}  
		//Add any stop words to the word list
		else if (e.getSource() == button3)
		{
		    //Adds what's in the stopword text field to the stopwords list	
			stoplist.add(stopword.getText());
		    	
		}
		//Run the data modeler     
		else if (e.getSource() == button4)
		{
			
			java.io.File h = files.getSelectedFile();
			java.io.File f = file.getSelectedFile();
			Fileprocessor file1 = new Fileprocessor();
			Fileprocessor file2 = new Fileprocessor();
			file1.readwords(f.getPath(),n);                        
			file2.readwords(h.getPath(),n);
			
			//Checks to see if a value for n is inputed 
			//If yes then runs as normal 
			//If no gives the user an error telling them to input a value for n
			if(correct ==0) 
			{
				//Checks to see if the readwords method was ran for both files 
				//AN then calculates the percentage and displays it if so
				if (j == 1)
				{
					percentage = correctcounter*100/tempWordlist.size();
					if (counter != 0) 
					{
						percentage =percentage -100;
					}//end if
					if(percentage>39) 
					{
						JOptionPane.showMessageDialog(button4,percentage+"% chance of being the same work \nThese are too close to be a coincidence more than likely the same file");
	        		
					}//end if
					else 
					{
						JOptionPane.showMessageDialog(button4,percentage+"% chance of being the same work \nThese are too different to be resonably the same file");
					}//end else
	         
					percentage =0;
					correctcounter = 0;
					
				}//end if
				checkbutton4 =0;
			}//end if
			else 
			{
				JOptionPane.showMessageDialog(button4,"You must enter and submit a valid value into n ");
			}//end else
        	
        	
        	
			if(counter == 0) 
			{
				j = 0;
				correctcounter =0;
				percentage =0;
			}//end if 
			counter++;
			
			
			
			
		
		}
		//Select the amount of top words you want to see
		else if (e.getSource() == button5)
		{
			//Check if the text field is empty
			if(nsize.getText().isEmpty())
			{
				
			}
			else//if not then converts the string number to int n
			{
				tempn = nsize.getText();
				n = Integer.parseInt(tempn);
				correct = 0;
			}
				
			
		}
		//Display the top n words 
		else if (e.getSource() == button6)
		{
			//rerun the fileproessor and its methods 
			Fileprocessor file1 = new Fileprocessor();
			Fileprocessor file2 = new Fileprocessor();
			java.io.File h = files.getSelectedFile();
			java.io.File f = file.getSelectedFile();
			file1.readwords(f.getPath(),n);                        
			file2.readwords(h.getPath(),n);
			
			//Check to see if the datamodeler was run above 
			if(checkbutton4 ==0) 
			{
				file1.printhashmap(n);
				file2.printhashmap(n);
			}
			else//If not then diplay an error  
			{
				JOptionPane.showMessageDialog(button4,"You must run the data modeler succesfully first  ");
			}
			percentage =0;
			correctcounter=0;
		}
		
		
		else
			System.out.print("I Finished ");
		
	}
	
	
	}

	


