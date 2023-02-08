package json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 12:02
*/
public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    public LocalDateDeserializer(){
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        return LocalDate.parse(jsonParser.readValueAs(String.class));
    }
}
