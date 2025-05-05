import java.util.*;

public class SeparatingChain {
    private List<String>[] table;
    private int tableSize = 10;
    private int collisionCount = 0;

    @SuppressWarnings("unchecked")
    public SeparatingChain() {
        table = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void SeparatingChainInsert(String[] words) {
        for (String word : words) {
            int index = (int)(HashFN.Hash(word) % tableSize);

            if (!table[index].isEmpty()) {
                collisionCount++;
                System.out.print("❗ Collision at index " + index + " -> ");
            }

            table[index].add(word);
            System.out.println("✅ \"" + word + "\" inserted at index " + index + " | Chain: " + table[index]);
        }

        display();
    }

    private void display() {
        System.out.println("\n📦 Final (Separate Chaining):");
        for (int i = 0; i < tableSize; i++) {
            if (!table[i].isEmpty()) {
                System.out.println("[" + i + "]: " + table[i]);
            }
        }
        System.out.println("\n🔁 Total collisions: " + collisionCount);
    }
}
