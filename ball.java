import java.util.*;

class ball
{
	public int x,y;
	private int circ = 25;
	public int gradx,grady;
	public ball(int x,int y)
	{
		this.x = x;
		this.y = y;
		
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


/*	public void checkCollision(int x2, int y2)
	{
		if(x2 == 0) {
			
		}
	}*/

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
