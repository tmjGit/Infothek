package structure;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BiMap<KeyType, ValueType> {
	private Map<KeyType, ValueType> keyToValueMap = new ConcurrentHashMap<KeyType, ValueType>();
	private Map<ValueType, KeyType> valueToKeyMap = new ConcurrentHashMap<ValueType, KeyType>();

	synchronized public void put(KeyType key, ValueType value) {
		keyToValueMap.put(key, value);
		valueToKeyMap.put(value, key);
	}

	synchronized public ValueType removeByKey(KeyType key) {
		ValueType removedValue = keyToValueMap.remove(key);
		valueToKeyMap.remove(removedValue);
		return removedValue;
	}

	synchronized public KeyType removeByValue(ValueType value) {
		KeyType removedKey = valueToKeyMap.remove(value);
		keyToValueMap.remove(removedKey);
		return removedKey;
	}

	public boolean containsKey(KeyType key) {
		return keyToValueMap.containsKey(key);
	}

	public boolean containsValue(ValueType value) {
		return keyToValueMap.containsValue(value);
//		You will significantly improve performance of containsValue() by changing it to return valueToKeyMap.containsKey(value) – 
	}

	public KeyType getKey(ValueType value) {
		return valueToKeyMap.get(value);
	}

	public ValueType get(KeyType key) {
		return keyToValueMap.get(key);
	}
}
