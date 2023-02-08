package visitor;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.nio.file.Path;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 19:29
*/
@NoArgsConstructor
public class DirectoryPrintVisitor implements IDirectoryVisitor{

    public String indent;

    @Override
    public void enterDirecotry(Path dir) {
        System.out.println(indent + "[" + dir.getFileName() + "]");
        indent += "  ";
    }

    @Override
    public void leaveDirecotry(Path dir) {
        indent = indent.substring(2);
    }

    @Override
    public void visitFile(Path file) {
        System.out.println(indent + file.getFileName());
    }
}
