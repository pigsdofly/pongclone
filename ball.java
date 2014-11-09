import java.util.*;

class ball
{
	//Declarations
	public int x,y,h,w;
	public int gradx,grady;
	
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

		System.out.println(gradx+", "+grady);
	}

	private void initGrad()
	{
		Random rdm = new Random();
		this.gradx = rdm.nextInt(3) - 1;
		this.grady = rdm.nextInt(3) - 1;
		
		if(gradx == 0 && grady == 0)
		{
			initGrad(); 		
		}
	}


	public void checkCollision(int bx,int bx2,int by, int by2)
	{
		System.out.println(bx+", "+bx2+", "+by+", "+by2);
		if(this.x <= bx && this.y <= by && this.y >= (by+(h/4))) 
			reflect();
		
		
		if(this.x+circ >= bx2 && this.y <= by2 && this.y >=(by+(h/4))) 
			reflect();
		
		
		if(this.y >= h || this.y <= 0)
			this.grady *= -1;
		
	}

	public void reflect()
	{
		this.gradx*=-1;
		this.grady*=-1;
	}

	public int getCirc()
	{
		return circ;
	}

	public void move()
	{
		x += gradx;
		y += grady;
	}

}
