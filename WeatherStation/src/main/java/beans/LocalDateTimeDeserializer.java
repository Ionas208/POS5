package beans;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 12:17
*/
public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {
    protected LocalDateTimeDeserializer(Class<?> vc) {
        super(vc);
    }
    public LocalDateTimeDeserializer() {
        this(null);
    }

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        return LocalDateTime.parse(node.asText());
    }
}
