import java.io.*;
public class Check
{
    int Win(char play[])
    {
        int i = 0;
        //check for vertical column
        while(i<3)
        {
            if(play[i]==play[i+3]&&play[i]==play[i+6]&&play[i]!=' ')
            {
                if(play[i]=='X')
                {
                    i = 300+i*10+1;
                    return i;
                }
                else
                {
                    i=300+i*10+2;
                    return i;
                }
            }
            i++;
        }
        i = 0;
        //check for horizontal row
        while(i<7)
        {
            if(play[i]==play[i+1]&&play[i]==play[i+2]&&play[i]!=' ')
            {
                if(play[i]=='X')
                {
                    i = 100+i*10+1;
                    return i;
                }
                else
                {
                    i = 100+i*10+2;
                    return i;
                }
            }
            i+=3;
        }
        i = 0;
        //checks for diagonal checking
        int d = 4;
        while(d!=1)
        {
            if(play[i]==play[i+d]&&play[i]==play[i+2*d])
            {
                if(play[i]=='X')
                {
                    i = d*100+i*10+1;
                    return i;
                }
                else
                {
                    i=d*100+i*10+2;
                    return i;
                }
            }
            i+=2;
            d/=2;
        }
        return 0;
    }
}