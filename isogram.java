import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class isogram {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        InputStream fin = System.in;
        OutputStream fout = System.out;
        // uncomment the two following lines if you want to read/write from files
        //fin = new FileInputStream("input0.txt");
        //fout = new FileOutputStream("MyOutput0.txt");

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fout));
        reader = new BufferedReader(new InputStreamReader(fin));

        //recopero dell'intero alla prima riga
        int tot = Integer.parseInt(next());

        //scan righe
        String[] test = new String[tot];
        for (int i = 1; i <= tot; i++) {
            test[i-1] = next();
        }
        int ret = 0;


        for(String t:test){
            if(isogram(t)){
                ret++;
            }
        }


        writer.write(String.valueOf(ret));
        writer.write('\n');

        writer.flush();
    }

    public static boolean isogram(String testString){
        char[] test = testString.toLowerCase().toCharArray();
        boolean ret = true;
        Map<Character, Integer> caratteri = new HashMap<>();
        for(char i:test){
            if(i!=' ') {
                if (caratteri.get(i) == null) {
                    caratteri.put(i, 1);
                } else if (caratteri.get(i) == 2) {
                    ret = false;
                } else {
                    caratteri.put(i, caratteri.get(i) + 1);
                }
            }
        }
        return ret;
    }

    static String next() throws IOException {
        return reader.readLine();
    }

    static BufferedReader reader;
}
