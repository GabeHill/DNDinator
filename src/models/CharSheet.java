package models;

import java.util.Map;
import java.util.Set;

import enums.Alignment;

public class CharSheet {
	private Alignment alignment;
	private boolean milestoneLeveling = false;
	private Map<String, Integer> money, counters;
	private String occupation, playerName, characterName, background, race;
	private Map<String, String> spells, items, otherData;
	private StatsMap stats, bonuses;
	private int xp = 0, level = 1;

	/**
	 * Creates the object. Does nothing more.
	 */
	public CharSheet() {

	}

	/**
	 *
	 * @param xp
	 *
	 *            Takes in the XP amount to add.
	 */
	public void addXp(int xp) {
		this.xp += xp;
	}

	/**
	 *
	 * @param alignment
	 *
	 *            Changes the alignment of the character to the inputted alignment.
	 */
	public void changeAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	/**
	 *
	 * @param piece
	 * @param money
	 *
	 *            String (eg. "CP") is used to determine the piece. Money is by how
	 *            much you change it.
	 */
	public void changeMoney(String piece, int money) {
		Integer i = this.money.get(piece).intValue();
		i += money;
		if (i < 0) {
			i = 0;
		}
		this.money.remove(piece);
		this.money.put(piece, i);
	}

	/**
	 *
	 * @return Character's alignment
	 */
	public Alignment getAlignment() {
		return alignment;
	}

	/**
	 *
	 * @return Character's background
	 */
	public String getBackground() {
		return background;
	}

	/**
	 *
	 * @return bonuses StatsMap
	 */
	public StatsMap getBonuses() {
		return bonuses;
	}

	/**
	 *
	 * @return Character's name
	 */
	public String getCharacterName() {
		return characterName;
	}

	public Map<String, Integer> getCounters() {
		// TODO
		return counters;
	}

	public Map<String, String> getItems() {
		// TODO

		return items;
	}

	/**
	 *
	 * @return Character's level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 *
	 * @param piece
	 * @return number of pieces
	 *
	 *         Uses piece to access the number of that piece of currency.
	 */
	public int getMoney(String piece) {
		return money.get(piece);
	}

	/**
	 *
	 * @return Character's occupation
	 */
	public String getOccupation() {
		return occupation;
	}

	public Map<String, String> getOtherData() {
		// TODO

		return otherData;
	}

	/**
	 *
	 * @return Player's name
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 *
	 * @return Character's race
	 */
	public String getRace() {
		return race;
	}

	/**
	 *
	 * @param spell
	 * @return Spell data
	 *
	 *         Takes in a spell name and return the description for that spell.
	 */
	public String getSpell(String spell) {
		return spells.get(spell);
	}

	public Set<String> getSpellsList() {
		return spells.keySet();
	}

	public StatsMap getStats() {
		// TODO
		return stats;
	}

	/**
	 *
	 * @return Character's XP
	 */
	public int getXp() {
		return xp;
	}

	/**
	 *
	 * @return
	 *
	 * 		Returns whether character is milestone based or not.
	 */
	public boolean isMilestoneLeveling() {
		return milestoneLeveling;
	}

	/**
	 *
	 * @param levelBy
	 *
	 *            Levels character up by the levelBy parameter.
	 */
	public void levelUp(int levelBy) {
		level += level;
	}

	/**
	 *
	 * @param background
	 *
	 *            Sets character's background to the provided background parameter.
	 */
	public void setBackground(String background) {
		this.background = background;
	}

	public void setBonuses(StatsMap bonuses) {
		// TODO
		this.bonuses = bonuses;
	}

	/**
	 *
	 * @param characterName
	 *
	 *            Sets character's name to the provided parameter.
	 */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public void setCounters(Map<String, Integer> counters) {
		this.counters = counters;
		// TODO

	}

	public void setItems(Map<String, String> items) {
		// TODO
		this.items = items;
	}

	/**
	 *
	 * @param milestoneLeveling
	 *
	 *            Sets the character to milestone leveling.
	 */
	public void setMilestoneLeveling(boolean milestoneLeveling) {
		this.milestoneLeveling = milestoneLeveling;
	}

	/**
	 *
	 * @param occupation
	 *
	 *            Sets the character's occupation to the provided parameter.
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/**
	 *
	 * @param playerName
	 *
	 *            Sets the character's player name to the provided parameter.
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 *
	 * @param race
	 *
	 *            Sets the character's race to the provided parameter.
	 */
	public void setRace(String race) {
		this.race = race;
	}

	public void setStats(StatsMap stats) {
		// TODO
		this.stats = stats;
	}

}
