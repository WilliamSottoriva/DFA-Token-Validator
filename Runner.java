public class Runner {
    public static void main(String[] args) {
        try {
            System.out.println(LexicalAnalyser.analyse("0.2+ 0.2"));
        }
        catch (NumberException e) {

        }
        catch (ExpressionException e) {
            
        }
    }
}
