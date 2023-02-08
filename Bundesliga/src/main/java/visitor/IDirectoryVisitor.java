package visitor;

import pojos.Team;

import java.nio.file.Path;
import java.util.PriorityQueue;
import java.util.Queue;

/*
    Created by: Jonas Seidl
    Date: 07.04.2022
    Time: 17:15
*/
public interface IDirectoryVisitor {
    void enterDirecotry(Path dir);
    void leaveDirecotry(Path dir);
    void visitFile(Path file);
}
