package singleton;

import jakarta.xml.bind.JAXB;
import pojos.Game;
import pojos.Team;
import pojos.Tournament;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
    Created by: Jonas Seidl
    Date: 07.04.2022
    Time: 16:32
*/
public class Calculator {
    private static Calculator instance;

    private Calculator() {
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    private List<Game> games;


    public List<Game> getAllGamesByTeamName(String name){
        return games.stream()
                .filter(game -> game.getTeam1().equals(name) || game.getTeam2().equals(name))
                .collect(Collectors.toList());
    }

    public List<Team> generateTable(){
        return null;
    }

    public void addDataFromTournamentObject(Tournament t){
        games = new ArrayList<>(t.getGames());
    }

    public void addDataFromXMLFiles(List<Path> xmlFiles){
        games = xmlFiles.stream()
                        .map(path -> XMLDal.getInstance().loadGame(path))
                        .collect(Collectors.toList());
    }

    public void removeDuplicates1(){
        for (int i = 0; i < games.size(); i++) {
            List<Game> new_games = new ArrayList<>(games);
            new_games.remove(i);
            for (Game g: new_games) {
                if(games.get(i).equals(g)){
                    games.remove(g);
                }
            }
        }
    }

    public void removeDuplicates2(){
        games = games.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/data/bundesliga2122.xml");
        Tournament t = XMLDal.getInstance().loadTournament(path);
        Calculator c = Calculator.getInstance();
        c.addDataFromTournamentObject(t);
        System.out.println(Calculator.getInstance().games.size());
        c.removeDuplicates2();
        System.out.println(Calculator.getInstance().games.size());
        Set<Game> set = new HashSet<>(Calculator.getInstance().games);
        System.out.println(set.size());
    }
}
