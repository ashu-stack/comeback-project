package CoreJava.effectiveJava.Item9;

public class ExceptionHandle {
    public static void main(String[] args) throws MyOwnException {
        String name = "Ashu";

        boolean isAshu = isNameAshu(name);
        try {
            if(isAshu){
                throw new MyOwnException();
            }
        } catch (MyOwnException e) {
            System.out.println();
        }finally {
            System.out.println(name);
        }


    }

    public static boolean isNameAshu(String name) {
        if(name.equals("Ashu")){
            //throw new MyOwnException();
            return true;
        }
        else{
            return false;
        }
    }

    private static int divideFunc(int numerator, int denominator) {
       try{
           return numerator/denominator;
       }catch(ArithmeticException e){
           System.out.println(e.getMessage());
           return -1;
        }
       finally {
           System.out.println("Last statement");
       }
    }
}
