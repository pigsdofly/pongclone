class bat
{
	public int x, y,lh,lw,h,w;
	private int key1,key2;
	public int dir;
	public int accel = h/30;

	public bat(int x, int y,int w,int h,int k1,int k2)
	{
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		this.key1 = k1;
		this.key2 = k2;
		
		lw = w/20;
		lh = h/4;
		accel=h/30;

	}

	public void keyHandler(int kC)
	{
		System.out.println("I am being called");
		if(kC == key1)
			dir = -accel;
		else if(kC == key2)
			dir = accel;
		else
			dir = 0;
		move();
	}

	public void move()
	{
		if(y <= 0 && dir<0)
			dir=0;
		if(y >= (h-lh-lw) && dir>0){
			dir=0;
			y=(h-lh-lw);
		}
		y+=dir;
	}
}
