
public class Numbers 
    {

    public static void main(String[] args) 
    {
        String a = args[0];
        String b = args[1];
        int c = Integer.parseInt(a);
        int d = Integer.parseInt(b);
        int sum = c+d;
        int diff = c-d;
        int product = c*d;
        int quo = c/d;
        int div = c%d;
        System.out.println(sum);
        System.out.println(diff);
        System.out.println(product);
        System.out.println(quo);
        System.out.println(div);
    }

}
