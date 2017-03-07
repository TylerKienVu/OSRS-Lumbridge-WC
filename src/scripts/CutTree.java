package scripts;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.utility.ConditionalSleep;

public class CutTree implements Activity{
	private Script script;
	private RS2Object tree;
	private Area treeArea = new Area(new Position(3207,3237,0),new Position(3200,3250,0));
	public String id = "CutTree";
	
	public CutTree(Script script) {
		this.script = script;
	}
	
	public String getID() {
		return this.id;
	}
	
	public void run() throws InterruptedException {
		Script.sleep(Script.random(2000,7000));
		if(tree != null){
			if(tree.interact("Chop down")){
				new ConditionalSleep(5000) {
					@Override
					public boolean condition() throws InterruptedException {
						return tree == null;
					}
				}.sleep();
			}
		}
	}
	
	public boolean validate() {
		this.tree = script.objects.closest("Oak");
		boolean valid = tree != null && !script.myPlayer().isAnimating() && !script.inventory.isFull() && treeArea.contains(tree);
		return valid;
	}
}
