/**
 * @ (#) LopezJ004PA1.java
 * @ author Justin Lopez
 * @ version 1.00 2024/02/26
 * 
 * PROGRAM PURPOSE: Create a program that allows a user to purchase
 * one or more laptops.
 */

import java.util.Scanner; // program use class Scanner
import java.util.Calendar; // program formatting dates and time

public class LopezJ004PA1
{
  /** METHOD PURPOSE: User is prompted to choose a laptop.
    * If the choice is not in the proper range an error message is
    * displayed and the user is asked whether or not to continue. 
    * If the choice is in the proper range the name of the laptop is
    * determined and its price: then the user is prompted for 
    * the quantity of the laptop. Once the quantity is entered, 
    * the item total for that line item is calculated followed by the 
    * calculations for the subtotal. An if-else determines the printing
    * of the $ sign in the first line item. The if-else also adds the 
    * line item to the order summary which is a report of the users purchase.
    * The user is then asked whether or not to continue. If the user says yes,
    * then the whole process begins again. If the user say no then the tax
    * and total are calculated, the subtotal, tax and total lines are added 
    * to the order summary, and the order summary is printd only when there
    * is a laptop purchase. 
    */
  
  // main method beings execution 
  public static void main(String[] args){
    
    String laptop = "";
    
    double price = 0.0;
    double tax = 0.0825;
    double subtotal = 0.0;
    double lineItem = 0.0;
    double total = 0.0;
    
    int choice =0;
    int qty = 0;
    int trigger = 1;
    
    char cont = 'Y';
    
    // create a Scanner to obtian input 
    Scanner input = new Scanner(System.in);
    
    //get current date and time
    Calendar dateTime = Calendar.getInstance();
    
    String orderSummary = String.format("%n%nLAPTOP ORDER SUMMARY%n"
                                          + "%nDATE: %tD,"
                                          +"%nTime: %tr%n", dateTime, dateTime);
    
    while(Character.toUpperCase(cont) == 'Y'){
      
      
      System.out.printf("%nTOP LAPTOPS OF %tY"
                          + "%n%n1. %-23s %7s $%,9.2f"
                          + "%n2. %-23s %8s %,9.2f"
                          + "%n3. %-23s %8s %,9.2f"
                          + "%n4. %-23s %8s %,9.2f"
                          + "%n5. %-23s %8s %,9.2f"
                          + "%n%nEnter your choice: ",
                        dateTime,
                        "HP Envy 13", " ", 799.99,
                        "Asus ZenBook 13 UX333FA", " ", 849.99,
                        "Dell XPS 13", " ", 989.99,
                        "Alienware Area 51-m", " ", 1999.99,
                        "Razer Blade Stealth", " ", 1299.00);
      
      choice = input.nextInt();
      
      if(choice == 5){
        laptop = "Razor Blade Stealth";
          price = 1299;
      }
      else {
        if(choice == 4){
          laptop = "Alienware Area 51-m";
            price = 1999.99;
        }
        else {
          if(choice == 3){
            laptop = "Dell XPS 131";
              price = 989.99;
          }
          else {
            if(choice == 2){
              laptop = "Asus Zenbook 13 UX33FA";
                price = 849.99;
            }
            else{
              if(choice == 1){
                laptop = "HP Envy 13";
                  price = 799.99;
              }
              else {
                System.out.printf("%nInvalid choice! Try again%n"); 
                                    
                                    }//END IfElse
            }//END IfElse
          } //END IfElse
        }//END IfElse
      } //END IfElse

 if(choice > 0)
 {
   if(choice < 6)
   {
     
     System.out.printf("%nEnter the quantity for %s:  ", laptop);
     
     qty = input.nextInt();
     
     lineItem = qty * price;
     
     subtotal = subtotal + lineItem;
   
 if (trigger ==1){
   orderSummary += String.format("%n%,-9d %-30s %8s $%,17.2f",
                                 qty, laptop, " ", lineItem);
   trigger = 0;
 }//END if for $ sign 
   }
 }
 else
 {
   orderSummary += String.format("%n%, -9d %-30s %9s %,17.2f",
                                 qty, laptop, " ", lineItem);
 }//END else for no $ sign
 input.nextLine();
 
 System.out.printf("%nEnter 'Y' to add another laptop to you purchase or 'N' to exit; ");
 
 cont = input.nextLine().charAt(0);
   
   }//END while
if (choice > 0)
{
  if(choice < 6)
  {
    tax = subtotal * .0825;
    
    total = subtotal + tax;
    
    orderSummary += String.format("%n%n%34s Subtotal %6s %,17.2f"
                                    + "%n%31s Tax @ 8.25%% %6s %,17.2f"
                                    + "%n%n%37s TOTAL %5s $%,17.2f%n",
                                  " ", " ", subtotal,
                                  " ", " ", tax,
                                  " ", " ", total);
    
    System.out.printf("%s", orderSummary);
    
  }// END if valid choice range ends print order summary 
}//END if valid choice range begins 

}// END main()
}//END CLASS LopezJ004PA1