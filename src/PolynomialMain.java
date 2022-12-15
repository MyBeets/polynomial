public class PolynomialMain {
    public static void main(String[] args) {
        double pass = 0;
        double fail = 0;
        polynomial p1 = new polynomial(new double[] {0,0,0,1});
        polynomial p2 = new polynomial(new double[] {0,0,0,1});

        //test 1 add
        polynomial p3 = p1.add(p2);
        boolean same = true;
        double[] p3_ideal = new double[] {0,0,0,2};
        for(int i = 0; i<p3.getVal().length; i++){
            if(p3_ideal[i]!=p3.getVal()[i]) same = false;
        }
        if(same) pass++;
        else fail++;

        //test 2 subtract
        polynomial p4 = p1.subtract(p2);
        same = true;
        double[] p4_ideal = new double[] {0,0,0,0};
        for(int i = 0; i<p4.getVal().length; i++){
            if(p4_ideal[i]!=p4.getVal()[i]) same = false;
        }
        if(same) pass++;
        else fail++;

        //test 3 multiply
        polynomial p5 = p1.multiply(p2);
        same = true;
        double[] p5_ideal = new double[] {0,0,0,0,0,0,1};
        for(int i = 0; i<p5.getVal().length; i++){
            if(p5_ideal[i]!=p5.getVal()[i]) same = false;
            //System.out.print(" "+ p5.getVal()[i] + " ");
        }
        if(same) pass++;
        else fail++;

        /*
        for tests of order 1 polynomials
         */

        //test 4 add
        polynomial p11 = new polynomial(new double[] {0,0,1,1}); // 0,0,1,1
        polynomial p12 = new polynomial(new double[] {0,0,2,1});//0,2,2,0
        polynomial p13 = p11.add(p12);
        same = true;
        double[] p13_ideal = new double[] {0,0,3,2};
        for(int i = 0; i<p13.getVal().length; i++){
            if(p13_ideal[i]!=p13.getVal()[i]) same = false;
        }
        if(same) pass++;
        else fail++;

        //test 5 subtract
        polynomial p14 = p11.subtract(p12);
        same = true;
        double[] p14_ideal = new double[] {0,0,-1,0};
        for(int i = 0; i<p14.getVal().length; i++){
            if(p14_ideal[i]!=p14.getVal()[i]) same = false;
        }
        if(same) pass++;
        else fail++;

        //test 6 multiply
        polynomial p15 = p11.multiply(p12);
        same = true;
        double[] p15_ideal = new double[] {0,0,0,0,2,3,1};
        for(int i = 0; i<p15.getVal().length; i++){
            if(p15_ideal[i]!=p15.getVal()[i]) same = false;
            //System.out.print(" "+ p5.getVal()[i] + " ");
        }
        if(same) pass++;
        else fail++;

        /*
        for tests of order 2 polynomials
         */

        //test 7 add
        polynomial p21 = new polynomial(new double[] {0,1,1,1});
        polynomial p22 = new polynomial(new double[] {0,1,2,1});
        // 0, 0, 0, 0, 1, 1, 1
        // 0, 0, 0, 2, 2, 2, 0
        // 0, 0, 1, 1, 1, 0, 0
        // 0, 0, 1, 3, 4, 3, 1
        polynomial p23 = p21.add(p22);
        same = true;
        double[] p23_ideal = new double[] {0,2,3,2};
        for(int i = 0; i<p23.getVal().length; i++){
            if(p23_ideal[i]!=p23.getVal()[i]) same = false;
        }
        if(same) pass++;
        else fail++;

        //test 8 subtract
        polynomial p24 = p21.subtract(p22);
        same = true;
        double[] p24_ideal = new double[] {0,0,-1,0};
        for(int i = 0; i<p24.getVal().length; i++){
            if(p24_ideal[i]!=p24.getVal()[i]) same = false;
        }
        if(same) pass++;
        else fail++;

        //test 9 multiply
        polynomial p25 = p21.multiply(p22);
        same = true;
        double[] p25_ideal = new double[] {0, 0, 1, 3, 4, 3, 1};
        for(int i = 0; i<p25.getVal().length; i++){
            if(p25_ideal[i]!=p25.getVal()[i]) same = false;
            //System.out.print(" "+ p5.getVal()[i] + " ");
        }
        if(same) pass++;
        else fail++;

        /*
        for tests of order 2 gapped polynomials
         */

        //test 10 add
        polynomial p2g1 = new polynomial(new double[] {0,1,0,1});
        polynomial p2g2 = new polynomial(new double[] {0,1,2,1});
        // 0, 0, 0, 0, 1, 0, 1
        // 0, 0, 0, 2, 0, 2, 0
        // 0, 0, 1, 0, 1, 0, 0

        // 0, 0, 1, 2, 2, 2, 1
        polynomial p2g3 = p2g1.add(p2g2);
        same = true;
        double[] p2g3_ideal = new double[] {0,2,2,2};
        for(int i = 0; i<p2g3.getVal().length; i++){
            if(p2g3_ideal[i]!=p2g3.getVal()[i]) same = false;
        }
        if(same) pass++;
        else fail++;

        //test 11 subtract
        polynomial p2g4 = p2g1.subtract(p2g2);
        same = true;
        double[] p2g4_ideal = new double[] {0,0,-2,0};
        for(int i = 0; i<p2g4.getVal().length; i++){
            if(p2g4_ideal[i]!=p2g4.getVal()[i]) same = false;
        }
        if(same) pass++;
        else fail++;

        //test 12 multiply
        polynomial p2g5 = p2g1.multiply(p2g2);
        same = true;
        double[] p2g5_ideal = new double[] {0, 0, 1, 2, 2, 2, 1};
        for(int i = 0; i<p2g5.getVal().length; i++){
            if(p2g5_ideal[i]!=p2g5.getVal()[i]) same = false;
            //System.out.print(" "+ p2g5.getVal()[i] + " ");
        }
        if(same) pass++;
        else fail++;

        System.out.println("tests passed: " + pass + "/" + (pass+fail));
    }
}
//spectral method - compute a fourier transform
// no particles -- eulerian - force at a location
// yes particles -- la grangian - force at a location with a particle
//write a method that takes a particle with a location and mass and produces a 2d array representing the force field
// {2,1 ; 7,1} - LaGrangian
// {0,0 ; 1,0 ; 2,1 ; 3,0 ; 4,0 ; 5,0 ; 6,0 ; 7,1} - Eulerian