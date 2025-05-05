
public class HashFN {
    public static long Hash(String str){
        str = str.toLowerCase();
        int m = 1000000009;
        int b = 31;
        long hash = 0;
        long power = 1;
        int n = str.length();
        for(int i = 0; i <= str.length() - 1; i++){
            int ascii = str.charAt(i);
            hash = (hash + ascii * power) % m;
            power = (power * b) % m;
        }
        return hash;
    }
}
