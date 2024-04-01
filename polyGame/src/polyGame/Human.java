package polyGame;

public abstract class Human extends Unit {

	Human(String name, int hp, int power) {
		super(name, hp, power);
	}
	
	abstract void skill() ; 
	
	

}
