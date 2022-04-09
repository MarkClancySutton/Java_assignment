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
		        while ((line1 = b.readLine()) != null)
		        {
		            for (String element1 : line1.toLowerCase().split(" ")) {
		            	stoplist.add(element1);
		            }
		                	
		                
		        }
		        while ((line = r.readLine()) != null) {
		            for (String element : line.toLowerCase().split(" ")) {
		            	if(stoplist.contains(element))
		            	{
		            		
		            	}	
		            	else 
		            	{
		            		wordlist.add(element);
		            	}
		                
		      
		            }
		            
		        }  
		 
		            
		            
		        
		        Set<String> unique = new HashSet<String>(wordlist);
		       
		        
	            for(String key: unique) 
	            {   
	            	Wordlist.put(key,Collections.frequency(wordlist, key));
			        
			       
			        
			    }  
	           
	            
	            
	            //check to see if the words are the sme or not
	            for (String key: Wordlist.keySet())
	            {
	                if (tempWordlist.containsKey(key)) 
	            	{ 
	            		
	            		// Okay, there's a key 
	            		if (tempWordlist.containsValue(Wordlist.get(key))) 
		            	{ 
		            	       // Okay, there's a value 
		            			correctcounter++;
		            			
		            	} 
	            	} 
	            	
	            }
	            
	            //creates and prints out the probability of being the same file
	          
	            //Stores the first files values and key into a new hashmap to be compared later 	
	            if(j == 0)
	     		{
	              
			    	tempWordlist.putAll(Wordlist);
	 			    j =1;
	     		}
	            	
	           
	           
			       
			       
			        
			    
 
	
		    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		 
		   
		    
		    
		   
		   
		    
		    
	}
	public void printhashmap(int n) {
		
	
		Wordlist.entrySet().stream()
    	.sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(n)
    	.forEach(x -> 
    	{
    		System.out.println(x.getKey() + " Count is "+ x.getValue());
    		
    		
    	});
		System.out.println("\n");
	}
}
