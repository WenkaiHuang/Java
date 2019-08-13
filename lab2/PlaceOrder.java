import java.util.Scanner;
public class PlaceOrder {

    
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Quantity: ");
        int q = keyboard.nextInt();
        
        keyboard.nextLine();
        System.out.print("Description: ");
        String des = keyboard.nextLine();
        String d =  des.toUpperCase();
        
        System.out.print("Unit price: ");
        double t = keyboard.nextDouble();
        System.out.println("Order for "+q+" "+d);
        System.out.printf("Total price %14.2f%n", q*t);
    }
    
}
