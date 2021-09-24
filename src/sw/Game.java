package sw;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

public class Game extends JFrame {

   private Image screenImage;
   private Graphics screenGraphic;

   private ImageIcon exitButtoEnteredImages = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png")); 
   private ImageIcon exitButtoBasicImages = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png")); 
   private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
   private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
   private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
   private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png")); 
   
   private Image background = new ImageIcon(Main.class.getResource("../images/back.png")).getImage();
   private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
   
   private JButton exitButton = new JButton(exitButtoBasicImages);
   private JButton startButton = new JButton(startButtonBasicImage);
   private JButton quitButton = new JButton(quitButtonBasicImage);
   
   private int mouseX, mouseY;
   
   Game() { // ������ ����
      setUndecorated(true);
      setTitle("���� ����");
      setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
      setLocationRelativeTo(null); // ���߾�����
      setResizable(true); // �������� ũ�⸦ ���Ƿ� ������ϰ� ����
      setVisible(true); // �������� ���� ���̰� ���ϴ�.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBackground(new Color(0,0,0,0));
      exitButton.setBounds(1245, 0, 30, 30);
      exitButton.setBorderPainted(false);
      exitButton.setContentAreaFilled(false);
      exitButton.setFocusPainted(false);
      exitButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            exitButton.setIcon(exitButtoEnteredImages);
            exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         }
         @Override
         public void mouseExited(MouseEvent e) {
            exitButton.setIcon(exitButtoBasicImages);
            exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            System.exit(0);
         }
      });
      getContentPane().setLayout(null);
      getContentPane().add(exitButton);
      startButton.setBounds(41, 76, 400, 100);
      startButton.setBorderPainted(false);
      startButton.setContentAreaFilled(false);
      startButton.setFocusPainted(false);
      startButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            startButton.setIcon(startButtonEnteredImage);
            startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         }
         @Override
         public void mouseExited(MouseEvent e) {
            startButton.setIcon(startButtonBasicImage);
            startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            setVisible(false); // ����ȭ�� �Ⱥ��̰�
            //new Start();
            new Ch();
            //���ӽ����̺�Ʈ
            // ���� new Subject();
         }
      });
      getContentPane().add(startButton);
      quitButton.setBounds(41, 206, 400, 100);
      quitButton.setBorderPainted(false);
      quitButton.setContentAreaFilled(false);
      quitButton.setFocusPainted(false);
      quitButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            quitButton.setIcon(quitButtonEnteredImage);
            quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         }
         @Override
         public void mouseExited(MouseEvent e) {
            quitButton.setIcon(quitButtonBasicImage);
            quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            System.exit(0);
         }
      });
      getContentPane().add(quitButton);
      menuBar.setBounds(0, 0, 1280, 30);
      menuBar.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
         }
      });
      menuBar.addMouseMotionListener(new MouseMotionAdapter() {
         @Override
         public void mouseDragged(MouseEvent e) {
            int x = e.getXOnScreen();
            int y = e.getYOnScreen();
            setLocation(x - mouseX, y - mouseY);
         }
      });
      
      getContentPane().add(menuBar);
      
      JButton btn1 = new JButton(new ImageIcon("n1.png"));
      btn1.setBounds(12, 340, 1240, 370);
      getContentPane().add(btn1);
      
      btn1.setBorderPainted(false);
       btn1.setContentAreaFilled(false);
       btn1.setFocusPainted(false);
       btn1.setOpaque(false);
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