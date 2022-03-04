package at.kaindorf.pattern.singleton;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 10:03
*/
public class TheOneAndOnly {
    private static TheOneAndOnly instance;

    private TheOneAndOnly() {
        // private constructor
    }

    public static TheOneAndOnly getInstance() {
        if (instance == null) {
            instance = new TheOneAndOnly();
        }
        return instance;
    }
}
