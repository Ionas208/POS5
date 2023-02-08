package visitor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.file.Path;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 12:20
*/
@NoArgsConstructor
@Data
public class DirectorySizeVisitor implements IDirectoryVisitor{

    private int xmlFiles = 0;

    private int dirs = 0;

    @Override
    public void enterDirecotry(Path dir) {
        dirs++;
    }

    @Override
    public void leaveDirecotry(Path dir) {

    }

    @Override
    public void visitFile(Path file) {
        if(file.toString().endsWith(".xml")){
            xmlFiles++;
        }
    }
}
