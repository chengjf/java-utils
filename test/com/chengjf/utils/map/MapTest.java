package com.chengjf.utils.map;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/**
 * Map常用方法。<br/>
 * 包括遍历，修改，删除。<br/>
 *
 * @author chengjianfeng
 * @date 2016-07-08
 * @version 1.0.0
 */
public class MapTest {

	private static Map<String, String> map;

	private static void initMap() {
		map = new HashMap<String, String>();
		map.put("a", "AKKE");
		map.put("b", "Burning");
		map.put("c", "farreri_430");
	}

	public static void main(String[] args) {
		traverseByEntrySet();
		traverseByKeySet();
		traverseByKeySetIterator();
		traverseByEntrySetIterator();
	}

	/**
	 * 使用{@link Map.EntrySet}进行遍历和修改value<br/>
	 * 循环内无法删除，会抛出异常 {@link ConcurrentModificationException}<br/>
	 * 可以将key保存，退出循环后调用 {@link Map#remove(Object)}进行删除
	 */
	private static void traverseByEntrySet() {
		System.out.println("========traverseByEntrySet=======");
		initMap();
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
			entry.setValue(((Long) new Random().nextLong()).toString());
			// map.remove(entry.getKey());
		}
		// after modify
		List<String> keys = new ArrayList<String>();
		System.out.println("--------after modify--------");
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
			keys.add(entry.getKey());
		}
		// remove
		for (String key : keys) {
			map.remove(key);
		}
		// after remove
		System.out.println("--------after remove--------");
		System.out.println("map's size is " + map.size());
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

	}

	/**
	 * 通过{@link Map#keySet()}进行遍历<br/>
	 * 循环内无法删除，会抛出异常 {@link ConcurrentModificationException}<br/>
	 * 可以将key保存，退出循环后调用 {@link Map#remove(Object)}进行删除
	 */
	private static void traverseByKeySet() {
		System.out.println("========traverseByKeySet=======");

		initMap();
		for (String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
			map.put(key, ((Long) new Random().nextLong()).toString());
			// map.remove(key);
		}
		System.out.println("--------after modify--------");
		List<String> keys = new ArrayList<String>();
		for (String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
			keys.add(key);
		}
		// remove
		for (String key : keys) {
			map.remove(key);
		}
		System.out.println("--------after delete--------");
		System.out.println("map's size is " + map.size());
		for (String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
	}

	/**
	 * 通过{@link Map#entrySet()}的{@code Set#iterator()} 进行遍历<br/>
	 * 循环内可以调用{@code Iterator#remove()}方法删除
	 */
	private static void traverseByEntrySetIterator() {
		System.out.println("========traverseByKeySetIterator=======");

		initMap();
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
			entry.setValue(((Long) new Random().nextLong()).toString());
		}
		iterator = map.entrySet().iterator();
		System.out.println("--------after modify--------");
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
			iterator.remove();
		}
		// remove
		iterator = map.entrySet().iterator();
		System.out.println("--------after delete--------");
		System.out.println("map's size is " + map.size());
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	/**
	 * 通过{@link Map#keySet()}的{@code Set#iterator()} 进行遍历<br/>
	 * 循环内可以调用{@code Iterator#remove()}方法删除
	 */
	private static void traverseByKeySetIterator() {
		System.out.println("========traverseByEntrySetIterator=======");

		initMap();
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " " + map.get(key));
			map.put(key, ((Long) new Random().nextLong()).toString());
		}
		iterator = map.keySet().iterator();
		System.out.println("--------after modify--------");
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " " + map.get(key));
			iterator.remove();
		}
		// remove
		iterator = map.keySet().iterator();
		System.out.println("--------after delete--------");
		System.out.println("map's size is " + map.size());
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " " + map.get(key));
		}
	}

}
