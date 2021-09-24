package sw;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class End extends JFrame{
    End(Start st) {
      setTitle("게임 끝");
      setSize(649, 489);
      Toolkit tk = Toolkit.getDefaultToolkit();
      setLocationRelativeTo(null); // 정중앙으로
      getContentPane().setLayout(null);
      
      JButton btn1 = new JButton(new ImageIcon(tk.getImage("e1.png")));
      btn1.setBounds(14, 12, 293, 418);
      getContentPane().add(btn1);
      btn1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            setVisible(false);
            st.setVisible(false);
            new Game();
         }
      });
      
      
      JButton btn2 = new JButton(new ImageIcon(tk.getImage("e2.png")));
      btn2.setBounds(321, 12, 296, 418);
      getContentPane().add(btn2);
      btn2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      });
      
      setVisible(true);
   }
}