// NOTE: it is recommended to use this even if you don't understand the following code.

import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class baseEs {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        InputStream fin = System.in;
        OutputStream fout = System.out;
        // uncomment the two following lines if you want to read/write from files
        // fin = new FileInputStream("input.txt");
        // fout = new FileOutputStream("output.txt");

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fout));
        reader = new BufferedReader(new InputStreamReader(fin));

        //recopero dell'intero alla prima riga
        int tot = Integer.parseInt(next());

        //scan righe
        for (int i = 1; i <= tot; i++) {
            //elaborazione righe dopo la prima
        }
        int ans = 0;


        // INSERT YOUR CODE HERE


        writer.write(String.valueOf(ans));
        writer.write('\n');

        writer.flush();
    }

    static String next() throws IOException {
        return reader.readLine();
    }

    static BufferedReader reader;
}
