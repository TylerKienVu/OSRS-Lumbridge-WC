package scripts;


public interface Activity {
	public boolean validate() throws InterruptedException;			
	public void run() throws InterruptedException;
}
