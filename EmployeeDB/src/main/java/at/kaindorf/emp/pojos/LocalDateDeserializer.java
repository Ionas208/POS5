package at.kaindorf.emp.pojos;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
    Created by: Jonas Seidl
    Date: 26.11.2021
    Time: 18:03
*/
public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    private static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public LocalDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return LocalDate.parse(jsonParser.getValueAsString(), DTF);
    }
}
