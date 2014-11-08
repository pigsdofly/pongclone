import java.util.*;

class ball
{
	public int x,y,h,w;
	private int circ = 25;
	public int gradx,grady;
	public ball(int x,int y,int h, int w)
	{
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		
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
		if(this.y >= h || this.y <= 0)
			this.grady *= -1;
		if(this.x <= bx && this.y <= by && this.y >= (by+(h/4))) {
			reflect();
		}
		if(this.x >= bx2 && this.y <= by2 && this.y >=(by+(h/4))) {
			reflect();
		}
		
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
