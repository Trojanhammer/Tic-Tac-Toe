import java.util.Scanner;
public class TicTacToe1 {
    public static void main(String[] args)
    {
      
       Scanner input = new Scanner(System.in);
       boolean winner = false;
       char player1 = 'X';
       char player2 = 'Y';
       char turn =player1;
       int number=0;
       boolean [] checkindex={false,false,false,false,false,false,false,false,false};
       
       char[] positions = { ' ',' ',' ',
                            ' ',' ',' ',
                            ' ',' ',' '};
       showboard(positions);
       while(!winner && number<9 )  //loop until there is winner and all box is fulfill
       {
        System.out.println("Player 1 (X)\nPlayer 2 (O)");
        if(turn == player1)
        System.out.print("Player 1 ,Enter coordinate : ");
        else
        System.out.print("Player 2 ,Enter coordinate :"); 
        int index=input.nextInt();
        while(index<=0 || index>9)  //loop until player gives valid coordinate
        {
        System.out.print("Enter coordinate again : ");
        index=input.nextInt();
        }
        while(checkindex[index-1]==true) //loop until player gives available coordinates.
        {
            System.out.print("Dont enter the same coordinate.Try again : ");
            index=input.nextInt();
        }
        checkindex[index-1]=true;  
        positions[index-1]=turn; //print X or Y to the coordinate desired.
        winner=checkwin(positions,turn,player1,player2);
        showboard(positions);
        if(turn == player1)
            turn =player2;
        else
            turn =player1;
        number++;
       }
       if(number==9 && !winner)
            System.out.println("DRAW !!");
    }
    public static void showboard(char[] positions)
    {
      
        System.out.println("-------------");
        for(int x=0;x<3;x++)
        {
        int rows=x*3;
        System.out.println("| " + positions[rows] + " | " + positions[rows+1] +" | "  + positions[rows+2] + " | ");
        System.out.println("-------------");
        }
    }
    public static boolean checkwin(char [] positions,char turn,char player1,char player2)
    {
        boolean winner =false;
        for(int i =0;i<3;i++)
        {
            int row = i*3;
            if(positions[row] == turn && positions[row+1] == turn && positions[row+2] == turn)
            {
              int win;
              if(turn == player1)
                win=1;
              else
                win = 2;
            System.out.println("Player " + win + " has won");
            winner=true;
            }   
        }
        for(int i =0;i<3;i++)
        {
        if(positions[i] == turn && positions[i+3]== turn && positions[i+6]==turn)
        {
           int win;
              if(turn == player1)
                win=1;
              else
                win = 2;
            System.out.println("Player " + win + " has won");
            winner=true; 
        }
        }
        if(positions[0] == turn && positions[4]== turn && positions[8]==turn)
        {
           int win;
              if(turn == player1)
                win=1;
              else
                win = 2;
            System.out.println("Player " + win + " has won");
            winner=true; 
        }
        else if(positions[2] == turn && positions[4]== turn && positions[6]==turn)
        {
           int win;
              if(turn == player1)
                win=1;
              else
                win = 2;
            System.out.println("Player " + win + " has won");
            winner=true; 
        }
        return winner;
    }
}