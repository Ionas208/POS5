package at.kaindorf.exam.pojos;

import at.kaindorf.exam.util.LocalDateDeserializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/*
    Created by: Jonas Seidl
    Date: 18.03.2022
    Time: 08:28
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dummy {
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    public static void main(String[] args) {
        ObjectMapper om = new ObjectMapper();
        try {
            Dummy d = om.readValue("{\"date\": \"2022-03-18\"}", Dummy.class);
            System.out.println(d);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
