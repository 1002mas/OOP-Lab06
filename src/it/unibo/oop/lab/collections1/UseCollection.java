package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

    private UseCollection() {
    }

    /**
     * @param s unused
     */
    public static void main(final String... s) {
	/*
	 * 1) Create a new ArrayList<Integer>, and populate it with the numbers from
	 * 1000 (included) to 2000 (excluded).
	 */
	/*
	 * 2) Create a new LinkedList<Integer> and, in a single line of code without
	 * using any looping construct (for, while), populate it with the same contents
	 * of the list of point 1.
	 */
	/*
	 * 3) Using "set" and "get" and "size" methods, swap the first and last element
	 * of the first list. You can not use any "magic number". (Suggestion: use a
	 * temporary variable)
	 */
	/*
	 * 4) Using a single for-each, print the contents of the arraylist.
	 */
	/*
	 * 5) Measure the performance of inserting new elements in the head of the
	 * collection: measure the time required to add 100.000 elements as first
	 * element of the collection for both ArrayList and LinkedList, using the
	 * previous lists. In order to measure times, use as example
	 * TestPerformance.java.
	 */
	/*
	 * 6) Measure the performance of reading 1000 times an element whose position is
	 * in the middle of the collection for both ArrayList and LinkedList, using the
	 * collections of point 5. In order to measure times, use as example
	 * TestPerformance.java.
	 */
	/*
	 * 7) Build a new Map that associates to each continent's name its population:
	 * 
	 * Africa -> 1,110,635,000
	 * 
	 * Americas -> 972,005,000
	 * 
	 * Antarctica -> 0
	 * 
	 * Asia -> 4,298,723,000
	 * 
	 * Europe -> 742,452,000
	 * 
	 * Oceania -> 38,304,000
	 */
	/*
	 * 8) Compute the population of the world
	 */
	ArrayList<Integer> array = new ArrayList<>();
	for (int i = 1000; i < 2000; i++) {
	    array.add(i);
	}

	LinkedList<Integer> linkedArray = new LinkedList<>();
	linkedArray.addAll(array);

	int n = array.get(0);
	array.set(0, array.size() - 1);
	array.set(array.size() - 1, n);

	for (Integer i : array) {
	    System.out.println(i);
	}

	// insertion performance testing
	long timeA = System.nanoTime();
	for (int i = 0; i < 100000; i++) {
	    array.add(0, i);
	}
	timeA = System.nanoTime() - timeA;

	long timeB = System.nanoTime();
	for (int i = 0; i < 100000; i++) {
	    linkedArray.addFirst(i);
	}
	timeB = System.nanoTime() - timeB;

	System.out.println("ArrayList: " + timeA + " ns");
	System.out.println("LinkedList: " + timeB + " ns");

	// reading performance testing
	System.out.println("Reading");
	int position = array.size() / 2;
	long readTimeA = System.nanoTime();
	for (int i = 0; i < 1000; i++) {
	    array.get(position);
	}
	readTimeA = System.nanoTime() - readTimeA;

	position = linkedArray.size() / 2;
	long readTimeB = System.nanoTime();
	for (int i = 0; i < 1000; i++) {
	    linkedArray.get(position);
	}
	readTimeB = System.nanoTime() - readTimeB;

	System.out.println("ArrayList: " + readTimeA + " ns");
	System.out.println("LinkedList: " + readTimeB + " ns");

	// Population
	Map<String, Long> population = new HashMap<>();
	population.put("Africa", (long) 1110635000);
	population.put("Americas", (long) 972005000);
	population.put("Antarctica", (long) 0);
	population.put("Asia", (long) 4298723000l);
	population.put("Europe", (long) 742452000);
	population.put("Oceania", (long) 38304000);

	long pop = 0;
	for (Entry<String, Long> row : population.entrySet()) {
	    pop += row.getValue();
	}
	System.out.println("Population: " + pop);
    }
}
