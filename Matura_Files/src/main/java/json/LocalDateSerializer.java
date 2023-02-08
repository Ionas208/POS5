package json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 12:04
*/
public class LocalDateSerializer extends StdSerializer<LocalDate> {
    protected LocalDateSerializer() {
        super(LocalDate.class);
    }

    @Override
    public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(localDate.toString());
    }
}
