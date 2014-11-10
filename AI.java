class AI
{
	int pos,a,h;
	int[] bp = {0,0};

	public AI(int y, int ballx,int bally,int accel,int h)
	{
		this.pos = y;
		this.bp[0] = ballx;
		this.bp[1] = bally;
		this.a = accel;
		this.h = h;
	}

	public void move()
	{
		if(bp[1] > pos)
			pos -= a;
		else if(bp[1] < pos)
			pos += a;
	}

}
