/**
 *
 * @author hwk
 */
public class BackgammonBoard 
{
    private int barBlackNum = 0;
    private int barWhiteNum = 0;
    private int[] pointsArray = new int[24];
    private boolean fitPoints(int point)
    {
        return 0 <= point && point <= 23;
    }
    public BackgammonBoard() 
    {
        
    }
    public int getPointCount(int point)
    {
        if(this.fitPoints(point))
            return Math.abs(this.pointsArray[point]);
        return 0;
    }
    boolean getPointBlack(int point)
    {
        if(this.fitPoints(point))
            return this.pointsArray[point] >= 0;
        return false;
    }
    void setPoint(int point, int count, boolean black)
    {
        if(count >= 0 && this.fitPoints(point))
        {
            if(black)
                this.pointsArray[point] = count;
            else
                this.pointsArray[point] = -count;
        }
        
    }
    int getBarBlackCount()
    {
        return this.barBlackNum;
    }
    int getBarWhiteCount()
    {
        return this.barWhiteNum;
    }
    void move(int fromPoint, int toPoint)
    {
        int diff = Math.abs(toPoint - fromPoint);
        int fromCount = this.getPointCount(fromPoint);
        int toCount = this.getPointCount(toPoint);
        boolean fromBlack = this.getPointBlack(fromPoint);
        boolean toBlack = this.getPointBlack(toPoint);
        if ((fromBlack && (fromPoint > toPoint) || !fromBlack && (fromPoint < toPoint)) 
            && (fromCount > 0) && (toCount == 0 || toCount == 1 || fromBlack == toBlack) 
            && (this.fitPoints(fromPoint) && this.fitPoints(toPoint)) && (1 <= diff && diff <= 6))
        {
            if (toCount == 1 && fromBlack != toBlack)
            {
                if (toBlack) 
                    this.barBlackNum++;
                else
                    this.barWhiteNum++;
                }
            else
                toCount++;
            fromCount += -1;
            toBlack = fromBlack;
            this.setPoint(fromPoint, fromCount, fromBlack);
            this.setPoint(toPoint, toCount, toBlack);
        }
        
    }

}

