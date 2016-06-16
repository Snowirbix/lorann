package contract;

public interface IHero {
	public void addOrder(ControllerOrder order);
	public void removeOrder(ControllerOrder order);
	public boolean isOrder(ControllerOrder order);
	public void setDirection(int x, int y);
	public void attack();
}
