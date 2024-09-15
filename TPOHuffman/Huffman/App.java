import algorithms.HuffmanAlgorithm;

public class App {
    public static void main(String[] args) throws Exception {
        char[] alph = {'a', 'b', 'c', 'd', 'e', 'f'};
        double[] prob = {.45, .13, .12, .16, .09, .05};

        HuffmanAlgorithm algo = new HuffmanAlgorithm(alph, prob);

        algo.PrintCodes();
    }
}
