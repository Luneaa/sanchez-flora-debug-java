package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Writes symptoms data to file
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filePath;

    /**
     * @param filePath path of the file to write to
     */
    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Writes symptoms to file
     *
     * @param symptoms map of symptoms to write
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try {

            FileWriter writer = new FileWriter(filePath);

            for (Map.Entry<String, Integer> entry : symptoms.entrySet()){
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }

            writer.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
