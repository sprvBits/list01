/**
 * A subclass of Item class that holds the information about the electronic item like its weight and then calculates the cost.
 */

public class ElectronicsItem extends Item
{
   private double weight;                             //weight of the electronic item
   public static final double SHIPPING_RATE = 1.50;   //the shipping rate per pound of the item
   
   /**
    * Initializes the value of weight of the electronic item
    * and passes the argument of the name and price to the superclass.
    * @param n The name of the item.
    * @param p The base price of the item.
    * @param w The weight of the electronic item.
    */
   
   public ElectronicsItem(String n, double p, double w)
   {
      super(n,p);                      //passing the value of name and price of the item to the superclass Item.
      weight = w;
   }
   
   /**
    * The setWeight method sets the weight of the electronic item.
    * @param w The weight of the electronic item.
    */
    
   public void setWeight(double w)
   {
      weight = w;
   }
   
   /**
    * The getWeight method returns the weight of the electronic item.
    * @param w The weight of the electronic item.
    */
    
   public double getWeight()
   {
      return weight;
   }
   
   /**
    * The calculateCost method returns the total cost
    * after adding the tax and shipping cost based on weight of the item.
    * @return The total cost after adding the taxes and shipping charge.
    */
    
   public double calculateCost()
   {
      return getPrice() + Item.TAX_RATE*getPrice() + (SHIPPING_RATE*weight);
   }
   
   /**
    * The toString method returns the information about the electronic item.
    * @return The formatted output regarding the electronic item.
   */
   public String toString()
   {
      String outline1= "\n***************************************************************************************";
      String header = String.format("\n| %-31s | %-16s| %-7s | %-7s | %-11s |", "Name of the Item", "Weight (in lbs)", "Price", "Tax", "Total Cost");
      String separator = "\n---------------------------------------------------------------------------------------";
      String information = String.format("\n| %-31s | %-16.2f| $%-7.2f| $%-7.2f| $%-11.2f|", getName(), getWeight(), getPrice(), Item.TAX_RATE*getPrice(), calculateCost());
      String outline2= "\n***************************************************************************************";

      return outline1 + header + separator + information + outline2;
    }
}