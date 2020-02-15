package ��ҵ20191122;

public class ���н��� {

	public static void main(String[] args) {
		new Supermarket();
	}
}
class Supermarket
{
	int number;
	Sole sole=new Sole(this);
	Buy buy=new Buy(this);
	public Supermarket() {
		sole.start();
		buy.start();
	}
	class Sole extends Thread
	{
		Supermarket supermarket;
		public Sole(Supermarket supermarket) {
			this.supermarket=supermarket;
		}
		public void run()
		{
			while(true)
			{
				synchronized (supermarket) {
					try {
						if(supermarket.number>0)
						{

							System.out.println("������һ����Ʒ��������Ʒ����"+(--supermarket.number));
							Thread.sleep(10);
							continue;
						}
						else
						{
							notify();
							this.wait();
						}
					} catch (Exception e) {}
				}
			}
		}
	}
	class Buy extends Thread
	{
		Supermarket supermarket;
		public Buy(Supermarket supermarket) {
			this.supermarket=supermarket;
		}
		public void run()
		{
			while(true)
			{
				synchronized (supermarket) {
					try {
						if(supermarket.number<=0)
						{
							System.out.println("����100����������Ʒ����"+(supermarket.number+=100));
							Thread.sleep(1000);
							continue;
						}
						else {
							notify();
							wait();
						}
					} catch (Exception e) {}
				}
			}
		}
	}
}