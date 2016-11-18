package com.github.akosbordas.ncore;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class StreamSerializer extends JsonSerializer<ByteArrayInputStream> {

    @Override
    public void serialize(ByteArrayInputStream content,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(IOUtils.toString(content));
    }
}
