import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        QuadraticProbing qc = new QuadraticProbing();
        DoubleHashing ds = new DoubleHashing();
        SeparateChaining sc = new SeparateChaining();
        Scanner scc = new Scanner(System.in);
        int tableSize = 0;


        System.out.println("(?) Do you wish to specify a size for the HashMap or use the default size? (52)");
        System.out.println("[1] Specify \n" +
                "[2] Default");
        int option1 = scc.nextInt();
        if (option1 == 2){
            tableSize = 52;
        } else if (option1 == 1){
            System.out.println("(?) Enter the size of the HashMap");
            tableSize = scc.nextInt();
        } else {
            System.out.println("Invalid Option");
            System.exit(-1);
        }


        if (tableSize <= 0) {
            System.out.println("Size can't be negative / 0");
            System.exit(1);
        }

        String[] values = readFile();

        System.out.println("(?) Select a hashing method:");
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
                lp.linearInsert(values, tableSize);
                break;

            case 2:
                QuadraticProbing qp = new QuadraticProbing();
                qp.quadraticProbingInsert(values, tableSize);
                break;

            case 3:
                SeparateChaining sch = new SeparateChaining();
                sch.SeparatingChainInsert(values, tableSize);
                break;

            case 4:
                DoubleHashing dh = new DoubleHashing();
                dh.DoubleHashInsert(values, tableSize);
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
        System.out.println("➡️ Number of Words = " + values.length);
        return values;
    }
}