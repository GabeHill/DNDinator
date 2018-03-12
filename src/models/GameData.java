package models;

import java.util.HashMap;
import java.util.Set;

public class GameData {

	private HashMap<String, CharSheet> characters = new HashMap<>();
	private String gameName = "Game";
	private String rules = "";

	/**
	 *
	 * @param name
	 *
	 *            Sets the name of the current game parameter.
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
	 * @param rule
	 * @param rule
	 *
	 *            Adds rule 'name' to the rules HashMap.
	 */
	public void addRule(String rule) {
		rules += rule + "/n";
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
	public String getRules() {
		return rules;
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
	 *            Used to change the game name.
	 */
	public void setGameName(String name) {
		gameName = name;
	}

	/**
	 *
	 * @param rules
	 *
	 *            Sets class rules to parameter rules.
	 */
	public void setRules(String rules) {
		this.rules = rules;
	}

}
