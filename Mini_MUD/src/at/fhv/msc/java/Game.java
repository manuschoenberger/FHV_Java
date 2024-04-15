package at.fhv.msc.java;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Game implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static Game _instance;
	
	private Map _map;
	private Player _player;
	private LinkedList<Player> _players;
	private SaveGame _save;
	
	private Game() {
		_map = Map.instance();
		_player = new Player();
		_players = new LinkedList<Player>();
	}
	
	public static Game instance() {
		if (_instance == null) {
			_instance = new Game();
		}
		return _instance;
	}
	
	public void login(Player player) {
		_players.add(player);
	}
	
	public String save() {
		_save = new SaveGame(_instance);
		String output = _save.saveGame();
		return output;
	}
	
	public String load() {
		_save = SaveGame.loadGame();
		if (_save != null) {
			_map = _save.getGame().getMap();
			_player = _save.getGame().getPlayer();
			_players = _save.getGame().getPlayers();
			return "Game loaded succesfully!";
		}

		return "ERROR: Game could not be loaded";
	}

	public static void main(String[] args) {
		Game game;
		
		System.out.println("Would you like to load your recent save-game? y/n");
		
		Scanner scanner0 = new Scanner(System.in);
		String choiceLoad = scanner0.next();
//		scanner0.close();
		
		if (choiceLoad.equals("y")) {
			game = Game.instance();
			System.out.println(game.load());
		} else {
			game = Game.instance();
		}
		
		Player player = game.getPlayer();
		game.login(player);
		System.out.println(player.spawn());

		Player npc = new Player();
		game.login(npc);
        npc.setCurrentPosition(game.getMap().getCell05());
		
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		Scanner scanner3 = new Scanner(System.in);
		
		while (true) {
 
	        System.out.println("\nWhat would you like to do?");
	        System.out.println("'north':\tMove north");
	        System.out.println("'east':\t\tMove east");
	        System.out.println("'south':\tMove south");
	        System.out.println("'west':\t\tMove west");
	        System.out.println("'inventory':\tShow inventory");
	        System.out.println("'use':\t\tUse an item");
	        System.out.println("'drop':\t\tDrop an Game");
	        System.out.println("'exit':\t\tExit Game");
	        System.out.println("'check':\tList all player IDs in cell");

	        String choice = scanner1.next();

	        switch (choice) {
	        case "exit":
	        	System.out.println("\nDo you want to exit the game? y/n");
	        	choice = scanner2.nextLine();
	        	if (choice.equals("y")) {
	        		System.out.println("\nGame closed!");
//	            	scanner1.close();
//	            	scanner2.close();
//	            	scanner3.close();
	        		System.exit(0);
	        	}
	        	break;
	        case "north":
                System.out.println(player.getCurrentPosition().enter(player, "N")); 
                break;
            case "east":
            	System.out.println(player.getCurrentPosition().enter(player, "E"));                
            	break;
            case "south":
            	System.out.println(player.getCurrentPosition().enter(player, "S"));                
            	break;
            case "west":
            	System.out.println(player.getCurrentPosition().enter(player, "W"));                
            	break;
            case "inventory":
            	if (player.getInventory().getItems().isEmpty()) {
            		System.out.println("\nInventory empty");
            	} else {
            		System.out.println("\nInventory:");
	                for (Item item : player.getInventory().getItems()) {
	                	System.out.println("> " + item.getItemName());
	                }
            	}
            	break;
            case "use":
            	if (player.getInventory().getItems().isEmpty()) {
            		System.out.println("\nNothing to use, inventory empty!");
            		break;
            	} else {
                    System.out.println("\n\nWhich item would you like to use?");
	                for (Item item : player.getInventory().getItems()) {
	                	System.out.println("> " + item.getItemName());
	                }
            	}
            	
                choice = scanner3.nextLine();
                boolean breakValue = false;
                
                for (Item item : player.getInventory().getItems()) {
                    if (item.getItemName().equals(choice.toString())) {
                    	System.out.println(item.use(player));
                    	breakValue = true;
                        if (player.getCurrentHealth() <= 0) {
                	        System.out.println("You died.");
                	        System.exit(0);
                        }
                        break;
                    }
                }
                
                if (breakValue == false) {
	                System.out.println("Item has not been found!");	                	
                }
                break;
            case "drop":
	          	if (player.getInventory().getItems().isEmpty()) {
	          		System.out.println("\nNothing to drop, inventory empty!");
	          		break;
	          	} else {
	                  System.out.println("\n\nWhich item would you like to drop?");
		                for (Item item : player.getInventory().getItems()) {
		                	System.out.println("> " + item.getItemName());
		                }
	          	}
	          	
				choice = scanner3.nextLine();
				
				for (Item item : player.getInventory().getItems()) {
				    if (item.getItemName().equals(choice.toString())) {
				    	player.getCurrentPosition().addItem(item);
				        System.out.println(item.remove(player));
				    }
				}
                break;
            case "check":
            	for (Player players : game.getPlayers()) {
            		if (players.getCurrentPosition().getCellName().equals(player.getCurrentPosition().getCellName())) {
            			System.out.println("Player found:\t" + "ID: " + players.getPlayerID());
            		}
            	}
            	break;
            case "print":
            	System.out.println(game.getMap().printAllCells()); 
            	break;
	        case "save":
	        	scanner1.reset();
	        	System.out.println(game.save());
	        	break;
            default:
                System.out.println("Invalid choice.");
	        }
		}
	}
	
	//GETTER/SETTER:

	public Map getMap() {
		return _map;
	}

	public void setMap(Map map) {
		_map = map;
	}

	public Player getPlayer() {
		return _player;
	}

	public void setPlayer(Player player) {
		_player = player;
	}

	public LinkedList<Player> getPlayers() {
		return _players;
	}

	public void setPlayers(LinkedList<Player> players) {
		_players = players;
	}

	public static Game getInstance() {
		return _instance;
	}

	public static void setInstance(Game _instance) {
		Game._instance = _instance;
	}

	@Override
	public String toString() {
		return "Game [_map=" + _map + ", _player=" + _player + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
