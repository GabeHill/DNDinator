package models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import enums.Alignment;
import enums.BonusStat;
import enums.Currency;
import enums.PrimaryStat;

public class CharSheet implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -3706052982620858209L;

	private static final int[] mods = { -5, -4, -4, -3, -3, -2, -2, -1, -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7,
			7, 8, 8, 9, 9, 10 };

	private Alignment alignment = Alignment.TRUE_NEUTRAL;
	private Map<String, Integer> counters = new HashMap<>();
	private boolean milestoneLeveling = false;
	private Map<Currency, Integer> money = new HashMap<>();
	private String occupation = "Failure", playerName = "Player", characterName = "Character", background = "Noob",
			race = "Nerd";
	private Map<String, String> spells = new HashMap<>(), otherData = new HashMap<>();
	private String items = "";
	private StatsMap stats = new StatsMap(), bonuses = new StatsMap();
	private int xp = 0, level = 1;

	/**
	 * Creates the object. Sets default values.
	 */
	public CharSheet() {
		for (Currency i : Currency.values()) {
			setMoney(i, 0);
		}
		for (PrimaryStat i : PrimaryStat.values()) {
			setStat(i, 0);
		}
		for (BonusStat i : BonusStat.values()) {
			setBonus(i, 0);
		}
	}

	@Override
	public String toString() {
		return characterName + ":" + playerName;
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
	 * @param s
	 * @return bonus value
	 *
	 *         Returns the bonus value assigned to the stat.
	 */
	public int getBonus(BonusStat s) {
		if (bonuses.get(s) == null) {
			return 0;
		}
		return bonuses.get(s);
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
		if (counters.get(name) == null) {
			return 0;
		}
		return counters.get(name);
	}

	/**
	 *
	 * @param name
	 * @return desc.
	 *
	 *         Returns the description of the item associated with name.
	 */
	public String getItems() {
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
	public int getMoney(Currency piece) {
		if (money.get(piece) == null) {
			return 0;
		}
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
	public int getStats(PrimaryStat s) {
		if (stats.get(s) == null) {
			return 0;
		}
		return stats.get(s);
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
	 *
	 *            Removes counter name.
	 */
	public void removeCounter(String name) {
		counters.remove(name);
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
	public void setBonus(BonusStat bonus, int num) {
		bonuses.replace(bonus, num);
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
	 * @param name
	 * @param changeBy
	 *
	 *            Modifies counter name by changeBy.
	 */
	public void setCounter(String name, int num) {
		counters.replace(name, num);

	}

	/**
	 *
	 * @param itemName
	 * @param desc
	 *
	 *            Assigns itemName as the key to desc in the items Hashmap.
	 */
	public void setItems(String items) {
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
	 * @param piece
	 * @param money
	 *
	 *            String (eg. "CP") is used to determine the piece. Money is by how
	 *            much you change it.
	 */
	public void setMoney(Currency piece, int money) {
		this.money.replace(piece, money);

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
	public void setStat(PrimaryStat statName, int num) {
		num = num > 20 ? 20 : num;

		stats.replace(statName, num);
		if (statName.ordinal() < 6) {
			for (BonusStat b : BonusStat.values()) {
				if (b.ordinal() == statName.ordinal()) {
					num = (num - 1) > 0 ? num - 1 : 1;
					setBonus(b, mods[num]);
				}
			}
		}
	}

}
