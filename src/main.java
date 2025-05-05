public class main {
    public static void main(String[] args) {
        QuadraticProbing qc=new QuadraticProbing();
        LinearProbing lp=new LinearProbing();
        String[] values = {"Apple", "banana", "Cherry", "apricot", "grape", "Mango", "Peach"};
        qc.quadraticProbingInsert(values);
        System.out.println("linear proping");
        lp.Linearinsert(values);
    }
}