import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Modes implements ActionListener
{
    JFrame frame = new JFrame();
    JButton sp = new JButton("SINGLE PLAYER");
    JButton mp = new JButton("MULTI PLAYER");
    
    Modes()
    {
        ImageIcon img = new ImageIcon("SP.jpeg");
        ImageIcon img1 = new ImageIcon("MP.jpeg");
        
        sp.setBounds(225,33,300,300);
        sp.setFocusable(false);
        sp.addActionListener(this);
        sp.setFont(new Font("MV Boli",Font.BOLD,20));
        sp.setIcon(img);
        sp.setBackground(new Color(181, 16, 255));
        sp.setForeground(Color.white);
        sp.setHorizontalTextPosition(JButton.CENTER);
        sp.setVerticalTextPosition(JButton.TOP);
        
        mp.setBounds(225,367,300,300);
        mp.setFocusable(false);
        mp.addActionListener(this);
        mp.setFont(new Font("MV Boli",Font.BOLD,20));
        mp.setIcon(img1);
        mp.setBackground(new Color(181, 16, 255));
        mp.setForeground(Color.white);
        mp.setHorizontalTextPosition(JButton.CENTER);
        mp.setVerticalTextPosition(JButton.TOP);
        
        frame.setTitle("MODE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,750);
        frame.setLayout(null);
        frame.add(sp);
        frame.add(mp);
        frame.getContentPane().setBackground(new Color(123,50,250));
        
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==sp)
            new Single();
        else
            new Multi();
        frame.setVisible(false);
    }
}