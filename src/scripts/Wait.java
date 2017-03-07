package scripts;
import org.osbot.rs07.script.Script;


public class Wait implements Activity {
	private Script script;
	
	public Wait(Script script) {
		this.script = script;
	}
	
	public void run() throws InterruptedException {
		Script.sleep(Script.random(500,700));
	}
	
	public boolean validate(){
		return script.myPlayer().isAnimating();
	}

}
