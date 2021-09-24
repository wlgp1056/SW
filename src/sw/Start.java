package sw;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Start extends JFrame implements KeyListener, Runnable{
   int f_width ;
   int f_height ;
   int x,y; // 캐릭터 좌표 변수
   boolean KeyUp = false; // 키보드 입력 처리를 위한 변수
   boolean KeyDown = false;
   boolean KeyLeft = false;
   boolean KeyRight = false;
   boolean KeySpace = false;
   String concept;
   int num;
   static int S;
   
   int cnt;
   int player_Speed; // 캐릭터 속도
   int missile_Speed; // 미사일 속도
   static int missile_Speed2; // 적미사일  속도
   int fire_Speed;  
   
   static int enemy_speed; // 적 이동 속도       
   
   int player_Status = 0; 
   // 유저 캐릭터 상태 
   int game_Score; // 게임 점수 계산
   int player_Hitpoint; // 플레이어 캐릭터의 체력
   private boolean gameOver = false;
   
   //소공  
   String concept1[] = {"<프로그램의 개발 운용 및 유지보수에 관련된 모든 문서와 정보>", 
	         "<소프트웨어를 개발하는 과정, 작업 순서 의미>", 
	         "<각 단계들의 순서와 역할을 정의하고 각 단계의 산출물을 자세히 명시하는 가이드라인>", 
	         "<요구의 대상들을 정의(기능적 요구,비기능적 요구)>",
	         "<시스템과 사용자의 상호작용, 시스템에 요구되는 기능을 사용자의 시점에서 나타낸것>",
	         "<데이터와 절차를 일체화 한 것, 개별적으로 인식할 수 있는 모든 항목>",
	         "<공동된 속성과 연산(메서드)를 갖는 객체의 집합>",
	         "<객체들 간에 상호작용을 하는데 사용하는 수단으로 메시지가 전달되면 메소드를 시작>",
	         "<객체가 메시지를 받아 실행해야 할 객체의 구체적 연산,객체의 속성을 참조 및 변경하는 수단>",
	         "<불필요한 부분을 생략하고, 객체의 속성 중 가장 중요한 것에만 중점을 두어 개략화 시킨 것>",
	         "<자료 부분과 연산 부분등 정보처리에 필요한 기능을 묶어 정보를 은폐하여 외부에서 변경 못하게 함>",
	         "<객체는 다른 객체로 부터 자신의 자료를 숨기고 자신의 연산만을 통하여 접근을 허용하는 것>"};
   //컴네
   String concept2[] = {"<시스템과 시스템을 연결하기 위한 표준화된 접근 방법이다.>",
           "<통신 시스템이 데이터를 교환하기 위해 사용하는 통신 규칙>",
           "<인터네트워킹 기능을 수행하는 시스템>",
           "<주소와 이름 정보를 자동으로 유지하고 관리하는 데이터베이스 시스템이다.>", 
           "<중개 시스템에서는 경로 배정 기능을 수행하는 네트워크 계층의 프로토콜이 동작하는 것>",
           "<데이터를 최종 목적지까지 올바른 경로로 중개하는 교환 기능>",
           "<연결형 서비스를 지원하는 기능>",
           "<패킷 교환 방식에서 비연결형 서비스를 이용해 패킷을 독립적으로 전송하는 것>",
           "<라우팅 장비는 네트워크 내부에서 패킷 교환 기능을 수행하는데 둘 이상의 서로 다른 네트워크를 연결하는 기능>",
           "<IEEE 802.3은 1-persistent CSMA/CD 방식의 LAN 환경에 관해 규정된 표준안>",
           "<두 호스트간의 프레임 전송을 위한 일반적인 통신 프로토콜>",
           "<송신 호스트의 구분 없이 양방향으로 동시에 정보 프레임과 응답 프레임을 교차하면서 전송할 수 있는 것>"};

   
   Thread th; // 스레드 생성
   con c;
   Toolkit tk = Toolkit.getDefaultToolkit(); //이미지를 불러오기 위한 툴킷
   Image BackGround_img; // 배경화면 이미지
   Image[] Explo_img; //폭발이펙트용 이미지배열
   Image[] Enemy;
   
   
   Image me_img;
   Image Missile_img; // 미사일
   //Image Enemy_img;
   Image Missile2_img; // 적미사일
   
   ArrayList Missile_List = new ArrayList();
   ArrayList Enemy_List = new ArrayList();
   ArrayList Explosion_List = new ArrayList();
   //다수의 폭발 이펙트를 처리하기 위한 배열
   ArrayList Enemyex_List=new ArrayList();

   Image buffImage;
   Graphics buffg;
   
   Missile ms;
   Enemy en;

   
   Explosion  ex;
   
   Start(Image me_img, int S, int enemy_speed, int missile_Speed2){
     // System.out.println("Start 시작 = "+ enemy_speed);
   init(S,enemy_speed,missile_Speed2);

   start();
     this.me_img = me_img;
   setTitle("쏘아올린공");
   setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
   Dimension screen = tk.getScreenSize();

   setLocationRelativeTo(null); // 정중앙으로
   setResizable(false);
   getContentPane().setLayout(null);
   setVisible(true);
   }
   
   public void init(int s, int e, int m){
     S=s;
      x=100;
      y=100;
      f_width = 1000;
      f_height = 600;

      enemy_speed = e;//적이 날라오는 속도 설정

      Missile_img = new ImageIcon("pen.png").getImage();
      Missile2_img = new ImageIcon("bullet_1.png").getImage();
 
      Explo_img = new Image[3];
      for(int i=0; i<Explo_img.length; i++) {
         Explo_img[i] = new ImageIcon("explo_"+i+".png").getImage();
      }
      if (s==1) {
         Enemy = new Image[12];
          for(int i=0; i<12; i++) {
             Enemy[i] = new ImageIcon("s"+(i+1)+".png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH );
         }
          
      }
      else if(s==2) {
         Enemy = new Image[12];
          for(int i=0; i<12; i++) {
             Enemy[i] = new ImageIcon("c"+(i+1)+".png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH );
          }
      }
      
      game_Score = 0; // 게임 스코어 초기화
      player_Hitpoint = 5;//최초 플레이어 체력
      player_Speed = 5; //유저 캐릭터 움직이는 속도 설정
      missile_Speed = 11; //미사일 움직임 속도 설정
      missile_Speed2 = m;
      fire_Speed = 15; //미사일 연사 속도 설정

      
   }
   
   public void start(){
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   //프레임 오른쪽 위에 X버튼을 눌렀을때 
   //프로그램이 정상적으로 종료하게 만들어 줍니다.
   addKeyListener(this); //키보드 이벤트 실행
   th = new Thread(this);
   th.start();  // 스레드 실행
   c = new con();
   c.start();
   }
   
   public void run(){ // 스레드가 무한 루프될 부분
      try{ // 예외옵션 설정으로 에러 방지
      while(true){ // while 문으로 무한 루프 시키기
         if(gameOver) {
        	 c.interrupt();
             th.interrupt();
         }
      KeyProcess(); // 키보드 입력처리를 하여 x,y 갱신
      EnemyProcess();//적 움직임 처리 메소드 실행
      MissileProcess(); // 미사일 처리 메소드
      ExplosionProcess();//폭파처리 메소드 실행
      repaint(); // 갱신된 x,y값으로 이미지 새로 그리기
      Thread.sleep(18);// 18 milli sec 로 스레드 돌리기
      cnt ++;
      }
      }catch (Exception e){}
   }
   
   public void MissileProcess() {
      if (KeySpace) {
         player_Status = 1;
         // 미사일을 발사하면 플레이어 캐릭터 상태를 1로 변경
         if ((cnt % fire_Speed)==0) {
            // 플레이어의 미사일 연사속도 조절
            ms = new Missile(x+150,y+30, 0,missile_Speed, 0);
            Missile_List.add(ms);  // 해당 미사일 추가
         }
      }
      for (int i=0; i<Missile_List.size(); ++i){
         ms = (Missile) Missile_List.get(i);
         ms.move();
         
         if ( ms.x > f_width - 20 || ms.x < 0 || ms.y < 0 || ms.y > f_height){
         Missile_List.remove(i);
         }
         if ( Crash(x, y, ms.x, ms.y, me_img, Missile_img) && ms.who == 1 ) {
            //적이발사한미사일이 플레이어와 충돌하는지 여부를 확인
            player_Hitpoint --;
            ex = new Explosion(x, y, 1);
            Explosion_List.add(ex);
            //생성한객체를배열로저장
            Missile_List.remove(i);
            //해당되는적미사일삭제
            if(player_Hitpoint==0) {
                gameOver = true;
                new End(this);
             }
         }
         for (int j = 0 ; j < Enemy_List.size(); j++){
         en = (Enemy) Enemy_List.get(j);
         
         if (Crash(ms.x,ms.y,en.x,en.y,Missile_img, Enemy[0]) && ms.who == 0){
         // 플레이어미사일과 적충돌과정
         Missile_List.remove(i); // 충돌 미사일 제거
         Enemy_List.remove(j); // 충돌 적 제거
         if (en.num==num-1) {
        	 game_Score += 10;
         }
         else {
        	 game_Score -= 5;
         }
         ex = new Explosion(en.x + Enemy[0].getWidth(null) / 2, en.y + Enemy[0].getHeight(null) / 2 , 0); // 폭팔설정
         Explosion_List.add(ex); 
         if(game_Score<-10) {
             gameOver = true;
             new End(this);
          }
         if(game_Score >= 50) {
            gameOver = true;
            new Next(this,S,enemy_speed,missile_Speed2);
         }
         }
         }
         }
   }

public void EnemyProcess(){//적 행동 처리 메소드
      for (int i = 0 ; i < Enemy_List.size() ; ++i ){ 
      en = (Enemy)(Enemy_List.get(i)); 
      en.move(); 
      if(en.x < -200){ // 밖으로 이동
      Enemy_List.remove(i); 
      }
      if ( cnt % 100 ==0) {
         ms = new Missile (en.x, en.y + 25, 180, missile_Speed2, 1);
         Missile_List.add(ms);
      }
      if (Crash(x, y, en.x, en.y, me_img, Enemy[0])) {
         // 플레이어와 적의 충돌을 판정하여 boolean값을 리턴받아 true면 아래 실행
         player_Hitpoint --; 
         Enemy_List.remove(i);
         if(player_Hitpoint==0) {
             gameOver = true;
             new End(this);
          }
         
         ex = new Explosion(en.x + Enemy[0].getWidth(null) / 2, en.y + Enemy[0].getHeight(null) / 2, 0 );
         Explosion_List.add(ex); 
         ex = new Explosion(x, y, 1 );
         Explosion_List.add(ex);
         //충돌시 플레이어의 위치에 충돌용 이펙트를 추가.
      }
      
      }
      
      if ( cnt % 300 == 0 ){ 
    	  en = new Enemy(f_width + 100, 70, enemy_speed,(int)(Math.random()*12));
          Enemy_List.add(en); 
          en = new Enemy(f_width + 450, 180,  enemy_speed,(int)(Math.random()*12));
          Enemy_List.add(en);
          en = new Enemy(f_width + 80, 290,  enemy_speed,(int)(Math.random()*12));
          Enemy_List.add(en);
          en = new Enemy(f_width + 450, 400, enemy_speed,(int)(Math.random()*12));
          Enemy_List.add(en);
          en = new Enemy(f_width + 100, 510,  enemy_speed,(int)(Math.random()*12));
          Enemy_List.add(en);  
         // 적 움직임 속도  추가하여 적 생성
         }

   }
public void ExplosionProcess(){ // 폭발 이펙트 처리용 메소드
   for (int i = 0 ;  i < Explosion_List.size(); ++i){
   ex = (Explosion) Explosion_List.get(i);
   ex.effect();
   }
}
   
public boolean Crash(int x1, int y1, int x2, int y2, Image img1, Image img2){ // 충돌 판정
   boolean check = false;

   if ( Math.abs( ( x1 + img1.getWidth(null) / 2 )  
         - ( x2 + img2.getWidth(null) / 2 ))  
         < ( img2.getWidth(null) / 2 + img1.getWidth(null) / 2 )
          && Math.abs( ( y1 + img1.getHeight(null) / 2 )  
         - ( y2 + img2.getHeight(null) / 2 ))  
         < ( img2.getHeight(null)/2 + img1.getHeight(null)/2 ) ){
	   
   check = true; 
   }else{ check = false;}
   return check; 

   }

   public void paint(Graphics g){
   buffImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
   //더블버퍼링 버퍼 크기를 화면 크기와 같게 설정
   buffg = buffImage.getGraphics(); // 버퍼의 그래픽 객체를 얻기
   update(g);
   }
   
   public void update(Graphics g) {
      Draw_Char();
      Draw_Enemy(); 
      Draw_Missile();
      
      Draw_Explosion();//폭발이펙트그리기 메소드 
      Draw_StatusText();//상태 표시 텍스트  메소드 
      g.drawImage(buffImage,0,0,this);
   }
   class con extends Thread {
		public void run() {
			while(true) {
				try {
					if(gameOver)
						break;
				    num = (int)(Math.random()*11)+1;
					if (S==1) {
						concept = concept1[num-1];
					}
					else {
						concept = concept2[num-1];
					}
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

   public void Draw_Char() {
      buffg.clearRect(0, 0,Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
      buffg.drawImage(me_img, x, y, this);
   }
   
   public void Draw_Missile(){ // 미사일
      for (int i = 0; i < Missile_List.size(); ++i){
      //미사일 존재 유무를 확인
      ms = (Missile) (Missile_List.get(i)); 
      // 미사일 위치값 확인
      if (ms.who == 0) buffg.drawImage(Missile_img, ms.x, ms.y, this); // 플레이어가 발사한 이미지 
      if (ms.who == 1)buffg.drawImage(Missile2_img, ms.x, ms.y, this); // 적이발사한이미지
      }
   }
   
   public void Draw_Enemy(){ // 적 이미지
      for (int i = 0; i < Enemy_List.size(); ++i ){
      en = (Enemy)(Enemy_List.get(i));
      buffg.drawImage(Enemy[en.num], en.x, en.y, this);
      }
   }
   
   public void Draw_Explosion(){ // 폭팔
     
      for (int i = 0 ; i < Explosion_List.size() ; ++i ){
      ex = (Explosion)Explosion_List.get(i);
   
      if (ex.damage == 0){
    
      if ( ex.ex_cnt < 7  ) { // 적 폭팔
      buffg.drawImage( Explo_img[0], ex.x - 
      Explo_img[0].getWidth(null) / 2, ex.y - 
      Explo_img[0].getHeight(null) / 2, this);
      }else if ( ex.ex_cnt < 14 ) {
      buffg.drawImage(Explo_img[1], ex.x - 
      Explo_img[1].getWidth(null) / 2, ex.y - 
      Explo_img[1].getHeight(null) / 2, this);
      }else if ( ex.ex_cnt < 21 ) {
      buffg.drawImage(Explo_img[2], ex.x - 
      Explo_img[2].getWidth(null) / 2, ex.y -
      Explo_img[2].getHeight(null) / 2, this);
      }else if( ex.ex_cnt > 21 ) {
      Explosion_List.remove(i);
      ex.ex_cnt = 0;
      }
      
      }else { // 맞았을때 
      if ( ex.ex_cnt < 7  ) {
      buffg.drawImage(Explo_img[0], ex.x + 120,
      ex.y + 15, this);
      }else if ( ex.ex_cnt < 14 ) {
      buffg.drawImage(Explo_img[1], ex.x + 60, 
      ex.y + 5, this);
      }else if ( ex.ex_cnt < 21 ) {
      buffg.drawImage(Explo_img[0], ex.x + 5,
      ex.y + 10, this);
      }else if( ex.ex_cnt > 21 ) {
      Explosion_List.remove(i);
      ex.ex_cnt = 0;
      }
     }
    }
   }
   public void Draw_StatusText(){ //상태 체크용  텍스트를 그립니다.

      buffg.setFont(new Font("Defualt", Font.BOLD, 20));
      buffg.drawString(concept , 14, 702);
      buffg.drawString("SCORE : " + game_Score, 1100, 60);
      buffg.drawString("캐릭터 체력 : " + player_Hitpoint, 1100, 80);
      buffg.drawString("speed : " + enemy_speed, 1100, 100);
    
    }
   public void KeyProcess(){
      if(KeyUp == true) {
      if( y > 20 ) y -= 5; //캐릭터가 보여지는 화면 위로 못넘어가게
      player_Status = 0;
      }

      if(KeyDown == true) {
      if( y+ me_img.getHeight(null) < f_height ) y += 5; //캐릭터가 보여지는 화면 아래로 못 넘어가게 
      player_Status = 0; //이동키가 눌려지면 플레이어 상태를 0으로 돌립니다.
      }

      if(KeyLeft == true) {
      if ( x > 0 ) x -= 5;
      player_Status = 0;
      }

      if(KeyRight == true) {
      if ( x + me_img.getWidth(null) < f_width ) x += 5;
      player_Status = 0;
      }
      }

   public void keyPressed(KeyEvent e){ // 키보드가 눌러졌을때 이벤트 처리하는 곳
      switch(e.getKeyCode()){
      case KeyEvent.VK_UP :
      KeyUp = true;
      break;
      case KeyEvent.VK_DOWN :
      KeyDown = true;
      break;
      case KeyEvent.VK_LEFT :
      KeyLeft = true;
      break;
      case KeyEvent.VK_RIGHT :
      KeyRight = true;
      break;
      
      case KeyEvent.VK_SPACE : // 스페이스키 입력 처리 추가
      KeySpace = true;
      break;
      }
   }
   
   public void keyReleased(KeyEvent e){// 키보드가 눌러졌다가 때어졌을때 이벤트 처리
      switch(e.getKeyCode()){
      case KeyEvent.VK_UP :
      KeyUp = false;
      break;
      case KeyEvent.VK_DOWN :
      KeyDown = false;
      break;
      case KeyEvent.VK_LEFT :
      KeyLeft = false;
      break;
      case KeyEvent.VK_RIGHT :
      KeyRight = false;
      break;
      case KeyEvent.VK_SPACE : // 스페이스키 입력 처리 추가
      KeySpace = false;
      break;
      }
   }
      public void keyTyped(KeyEvent e){}
   }

   class Missile { // 미사일 위치 파악 및 이동을 위한 클래스 추가 
      int x,y;
      int angle;
      int speed; //미사일 스피드 변수 
      int who;
      
      Missile(int x, int y, int angle,int speed, int who) { //미사일 좌표를 입력 
         this.x = x;
         this.y = y;
         this.angle = angle;
         this.speed = speed;
         this.who = who;
      
      }
      
      public void move(){ //미사일 이동을 위한 메소드
         x += Math.cos(Math.toRadians(angle)) * speed;
      }
   }
   
   

class Enemy{ // 적 위치 파악 및 이동을 위한 클래스
      
      int x;      
      int y;
      int speed; // 적 이동 속도 변수 
      int num;
      
      Enemy(int x, int y, int speed,int num){ 
      
      this.x = x;   
      this.y = y;
      this.speed = speed;
      this.num = num;
      
      }
      
      public void move(){ // 적 이동 속도만큼 이동 
            
      x -= speed;
      
      }
}

class Explosion {
   int x; //이미지를 그릴 x 좌표
   int y; //이미지를 그릴 y 좌표
   int ex_cnt; //이미지를 순차적으로 그리기 위한 카운터
   int damage; //이미지 종류를 구분하기 위한 변수값

   Explosion(int x, int y, int damage){
   this.x = x;
   this.y = y;
   this.damage = damage;
   ex_cnt = 0;
   }
   public void effect(){
   ex_cnt ++; //해당 메소드 호출 시 카운터를 +1 시킨다.
   }
}
