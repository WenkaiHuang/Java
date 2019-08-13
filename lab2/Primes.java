public class Primes {

    
    public static void main(String[] args) 
    {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        if (a<2)
            a = 2;
        int i;
        int j;
        
        for ( i = a; i <= b; i++) 
        {
            double c = Math.sqrt(i);
            for ( j = 2; j <= c; j++) 
            {
                if (i % j == 0) {
                    break;
                }
            }
            if (j>c) 
            {
                System.out.println(i);
            }
        }
        
      
    }
    
}
