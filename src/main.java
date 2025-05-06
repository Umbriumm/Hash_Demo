import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        QuadraticProbing qc = new QuadraticProbing();
        DoubleHashing ds = new DoubleHashing();
        SeparateChaining sc = new SeparateChaining();

        String[] values = readFile();

        System.out.println("Select a hashing method:");
        System.out.println(
                "[1] Linear Probing" + "\n"
                        + "[2] Quadratic Probing" + "\n"
                        + "[3] Separate Chaining" + "\n"
                        + "[4] Double Hashing"
        );

        Scanner sc2 = new Scanner(System.in);
        int option = sc2.nextInt();

        switch (option) {
            case 1:
                LinearProbing lp = new LinearProbing();
                lp.linearInsert(values);
                break;

            case 2:
                QuadraticProbing qp = new QuadraticProbing();
                qp.quadraticProbingInsert(values);
                break;

            case 3:
                SeparateChaining sch = new SeparateChaining();
                sch.SeparatingChainInsert(values);
                break;

            case 4:
                DoubleHashing dh = new DoubleHashing();
                dh.DoubleHashInsert(values);
                break;

            default:
                System.out.println("Invalid Option");
                break;
        }


    }

    public static String[] readFile() {
        String filename = "input.txt";
        ArrayList<String> wordList = new ArrayList<>();

        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                wordList.add(scanner.next());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


         String[] values = wordList.toArray(new String[0]);
        System.out.println("➡️ initial size = " + values.length);
        return values;
    }
}