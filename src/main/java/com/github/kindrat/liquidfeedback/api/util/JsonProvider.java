package com.github.kindrat.liquidfeedback.api.util;

import com.fasterxml.jackson.datatype.joda.JodaMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import javax.ws.rs.ext.Provider;

@Provider
public class JsonProvider extends JacksonJaxbJsonProvider {

    public JsonProvider()
    {
        super();
        JodaMapper mapper = new JodaMapper();
        mapper.setWriteDatesAsTimestamps(false);
        setMapper(mapper);
    }
}
