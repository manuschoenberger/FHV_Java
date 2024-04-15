package at.fhv.msc.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class SaveGame implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Game _game;
	
	public SaveGame(Game game) {
		_game = game;
	}

	public String saveGame() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:/Users/manue/eclipse-javaspace/Mini_MUD/src/at/fhv/msc/java/game.bin"));) {
			out.writeObject(this);
			return "Saving successful!";
		} catch (IOException e) {
			return e.getMessage();
		}
	}
	
	@SuppressWarnings("finally")
	public static SaveGame loadGame() {
		Object game = null;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:/Users/manue/eclipse-javaspace/Mini_MUD/src/at/fhv/msc/java/game.bin"));) {
			game = in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			return (SaveGame) game;
		}
	}

	public Game getGame() {
		return _game;
	}

	public void setGame(Game game) {
		_game = game;
	}
}
