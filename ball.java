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


	public void checkCollision(int x,int x2,int y, int y2)
	{
		if(this.y >= h || this.y <= 0)
			this.grady = -1;
		if(this.x == x && this.y == y) {
			this.gradx *= -1;
			this.grady *= -1;
		}
		
	}

	public int getCirc()
	{
		return circ;
	}

	public void move()
	{
		System.out.println(grady);
		x += gradx;
		y += grady;
	}

}
