package astro.syntax;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Keywords {

    /**
     * Get All Keywords from classes text file and split them to classes import path and keywords
     */
    public static void onKeywordsBind() {
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("astro/res/files/classes.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        Stream<String> lines = reader.lines();
        Object[] arr = lines.toArray();
        for(int i = 0 ; i < arr.length ; i = i + 2){
            SyntaxUtils.KEYWORDS_lIST.add(arr[i].toString());
            SyntaxUtils.KEYWORDS_lIST.add(arr[i + 1].toString());
            SyntaxUtils.CLASSES_LIST.put(arr[i].toString(),arr[i + 1].toString());
        }
        SyntaxUtils.KEYWORDS_lIST.addAll(Arrays.asList(SyntaxUtils.KEYWORDS));
    }
}
