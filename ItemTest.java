 /** 
   Program to test the basic functionality of classes in the Item hierarchy
 */
  
 public class ItemTest
 {
   /**
      Accepts and displays the attributes of an Item object.
      @param item the object whose attributes are displayed.
   */
    /*public static void showCommonAttributes (Item item)
    {
         System.out.printf("Item name: %s, price: $%7.2f, total cost: $%7.2f\n", item.getName(), item.getPrice(), item.calculateCost()); 
    }*/
 
    /** 
       main method to declare and test objects in the Item hierarchy
    */
	 public static void main(String[] args) 
    {
        Item[] pa = new Item[6];
     
        EBook myBook = new EBook("Data Structures in Python", 30.00, "Miller, J.", 925);
        ElectronicsItem eItem = new ElectronicsItem("Seagate Hard Drive", 100.00, 3.5);
        eItem.setPrice(160);
        eItem.setName("AAAA");
        //showCommonAttributes(myBook);
        System.out.printf("Author:  %s, Number of pages: %d\n\n", myBook.getAuthor(), myBook.getPages());
        //showCommonAttributes(eItem);
        System.out.printf("Weight:  %4.1f pounds\n\n", eItem.getWeight());
        
        pa[0] = myBook;
        pa[1] = eItem;
        pa[2] = new EBook("The Beatles 100 Greatest Songs", 40.00, "Martin, G.", 360);
        pa[3] = new ElectronicsItem("ABC SmartWatch", 60.00, 0.5);
         
        // Compute total cost
        double totalSalePrice = 0;
        for (int i = 0; i < 4; i++)
		  {
            totalSalePrice += pa[i].calculateCost();
            System.out.printf ("%s \n", pa[i]);
        }
        System.out.printf("\nTotal Cost    = $%7.2f \n", totalSalePrice);
        System.out.println("****************************************************************".length());
    }
}