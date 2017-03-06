package scripts;
//This is going to be a simple woodcutting bot for lumbridge in OSRS
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.utility.ConditionalSleep;

import java.awt.*;

@ScriptManifest(author = "Tylersobored", info = "A simple woodcutting script", name = "Lumbridge Woodcutter", version = 0, logo = "")

public class CuttingTrees extends Script {

	@Override
	public void onStart() {
		log("Let's hack some trees!");
	}
	
	private enum State {
			CUT, DROP, WAIT
	};
	
	private State getState() {
		RS2Object tree = objects.closest("Tree");
		if(!inventory.isEmpty()){
			return State.DROP;
		}
		if(tree != null){
			if(myPlayer().isAnimating()){
				return State.WAIT;
			}
			return State.CUT;
		}
		return State.WAIT;
	}
	
	@Override
	public int onLoop() throws InterruptedException {
		switch(getState()) {
		case CUT:
			if(random(1,10) > 8){
				log("Taking random break");
				sleep(random(4000,7000)); //random break
			}
			RS2Object tree = objects.closest("Tree");
			if(tree != null){
				if(tree.interact("Chop down")){
					new ConditionalSleep(5000){ //sleeps until tree is chopped, times out after 5 secs
						@Override
						public boolean condition() throws InterruptedException {
							return tree == null;
						}
					}.sleep();
				}
			}
			break;
		case DROP:
			inventory.dropAll();
			sleep(random(500,1000));
			break;
		case WAIT:
			sleep(random(500,700));
			break;
		}
		return random(200,300);
	}
	
	@Override
	public void onExit() {
		log("We are done hacking for today...");
	}
	
	@Override
	public void onPaint(Graphics2D g) {
		
	}
}