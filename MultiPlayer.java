import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MultiPlayer implements ActionListener
{
    int i = 0;
    int r = 0;
    int p1,p2=0;
    int control = -1;
    char play[] = new char[9];
    String s3 = "";
    String s4 = "";
    
    ImageIcon x = new ImageIcon("X.png");
    ImageIcon o = new ImageIcon("O.png");
    ImageIcon h = new ImageIcon("HOME.png");
    ImageIcon re = new ImageIcon("RESET.png");
    
    JFrame frame = new JFrame();
    
    JLabel l1 = new JLabel();
    JLabel l1a = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l2a = new JLabel();
    JLabel l3 = new JLabel();
    JLabel l4 = new JLabel();
    JLabel l5 = new JLabel();
    
    JButton[] buttons = new JButton[9];
    JButton home = new JButton();
    JButton reset = new JButton();
    
    Check ob = new Check();
    Score sc = new Score();
    MultiPlayer(String s1,String s2)
    {
        s3=s1;
        s4=s2;
        
        fill();
        
        l1.setBounds(0,0,100,50);
        l1.setBackground(new Color(178,102,255));
        l1.setOpaque(true);
        l1.setText(s3);
        l1.setFont(new Font("MV Boli",Font.PLAIN,15));
        l1.setForeground(Color.white);
        
        l1a.setBounds(0,50,100,50);
        l1a.setBackground(new Color(178,102,255));
        l1a.setOpaque(true);
        l1a.setText(Integer.toString(p1));
        l1a.setFont(new Font("MV Boli",Font.PLAIN,30));
        l1a.setForeground(Color.white);
        
        l2.setBounds(100,0,500,100);
        l2.setBackground(new Color(120,0,204));
        l2.setOpaque(true);
        l2.setFont(new Font("MV Boli",Font.PLAIN,30));
        if(r==1)
            l2.setText("FIRST MOVE BY:- "+s3);
        else
            l2.setText("FIRST MOVE BY:- "+s4);
        l2.setForeground(Color.white);
        
        l3.setBounds(600,0,125,50);
        l3.setBackground(new Color(178,102,255));
        l3.setOpaque(true);
        l3.setText(s4);
        l3.setFont(new Font("MV Boli",Font.PLAIN,15));
        l3.setForeground(Color.white);
        
        l2a.setBounds(600,50,12,50);
        l2a.setBackground(new Color(178,102,255));
        l2a.setOpaque(true);
        l2a.setText(Integer.toString(p1));
        l2a.setFont(new Font("MV Boli",Font.PLAIN,30));
        l2a.setForeground(Color.white);
        
        l4.setLayout(new GridLayout(3,3,10,10));
        l4.setBounds(100,100,500,500);
        l4.setOpaque(true);
        
        home.setBounds(0,550,100,150);
        home.setBackground(Color.yellow);
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
        
        reset.setBounds(600,550,125,150);
        reset.setBackground(Color.yellow);
        reset.addActionListener(this);
        reset.setIcon(re);
        reset.setFocusable(false);
        reset.setVerticalAlignment(JButton.TOP);
        
        for(int j=0;j<9;j++)
        {
            buttons[j] = new JButton();//creating button array
            l4.add(buttons[j]);
            buttons[j].setFocusable(false);
            buttons[j].setBackground(new Color(140,0,155));
            buttons[j].addActionListener(this);
        }
        
        frame.setTitle("MultiPLayer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,750);
        frame.add(home);
        frame.add(reset);
        frame.setLayout(null);
        frame.add(l1);
        frame.add(l1a);
        frame.add(l2);
        frame.add(l2a);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.getContentPane().setBackground(new Color(123,50,250));
        
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
            l5.setText("   "+s3+" WINS");
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
            l5.setText("   "+s4+" WINS");;
            control = 0;
        }
    }
    void fill()
    { 
        for(int j=0;j<9;j++)
            play[j] = ' ';
    }
    void reset()
    {
        i=0;
        fill();
        r = sc.score(control);
        p2 += r%10;
        p1 += r/10;
        l1a.setText(Integer.toString(p1));
        l2a.setText(Integer.toString(p2));
        r = (int)(Math.random()*(2)+1);
        control = -1;
        for(int j=0;j<9;j++)
        {
            buttons[j].setIcon(null) ;
            buttons[j].setEnabled(true);
            buttons[j].setBackground(new Color(140,0,155));
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==home)
        {
            new Home();
            frame.setVisible(false);
        }
        else if(e.getSource()==reset)
        {
            if(control==-1)
            {
                new Multi();
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
                     if((r+i%2)%2==0)
                     {
                        buttons[j].setIcon(x);
                        buttons[j].setEnabled(false);//button disable
                        buttons[j].setDisabledIcon(x);//shows button icon instead of disable button
                        play[j] = 'X';
                        if(r==1)
                            l5.setText(s3+"\'S MOve");
                        else
                            l5.setText(s4+"\'S MOve");
                        i++;
                     }
                     else
                     {
                        if(r==1)
                            l5.setText(s3+"\'S MOve");
                        else
                            l5.setText(s4+"\'S MOve");
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
                 }    
            }
        }
    }
}