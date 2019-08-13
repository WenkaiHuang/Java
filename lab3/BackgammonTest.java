/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hwk
 */
public class BackgammonTest {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
            /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

        /*****bug1*****/
        BackgammonBoard Board1 = new BackgammonBoard();
        Board1.setPoint(0,1,true);
        Board1.setPoint(7,1,true);
        Board1.move(7,0);
        int a1 = Board1.getPointCount(0);

        /*****bug2*****/
        BackgammonBoard Board2 = new BackgammonBoard();
        Board2.setPoint(3,0,true);
        Board2.setPoint(6,1,true);
        Board2.move(3,6);
        int a2 = Board2.getPointCount(6);
        
        /*****bug3*****/
        BackgammonBoard Board3 = new BackgammonBoard();
        Board3.setPoint(0,1,false);
        Board3.setPoint(6,1,false);
        Board3.move(6,0);
        int a3 = Board3.getPointCount(0);
    
        /*****bug4*****/
        BackgammonBoard Board4 = new BackgammonBoard();
        Board4.setPoint(0,2,false);
        Board4.setPoint(2,2,true);
        Board4.move(0,2);
        int a4 = Board4.getPointCount(2);
        
        /*****bug5*****/
        BackgammonBoard Board5 = new BackgammonBoard();
        Board5.setPoint(0,1,false);
        Board5.setPoint(3,3,true);
        Board5.move(3,0);
        boolean a5 = Board5.getPointBlack(0);
        
         /*****bug6*****/
        BackgammonBoard Board6 = new BackgammonBoard();
        Board6.setPoint(0,2,true);
        Board6.setPoint(2,2,true);
        Board6.move(2,0);
        int a6 = Board6.getPointCount(2);

         /*****bug7*****/
        BackgammonBoard Board7 = new BackgammonBoard();
        Board7.setPoint(0,2,true);
        Board7.setPoint(2,2,true);
        Board7.move(2,0);
        int a7 = Board7.getPointCount(0);

         /*****bug8*****/
        BackgammonBoard Board8 = new BackgammonBoard();
        Board8.setPoint(23,2,false);
        Board8.setPoint(25,1,true);
        Board8.move(23,25);
        int a8 = Board8.getPointCount(23);

         /*****bug9*****/
        BackgammonBoard Board9 = new BackgammonBoard();
        Board9.setPoint(0,1,false);
        Board9.setPoint(2,1,true);
        Board9.move(0,2);
        int a9 = Board9.getBarBlackCount();


         /*****bug10*****/
        BackgammonBoard Board10 = new BackgammonBoard();
        Board10.setPoint(0,1,false);
        Board10.setPoint(2,1,true);
        Board10.move(2,0);
        int a10 = Board10.getBarWhiteCount();
 
        if((a1==1)&&(a2==1)&&(a3==1)&&(a4==2)&&(a5)&&(a6==1)&&(a7==3)&&(a8==2)&&(a9==1)&&(a10==1))
            System.out.println("CORRECT");
        else 
            System.out.println("BUG");
        
    }
    
}
