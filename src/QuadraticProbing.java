public class QuadraticProbing {

    public static class QuadraticProbingResult {
        int index;
        int probes;

        public QuadraticProbingResult(int index, int probes) {
            this.index = index;
            this.probes = probes;
        }
    }

    public void quadraticProbingInsert(String[] values) {
        int tablesize = values.length;
        String[] HashedTable = new String[tablesize];


        for (String value : values) {
            int hash = HashFN.Hash(value);
            int probes = 1;

            if (HashedTable[hash] == null) {
                HashedTable[hash] = value;
                System.out.println("✅ \"" + value + "\" inserted at index " + hash + " (Probes: " + probes + ")");
                continue;
            }

            boolean inserted = false;

            for (int i = 1; i < tablesize; i++) {
                int newhash = (hash + i + i * i) % tablesize;
                probes++;
                if (HashedTable[newhash] == null) {
                    HashedTable[newhash] = value;
                    System.out.println("✅ \"" + value + "\" inserted at index " + newhash + " (Probes: " + probes + ")");
                    inserted = true;
                    break;

                }
            }
            if (!inserted) {
                System.out.println("❌ Failed to insert \"" + value + "\" (Probes: " + probes + ")");
            }
        }

        System.out.println("\n📦 Final Hash Table:");
        for (int i = 0; i < tablesize; i++) {
            System.out.println("[" + i + "]: " + (HashedTable[i] != null ? HashedTable[i] : "empty"));
        }


    }
}



