import java.util.*;
public class Score
{
    int p1 = 0;
    int p2 = 0;
    /*
       3 points - you win
       2 points - you draw when opposition gave move
       1 point - you draw whrn you gave the first move
       0 point - you loose*/
    int score(int m)
    {
        if(m==3)
        {
            p1+=3;
            p2+=0;
        }
        else if(m==2)
        {
            p1+=2;
            p2+=1;
        }
        else if(m==1)
        {
            p1+=1;
            p2+=2;
        }
        else 
        {
            p1+=0;
            p2+=3;
        }
        return (p1*10+p2);
    }
}