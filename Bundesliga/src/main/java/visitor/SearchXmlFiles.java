package visitor;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 12:20
*/
@AllArgsConstructor
@NoArgsConstructor
public class SearchXmlFiles {
    private int directories;
    private int files;
    private int workingDirectory;

    public void searchXmlFiles(Path workingDirectory){
        IDirectoryVisitor v = new DirectorySizeVisitor();
        traverse(workingDirectory, v);
        System.out.println(v);
    }

    public List<File> getXmlFiles(Path workingDirectory){
        IDirectoryVisitor v = new DirectoryXMLFileVisitor();
        traverse(workingDirectory, v);
        return ((DirectoryXMLFileVisitor) v).getXmlFiles();
    }

    private void traverse(Path dir, IDirectoryVisitor visitor){
        File[] files = dir.toFile().listFiles();
        if(dir.toFile().isDirectory()){
            visitor.enterDirecotry(dir);
        }
        for (File f: files) {
            if(f.isDirectory()){
                traverse(f.toPath(), visitor);
            }else{
                visitor.visitFile(f.toPath());
            }
        }
        visitor.leaveDirecotry(dir);
    }

    public void print(Path dir){
        IDirectoryVisitor v = new DirectoryPrintVisitor();
        traverse(dir, v);
        System.out.println(((DirectoryPrintVisitor)v).indent);
    }

    public static void main(String[] args) {
        Path p = Paths.get("src", "main", "resources", "data");
        new SearchXmlFiles().print(p);
    }
}
