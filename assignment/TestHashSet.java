package assignment;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class TestHashSet {
	public  void readwords(String filename, int n) {
		
		 HashMap<String, Integer> Wordlist = new HashMap<String, Integer>();
		 ArrayList<String> wordlist = new ArrayList<String>();
		 int counterarr[];
		 
		 ArrayList<String> orderedlist = new ArrayList<String>();
		 int j =0;
		 
		 
		
		    try (LineNumberReader r = new LineNumberReader(new FileReader(filename))) {
		        String line;
				
		        
		        while ((line = r.readLine()) != null) {
		            for (String element : line.toLowerCase().split(" ")) {
		            	wordlist.add(element);
		                	
		                
		            }
		            
		            
		            
		        }
		        Set<String> unique = new HashSet<String>(wordlist);
		        counterarr =new int[wordlist.size()];
		      
		       
		        
	            
	            
	            for(String key: unique) 
	            {   
	            	Wordlist.put(key, Collections.frequency(wordlist, key));
			        counterarr[j] = Collections.frequency(wordlist, key);
			        j++;
	                
	                
	                
	               
	                
	               
			    }  
	            //Sorts the counter array into desc order
	            int temp;
	            for (int i = 1; i < counterarr.length; i++) 
	            {
	            	for (int j1 = i; j1 > 0; j1--) 
	            	{
	            		if (counterarr[j1] > counterarr [j1 - 1]) 
	            		{
	            			temp = counterarr[j1];
	            			counterarr[j1] = counterarr[j1 - 1];
	            			counterarr[j1 - 1] = temp;
	            		}
	            	}
	            }
	            for (String i : Wordlist.keySet()) 
	            {
	                System.out.println("key: " + i + " value: " + Wordlist.get(i));
	                
	            }
	           
	            
	            
	            
		        
		    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		   
		   
		    System.out.println("\n");
		   
		    
		    
	}
	

	
	
	
	
}
