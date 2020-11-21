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
   
   List <Albums> list;          
   //Albums album = new Albums();  
   
   
  
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
    * @param The name of the file that is to be read
    * @return Whether the file has been read properly or not.
    */
    
   public boolean readAlbums(String filename)
   {
      boolean flag = false;
      try
      {
         
      
         Scanner in = new Scanner(new File(filename));
         
         //in.nextLine();                     //getting past the list that says name, number and year from the excel file
         int i = 0;
         while (in.hasNextLine())
         {     
               in.useDelimiter(",");
               Albums album = new Albums();
               album.setPosition(in.next());
               album.setYear(in.next());
               album.setName(in.next());
               album.setArtist(in.next());
               list.add(i, album);
               i++;    
         }

         return true;
      
      }//end oftry 
        
         
      
      
      catch(FileNotFoundException e)
      {
         System.out.println("File not found");
         return false;
      }
      
      
      /*catch(NoSuchElementException e)
      {
             //displaying the error message if the input isnt available based on the  method that has been called
         System.out.print("Insufficient data.\n\n");
      }*/
   
      }//boolean method
   
   
   /**
    * The count method returns the total number of albums in the file
    * @return The total number of albums in the file that have been added to the list.
    */
   public int count()
   {
      return list.size();
      
   }
   
   /**
    * The topAlbums method returns the top n number of albums as specified
    * in the parameter when the method is called
    * @param 
    * @return The formatted output of the top n albums from the file.
    */
   public String topAlbums (int n)
   {     
      String result = "";
      for(int i = 0; i <n ; i++)
      {
         result += list.get(i).formattedOutput() + "/n";
      }
        
      return result;
   }
   
   
  /**
    * The topAlbums method returns the all tha albums that have been added to the list
    * @return The formatted output of all the albums from the file.
    */ 
    
   public String topAlbums()
   {
      String result = "";
      for(int i = 0; i < list.size(); i ++)
      {
         result += list.get(i).formattedOutput() + "\n";
      }
        
      return result;
   }
   
    /**
    * The display method returns the all tha albums
    * that were published in the decade which is the argument of the method
    * @param decade The decade in which the returned albums were published
    * @return The formatted output of all the albums published in the decade.
    */ 
    
   public int display(int decade)
   {  int numberYear = 0;
      for(int i = 0; i < count(); i++)
      {
         int year = Integer.parseInt(list.get(i).getYear());
         if ((Math.floor(year/100)) == (Math.floor(decade/100)))
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
      int artistNumber = 4;
      for (int i = 0; i < count(); i++)
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
      for(int i = 0; i<count(); i++)
      {
         String tempArt = list.get(i).getArtist();
         int tempCount = 0;
         for(int k = 0; k<count(); k++)
         {
            if (list.get(k).getArtist().equals(tempArt))
            {
               tempCount++;
                
               if(tempCount > count)
               {
                  top = tempArt;
                  count = tempCount;
               }
            }
         }
        
       
      } //main for
      
      return top;
      
      
   }
   
}
   
   
