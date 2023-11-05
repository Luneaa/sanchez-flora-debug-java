package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		// Constructor
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return this.reader.GetSymptoms();
	}
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		HashMap<String, Integer> result = new HashMap<>();
		for (String symptom : symptoms) {
            result.putIfAbsent(symptom, 0);
			result.put(symptom, result.get(symptom) + 1);
		}

		return result;
	}
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
	}
	public void writeSymptoms(Map<String, Integer> symptoms) {
		this.writer.writeSymptoms(symptoms);
	}

}