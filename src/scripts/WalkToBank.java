package scripts;

import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.script.Script;

public class WalkToBank implements Activity{
	private Script script;
	private Area bankArea = new Area(new Position(3207,3220,2),new Position(3210,3215,2));
	public String id = "WalkToBank";
	
	public WalkToBank(Script script) {
		this.script = script;
	}
	
	public String getID(){
		return this.id;
	}
	
	public void run() throws InterruptedException {
		script.walking.webWalk(new Position(3208,3220,2));
	}
	
	public boolean validate() {
		boolean valid = script.inventory.isFull() && !bankArea.contains(script.myPosition());
		return valid;
	}
}
