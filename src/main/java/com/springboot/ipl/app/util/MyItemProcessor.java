package com.springboot.ipl.app.util;

import com.springboot.ipl.app.dto.MatchData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyItemProcessor implements ItemProcessor<MatchData, MatchData> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyItemProcessor.class);

    @Override
    public MatchData process(MatchData item) throws Exception {
        // Validate the input DTO
//        if (item.getDecision() == null || item.getSeason().isEmpty()) {
//            data = item;
//            LOGGER.warn("Field1 is null or empty for item: {}", item);
//        }
//        if (item.getAway_boundaries() == null || item.getHighlights().isEmpty()) {
//            data = item;
//            LOGGER.warn("Field2 is null or empty for item: {}", item);
//        }
        // Add more validation logic here as needed

        // Return the input DTO as the output DTO
        return item;
    }
}
