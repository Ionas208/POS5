import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/*
    Created by: Jonas Seidl
    Date: 29.04.2022
    Time: 10:03
*/
public class XORLauncher {


    public void loadData() throws IOException {
        Path path = Paths.get("src", "main", "resources", "cipher.txt");
        int[] numbers = Arrays.stream(Files.readString(path).split(",")).mapToInt(Integer::parseInt).toArray();
        XORWorker.setData(numbers);
    }

    public void perform() {
        List<String> commonWords = new ArrayList<>();
        commonWords.add("the ");
        commonWords.add("of ");
        commonWords.add("and ");
        commonWords.add("to ");
        commonWords.add("in ");
        commonWords.add("is ");
        commonWords.add("you ");
        commonWords.add("that ");
        XORWorker.setCommonWords(commonWords);

        try {
            loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ExecutorService pool = Executors.newFixedThreadPool(6);
        List<XORWorker> workers = new ArrayList<>();
        for (int c = 'a'; c <= 'z'; c++) {
            workers.add(new XORWorker((char)c));
        }

        try {
            String result = pool.invokeAny(workers);
            System.out.println(result);
            int sum = result.chars()
                            .sum();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new XORLauncher().perform();
    }
}
