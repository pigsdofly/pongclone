import java.util.*;

class ball
{
	//Declarations
	public int x,y,h,w;
	public double tx, ty;
	private double gradx,grady;


	private boolean p1score,p2score;
	
	private int circ = 25;//init circumference

	public ball(int w, int h)
	{
		//initialising local copies of width and height and defining 
		//startpos with them
		this.w = w;
		this.h = h;

		this.x = w/2;
		this.y = h/2;
		
		initGrad();

		System.out.println(gradx+", "+grady+", "+x+", "+y);
	}

	private double randominRange(double min, double max)
	{
		return Math.random() * (max-min)+min;
	}

	private void initGrad()
	{
		this.gradx = randominRange(-0.75,0.75);
		this.grady = randominRange(-0.75,0.75);


		if(gradx <= 0.15 && gradx>= -0.15 || grady >=-0.15 && grady<=0.15)
			initGrad(); 		
		System.out.println(gradx+", "+grady);
	}


	public void checkCollision(int bx,int bx2,int by, int by2)
	{
	//	System.out.println(bx+", "+bx2+", "+by+", "+by2);
		if(this.x >= bx2 && this.y >= by2 && this.y <= (by2+(h/4))) 
			reflect();
		
		
		if(this.x <= bx && this.y >= by && this.y <=(by+(h/4))) 
			reflect();
		
		
		if(this.y >= h || this.y-circ <= 0)
			this.grady *= -1;
		
		if(this.x <= 0) {
			resetPos();
			p2score = true;
		}
		if(this.x >= w) {
			resetPos();
			p1score = true;
		}
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
		if(gradx <0)
			gradx -= 0.1;
		else
			gradx += 0.1;
		if(grady<0)
			grady -=0.1;
		else
			grady += 0.1;
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
