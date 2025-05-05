public class main {
    public static void main(String[] args) {
        QuadraticProbing qc=new QuadraticProbing();
        SeparatingChain sc = new SeparatingChain();

        String[] values = {"Apple", "banana", "Cherry", "apricot", "grape", "Mango", "Peach"};
        qc.quadraticProbingInsert(values);

        System.out.println("-----------------------------------------------------------------------------------------");

        String[] values2 = {"Apple", "banana", "Cherry", "apricot", "Grape", "mango", "Peach", "strawberry"};
        sc.SeparatingChainInsert(values2);

    }
}