package com.dsa.questions.medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class DesignLRUCache {

  /**
   * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
   * <p>
   * Implement the LRUCache class:
   * <p>
   * LRUCache(int capacity) Initialize the LRU cache with positive size capacity. int get(int key)
   * Return the value of the key if the key exists, otherwise return -1. void put(int key, int
   * value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the
   * cache. If the number of keys exceeds the capacity from this operation, evict the least recently
   * used key. The functions get and put must each run in O(1) average time complexity.
   */
  public static void main(String[] args) {

    // Create an LRU cache with a capacity of 2
    LRUCache cache = new LRUCache(2);

    // Insert key-value pairs into the cache
    cache.put(1, 1);
    cache.put(2, 2);

    // Retrieve and print the value associated with key 1 (expected output: 1)
    System.out.println(cache.get(1));

    // Insert a new key-value pair into the cache
    cache.put(3, 3);

    // Retrieve and print the value associated with key 2 (expected output: -1, as it has been evicted)
    System.out.println(cache.get(2));

    // Insert a new key-value pair into the cache
    cache.put(4, 4);

    // Retrieve and print the value associated with key 1 (expected output: -1, as it has been evicted)
    System.out.println(cache.get(1));

    // Retrieve and print the value associated with key 3 (expected output: 3)
    System.out.println(cache.get(3));

    // Retrieve and print the value associated with key 4 (expected output: 4)
    System.out.println(cache.get(4));
  }

  /*
  Access order: Starting from Java 8, LinkedHashMap can be constructed to maintain the order based on access
  (the most recently accessed entry is moved to the end of the list). This is useful in implementing LRU caches.
  In access-order mode, when an element is accessed (via get or put operations),
   it is moved to the end of the list. This feature is particularly useful in implementing LRU (Least Recently Used) caches.
     // Create a LinkedHashMap with initial capacity 10, load factor 0.75, and access-order mode
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(10, 0.75f, true);
   */
  private static class LRUCache {

    //LinkedHashMap because it provides us with the ability to maintain the order of entries based on access.
    //The access order is determined by the last accessed entry being moved to the end of the map.
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
      cache = new LinkedHashMap<Integer, Integer>(capacity, 0.7f, true) {
        protected boolean removeEldestEntry(Map.Entry eldest) {
          return size() > capacity;
        }
      };
    }
    public int get(int key) {
      return cache.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
      cache.put(key, value);
    }
  }
}