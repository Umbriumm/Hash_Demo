public class LinearProbing {
    public static class LinearPropingresult {
        int index;
        int steps;

        public LinearPropingresult(int index, int steps) {
            this.index = index;
            this.steps = steps;
        }
    }
        public void Linearinsert(String [] values ){
            int tablesize =values.length;
            String [] ftable =new String[tablesize];

            for (String value :values){
                int hash=(int)(HashFN.Hash(value)%tablesize);
                int steps=1;

                if (ftable[hash]==null){
                    ftable[hash]=value;
                    System.out.println("✅ \"" + value + "\" inserted at index " + hash + " (steps: " + steps + ")");
                    continue;
                }
                boolean isinserted=false;

                for (int i=1;i<tablesize;i++){
                    int newhash=(hash+i)%tablesize;
                    steps++;
                    if (ftable[newhash]==null){
                        ftable[newhash]=value;
                        System.out.println("✅ \"" + value + "\" inserted at index " + newhash + " (steps: " + steps + ")");
                        isinserted=true;
                        break;
                    }
                }
                if(!isinserted){
                    System.out.println("failed to insert");
                }
            }
            System.out.println("\n📦 Final Hash Table:");
            for (int i = 0; i < tablesize; i++) {
                System.out.println("[" + i + "]: " + (ftable[i] != null ? ftable[i] : "empty"));
            }
        }
}


