public class DJB2Hash {
    public static long Hash(String str, int tableSize){
        long hash = 5381;
        for(int i = 0; i <= str.length()-1; i++){
            char c = str.charAt(i);
            hash = ((hash << 5) + hash) + c;
        }
        return (long)(Math.abs(hash) % tableSize);
    }
}
