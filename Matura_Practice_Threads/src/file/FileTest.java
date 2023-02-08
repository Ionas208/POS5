package file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 10:24
*/
public class FileTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String test = scan.nextLine();
        System.out.println(test);
    }
}
