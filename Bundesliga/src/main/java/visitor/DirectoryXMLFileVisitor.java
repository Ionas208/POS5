package visitor;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 12:20
*/
@NoArgsConstructor
@Data
@Getter
public class DirectoryXMLFileVisitor implements IDirectoryVisitor{

    List<File> xmlFiles = new ArrayList<>();

    @Override
    public void enterDirecotry(Path dir) {

    }

    @Override
    public void leaveDirecotry(Path dir) {

    }

    @Override
    public void visitFile(Path file) {
        if(file.toString().endsWith(".xml")){
            xmlFiles.add(file.toFile());
        }
    }
}
