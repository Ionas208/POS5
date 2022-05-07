package singleton;

import jakarta.xml.bind.JAXB;
import pojos.Game;
import pojos.Tournament;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
    Created by: Jonas Seidl
    Date: 07.04.2022
    Time: 16:33
*/
public class XMLDal {
    private static XMLDal instance;

    private XMLDal() {
    }

    public static XMLDal getInstance() {
        if (instance == null) {
            instance = new XMLDal();
        }
        return instance;
    }

    public Tournament loadTournament(Path path) {
        return JAXB.unmarshal(path.toFile(), Tournament.class);
    }

    public Game loadGame(Path path) {
        return JAXB.unmarshal(path.toFile(), Game.class);
    }

    public void saveTournament(Tournament tournament, Path path) {
        JAXB.marshal(tournament, path.toFile());
    }

    public Tournament convertTxtToXml(Path path) {
        return JAXB.unmarshal(path.toFile(), Tournament.class);
    }
}
