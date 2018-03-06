package models;

import java.util.HashMap;
import java.util.Set;

public class GameData {

	private HashMap<String, CharSheet> characters = new HashMap<>();
	private String gameName;
	private HashMap<String, String> rules = new HashMap<>();

	public GameData(String name) {
		setGameName(name);
	}

	public void addCharacter(String name, CharSheet sheet) {
		characters.put(name, sheet);
	}

	public void addRule(String name, String rule) {
		rules.put(name, rule);
	}

	public String gameName() {
		return gameName;
	}

	public CharSheet getCharacter(String name) {
		return characters.get(name);
	}

	public String getRule(String name) {
		return rules.get(name);
	}

	public Set<String> listCharacters() {
		return characters.keySet();
	}

	public Set<String> listRules() {
		return rules.keySet();
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
