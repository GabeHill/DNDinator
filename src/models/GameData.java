package models;

import java.util.HashMap;
import java.util.Set;

public class GameData {

	private HashMap<String, CharSheet> characters = new HashMap<>();
	private String gameName;
	private HashMap<String, String> rules = new HashMap<>();

	/**
	 *
	 * @param name
	 *
	 *            Sets the name of the current game the parameter.
	 */
	public GameData(String name) {
		setGameName(name);
	}

	/**
	 *
	 * @param sheet
	 *
	 *            Add character to the characters HashMap with the key being the
	 *            character's name.
	 */
	public void addCharacter(CharSheet sheet) {
		characters.put(sheet.getCharacterName(), sheet);
	}

	/**
	 *
	 * @param name
	 * @param rule
	 *
	 *            Adds rule 'name' to the rules HashMap.
	 */
	public void addRule(String name, String rule) {
		rules.put(name, rule);
	}

	/**
	 *
	 * @return Current game's name.
	 */
	public String gameName() {
		return gameName;
	}

	/**
	 *
	 * @param name
	 * @return
	 *
	 * 		Returns the character sheet associated with name, or null if there is
	 *         no character sheet.
	 */
	public CharSheet getCharacter(String name) {
		return characters.get(name);
	}

	/**
	 *
	 * @param name
	 * @return
	 *
	 * 		Returns the rule description assicated with name, or null if there is
	 *         no rule by that name.
	 */
	public String getRule(String name) {
		return rules.get(name);
	}

	/**
	 *
	 * @return Set of character names.
	 */
	public Set<String> listCharacters() {
		return characters.keySet();
	}

	/**
	 *
	 * @return Set of rule names.
	 */
	public Set<String> listRules() {
		return rules.keySet();
	}

	/**
	 *
	 * @param name
	 *
	 *            Removes the character at name.
	 */
	public void removeCharacter(String name) {
		characters.remove(name);
	}

	/**
	 * 
	 * @param name
	 * 
	 *            Removes the rule at name.
	 */
	public void removeRule(String name) {
		rules.remove(name);
	}

	/**
	 * 
	 * @param name
	 * 
	 *            Used to change the game name.
	 */
	public void setGameName(String name) {
		gameName = name;
	}

}
