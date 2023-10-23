package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	private final ISymptomReader reader;
	private final ISymptomWriter writer;

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();


		while (line != null) {
			if (line.equals("headache")) {
				headacheCount++;
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.equals("dialated pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}

		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {

		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return this.reader.GetSymptoms();
	}
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		HashMap<String, Integer> result = new HashMap<>();

		// TODO: Implementer la methode

		return result;
	}
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		// TODO: Implementer la methode
		return null;
	}
	public void writeSymptoms(Map<String, Integer> symptoms) {
		this.writer.writeSymptoms(symptoms);
	}

}