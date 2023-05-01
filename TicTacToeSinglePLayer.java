import java.io.*;
public class TicTacToeSinglePLayer extends TTTAI
{
    char play[] = new char[9];
    void arr()
    {
        //displaing number in the array
        for(int i=0;i<9;i++)
            play[i] = (char)(i+49);
    }
    void fill()
    { 
        //fill the array with blank space
        for(int i=0;i<9;i++)
            play[i] = ' ';
    }
    int input(char c) throws IOException
    {
        //input for single player
        DataInputStream dis = new DataInputStream(System.in);
        System.out.println("PLAYER ENTER:-");
        int n = Integer.parseInt(dis.readLine());
        if(play[n-1]==' ')
        {
            play[n-1] = c;
            return (n-1);
        }
        else
        {
            System.out.println("WRONG INPUT.INPUT COINCIDING, INPUT AGAIN");
            return 10;
        }
    }
    void input(char c,int f,int x,int n1)
    {
        //calling TTTAI
        int n = input(play,f,x,n1);
        play[n] = c;
    }
    char check()
    {
        int i = 0;
        //check for vertical column
        while(i<3)
        {
            if(play[i]==play[i+3]&&play[i]==play[i+6]&&play[i]!=' ')
                return play[i];
            i++;
        }
        i = 0;
        //check for horizontal row
        while(i<7)
        {
            if(play[i]==play[i+1]&&play[i]==play[i+2]&&play[i]!=' ')
                return play[i];
            i+=3;
        }
        i = 0;
        //checks for diagonal checking
        int d = 4;
        while(d!=1)
        {
            if(play[i]==play[i+d]&&play[i]==play[i+2*d])
                    return play[i];
            i+=2;
            d/=2;
        }
        return 'n';
    }
    void display()
    {
        //display the tic tac toe background
        int a=2,b=4,k=0;
        for(int j=1;j<=11;j++)
        {
            System.out.print("\t\t\t\t\t\t\t");
            if(j%4!=0)
            {
                for(int i=1;i<=23;i++)
                {
                    if(i==b&&j==a)
                    {
                        System.out.print(play[k]);
                        b+=8;
                        k++;
                    }
                    else if(i%8==0)
                        System.out.print("|");
                    else
                        System.out.print(" ");
                }
            }
            else
            {
                for(int i=1;i<=23;i++)
                    System.out.print("-");
            }
            b=4; 
            a += (j==a)?4:0;
            System.out.println();
        }
    }
    public static void main(String args[]) throws IOException
    {
        DataInputStream dis = new DataInputStream(System.in);
        System.out.println("\t\t\t\t\t\t\t  WELCOME TO TIC TAC TOE\n\n"); 
        int c = 5;
        while(c==5)
        {
            String result="GAME ON";
            TicTacToeSinglePLayer ob = new TicTacToeSinglePLayer();
            ob.arr();
            System.out.println("Press the Number to Put the Symbol on the Spot");
            ob.display();
            ob.fill();
            int i = 0;
            System.out.println("Enter 1 for Easy Mode,2 for Medium mode,3 for Hard Mode and 4 for Impossible Mode");
            int n1 = Integer.parseInt(dis.readLine());
            int r = (int)(Math.random()*(2)+1);   
            if(r==1)
            {
                System.out.println("Computer's First Move");
                int n = -1;
                while(i<9)
                {
                    if(i%2==0)
                    {
                        System.out.println();
                        System.out.println("MOVE BY COMPUTER");
                        System.out.println();
                        ob.input('X',r,n,n1);
                        ob.display();
                        i++;
                    }
                    else
                    {
                        n = ob.input('O');
                        ob.display();  
                        if(n!=10)
                            i++;
                        else
                            continue;
                    }
                    if(i>4)
                    {
                        if(ob.check()=='X')
                        {
                            result="Computer Won";
                            System.out.println("Computer Won");
                            break;
                        }
                        else if(ob.check()=='O')
                        {
                            result= "Congratulations,Player  Won";
                            System.out.println("Congratulations,Player  Won");
                            break;
                        }
                    }
                }
            }
            else
            {
                System.out.println("Player's First Move");
                int n = -1;
                while(i<9)
                {
                    if(i%2==0)
                    {
                        n = ob.input('X');
                        ob.display();  
                        if(n!=10)
                            i++;
                        else
                            continue;
                    }
                    else
                    {
                        System.out.println();
                        System.out.println("MOVE BY COMPUTER");
                        System.out.println();
                        ob.input('O',r,n,n1);
                        ob.display();
                        i++;
                    }
                    if(i>4)
                    {
                        if(ob.check()=='X')
                        {
                            result="Congratulations,Player Won";
                            System.out.println("Congratulations,PLayer Won");
                            break;
                        }
                        else if(ob.check()=='O')
                        {
                            result= "Computer Won";
                            System.out.println("Computer Won");
                            break;
                        }
                    }
                }
            }
            if(result=="GAME ON")
                System.out.println("The Game is a Draw");
            System.out.println("ENTER 5 to Continue and any Number to Quit");
            c = Integer.parseInt(dis.readLine());
        }
        System.out.println("Thanks for Playing the Game");
    }
}
