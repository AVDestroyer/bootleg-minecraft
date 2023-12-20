import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

public class tests {
    public static void test() {
        //System.out.println("hello");
        Game g = new Game();
        Board b = g.getBoard();
        try {
            File myObj = new File("board.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
        try {
            FileWriter myWriter = new FileWriter("board.txt");
            Hashtable<String,String> shortNames = new Hashtable<String,String>();
            shortNames.put("grass","g");
            shortNames.put("water","w");
            shortNames.put("stone","s");
            shortNames.put("lava","l");
            shortNames.put("end_portal_frame","f");
            shortNames.put("end_portal","p");


            for (int i = 0; i<b.getSizeX(); i++) {
                for (int j = 0; j<b.getSizeY(); j++) {
                    if (b.getTile(i,j).getName().equals("end_portal_frame")) {
                        myWriter.write(b.getTile(i,j).getFilled()? "e" : "f");
                    }
                    else {
                        myWriter.write(shortNames.get(b.getTile(i, j).getName()));
                    }
                }
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
        CustomRandom r = new CustomRandom();
        r.setSeed(32875983275l);
        long[] outputs = new long[1000];
        long sum = 0L;
        long comparison = 9 * (1L << 50)/10L ;
        int success = 0;
        for (int i = 0; i<1000;i++) {
            outputs[i] = r.nextLong();
            sum+=outputs[i];
            if (outputs[i] > comparison) {
                success++;

            }
        }
        /*System.out.println(sum/1000L);
        System.out.println(1L << 49);
        System.out.println(success);
        for (int i = 0; i< 500; i++) {
            System.out.println(outputs[i]);
        }*/

    }
}
