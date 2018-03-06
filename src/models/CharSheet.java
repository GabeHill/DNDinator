package models;

import java.util.Map;
import java.util.Set;

import enums.Alignment;
import enums.Currency;
import enums.Stat;

public class CharSheet {
	private Alignment alignment;
	private Map<String, Integer> counters;
	private boolean milestoneLeveling = false;
	private Map<Currency, Integer> money;
	private String occupation, playerName, characterName, background, race;
	private Map<String, String> spells, items, otherData;
	private StatsMap stats, bonuses;
	private int xp = 0, level = 1;

	/**
	 * Creates the object. Sets default values.
	 */
	public CharSheet() {
		for (Currency c : Currency.values()) {
			money.put(c, 0);
		}
	}

	/**
	 *
	 * @param itemName
	 * @param desc
	 *
	 *            Assigns itemName as the key to desc in the items Hashmap.
	 */
	public void addItem(String itemName, String desc) {
		items.put(itemName, desc);
	}

	/**
	 *
	 * @param name
	 * @param desc
	 *
	 *            Adds data with name as the key and desc as the value.
	 */
	public void addOtherData(String name, String desc) {
		otherData.put(name, desc);
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
	 * @param counter
	 * @param changeBy
	 *
	 *            Uses counter parameter to access the appropriate counter and
	 *            change it by changeBy.
	 */
	public void changeCounter(String counter, int changeBy) {
		Integer a = counters.get(counter);
		a += changeBy;
		counters.remove(counter);
		counters.put(counter, a);
	}

	/**
	 *
	 * @param piece
	 * @param money
	 *
	 *            String (eg. "CP") is used to determine the piece. Money is by how
	 *            much you change it.
	 */
	public void changeMoney(Currency piece, int money) {
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

	/**
	 *
	 * @param name
	 * @return counter value
	 *
	 *         Returns the value associated with name.
	 */
	public int getCounter(String name) {
		return counters.get(name);
	}

	/**
	 *
	 * @param name
	 * @return desc.
	 *
	 *         Returns the description of the item associated with name.
	 */
	public String getItem(String name) {
		return items.get(name);
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
	public int getMoney(Currency piece) {
		return money.get(piece);
	}

	/**
	 *
	 * @return Character's occupation
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 *
	 * @param name
	 * @return desc.
	 *
	 *         Returns the data associated with the inputted string.
	 */
	public String getOtherData(String name) {
		return otherData.get(name);
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

	/**
	 *
	 * @return Set of spell name Strings.
	 */
	public Set<String> getSpellsList() {
		return spells.keySet();
	}

	/**
	 *
	 * @param s
	 * @return Stat value
	 *
	 *         Takes in a Stat and returns the value associated with it for the
	 *         character.
	 */
	public int getStats(Stat s) {
		return stats.get(s.toString());
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
	 * @param name
	 * @param changeBy
	 *
	 *            Modifies counter name by changeBy.
	 */
	public void modifyCounter(String name, int changeBy) {

		Integer a = counters.get(name);
		a += changeBy;
		counters.remove(name);
		counters.put(name, a);
	}

	/**
	 *
	 * @param name
	 *
	 *            Removes counter name.
	 */
	public void removeCounter(String name) {
		counters.remove(name);
	}

	/**
	 *
	 * @param itemName
	 *
	 *            Removes itemName from the Items HashMap.
	 */
	public void removeItem(String itemName) {
		items.remove(itemName);
	}

	/**
	 *
	 * @param name
	 *
	 *            Removes the desc. associated with name.
	 */
	public void removeOtherData(String name) {
		otherData.remove(name);
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

	/**
	 *
	 * @param bonus
	 * @param changeBy
	 *
	 *            Uses bonus to change the appropriate bonus by changeBy.
	 */
	public void setBonus(Stat bonus, int changeBy) {
		Integer a = bonuses.get(bonus);
		a += changeBy;
		stats.remove(bonus);
		stats.put(bonus, a);
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

	/**
	 *
	 * @param statName
	 * @param changeBy
	 *
	 *            Uses statName to change the appropriate stat by changeBy.
	 */
	public void setStat(Stat statName, int changeBy) {
		Integer a = stats.get(statName);
		a += changeBy;
		stats.remove(statName);
		stats.put(statName, a);
	}

}
