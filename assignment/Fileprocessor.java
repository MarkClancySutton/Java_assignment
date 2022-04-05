package assignment;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class Fileprocessor {
	public  void readwords(String filename, int n) {
		
		
		HashMap<String,Integer> Wordlist = new HashMap<String, Integer>();
		 ArrayList<String> wordlist = new ArrayList<String>();
		 ArrayList<String> stoplist = new ArrayList<String>();
		 int counterarr[];
		 
		 
		 int j =0;
		 
		 
		
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
		        counterarr =new int[wordlist.size()];
		        
		       
		        
	            
	            
		        
	            for(String key: unique) 
	            {   
	            	Wordlist.put(key,Collections.frequency(wordlist, key));
			        counterarr[j] = Collections.frequency(wordlist, key);
			        j++;
			       
			        
			    }  
	           
	            
	            	// got from interweb at https://stackoverflow.com/questions/43922882/how-to-print-hashmap-elements-from-max-to-min
	            	Wordlist.entrySet().stream()
	            	.sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(n)
	            	.forEach(x -> 
	            	{
	            		System.out.println(x.getKey() + " Count is "+ x.getValue());
	            		
	            		
	            	});
	            	
	            
	            
	            
	            
	
		    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		   
		   
		    System.out.println("\n");
		    
		    
		   
		    
		    
	}
	
	
	
	
	
	
}
