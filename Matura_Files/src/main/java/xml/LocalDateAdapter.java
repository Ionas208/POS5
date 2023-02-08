package xml;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 12:08
*/
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String s) throws Exception {
        return LocalDate.parse(s);
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return localDate.toString();
    }
}
