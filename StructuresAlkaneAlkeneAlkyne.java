import java.io.*;
public class StructuresAlkaneAlkeneAlkyne
{
    public static void main(String args[]) throws IOException
    {
        DataInputStream dis = new DataInputStream(System.in);
        System.out.println("Enter Number of Carbon atom:-");
        int c = Integer.parseInt(dis.readLine());
        System.out.println("Enter Number of Hydrogen atom:-");
        int h = Integer.parseInt(dis.readLine());
        if(h==2*c+2)
            System.out.println("Compound is Alkane");
        else if(h==2*c)
            System.out.println("Compound is Alkene");
        else if(h==2*c-2)
            System.out.println("Compound is Alkyne");
        else
        {
            System.out.println("Structure not Possible");
            System.exit(0);
        }
        int cv = 4,ns = 3+2*c;
        String display[][] = new String[5][ns];
        int C[][] = new int[c][2];
        for(int i=0;i<c;i++)
            for(int j=0;j<2;j++)
            C[i][j] = 0;
        for(int i=0;i<5;i++)
            for(int j=0;j<ns;j++)
                display[i][j] = " ";
        int i = 0; 
        while(i!=c)
        {
            if(i==c-2)
            {
                int cb = cv-C[i][0]+cv-C[i+1][0];
                cb -= h;
                cb=cb/2;
                C[i][0]+=cb;
                C[i+1][0]+=cb;
                C[i][1] = C[i][1]*10+cb;
            }
            else if(i+1!=c)
            {
                C[i][0] +=1;
                C[i+1][0] +=1;
                C[i][1] = C[i][1]*10+1;
            }
            int b = cv-C[i][0];
            h -= b;
            C[i][0] += b;
            C[i][1] = C[i][1]*10+b;
            i++;
        }
        for(int j=0;j<c;j++)
        {
            System.out.print("C");
            if(C[j][1]%10==1)
                System.out.print("H");
            else if(C[j][1]%10==2)
                System.out.print("H\u2082");
            else if(C[j][1]%10==3)
                System.out.print("H\u2083");
            else if(C[j][1]%10==4)
                System.out.print("H\u2084");
            i = C[j][1]/10;
            if(i==1)
                System.out.print("-");
            else if(i==2)
                System.out.print("=");
            else if(i==3)
                System.out.print("≡");
        }
        System.out.println();
        int l = 0;
        for(i=2;i<ns-2;i+=2)
        {
            int n = C[l][1];
            l++;
            display[2][i]="C";
            if(n%10==4)
            {
                display[2][i+1]="-";
                display[2][i+2]="H";
                n--;
            }
            if(n%10==3&&l==1)
            {
                display[2][i-1]="-";
                display[2][i-2]="H";
                n--;
            }
            else if(n%10==3&&l!=1)
            {
                display[2][i+1]="-";
                display[2][i+2]="H";
                n--;
            }
            if(n%10==2)
            {
                 display[3][i]= "|";
                 display[4][i]= "H";
                 n--;
            }
            if(n%10==1)
            {
                 display[1][i]= "|";
                 display[0][i]= "H";
                 n--;
            }
            n=n/10;
            if(i!=ns-3&&n>0)
            {
                 if(n==1)
                    display[2][i+1]="-";
                 else if(n==2)
                    display[2][i+1]="=";
                 else if(n==3)
                     display[2][i+1]="≡";
            }
        }
        for(int x=0;x<5;x++)
        {
            for(int j=0;j<ns;j++)
                System.out.print(display[x][j]);
            System.out.println();
        }
    }
}