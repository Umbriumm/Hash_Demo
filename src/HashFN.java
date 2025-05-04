
// TODO: update the hash function

public class HashFN {
    public static int Hash(String str){
        long hash = 5381;
        for(int i = 0; i <= str.length()-1; i++){
            char c = str.charAt(i);
            hash = ((hash << 5) + hash) + c;
        }
        return (int)(Math.abs(hash) % 7);
    }
}
