package assignment;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

import javax.swing.*;





public class MyFirstGUI extends Fileprocessor implements ActionListener{
	
	
	JLabel label1;
	JButton button1, button2,button3;
	JPanel panel1,pannel2,panel3;
	JTextField nsize,stopwords;
	final JFileChooser filename1 = new JFileChooser();
	final JFileChooser filename2 = new JFileChooser();
	
	
	
	public MyFirstGUI()  
	{
	
	
	//Title of site
	
	JFrame frame1= new JFrame("My First GUI");
	frame1.setTitle("GUI-First");
	frame1.setVisible(true);
	frame1.setSize(500,300);
	GridLayout experimentLayout = new GridLayout(0,0);
	frame1.setLayout(experimentLayout);
	//Background and panel creation
	
	JPanel panel1 = new JPanel();
	
	frame1.add(panel1);
	
	
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	frame1.add(panel2);
	frame1.add(panel3);
	
	//Opens the file navigator to select the first file
	button1 = new JButton();
	frame1.add(button1);
	button1.setText("File1");
	button1.setToolTipText("Open the first file ");
	button1.addActionListener(this);
	
	//Opens the file navigator to select the second file 
	button2 = new JButton();
	frame1.add(button2);
	button2.setText("File2");
	button2.setToolTipText("open the second file");
	button2.addActionListener(this);
	nsize = new JTextField("How many of the top words do you want to see");
	frame1.add(nsize);
	stopwords = new JTextField("Add entry to stop words");
	frame1.add(stopwords);
	
	}



	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1)
		{
			int returnVal = filename1.showOpenDialog(button1);

			
		}
		else if (e.getSource() == button2)
		{
			int returnVal = filename2.showOpenDialog(button2);
		}
		else if (e.getSource() == button3)
		{
			
		}
		
		else
			System.out.print("I Finished ");
		
	}
	
	
	
}
	


