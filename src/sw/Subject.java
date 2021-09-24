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

public class Subject extends JFrame {
	Subject(int x) {
		setTitle("과목선택하기");
		setSize(649, 489);
		Toolkit tk = Toolkit.getDefaultToolkit();
		setLocationRelativeTo(null); // 정중앙으로
		getContentPane().setLayout(null);
		
		JButton btn1 = new JButton(new ImageIcon(tk.getImage("sub1.png")));
		btn1.setBounds(14, 12, 293, 418);
		getContentPane().add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//new Ch();
				//new Start(tk.getImage(x+".png").getScaledInstance(50, 50, Image.SCALE_SMOOTH),1,3,5);
				//매개변수 세번째 = 처음속도
				new definition(x,1);

			}
		});
		
		
		JButton btn2 = new JButton(new ImageIcon(tk.getImage("sub2.png")));
		btn2.setBounds(321, 12, 296, 418);
		getContentPane().add(btn2);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//new Ch();
				//new Start(tk.getImage(x+".png").getScaledInstance(50, 50, Image.SCALE_SMOOTH),2,3,5);
				new definition(x,2);
			
			}
		});
		
		setVisible(true);
	}
}
