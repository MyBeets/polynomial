public class ComplexMain {
    public static void main(String[] args){
        int pass = 0;
        int fail = 0;

        complexPolynomial c1 = new complexPolynomial(new int[] {1}, new int[] {1});
        complexPolynomial c2 = new complexPolynomial(new int[] {1}, new int[] {1});
        complexPolynomial c3 = c1.add(c2);
        if(c3.getComplex().getVal()[0] == 2) pass++;
        else fail++;
        if(c3.getReal().getVal()[0] == 2) pass++;
        else fail++;


        System.out.println("tests passed: " + pass + "/" + (pass+fail));
    }
}
