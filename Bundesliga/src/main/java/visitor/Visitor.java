package visitor;

import pojos.Team;

import java.util.PriorityQueue;
import java.util.Queue;

/*
    Created by: Jonas Seidl
    Date: 07.04.2022
    Time: 17:15
*/
public interface Visitor {
    Queue<Team> q = new PriorityQueue<>();
}
