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

	public CharSheet() {

	}

	public void addXp(int xp) {
		this.xp += xp;
	}

	public void changeAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	public void changeMoney(String piece, int money) {
		Integer i = this.money.get(piece).intValue();
		i += money;
		if (i < 0) {
			i = 0;
		}
		this.money.remove(piece);
		this.money.put(piece, i);
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public String getBackground() {
		return background;
	}

	public StatsMap getBonuses() {
		return bonuses;
	}

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

	public int getLevel() {
		return level;
	}

	public int getMoney(String piece) {
		return money.get(piece);
	}

	public String getOccupation() {
		return occupation;
	}

	public Map<String, String> getOtherData() {
		// TODO

		return otherData;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getRace() {
		return race;
	}

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

	public int getXp() {
		return xp;
	}

	public boolean isMilestoneLeveling() {
		return milestoneLeveling;
	}

	public void levelUp(int levelBy) {
		level += level;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public void setBonuses(StatsMap bonuses) {
		this.bonuses = bonuses;
	}

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

	public void setMilestoneLeveling(boolean milestoneLeveling) {
		this.milestoneLeveling = milestoneLeveling;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public void setStats(StatsMap stats) {
		// TODO
		this.stats = stats;
	}

}
