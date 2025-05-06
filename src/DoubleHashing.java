import java.util.Arrays;

public class DoubleHashing {
    String[] HashTable;
    int Collisions = 0;


    public long h2(String s){
        long jump = 97 - (HashFN.Hash(s) % 97);
        return jump;
    }

    public void DoubleHashInsert(String[] data) {
        // Edit the size to "findTableSize(data.length)" for the nearest prime (iterates over each index)
        HashTable = new String[findTableSize(data.length)];
        for (int i = 0; i <= data.length - 1; i++ ) {
            int j = 0;
            String s = data[i];
            int index = (int) ((HashFN.Hash(s) + j * h2(s)) % (HashTable.length));

            if (HashTable[index] == null){
                Insert(s, index);
                System.out.println("✅ String \""+s+"\" inserted into index "+index);
            } else {
                int probes = 0;
                Collisions++;
                System.out.println("❌ Collision at index (" + index + ") [Total: " + Collisions + "]");
                while (HashTable[index] != null) {
                    probes++;
                    j++;
                    System.out.println("🗿 index (" + index + ") is occupied [Total: " + Collisions + "] [🔄️ Probes: "+probes+"]");
                    index = (int) ((HashFN.Hash(s) + j * h2(s)) % (HashTable.length));

                    if (j >= HashTable.length){
                        System.out.println("Failed to insert string \""+s+"\"");
                        break;
                    }

                }

                if (HashTable[index] == null){
                    Insert(s, index);
                    System.out.println("✅ String \"" + s + "\" inserted into index " + index);
                }
            }

        }
        System.out.println("\n📦 Final Hash Table:");
        for (int i = 0; i < HashTable.length; i++) {
            System.out.println("[" + i + "]: " + (HashTable[i] != null ? HashTable[i] : "\033[41;1;97mEmpty\033[0m"));
        }    }

    public void Insert(String s, int index){
        HashTable[index] = s;
    }

    public int findTableSize(int initialSize){
        int i = initialSize;
        boolean isprime = false;
        while (!isprime){
            isprime = true;
            for (int j = 2; j <= Math.sqrt(i); j++){
                if (i % j == 0) {
                    isprime = false;
                    break;
                }
            }

            if (isprime){
                return i;
            }

            i++;
        }
        return i;
    }

}
