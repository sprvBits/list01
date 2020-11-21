//importing the required pachakes and classes
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;


/**
 * A class that holds all the list of the albums.
 */
 
public class AlbumList extends Albums
{
  //creating an object of List interface of type Albums
   private List <Albums> list;          
  
   /**
    * Initializes the arraylist for the list of albums created.
    */
    
   public AlbumList()
   {
      list = new ArrayList<Albums>();
   }
   
   /**
    * The readAlbums method adds the albums in the file to the list and
    * lets us know if there are any errors while reading the file.
    * @param filename The name of the file that is to be read
    * @return Whether the file has been read properly or not.
    */
    
   public boolean readAlbums(String filename)
   {
      try
      {
         
         Scanner in = new Scanner(new File(filename));  //creating a scanner object to read through the given file used as parameter
         
         in.nextLine();
                                            //getting past the list that says name, number and year from the excel file
         int k = 0;
         while (in.hasNextLine())           //continuing to add elements of the file to the list as long as there is next line of information
         {     
            Scanner lineReader = new Scanner(in.nextLine());  //creating a scanner object to read the elements of each line in the file
            
            lineReader.useDelimiter(",");                     //using delimeter to read upto a certain point in the line
            
            Albums album = new Albums();                      //creating album object to store the information of each album
            
            //setting the value of attributes of the album using mutators
            album.setPosition(lineReader.next());         
            album.setYear(lineReader.next());
            album.setName(lineReader.next());
            album.setArtist(lineReader.next());
            
            //adding the created album to the list
            list.add(k, album);
            
            k++;
                          
         }
      
         return true;
      
      }//end of try 
        
      
      catch(FileNotFoundException e)
      {
         System.out.println("File not found");
         return false;
      }
      
      catch(NoSuchElementException e)
      {
         System.out.print("Insufficient data.\n\n");
         return false;
      }
   
   }//boolean method
   
   
   /**
    * The total method returns the total number of albums in the file.
    * @return The total number of albums in the file that have been added to the list.
    */
   public int total()
   {
      return list.size();
      
   }
   
   /**
    * The output method returns the formatted output of the number
    * of albums it takes as an argument
    * @param number The number of albums too be displayed.
    * @return The formatted output of n albums from the file.
    */
   private String output(int number)
   {
      String result = "";
      for(int i = 0; i < n ; i ++)
      {
         result += list.get(i).formattedOutput() + "\n";         
      }
      
      return result;
   }
   
   /**
    * The topAlbums method returns the top n number of albums as specified
    * in the parameter when the method is called
    * @param n The rank of top albums.
    * @return The formatted output of the top n albums from the file.
    */
   public String topAlbums (int n)
   {  
      String result = "";
      
      if(n < total())
      {
         return output(n);
      }
      
      else
      {
         return output(total());
         
      }
   }
   
   
  /**
    * The topAlbums method returns the all tha albums that have been added to the list
    * @return The formatted output of all the albums from the file.
    */ 
    
   public String topAlbums()
   {
      return output(total());
   }
   
    /**
    * The display method returns the all tha albums
    * that were published in the decade which is the argument of the method.
    * @param decade The decade in which the returned albums were published
    * @return The formatted output of all the albums published in the decade.
    */ 
    
   public int display(int decade)
   {  int numberYear = 0;
      for(int i = 0; i < total(); i++)
      {
         int year = Integer.parseInt(list.get(i).getYear());            //casting the year read from the file which is a String to integer
         if ((Math.floor(year/10)) == (Math.floor(decade/10)))
         {
            numberYear++;
         }
      }
      
      return numberYear++;
   }
   
   
   /**
    * The display method returns the all tha albums
    * that were published by the artist which is the argument of the method
    * @param artist The artist of the albums returned as the output.
    * @return The formatted output of all the albums of the given artist.
    */ 
    
   public int display(String artist)
   {
      int artistNumber = 0;
      for (int i = 0; i < total(); i++)
      {
         if (list.get(i).getArtist().equals(artist))
         {
            artistNumber++;
         }
      }
      
      return artistNumber++;
   
   }
   
   /**
    * The topArtist method returns name of the artist with the largest
    * number of the albums in the list
    * @return The name of the artist with the most albums in the list.
    */ 
    
   public String topArtist()
   {
      String top = "";
      int count = 0;
      for(int i = 0; i<total(); i++)
      {
         String artist = list.get(i).getArtist();
         int tempCount = 0;
         for(int k = 0; k < total(); k++)
         {
            if (list.get(k).getArtist().equals(artist))
            {
               tempCount++;                              
                
               if(tempCount > count)
               {
                  top = artist;
                  count = tempCount;
               }
            }
         }
        
       
      } //main for
      
      return top;
      
      
   }
   
}
   
   
