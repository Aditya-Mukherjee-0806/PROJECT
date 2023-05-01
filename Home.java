import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home implements ActionListener
{
    JFrame frame = new JFrame();
    JButton play = new JButton("PLAY");
    JButton exit = new JButton("EXIT");
    Home()
    {
        ImageIcon img = new ImageIcon("logo.png");
        
        JLabel label = new JLabel("TIC TAC TOE");
        label.setBounds(0,0, 750,600);
        label.setFont(new Font("MV Boli",Font.PLAIN,40));
        label.setForeground(Color.white);
        label.setIconTextGap(-10);
        label.setIcon(img);
        label.setOpaque(true);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setBackground(new Color(123,50,250));
        
        
        play.setBounds(175,600,200,100);
        play.setFocusable(false);
        play.addActionListener(this);
        play.setFont(new Font("MV Boli",Font.BOLD,40));
        play.setBackground(new Color(181, 16, 255));
        play.setForeground(Color.white);
        
        exit.setBounds(375,600,200,100);
        exit.setFocusable(false);
        exit.addActionListener(this);
        exit.setFont(new Font("MV Boli",Font.BOLD,40));
        exit.setBackground(new Color(181, 16, 255));
        exit.setForeground(Color.white);
        
        frame.setTitle("HOME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,750);
        frame.setLayout(null);
        frame.add(label);
        frame.add(play);
        frame.add(exit);
        frame.getContentPane().setBackground(new Color(123,50,250));
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==play)
        {
            new Modes();
            frame.setEnabled(false);
        }
        else
            System.exit(0);
    }
}