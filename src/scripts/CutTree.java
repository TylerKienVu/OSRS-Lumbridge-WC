package scripts;

import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.utility.ConditionalSleep;

public class CutTree implements Activity{
	private Script script;
	private RS2Object tree;
	public String id = "CutTree";
	
	public CutTree(Script script){
		this.script = script;
	}
	
	public String getID(){
		return this.id;
	}
	
	public void run() throws InterruptedException{
		if(Script.random(1,5) == 5){
			script.log("Taking random break");
			Script.sleep(Script.random(4000,7000)); //random break
		}
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
	
	public boolean validate(){
		this.tree = script.objects.closest("Oak");
		boolean valid = tree != null && !script.myPlayer().isAnimating() && !script.inventory.isFull();
		return valid;
	}
}
