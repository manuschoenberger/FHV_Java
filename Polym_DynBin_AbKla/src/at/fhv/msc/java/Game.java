package at.fhv.msc.java;

import java.util.LinkedList;

public class Game {
	
	private LinkedList<Creature> _creatures;
	
	public Game () {
		_creatures = new LinkedList<>();
	}
	
	public void addCreature(Creature creature) {
		_creatures.add(creature);
	}

	public static void main(String[] args) {
		Game g = new Game();
		
		Creature c1 = new Donkey();
		Creature c2 = new Cow();
		Creature c3 = new Player();
		
		g._creatures.add(c1);
		g._creatures.add(c2);
		g._creatures.add(c3);
		
		for (Creature creature : g._creatures) {
			creature.speak();
		}
		
		Beast b1 = new Donkey();
		
		b1.speak();

	}

}
