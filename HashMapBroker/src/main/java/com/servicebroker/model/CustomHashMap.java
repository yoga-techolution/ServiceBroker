package com.servicebroker.model;

import org.springframework.stereotype.Component;

/**
 * Custom Hashmap implementation
 * @author Yoga Chandran
 *
 * @param <K>
 * @param <V>
 */
@Component
public class CustomHashMap<K,V> {

	private int DEFAULT_BUCKET_SIZE = 10;
	
	private Entry<K, V>[] buckets;
	
	public CustomHashMap()
	{
		buckets = new Entry[DEFAULT_BUCKET_SIZE]; 
	}
	
	public CustomHashMap(int capacity){
		buckets = new Entry[capacity];
	}
	
	public V get(K key){
		
		try {
			throwIfKeyIsNull(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Entry<K, V> entry = buckets[getBucketIndexForKey(key)];
		while(entry!=null && !key.equals(entry.getKey())){
			entry = entry.getNext();
		}
		return entry!= null ? entry.getValue() : null;
	}
	
	private void throwIfKeyIsNull(K key) throws Exception{	
		if(key == null)
			throw new NullPointerException("Key cannot be null");
	}
	
	public void put(K key, V value){
		
		try {
			throwIfKeyIsNull(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int bucketIndex = getBucketIndexForKey(key);
		Entry<K, V> entry = buckets[bucketIndex];
		if(null!=entry){
			boolean isUpdated = false;
			while(!isUpdated){
				if(key.equals(entry.getKey())){
					entry.setValue(entry.getValue());
					isUpdated = true;
				}
				else if(entry.getNext() == null){
					Entry<K, V> temp = new Entry<K, V>(key, value);
					entry.setNext(temp);
					isUpdated = true;
				}
				entry = entry.getNext();
			}
		}
		else{
			buckets[bucketIndex] = new Entry<K, V>(key, value);
		}
	}
	
	public boolean remove(K key){
		try {
			throwIfKeyIsNull(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Entry<K, V> entry = buckets[getBucketIndexForKey(key)];
		boolean isRemoved = false;
		while(!isRemoved){
			if(entry!=null && key.equals(entry.getKey())){
				Entry<K, V> temp = entry.getNext();
				entry.setNext(temp);
				isRemoved = true;
			}
		}
		return isRemoved;
	}
	
	public int getBucketIndexForKey(K key){
		
		int bucketIndex = key.hashCode() % buckets.length;
		return bucketIndex;
	}
	
}
