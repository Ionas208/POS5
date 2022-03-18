package at.kaindorf.exam.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
    Created by: Jonas Seidl
    Date: 18.03.2022
    Time: 08:19
*/
public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    private static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalDateDeserializer(){
        super(LocalDate.class);
    }


    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        return LocalDate.parse(jsonParser.readValueAs(String.class));
    }
}
