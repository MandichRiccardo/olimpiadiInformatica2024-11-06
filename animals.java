// NOTE: it is recommended to use this even if you don't understand the following code.

import java.io.*;

public class animals {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        InputStream fin = System.in;
        OutputStream fout = System.out;
        // uncomment the two following lines if you want to read/write from files
        fin = new FileInputStream("input0.txt");
        fout = new FileOutputStream("myOutput0.txt");

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fout));
        reader = new BufferedReader(new InputStreamReader(fin));

        //recopero dell'intero alla prima riga
        int tot = Integer.parseInt(next());

        int[] ordineDiArrivo = new int[tot];
        //scan righe
        String[] n = next().split(" ");
        for(int i=0;i<tot;i++){
            ordineDiArrivo[i] = Integer.parseInt(n[i]);
        }

        int[] animali = new int[0];

        for(int a:ordineDiArrivo){
            animali = add(animali, a);
            animali = remove(animali, a);
        }

        writer.write(String.valueOf(animali.length));
        writer.write('\n');

        writer.flush();
    }

    public static int[] add(int[] oldArray, int newValue){
        int[] newArray = new int[oldArray.length+1];
        for(int i=0;i< oldArray.length;i++){
            newArray[i] = oldArray[i];
        }
        newArray[oldArray.length] = newValue;
        return newArray;
    }

    public static int[] remove(int[] oldArray, int min){
        int[] newArray = new int[0];
        for(int i:oldArray){
            if(i>=min) newArray = add(newArray, i);
        }
        return newArray;
    }

    static String next() throws IOException {
        String read = reader.readLine();
        return read;
    }

    static BufferedReader reader;
}
