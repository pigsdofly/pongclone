import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

@SuppressWarnings("serial")
class game extends JPanel 
{
	//Declarations
	public static JFrame frame;
	private static final int w = 640;
	private static final int h = 480;
	public static final int accel = h/30;

	public static int lw = w/20;
	public static int lh = h/4;
	
	public static int x = 0;
	public static int y = (h/4)+(lh/2);

	public static int x2 = (w - lw);
	public static int y2 = y;

	public static int[] score = {0,0,0};

	public static int dir;
	public static int dir2;
	
	public static ball b;
	public static bat p1;
	public static bat p2;

	//Constructor,creates ball in middle of board
	public game()
	{
		super();
		this.setBackground(Color.BLACK);
		this.setSize(w,h);

		b = new ball(w,h);

		p1 = new bat(x,y,w,h,38,40);
		p2 = new bat(x2-10,y,w,h,87,83);
		

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
		g2.fillRect(p1.x,p1.y,p1.lw,p1.lh);
		g2.fillRect(p2.x,p2.y,p2.lw,p2.lh);
		g2.fillOval(b.x-c,b.y-c,c,c);
		
		g2.drawString(game.score[1] + ":" + game.score[2],w/2,10);


	}

	
	public void checkScore()
	{
		int i = b.checkPoint();
		if(i != 0) {
			game.score[i] += 1;
			System.out.println("Player "+i+" Score:"+game.score[i]);
		}
	}

	public void gameLoop()
	{
		int step = 0;
		while(true) 
		{
			if(step %600000 == 0)
			{
				b.checkCollision(p1.lw,p2.x,p1.y,p2.y);
				checkScore();
				b.move();
				repaint();
			}
			step++;
		}
	}

	public static void main(String[] args)
	{
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(w,h);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		game g = new game();
		frame.add(g);

		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				p1.keyHandler(e.getKeyCode());
				p2.keyHandler(e.getKeyCode());
			}			
		});
		
		g.gameLoop();
	}
}
