package models;

import java.util.HashMap;

public class GameData {

	private HashMap<String, CharSheet> characters = new HashMap<>();
	private String gameName;
	private HashMap<String, String> rules = new HashMap<>();

	public void addCharacter(String name, CharSheet sheet) {
		characters.put(name, sheet);
	}

	public void addRule(String name, String rule) {
		rules.put(name, rule);
	}

	public String gameName() {
		return gameName;
	}

	public void removeCharacter(String name) {
		characters.remove(name);
	}

	public void removeRule(String name) {
		rules.remove(name);
	}

	public void setGameName(String name) {
		gameName = name;
	}
}
