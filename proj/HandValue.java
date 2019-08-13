/** This class provides one main method to count the total score of 5 cards
 * where the fifth one is the start card and five methods to count
 * "One for his nob", "Flushes", "Paris", "Fifteens", "Runs" respectively.
 *
 * @author Wenkai Huang(Login ID: WHHUANG), Thomas Christy
 */
import java.util.Arrays;
public class HandValue
{
    //Declare the varblie count which means the total points of five cards.
    private static int count = 0;
    /**
     * This main method aims to count the total value 5 card
     * and the fifth card is the start card.
     * @param args the command line arguments with two-character string.
     * The first being an upper-case A for Ace, K for King, Q for Queen,
     * J for Jack, T for Ten, or digit between 2 and 9 for ranks 2-9.
     * The second character should be a C for Clubs, D for Diamonds,
     * H for Hearts, or S for Spades.
     */
    public static void main(String[] args)
    {
        
        //Get the first character from the original two-character args
        //and put it into a new array.
        String[] argsArray = new String[args.length];
        for (int i = 0; i < args.length; i++)
            argsArray[i] = String.valueOf(args[i].charAt(0));
        //To count the situation in "One for his nob".
        Nob(args);
        //To count the situation in "Flushes".
        Flushes(args);
        //To count the situation in "Paris".
        Paris(argsArray);
        //To count the situation in "Fifteens".
        Fifteens(argsArray);
        //To count the situation in "Runs".
        Runs(argsArray);
        //Print out the total count.
        System.out.println(count);   
    }


    /**
     * The method to count "One for his nob".
     * @param argsNob
     */
    public static void Nob(String[] argsNob)
    {
        for (int i = 0; i < 4; i++)
        {
            //If the hand contains the jack and the suit is the
            //same as the start card, it counts 1 point.
            if (argsNob[i].charAt(0) == 'J'
                    && argsNob[4].charAt(1) == argsNob[i].charAt(1))
                count++;
        }
    }
    
    /**
     * The method to count "Flushes".
     * @param argsFlushes
     */
    public static void Flushes(String[] argsFlushes)
    {
        //If a hand is the same suit, it counts 4 points.
        if (argsFlushes[0].charAt(1) == argsFlushes[1].charAt(1)
                && argsFlushes[0].charAt(1) == argsFlushes[2].charAt(1)
                && argsFlushes[0].charAt(1) == argsFlushes[3].charAt(1))
        {
            count += 4;
            //If the star card also in the same suit, there is another 1 point.
            if (argsFlushes[0].charAt(1) == argsFlushes[4].charAt(1))
                count++;
        }
    }
    
    /**
     * The method to count "Paris".
     * @param argsParis
     */
    public static void Paris(String[] argsParis)
    {
        //Use the Combinations method and get a fresh one.
        Combinations combParis = new Combinations();
        //All combinations of 5 cards.
        String[][] stringParis = combParis.combinations(argsParis);
        for (String[] lineParis : stringParis)
        {
            //Find the combinations which length is 2.
            if (lineParis.length == 2)
            {
                //If the first value equals to the sencond one, 
                //it counts 2 points.
                if (lineParis[0].equals(lineParis[1]))
                    count += 2;
            }
        }
    }

    /**
     * The method to count "Fifteens".
     * @param argsFifteens
     */
    public static void Fifteens(String[] argsFifteens)
    {
        //It is the value of card face.
        int value;
        //The sum value in each combination.
        int sumLine;
        //Use the Combinations method and get a fresh one.
        Combinations combFifteens = new Combinations();
        //All combinations of 5 cards.
        String[][] stringFifteens = combFifteens.combinations(argsFifteens);
        for (String[] lineFifteens : stringFifteens)
        {
            //Each time initialize the sum value of each combination.
            sumLine = 0;
            //At least the sum of 2 cards equals 15.
            if (lineFifteens.length > 1)
            {
                for (String strFifteens : lineFifteens)
                {
                    //Get the face value of Ace, Ten, Jack, Queen and King.
                    if (strFifteens.equals("A"))
                        strFifteens = "1";
                    if (strFifteens.equals("T") || strFifteens.equals("J") 
                        || strFifteens.equals("Q") || strFifteens.equals("K"))
                        strFifteens = "10";
                    //Change the string into int.
                    value = Integer.parseInt(strFifteens);
                    //Get the sum value of each combination.
                    sumLine += value;
                }
            }
            //Each time, if the sum value of each combination equals to 15,
            //it counts 2 points.
            if (sumLine == 15)
                count += 2;
        }
    }

    /**
     * The method to count "Runs".
     * @param argsRuns
     */
    public static void Runs(String[] argsRuns)
    {
        //The index of card in each combination.
        int location;
        //The length of longest run in the all combinations
        //which is also the counted points and the inital value is 0.
        int maxLength = 0;
        //The number of multi-way ties for longest run
        //and the inital value is 1.
        int times = 1;
        //Use the Combinations method and get a fresh one.
        Combinations combRuns = new Combinations();
        //All combinations of 5 cards.
        String[][] stringRuns = combRuns.combinations(argsRuns);
        //Initalize a 2 dimensional arrays and the length of each dimension
        //is the same as the stringRuns.
        int[][] argsInt = new int[stringRuns.length][];
        for (int i = 0; i < stringRuns.length; i++)
        { argsInt[i] = new int[stringRuns[i].length];}
        //Get the order of each card.
        for (int p = 0; p < stringRuns.length; p++)
        {
            for (int q = 0; q < stringRuns[p].length; q++)
            {
                //Change the card face into numbers.
                if (stringRuns[p][q].equals("A"))
                    stringRuns[p][q] = "1";
                if (stringRuns[p][q].equals("T"))
                    stringRuns[p][q] = "10";
                if (stringRuns[p][q].equals("J"))
                    stringRuns[p][q] = "11";
                if (stringRuns[p][q].equals("Q"))
                    stringRuns[p][q] = "12";
                if (stringRuns[p][q].equals("K"))
                    stringRuns[p][q] = "13";
                //Change the string into int.
                argsInt[p][q] = Integer.parseInt(stringRuns[p][q]);
            }
            //Sort each combination from small to large.
            Arrays.sort(argsInt[p]);
            //Each time, initalize it to 0.
            location = 0;
            if (argsInt[p].length >= 3)
            {
                //In each combination, to judge the order of each next card
                //minus 1 equals the order of the card before.
                for (int j = 0; j < argsInt[p].length-1; j++)
                    if(argsInt[p][location] == argsInt[p][location+1] - 1)
                        location++;
                //To judge whether it is a run.
                if(location == argsInt[p].length-1)
                {
                    //Record the times of the same length of the run.
                    if (maxLength == argsInt[p].length)
                        times++;
                    //Find the longest length of run in all combinations
                    //and if there is a longer one existing,
                    //initialize the times to 1.
                    else if (argsInt[p].length > maxLength)
                    {
                        times = 1;
                        maxLength = argsInt[p].length;
                    }
                }
            }
        }
        //Add the longest length of "run" multiply
		//the number of multi-way ties to the total points.
        count += maxLength * times;
    }
}
