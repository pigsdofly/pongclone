import java.util.*;

class ball
{
	private final int circ = 25;//init circumference

	//Declarations
	public int x,y,h,w;
	public double tx, ty;
	private double gradx,grady;

	private boolean p1score,p2score;

	public ball(int w, int h)
	{
		//initialising local copies of width and height and defining 
		//startpos with them
		this.w = w;
		this.h = h;

		this.x = w/2;
		this.y = h/2;
		
		initGrad();
	}

	private double randominRange(double min, double max)
	{
		return Math.random() * (max-min)+min;//random number gen
	}

	private void initGrad()
	{
		this.gradx = randominRange(-0.75,0.75);
		this.grady = randominRange(-0.75,0.75);

		if(gradx <= 0.15 && gradx>= -0.15 || grady >=-0.15 && grady<=0.15)
			initGrad(); 		//if gradient initialized is too low
	}


	public void checkCollision(int bx,int bx2,int by, int by2)
	{	
		checkBat(bx,by);
		checkBat(bx2,by2);
		checkUpperLower();
		checkScore();
	}

	private void checkUpperLower()
	{
		if(this.y >= h || this.y-circ <= 0)
			this.grady *= -1;
	}
	
	private void checkScore()
	{
		if(this.x <= 0) {
			resetPos();
			p2score = true;
		}
		if(this.x >= w) {
			resetPos();
			p1score = true;
		}
		
	}
	private void checkBat(int bx,int by)
	{
		if(this.x == bx && this.y >= by && this.y <=(by+(h/4))) 
			reflect();
		
	}

	private void resetPos()
	{
		this.x = w/2;
		this.y = h/2;
		tx = x;
		ty = y;
		initGrad();
	}

	public int checkPoint()
	{
		if(p1score) {
			p1score = false;
			return 1;
		}
		if(p2score) {
			p2score = false;
			return 2;
		}
		else {
			p1score = false;
			p2score = false;
			return 0;
		}
	}

	public void reflect()
	{
		this.gradx*=-1;
		this.grady*=-1;
		gradx += randominRange(-0.1,0.1);
		grady += randominRange(-0.1,0.1);
		printGrad();
	}

	public void printGrad()
	{
		System.out.println(gradx+", "+grady);
	}

	public int getCirc()
	{
		return circ;
	}

	public void move()
	{
		tx += gradx;
		ty += grady;
		x = (int) tx;
		y = (int) ty;
	}

}
