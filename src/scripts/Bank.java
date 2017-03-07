package scripts;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.Script;

public class Bank implements Activity {
	private Script script;
	private Area bankArea = new Area(new Position(3207,3220,2),new Position(3210,3215,2));
	private RS2Object bank;
	public String id = "Bank";
	
	public Bank(Script script) {
		this.script = script;
	}
	
	public String getID() {
		return this.id;
	}
	
	public void bankDeposit() throws InterruptedException {
		if(Script.random(1,5) > 4) {
			script.log("Taking random break");
			Script.sleep(Script.random(4000,7000));
		}
		this.script.getBank().depositAll();
		Script.sleep(Script.random(1000,3000));
		this.script.getBank().close();
	}
	
	public void run() throws InterruptedException {
		this.bank = this.script.objects.closest("Bank booth");
		if(!this.script.getBank().isOpen() && bank != null){ //if bank not open and bank exists
			while(!this.script.getBank().isOpen()){
				bank.interact("Bank");
				Script.sleep(Script.random(1000,1500));
			}
			this.bankDeposit();
		}
		else if(this.script.getBank().isOpen() && bank != null){ //if bank open and bank exists
			this.bankDeposit();
		}
	}
	
	public boolean validate() {
		boolean valid = bankArea.contains(script.myPosition()) && script.inventory.isFull();
		return valid;
	}
}
