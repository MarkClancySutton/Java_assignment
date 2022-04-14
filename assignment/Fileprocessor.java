package assignment;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;

import java.util.Set;

import javax.swing.JFileChooser;



public class Fileprocessor  {
	 
	//declare attributes
	static int j=0;
	static HashMap<String,Integer> tempWordlist = new HashMap<String, Integer>();
	HashMap<String,Integer> Wordlist = new HashMap<String, Integer>(); 
	ArrayList<String> wordlist = new ArrayList<String>();
	static ArrayList<String> stoplist = new ArrayList<String>();
	static int correctcounter=0;
	final JFileChooser filename1 = new JFileChooser();
	final JFileChooser filename2 = new JFileChooser();
	double percentage = 0;
	
	public  void readwords(String filename, int n) 
	{
		
		        
		    try (LineNumberReader r = new LineNumberReader(new FileReader(filename))) {
		        String line;
		        LineNumberReader b = new LineNumberReader(new FileReader("stop_words.txt"));
		        String line1;
		        //read the stopwords.txt file line by line and add them to a array list
		        while ((line1 = b.readLine()) != null)
		        {
		            for (String element1 : line1.toLowerCase().split(" ")) {
		            	stoplist.add(element1);
		            }//end for
		                	
		                
		        }//end while
		        
		        //Read the file word by word and line by line 
		        //Then only adding the word to the arraylist if it isn't inside the stopwords list
		       
		        while ((line = r.readLine()) != null) {
		            for (String element : line.toLowerCase().split(" ")) {
		            	if(stoplist.contains(element))
		            	{
		            		
		            	}//end if	
		            	else 
		            	{
		            		wordlist.add(element);
		            	}//end else
		                
		      
		            }//end for
		            
		        } //end while 
		 
		            
		            
		        //Using a newly made hashset and putting the values scanned from the file into a hashset
		        //Which is used to eliminate duplicates
		        Set<String> unique = new HashSet<String>(wordlist);
		       
		        //Scans through the array list of words and for every word in the hashset 
		        //Checks how many times it appears and puts both the word and the fequency of the word into a Hashmap
	            for(String key: unique) 
	            {   
	            	Wordlist.put(key,Collections.frequency(wordlist, key));
			        
			       
			        
			    }  //end for
	           
	            
	            
	            //check to see if the words and keys are the same or not
	            //and count the amount of times this happens
	            for (String key: Wordlist.keySet())
	            {
	                if (tempWordlist.containsKey(key)) 
	            	{ 
	            		
	            		// Okay, there's a key 
	            		if (tempWordlist.containsValue(Wordlist.get(key))) 
		            	{ 
		            	       // Okay, there's a value 
		            			correctcounter++;
		            			
		            	} //end if
	            	} //end if
	            	
	            }//end for
	            
	            //creates and prints out the probability of being the same file
	          
	            //Stores the first files values and key into a new hashmap to be compared later 	
	            if(j == 0)
	     		{
	              
			    	tempWordlist.putAll(Wordlist);
	 			    j =1;
	     		}
	       
		    }//end try 
		    catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end catch
		   	    
	}
	//Method used to print the hashmap with the word and the count displayed nicely
	public void printhashmap(int n) {
		
		//got form internet at https://stackoverflow.com/questions/43922882/how-to-print-hashmap-elements-from-max-to-min
		Wordlist.entrySet().stream()
    	.sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(n)
    	.forEach(x -> 
    	{
    		System.out.println(x.getKey() + " Count is "+ x.getValue());
    		
    		
    	});
		System.out.println("\n");
	}
}
