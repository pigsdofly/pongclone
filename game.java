import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

class game extends JPanel 
{
	public static JFrame frame;
	private static int w = 600;
	private static int h = 600;
	public static int lw = h/20;
	public static int lh = h/4;
	
	public static int x = 0;
	public static int y = (h/4)+(lh/2);

	public static int x2 = w - lw;
	public static int y2 = (h/4)+(lh/2);

	public static int dir;
	public static int dir2;
	
	public static ball b;

	public game()
	{
		super();
		this.setBackground(Color.BLACK);
		this.setSize(w,h);
		System.out.println(lw+", "+x2);
		b = new ball(w/2,h/2);

	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//System.out.println(x+", "+y+", "+x2+", "+y2);
		g2.setColor(new Color(0xDCDCDC));
		g2.fillRect(x,y,lw,lh);
		g2.fillRect(x2,y2,lw*2,lh);
		g2.fillOval(b.x-b.getCirc(),b.y-b.getCirc(),b.getCirc(),b.getCirc());


	}

	public static void move()
	{
		if(y <= 0 && dir<0 || y >= (h-lh) && dir>0)
			dir=0;
		if(y2 <= 0 && dir2<0 || y2 >= (h-lh) && dir2>0)
			dir2=0;
		y+=dir;
		y2+=dir2;
	}

	public static void keyHandlerP1(int kC)
	{
		if(kC == 38)
			dir = -10;
		else if(kC == 40)
			dir = 10;
		else
			dir = 0;
		move();
	}	
	public static void keyHandlerP2(int kC)
	{
		if(kC == 87)
			dir2 = -10;
		else if(kC == 83)
			dir2 = 10;
		else 
			dir2 = 0;
		move();
	}

	public static void main(String[] args)
	{
		int step = 0;
		game g = new game();
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(w,h);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(g);
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				keyHandlerP1(e.getKeyCode());
			}			
		});
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				keyHandlerP2(e.getKeyCode());
			}			
		});

		while(true) 
		{
			if(step %500000 == 0)
			{
				b.move();
				g.repaint();
			}
			step++;
		}
	}
		
}
