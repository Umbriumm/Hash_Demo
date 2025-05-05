public class LinearProbing {
    // Fixed the typo and naming convention in the class name
    public static class LinearProbingResult {
        int index;
        int steps;

        public LinearProbingResult(int index, int steps) {
            this.index = index;
            this.steps = steps;
        }
    }

    // Fixed naming convention (camelCase)
    public void linearInsert(String[] values) {
        // Added null check for values
        if (values == null || values.length == 0) {
            System.out.println("Empty array provided. Nothing to insert.");
            return;
        }

        int tableSize = values.length;
        String[] hashTable = new String[tableSize];

        for (String value : values) {
            // Added null check for individual values
            if (value == null) {
                System.out.println("Skipping null value");
                continue;
            }

            int hash = (int)(HashFN.Hash(value) % tableSize);
            int steps = 1;

            if (hashTable[hash] == null) {
                hashTable[hash] = value;
                System.out.println("✅ \"" + value + "\" inserted at index " + hash + " (steps: " + steps + ")");
                continue;
            }

            boolean isInserted = false;

            for (int i = 1; i < tableSize; i++) {
                int newHash = (hash + i) % tableSize;
                steps++;
                if (hashTable[newHash] == null) {
                    hashTable[newHash] = value;
                    System.out.println("✅ \"" + value + "\" inserted at index " + newHash + " (steps: " + steps + ")");
                    isInserted = true;
                    break;
                }
            }

            if (!isInserted) {
                System.out.println("❌ Failed to insert \"" + value + "\" - table is full");
            }
        }

        System.out.println("\n📦 Final Hash Table:");
        for (int i = 0; i < tableSize; i++) {
            System.out.println("[" + i + "]: " + (hashTable[i] != null ? "\"" + hashTable[i] + "\"" : "empty"));
        }
    }

    // Added a method that returns the LinearProbingResult for a search
    public LinearProbingResult linearSearch(String[] hashTable, String value) {
        if (hashTable == null || value == null) {
            return new LinearProbingResult(-1, 0);
        }

        int tableSize = hashTable.length;
        int hash = (int)(HashFN.Hash(value) % tableSize);
        int steps = 1;

        if (hashTable[hash] != null && hashTable[hash].equals(value)) {
            return new LinearProbingResult(hash, steps);
        }

        for (int i = 1; i < tableSize; i++) {
            int newHash = (hash + i) % tableSize;
            steps++;

            if (hashTable[newHash] != null && hashTable[newHash].equals(value)) {
                return new LinearProbingResult(newHash, steps);
            }

            // Stop searching if we hit an empty slot
            if (hashTable[newHash] == null) {
                break;
            }
        }

        // Value not found
        return new LinearProbingResult(-1, steps);
    }
}


