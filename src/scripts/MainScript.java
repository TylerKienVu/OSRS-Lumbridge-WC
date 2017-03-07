//This is going to be a simple woodcutting bot for lumbridge in OSRS

package scripts;

import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/* Things to implement:
 * Bank
 * WalkToTrees
 * Features to implement:
 * Randomized Patterns of Interaction
 * Randomized Smart Breaks
 */

@ScriptManifest(author = "Tylersobored", info = "A simple woodcutting script", name = "Lumbridge Woodcutter", version = 0, logo = "")

public class MainScript extends Script {
	private ArrayList<Activity> activities = new ArrayList<Activity>();
	private TaskManager taskmanager;
	
	@Override
	public void onStart() {
		log("Let's hack some trees!");
		Collections.addAll(activities, new CutTree(this), new WalkToBank(this), new Wait(this));
		this.taskmanager = new TaskManager(activities,this);
	}
	
	@Override
	public int onLoop() throws InterruptedException {
		taskmanager.getActive().run();
		return Script.random(500, 700);
	}
	
	@Override
	public void onExit() {
		log("We are done hacking for today...");
	}
	
	@Override
	public void onPaint(Graphics2D g) {
		
	}
}