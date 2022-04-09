package assignment;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.*;

import javax.swing.*;





public class MyFirstGUI extends Fileprocessor  implements ActionListener{
	
	
	JLabel label1;
	JButton button1, button2,button3,button4,button5;
	JPanel panel1,pannel2,panel3,panel4,panel5;
	JTextField nsize,stopword,hashmap;
	JFileChooser file = new JFileChooser();
	JFileChooser file2 = new JFileChooser();
	String tempn;
	int n = 0;
	static int counter =0;
	static int i = 0;

	
	
	
	
	
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
	frame1.add(panel1);
	frame1.add(panel2);
	frame1.add(panel3);
	frame1.add(panel4);
	frame1.add(panel5);
	
	 
	//Opens the file navigator to select the first file
	button1 = new JButton();
	panel2.add(button1);
	button1.setText("File1");
	button1.setToolTipText("Open the first file ");
	button1.addActionListener(this);
	
	button2 = new JButton();
	button3 = new JButton();
	button4 = new JButton();
	button5 = new JButton();
	
	panel2.add(button2);
	button2.setText("File2");
	button2.setToolTipText("open the second file");
	button2.addActionListener(this);
	
	nsize = new JTextField("How many of the top words do you want to see");
	panel3.add(nsize);
	
	stopword = new JTextField("Add a word to the stop words");
	panel4.add(stopword);
	
	panel4.add(button3);
	button3.setText("Add stopword");
	button3.setToolTipText("Add a word to teh stop words");
	button3.addActionListener(this);
	
	panel5.add(button4);
	button4.setText("Start Modeller");
	button4.setToolTipText("Saves from the text fields and runs the modeler");
	button4.addActionListener(this);
	
	panel3.add(button5);
	button5.setText("Enter n ");
	button5.setToolTipText("Select the amount of top words to see");
	button5.addActionListener(this);
	
	hashmap = new JTextField("");
	
	}



	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1)
		{
			
		    file.setMultiSelectionEnabled(true);
		    file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		    file.setFileHidingEnabled(false);
		    if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		       java.io.File f = file.getSelectedFile();
		      
		    }
		    

			
		}
		else if (e.getSource() == button2)
		{
			file2.setMultiSelectionEnabled(true);
		    file2.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		    file2.setFileHidingEnabled(false);
		    if (file2.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		       java.io.File h = file2.getSelectedFile();
	
		       
		    }
		}  
		//Ad any stop words to the word list
		else if (e.getSource() == button3)
		{
		    	stoplist.add(stopword.getText());
		    	
		}
		//Run the data modeler     
		else if (e.getSource() == button4)
		{
			
			java.io.File h = file2.getSelectedFile();
			java.io.File f = file.getSelectedFile();
		    Fileprocessor file1 = new Fileprocessor();
			Fileprocessor file2 = new Fileprocessor();
			file1.readwords(f.getPath(),n);                        
			file2.readwords(h.getPath(),n);
			file1.printhashmap(n);
			file2.printhashmap(n);
			
			
			
			if (j == 1)
	        {
	           percentage = correctcounter*100/tempWordlist.size();
	           if (counter != 0) 
	           {
	        	   percentage =percentage -100;
	           }
	           if(percentage>39) 
	        	{
	        		JOptionPane.showMessageDialog(button4,percentage+"% chance of being the same work \nThese are too close to be a coincidence more than likely the same file");
	        		
	        	}
	        	else 
	        	{
	        		JOptionPane.showMessageDialog(button4,percentage+"% chance of being the same work \nThese are too different to be resonably the same file");
	        	}
	         
	            percentage =0;
	            correctcounter = 0;
	        }
			
        	
        	
        	
			if(counter == 0) 
			{
				j = 0;
				correctcounter =0;
				percentage =0;
			}
			counter++;
			
			
			
			
		
		}
		//Select the amount of top words you want to see
		else if (e.getSource() == button5)
		{
			if(nsize.getText().isEmpty())
			{
				
			}
			else
			{
				tempn = nsize.getText();
				n = Integer.parseInt(tempn);
			}
				
			
		}
		
		
		else
			System.out.print("I Finished ");
		
	}
	
	
	}

	


