import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SinglePlayer extends TTTAI implements ActionListener 
{
    char play[] = new char[9];;
    int i = 0;
    int r = (int)(Math.random()*(2)+1);
    int p1 = 0;
    int p2 = 0;
    int control = -1;
    
    ImageIcon x = new ImageIcon("X.png");
    ImageIcon o = new ImageIcon("O.png");
    ImageIcon h = new ImageIcon("HOME.png");
    ImageIcon re = new ImageIcon("RESET.png");
    
    JFrame frame = new JFrame();
    
    JLabel l1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel();
    JLabel l4 = new JLabel();
    JLabel l5 = new JLabel();
    
    JButton[] buttons = new JButton[9];
    JButton home = new JButton();
    JButton replay = new JButton();
    
    Check ob = new Check();
    Score sc = new Score();
    SinglePlayer()
    {
        fill();
        
        l1.setBounds(0,0,100,150);
        l1.setBackground(new Color(127,0,255));
        l1.setOpaque(true);
        l1.setText(Integer.toString(p1));
        l1.setFont(new Font("MV Boli",Font.PLAIN,40));
        
        l2.setBounds(100,0,500,100);
        l2.setBackground(Color.blue);
        l2.setOpaque(true);
        l2.setFont(new Font("MV Boli",Font.PLAIN,40));
        if(r==1)
            l2.setText(" TTTAI'S FIRST MOVE");
        else
            l2.setText(" PLAYER'S FIRST MOVE");
        l2.setForeground(Color.white);
        
        l3.setBounds(600,0,125,150);
        l3.setBackground(new Color(75,0,130));
        l3.setOpaque(true);
        l3.setText(Integer.toString(p2));
        l3.setFont(new Font("MV Boli",Font.PLAIN,40));
        
        l4.setBounds(100,100,500,500);
        l4.setLayout(new GridLayout(3,3,10,10));
        l4.setOpaque(true);
        
        home.setBounds(0,550,100,150);
        home.setBackground(Color.yellow);
        frame.add(home);
        home.addActionListener(this);
        home.setIcon(h);
        home.setFocusable(false);
        home.setVerticalAlignment(JButton.TOP);
        
        l5.setBounds(100,600,500,100);
        l5.setBackground(Color.orange);
        l5.setOpaque(true);
        l5.setHorizontalTextPosition(JLabel.CENTER);
        l5.setVerticalTextPosition(JLabel.CENTER);
        l5.setFont(new Font("MV Boli",Font.PLAIN,50));
        l5.setForeground(Color.white);
        
        replay.setBounds(600,550,125,150);
        replay.setBackground(Color.red);
        frame.add(replay);
        replay.addActionListener(this);
        replay.setIcon(re);
        replay.setFocusable(false);
        replay.setVerticalAlignment(JButton.TOP);
        
        for(int j=0;j<9;j++)
        {
            buttons[j] = new JButton();//creating button array
            l4.add(buttons[j]);
            buttons[j].setFocusable(false);
            buttons[j].setBackground(new Color(140,0,155));
        }
        if(i==0&&r==1)
            SecondMove(0);
        for(int j=0;j<9;j++)
            buttons[j].addActionListener(this);
            
        frame.setTitle("SinglePlayer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,750);
        frame.setLayout(null);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        
        frame.setVisible(true);
    }
    void Check1()
    {
        int g = 0;
        g = ob.Win(play);
        if(r+(g%10)==3)
        {
            g/=10;
            r=g%10;
            g/=10;
            for(i=0;i<3;i++)
            {
               buttons[r].setBackground(Color.white);
               r+=g;
            }
            l5.setText("PLAYER WINS");
            control = 3;
        }
        else if(g!=0)
        {
            g/=10;
            r=g%10;
            g/=10;
            for(i=0;i<3;i++)
            {
               buttons[r].setBackground(Color.white);
               r+=g;
            }
            l5.setText(" TTTAI WINS");
            control = 0;
        }
    }
    void reset()
    {
        i=0;
        fill();
        reset1();
        r = sc.score(control);
        p2 += r%10;
        p1 += r/10;
        l1.setText(Integer.toString(p1));
        l3.setText(Integer.toString(p2));
        r = (int)(Math.random()*(2)+1);
        control = -1;
        if(r==1)
            SecondMove(0);
        for(int j=0;j<9;j++)
        {
            buttons[j].setIcon(null) ;
            buttons[j].setEnabled(true);
            buttons[j].setBackground(new Color(140,0,155));
        }
    }
    void fill()
    { 
        for(int j=0;j<9;j++)
            play[j] = ' ';
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==home)
        {
            new Home();
            frame.setVisible(false);
        }
        else if(e.getSource()==replay)
        {
             if(control == -1)
             {
                 new SinglePlayer();
                 frame.setVisible(false);
             }
             else
                 reset();
        }
        for(int j=0;j<9;j++) 
        {
            if(e.getSource()==buttons[j])
            {
                 if(buttons[j].getText()=="")
                 {
                     if(r==2)
                     {
                        buttons[j].setIcon(x);
                        buttons[j].setEnabled(false);//button disable
                        buttons[j].setDisabledIcon(x);//shows button icon instead of disable button
                        play[j] = 'X';
                        i++;
                     }
                     else
                     {
                        buttons[j].setIcon(o);
                        buttons[j].setEnabled(false);
                        buttons[j].setDisabledIcon(o);
                        play[j] = 'O';
                        i++;
                     }
                     if(i==9)
                     {
                        l5.setText("   GAME DRAWN");
                        control = 2;
                     }
                     else if(i>4)
                        Check1();
                     SecondMove(j);
                     if(i==9)
                     {
                        l5.setText("   GAME DRAWN");
                        control = 1;
                     }
                     else if(i>4)
                        Check1();
                 }    
            }
        }
    }            
    void SecondMove(int y)
    {
        int n = input(play,r,y,4);
        if(r==2)
        {
            buttons[n].setIcon(o);
            buttons[n].setEnabled(false);
            buttons[n].setDisabledIcon(o);
            play[n] = 'O';
            i++;
        }
        else 
        {
            buttons[n].setIcon(x);
            buttons[n].setEnabled(false);
            buttons[n].setDisabledIcon(x);
            play[n] = 'X';
            i++;
        }
    }

    public static void main(String[] args) {
        new SinglePlayer();
    }
}