public class ComplexMain {
    public static void main(String[] args){
        int pass = 0;
        int fail = 0;

        complexPolynomial c1 = new complexPolynomial(new double[] {1}, new double[] {1});
        complexPolynomial c2 = new complexPolynomial(new double[] {1}, new double[] {1});
        complexPolynomial c3 = c1.add(c2);
        if(c3.getComplex().getVal()[0] == 2) pass++;
        else fail++;
        if(c3.getReal().getVal()[0] == 2) pass++;
        else fail++;

        complexPolynomial c4 = c1.subtract(c2);
        if(c4.getComplex().getVal()[0] == 0) pass++;
        else fail++;
        if(c4.getReal().getVal()[0] == 0) pass++;
        else fail++;

        complexPolynomial c5 = c1.multiply(c2);
        //for(var a: c5.getReal().getVal()) System.out.print(" " + a + " ");
        //System.out.println();
        //for(var a: c5.getComplex().getVal()) System.out.print(" " + a + " ");
        //System.out.println();
        if(c5.getReal().getVal()[0] == 0.0) pass++;
        else fail++;
        if(c5.getComplex().getVal()[0] == 2.0) pass++;
        else fail++;

        complexPolynomial c6 = new complexPolynomial(new double[] {1,1}, new double[] {1,1});
        complexPolynomial c7 = new complexPolynomial(new double[] {2,2}, new double[] {2,2});
        complexPolynomial c8 = c6.multiply(c7);
        /*
        for(double a:c8.getReal().getVal()) System.out.print(" " + a + " ");
        System.out.println();
        for(double a:c8.getComplex().getVal()) System.out.print(" " + a + " ");
        System.out.println();
         */
        double[] c8_ideal_real = {0,0,0};
        double[] c8_ideal_complex = {4,8,4};

        boolean same = true;
        for(int i = 0; i<c8_ideal_real.length; i++) if(c8.getReal().getVal()[i] != c8_ideal_real[i]) same = false;
        if(same) pass++;
        else fail++;


        for(int i = 0; i<c8_ideal_complex.length; i++) if(c8.getComplex().getVal()[i] != c8_ideal_complex[i]) same = false;
        if(same) pass++;
        else fail++;


        System.out.println("tests passed: " + pass + "/" + (pass+fail));
    }
}
