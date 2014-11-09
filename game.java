import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

class game extends JPanel 
{
	//Declarations
	public static JFrame frame;
	private static int w = 640;
	private static int h = 480;

	public static int lw = h/20;
	public static int lh = h/4;
	
	public static int x = 0;
	public static int y = (h/4)+(lh/2);

	public static int x2 = (w - lw);
	public static int y2 = y;

	public static int[] score = {0,0,0};

	public static int dir;
	public static int dir2;
	
	public static ball b;

	//Constructor,creates ball in middle of board
	public game()
	{
		super();
		this.setBackground(Color.BLACK);
		this.setSize(w,h);

		System.out.println(lw+", "+x2);

		b = new ball(w,h);

	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int c = b.getCirc();

		/*System.out.println(x+", "+y+", "+x2+", "+y2);*/
		g2.setColor(new Color(0xDCDCDC));//colouring the pieces white

		//drawing two 'bats' and ball
		g2.fillRect(x,y,lw,lh);
		g2.fillRect(x2-10,y2,lw,lh);
		g2.fillOval(b.x-c,b.y-c,c,c);


	}

	public static void move()
	{
		if(y <= 0 && dir<0 ) { //if collision with edge
			dir=0;
		}
		if(y >= (h-lh-lw) &&dir >0) {
			dir=0;
			y = h-lh-lw;
		}

		if(y2 <= 0 && dir2<0) {
			dir2=0;
		}
		if(y2 >= (h-lh-lw) && dir2>0) {
			dir2=0;
			y2 = h-lh-lw;
		}
	
		y+=dir;
		y2+=dir2;
	}

	public static void keyHandlerP1(int kC)
	{
		if(kC == 38) //Arrow key up
			dir = -10;
		else if(kC == 40) //Arrow key down
			dir = 10;
		else
			dir = 0;
		move();
	}	
	public static void keyHandlerP2(int kC)
	{
		if(kC == 87) //W
			dir2 = -10;
		else if(kC == 83) //S
			dir2 = 10;
		else 
			dir2 = 0;
		move();
	}

	public static void main(String[] args)
	{
		int step = 0;
		int i = 0;
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(w,h);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		game g = new game();
		frame.add(g);

		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				keyHandlerP1(e.getKeyCode());
			}			
		});
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) { //Still not really working
				keyHandlerP2(e.getKeyCode());
			}			
		});

		while(true) 
		{
			if(step %600000 == 0)
			{
				b.checkCollision(lw,x2,y,y2);
				i = b.checkPoint();
				if(i != 0) {
					game.score[i] += 1;
					System.out.println("Player "+i+" Score:"+game.score[i]);
				}
				b.move();
				g.repaint();
			}
			step++;
		}
	}
		
}
