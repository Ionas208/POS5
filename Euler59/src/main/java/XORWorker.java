import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/*
    Created by: Jonas Seidl
    Date: 29.04.2022
    Time: 10:02
*/
public class XORWorker implements Callable<String> {

    private static int[] data;
    private static List<String> commonWords;


    private char c;

    public XORWorker(char c) {
        this.c = c;
    }

    @Override
    public String call() throws Exception {
        for (int c2 = 'a'; c2 <= 'z'; c2++) {
            for (int c3 = 'a'; c3 <= 'z'; c3++) {
                char[] result = new char[data.length];
                char[] key = {c, (char) c2, (char) c3};
                for (int i = 0; i < data.length; i++) {
                    result[i] = (char)(data[i] ^ key[i%3]);
                }
                int occurences = 0;
                for (String word : commonWords) {
                    if (new String(result).contains(word)) {
                        occurences++;
                    }
                }
                if (occurences > 5) {
                    return String.valueOf(result);
                }
            }
        }
        throw new Exception("No solution found");
    }

    public static void setData(int[] data) {
        XORWorker.data = data;
    }

    public static void setCommonWords(List<String> commonWords) {
        XORWorker.commonWords = commonWords;
    }
}
