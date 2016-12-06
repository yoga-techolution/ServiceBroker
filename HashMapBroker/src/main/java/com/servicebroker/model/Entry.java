package com.servicebroker.model;

/**
 * User defined Entry class	
 * @author Yoga Chandran
 *
 * @param <K>
 * @param <V>
 */
public class Entry<K, V> {
	
	//Entry class to represent in Key value pair
	private Entry<K, V> next;
	
	private final K key;
	
	private V value;
	
	public Entry(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
        return key;
    }
 
    public void setValue(V value) {
        this.value = value;
    }
 
    public V getValue() {
        return value;
    }
 
    public void setNext(Entry<K, V> next) {
        this.next = next;
    }
 
    public Entry<K, V> getNext() {
        return next;
    }
	
}
