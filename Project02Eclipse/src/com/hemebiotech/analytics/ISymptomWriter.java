package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Writes symptoms data to a target
 */
public interface ISymptomWriter {

    /**
     * Writes symptoms to a target destination
     *
     * @param symptoms map of symptoms to write
     */
    void writeSymptoms(Map<String, Integer> symptoms);

}
