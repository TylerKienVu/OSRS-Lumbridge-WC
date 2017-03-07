package scripts;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.script.Script;

public class WalkToTrees implements Activity {
	private Script script;
	private Area treeArea = new Area(new Position(3207,3237,0),new Position(3200,3250,0));
	public String id = "WalkToTrees";
	
	public WalkToTrees(Script script) {
		this.script = script;
	}
	
	public String getID() {
		return this.id;
	}
	
	public void run() {
		script.walking.webWalk(new Position(Script.random(3200,3207),Script.random(3237,3250),0));
	}
	
	public boolean validate() {
		boolean valid = !script.inventory.isFull() && !treeArea.contains(script.myPosition()); 
		return valid;
	}
}
