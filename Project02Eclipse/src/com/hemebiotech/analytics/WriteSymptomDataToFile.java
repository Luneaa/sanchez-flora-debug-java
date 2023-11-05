package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filePath;

    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

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
