import java.util.*;
public class SecondMove
{
    int tools(int k)
    {
        if(k==1||k==2||k==3)
            return 0;
        else if(k==4)
            return 1;
        else if(k==5||k==6)
            return 2;
        else if(k==7)
            return 3;
        else 
            return 6;
    }
    int tools1(int k)
    {
        if(k==1)
            return 4;
        else if(k==2||k==7||k==8)
            return 1;
        else if(k==3||k==4||k==6)
            return 3;
        else
            return 2;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[9];
        int a=0;
        SecondMove ob = new SecondMove();
        int rand[] = new int[9];//array containing random valuesof arr[]
        //assigning 0 as blank element
        for(int i=0;i<9;i++)
            arr[i] = 0;//0 is used as filler
        //using 1,2 here
        //1 is X and 2 is O for TicTacToe.
        while(a!=9)
        {
            for(int i=0;i<9;i++)
                rand[i] = -1;//-1 is used as filler
            int f1 = 0;
            if(a%2==0||a==0)//players input
            {
                System.out.println("Enter PLayer's Position:-");
                int n = sc.nextInt();
                arr[n] = 1;
                f1=1;
            }
            else if(a==1)//CHECKING FOR WINNING CASE
            {
                if(arr[4]==0)
                {
                    arr[4]=2;
                    f1=1;
                }
                else
                {
                    arr[2]=2;
                    f1=1;
                }
            }
            else if(a==3&&arr[4]==2)//STOPING THE WINNIG CASE
            {
                if(arr[0]==1&&arr[8]==1)
                {
                    arr[3]=2;
                    f1=1;                   
                }
                if(arr[2]==1&&arr[6]==1)
                {
                    arr[3]=2;
                    f1=1;
                }
                else if(arr[1]==1&&arr[7]==1)
                {
                    arr[0]=2;
                    f1=1;
                }
                else if(arr[3]==1&&arr[5]==1)
                {
                    arr[0]=2;
                    f1=1;
                }
            }
            //this check for 0 to win the game #Computer Move
            if(f1==0)
            {
                for(int k=1;k<=8;k++)
                {
                    int x = ob.tools(k);
                    int c = ob.tools1(k);
                    int sum  = 0;
                    int sum1 = 0;
                    int i = 0;
                    int f=0;
                    while(f!=3)
                    {
                        sum+=x;
                        if(arr[x]==2)
                        {
                            sum1 +=x;
                            i++;
                        }
                        f++;
                        x+=c;
                    }
                    sum1 = sum - sum1;
                    if(i==2&&arr[sum1]==0)
                    {
                        arr[sum1]=2;
                        System.out.println("4");
                        System.out.println(sum);
                        System.out.println(sum1);
                         System.out.println();
                        f1=1;
                        break;
                    }
                }
            }
            if(f1==0)
            {
                //this checks for the X in line to win the game
                for(int k=1;k<=8;k++)
                {
                    int x = ob.tools(k);
                    int c = ob.tools1(k);
                    int sum  = 0;
                    int sum1 = 0;
                    int i = 0;
                    int f=0; 
                    while(f!=3)
                    {
                        sum+=x;
                        if(arr[x]==1)
                        {
                            sum1 +=x;
                            i++;
                        }
                        f++;
                        x+=c;
                    }
                    sum1 = sum - sum1;
                    if(i==2&&arr[sum1]==0)
                    {
                        arr[sum1]=2;
                        System.out.println("5");
                        System.out.println(sum);
                        System.out.println(sum1);
                        System.out.println(k);
                         System.out.println();
                        f1=1;
                        break;
                    }
                }
            }
            if(f1==0)
            {
                int b = 0;
                for(int i=0;i<9;i++)
                {
                    if(arr[i]==0)
                    {
                        rand[b] = i;
                        b++;
                    }
                }
                int j = (int)(Math.random()*(b)+1);
                arr[rand[j-1]] = 2;
            }    
            System.out.println();
            a++;
            for(int i=0;i<9;i++)
            {
                if(i%3==0)
                    System.out.println();
                if(arr[i]==1)
                    System.out.print("X ");
                else if(arr[i]==2)
                    System.out.print("O ");
                else
                    System.out.print("- ");
            }
            System.out.println();
        }
    }
}