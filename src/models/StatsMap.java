package models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StatsMap implements Map<String, Integer> {

	private Map<String, Integer> m;

	public StatsMap() {
		m = new HashMap<>();
	}

	@Override
	public void clear() {
		m.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return m.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return m.containsValue(value);
	}

	@Override
	public Set<Entry<String, Integer>> entrySet() {
		return m.entrySet();
	}

	@Override
	public Integer get(Object key) {
		return m.get(key);
	}

	@Override
	public boolean isEmpty() {
		return m.isEmpty();
	}

	@Override
	public Set<String> keySet() {
		return m.keySet();
	}

	@Override
	public Integer put(String key, Integer value) {
		return m.put(key, value);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Integer> m) {
		this.m.putAll(m);
	}

	@Override
	public Integer remove(Object key) {
		return m.remove(key);
	}

	@Override
	public int size() {
		return m.size();
	}

	@Override
	public Collection<Integer> values() {
		return m.values();
	}

}
