package sw;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Next extends JFrame{
	Next(Start st, int S, int enemy_speed,int missile_Speed2) {
		 setTitle("惟績 魁");
	      setSize(649, 489);
	      Toolkit tk = Toolkit.getDefaultToolkit();
	      setLocationRelativeTo(null); // 舛掻肖生稽
	      getContentPane().setLayout(null);
	      
	      JButton btn1 = new JButton(new ImageIcon(tk.getImage("e3.png")));
	      btn1.setBounds(14, 12, 293, 418);
	      getContentPane().add(btn1);
	      btn1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            setVisible(false);
	            st.setVisible(false);
	            //食奄艦猿誤宿背!せせせせせせせせせせせせせせせせせ
	            new Start(tk.getImage(S+".png").getScaledInstance(50, 50, Image.SCALE_SMOOTH ),S,enemy_speed+3,missile_Speed2+5);
	            //原走厳 古鯵痕呪 enemy_speed+収切 = 紗亀 装亜拝凶 食奄辞 壱団
	            
	            //new Start(tk.getImage(1+".png").getScaledInstance(100, 100, Image.SCALE_SMOOTH ),1);
	           // new Start(tk.getImage(1+".png").getScaledInstance(100, 100, Image.SCALE_SMOOTH),1);
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

