package sw;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class definition  extends JFrame {
   private Image screenImage;
   private Graphics screenGraphic;
   private Image background;
   Toolkit tk = Toolkit.getDefaultToolkit();
      definition(int x,int num) {
      setUndecorated(true);
      setTitle("���� ���� Time!");
      setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
      setLocationRelativeTo(null); // ���߾�����
      setResizable(true); // �������� ũ�⸦ ���Ƿ� ������ϰ� ����
      setVisible(true); // �������� ���� ���̰� ���ϴ�.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBackground(new Color(0, 0, 0, 0));
      setLayout(null);
      
      if(num==1) {
         background = new ImageIcon(Main.class.getResource("../images/sw.png")).getImage();
      }
      else
         background = new ImageIcon(Main.class.getResource("../images/cn.png")).getImage();
      JButton btn1 = new JButton("Game Start");
      btn1.setBounds(Main.SCREEN_WIDTH-420, Main.SCREEN_HEIGHT-130, 300, 80);
      btn1.setContentAreaFilled(false);
      btn1.setFont(new Font("Arial", Font.PLAIN, 50));
      getContentPane().add(btn1);
      btn1.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
            setVisible(false);
            new Start(tk.getImage(x+".png").getScaledInstance(50, 50, Image.SCALE_SMOOTH),num,3,5);
         }
      });
      
   }
   
   public void paint(Graphics g) {
      screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
      screenGraphic = screenImage.getGraphics();
      screenDraw(screenGraphic);
      g.drawImage(screenImage, 0, 0, null);
   }

   public void screenDraw(Graphics g) {
      g.drawImage(background, 0, 0, null);
      paintComponents(g);
      this.repaint();
   }
}
   
