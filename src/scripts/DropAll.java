package scripts;
import org.osbot.rs07.script.Script;


public class DropAll implements Activity {
	private final Script script;
	
	public DropAll(Script script){
		this.script = script;
	}
	
	public void run() throws InterruptedException {
		script.inventory.dropAll();
		Script.sleep(Script.random(500,1000));
	}
	
	public boolean validate(){
		boolean valid = !script.inventory.isEmpty() && !script.myPlayer().isAnimating();
		return valid;
	}
}
