package sw;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ch extends JFrame {
	Ch() {
		setTitle("캐릭터 정하기");
		setSize(649, 489);
		Toolkit tk = Toolkit.getDefaultToolkit();
		setLocationRelativeTo(null); // 정중앙으로
		getContentPane().setLayout(null);
		
		JButton btn1 = new JButton(new ImageIcon(tk.getImage("1.png")));
		btn1.setBounds(49, 41, 147, 162);
		getContentPane().add(btn1);
		btn1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false); // 원래화면 안보이게
				//new Start(tk.getImage("1.png").getScaledInstance(100, 100, Image.SCALE_SMOOTH ));
				new Subject(1);
			
			}
		});
		
		JButton btn2 = new JButton(new ImageIcon(tk.getImage("2.png")));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn2.setBounds(237, 41, 147, 162);
		btn2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false); // 원래화면 안보이게
				//new Start(tk.getImage("2.png").getScaledInstance(100, 100, Image.SCALE_SMOOTH ));
				new Subject(2);
			
			}
		});
		getContentPane().add(btn2);
		
		JButton btn3 = new JButton(new ImageIcon(tk.getImage("3.png")));
		btn3.setBounds(422, 41, 147, 162);
		getContentPane().add(btn3);
		btn3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false); // 원래화면 안보이게
				new Subject(3);
				//new Start(tk.getImage("3.png").getScaledInstance(100, 100, Image.SCALE_SMOOTH ));
			}
		});
		
		JButton btn4 = new JButton(new ImageIcon(tk.getImage("4.png")));
		btn4.setBounds(49, 233, 147, 162);
		getContentPane().add(btn4);
		btn4.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false); // 원래화면 안보이게
				new Subject(4);
				//new Start(tk.getImage("4.png").getScaledInstance(100, 100, Image.SCALE_SMOOTH ));
			}
		});
		JButton btn5 = new JButton(new ImageIcon(tk.getImage("5.png")));
		btn5.setBounds(237, 233, 147, 162);
		getContentPane().add(btn5);
		btn5.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false); // 원래화면 안보이게
				new Subject(5);
				//new Start(tk.getImage("5.png").getScaledInstance(100, 100, Image.SCALE_SMOOTH ));
			}
		});
		
		JButton btn6 = new JButton(new ImageIcon(tk.getImage("6.png")));
		btn6.setBounds(422, 233, 147, 162);
		getContentPane().add(btn6);
		btn6.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false); // 원래화면 안보이게
				new Subject(6);
				//new Start(tk.getImage("6.png").getScaledInstance(100, 100, Image.SCALE_SMOOTH ));
			}
		});
		setVisible(true);
	}
}