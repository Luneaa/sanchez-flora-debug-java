package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Read symptoms from file
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filePath;
	
	/**
	 * 
	 * @param filePath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filePath) {
		this.filePath = filePath;
	}

	/**
	 * If no data is available, return an empty List
	 *
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	@Override
	public List<String> getSymptoms() {
		List<String> result = new ArrayList<>();

		if (filePath != null) {
			try (BufferedReader reader = new BufferedReader (new FileReader(filePath))) {
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();

				// affichage dans logger
			}
		}
		
		return result;
	}

}
