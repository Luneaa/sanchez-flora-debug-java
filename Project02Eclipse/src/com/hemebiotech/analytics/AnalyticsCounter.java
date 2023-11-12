package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class to manage symptoms analytics
 */
public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		// Constructor
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Gets all the symptoms from the reader
	 *
	 * @return the list of symptoms
	 */
	public List<String> getSymptoms() {
		return this.reader.getSymptoms();
	}


	/**
	 * Count the given symptoms
	 *
	 * @param symptoms the list of symptoms to count
	 *
	 * @return map of all symptoms and their count
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		HashMap<String, Integer> result = new HashMap<>();
		for (String symptom : symptoms) {
            result.putIfAbsent(symptom, 0);
			result.put(symptom, result.get(symptom) + 1);
		}

		return result;
	}

	/**
	 * Sorts a symptoms map alphabetically
	 *
	 * @param symptoms map of symptoms to sort
	 *
	 * @return sorted map of symptoms
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
	}

	/**
	 * Writes the map of symptoms
	 *
	 * @param symptoms map of symptoms to write
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		this.writer.writeSymptoms(symptoms);
	}

}