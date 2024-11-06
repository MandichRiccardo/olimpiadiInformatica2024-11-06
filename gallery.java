// NOTE: it is recommended to use this even if you don't understand the following code.

import java.io.*;

public class gallery {

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

        int[][] coordinate = new int[0][2];
        //scan righe
        String line;
        while ((line = next()) != null) {
            int[] coordinata = new int[2];
            coordinata[0] = Integer.parseInt(line.split(" ")[0]);
            coordinata[1] = Integer.parseInt(line.split(" ")[1]);
            coordinate = add(coordinate, coordinata);
        }
        boolean simmetrico = true;
        long medio = 0;

        for(int[] c:coordinate){
            if(count(coordinate, c[1])%2 == 0){
                //se ho un numero pari di coordinate a questa y
                //System.out.println("pari " + c[1]);
                int min = 10000000;
                int max = 0;
                for(int i=0;i<coordinate.length;i++){
                    if(coordinate[i][1] == c[1]){
                        min = Math.min(min, coordinate[i][0]);
                        max = Math.max(max, coordinate[i][0]);
                    }
                }
                if(medio == 0){
                    medio = min + (max-min)/count(coordinate, c[1]);
                    //System.out.println("min="+min+" max="+max+" medio="+medio);
                }else{
                    if(medio != min + (max-min)/count(coordinate, c[1])) simmetrico = false;
                }
            }else if(count(coordinate, c[1])>1){
                //se ho un numero dispari di coordinate a questa y maggiore di 1
                //System.out.println("dispari " + c[1]);
            }else{
                //se ho una sola coordinata a questa y
                //System.out.println("singola " + c[1]);
                if(medio == 0) medio = c[0];
                else{
                    if(medio != c[0]) simmetrico = false;
                }
            }
        }


        writer.write(simmetrico ? "YES" : "NO");
        writer.write('\n');

        writer.flush();
    }

    static int count(int[][] coordinate, int y){
        int i=0;
        for(int[] c:coordinate){
            if(c[1] == y) i++;
        }
        return i;
    }

    static int[][] add(int[][] oldCoordinate, int[] coordinata){
        int[][] newCoordinate = new int[oldCoordinate.length+1][2];
        for(int i=0;i< oldCoordinate.length;i++){
            newCoordinate[i] = oldCoordinate[i];
        }
        newCoordinate[oldCoordinate.length] = coordinata;
        return newCoordinate;
    }

    static String next() throws IOException {
        return reader.readLine();
    }

    static BufferedReader reader;
}
