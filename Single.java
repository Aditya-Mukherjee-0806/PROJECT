import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Single implements ActionListener
{
    int i=0;
    
    JFrame frame = new JFrame();
    
    JLabel l = new JLabel();
    JLabel l1 = new JLabel("ENTER YOUR NAME:-");
    JLabel l2 = new JLabel("* PRESS RESET BUTTON TO RESET THE TIC TAC TOE BOARD");
    JLabel l3 = new JLabel("* RESET PRESSED BETWEEN THE GAME WOULD RESET THE GAME");
    JLabel l4 = new JLabel("* RESET PRESSED AFTER THE GAME IS WON/DRAW/LOST WILL");
    JLabel l5 = new JLabel("  ONLY RESET THE GAME BOARD");
    
    JButton con = new JButton("CONTINUE");
    
    ImageIcon img = new ImageIcon("score.png");
    
    JTextField tf1 = new JTextField();
    Single()
    {
        tf1.setBounds(225,100,250,50);
        tf1.setFont(new Font("MV Boli",Font.BOLD,20));
        tf1.setText("PLAYER");
        tf1.setBackground(new Color(123,50,250));
        tf1.setForeground(Color.white);
        
        l.setBounds(0,0, 750,600);;
        l.setOpaque(true);
        l.setIcon(img);
        l.setVerticalAlignment(JLabel.CENTER);
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setBackground(new Color(123,50,250));
        
        l1.setBounds(225, 70, 250,30);
        l1.setOpaque(true);
        l1.setBackground(new Color(123,50,250));
        l1.setForeground(Color.white);
        l1.setFont(new Font("MV Boli",Font.BOLD,20));
        
        l2.setBounds(0, 370, 800,40);
        l2.setOpaque(true);
        l2.setBackground(new Color(123,50,250));
        l2.setForeground(Color.white);
        l2.setFont(new Font("MV Boli",Font.BOLD,20));
        
        l3.setBounds(0, 420, 800,40);
        l3.setOpaque(true);
        l3.setBackground(new Color(123,50,250));
        l3.setForeground(Color.white);
        l3.setFont(new Font("MV Boli",Font.BOLD,20));
        
        l4.setBounds(0, 470, 800,40);
        l4.setOpaque(true);
        l4.setBackground(new Color(123,50,250));
        l4.setForeground(Color.white);
        l4.setFont(new Font("MV Boli",Font.BOLD,20));
        
        l5.setBounds(0, 500, 800,40);
        l5.setOpaque(true);
        l5.setBackground(new Color(123,50,250));
        l5.setForeground(Color.white);
        l5.setFont(new Font("MV Boli",Font.BOLD,20));
        
        con.setBounds(100,600,500,100);
        con.setBackground(Color.orange);
        con.setFocusable(false);
        con.setHorizontalTextPosition(JLabel.CENTER);
        con.setVerticalTextPosition(JLabel.CENTER);
        con.setFont(new Font("MV Boli",Font.PLAIN,60));
        con.setForeground(Color.white);
        con.addActionListener(this);
        
        frame.setTitle("SinglePLayer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,900);
        frame.add(con);
        frame.add(l);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(123,50,250));
        
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==con)
        {
            if(i==0)
            {
                l.setIcon(null);
                l.add(tf1);
                l.add(l1);
                l.add(l2);
                l.add(l3);
                l.add(l4);
                l.add(l5);
                i++;
            }
            else if(i==1)
            {
                new SinglePlayer();
                tf1.setEnabled(false);
            }   
        }
    }
}