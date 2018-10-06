/*
 * Copyright (C) Lundegaard, s.r.o. 2018 - All Rights Reserved
 * Proprietary and confidential. Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package eu.lundegaard.reactunion.support.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.lundegaard.reactunion.support.exception.ReactSupportException;

/**
 * Serves to map data between Java and React.
 *
 * @author Roman Srom (roman.srom@lundegaard.eu)
 */
public class ReactDataMapper {

    private static final Logger LOG = LoggerFactory.getLogger(ReactDataMapper.class);

    /**
     * Returns JSON representation of the object. It uses Jackson library to create JSON format.
     *
     * @param object
     * @return
     */
    public String getJson(Object object) {
        ObjectMapper objectMapper = ObjectMapperFactory.getInstance();
        try {
            final String json = objectMapper.writeValueAsString(object);
            LOG.debug("Serialized object {} to json {}", object, json);
            return json;
        } catch (JsonProcessingException e) {
            throw new ReactSupportException("Serialization to json error", e);
        }
    }
}
