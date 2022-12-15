public class polynomial {
    private double[] values;
    public polynomial(double[] input){
        values = input;
    }
    public double[] getVal(){
        return values;
    }

    public polynomial add(polynomial b){
        double[] a_val = this.getVal();
        double[] b_val = b.getVal();
        double[] c_val = new double[Math.max(a_val.length, b_val.length)];
        for(int i = 0; i< a_val.length; i++) c_val[i] += a_val[i];
        for(int j = 0; j< b_val.length; j++) c_val[j] += b_val[j];
        polynomial c = new polynomial(c_val);
        return c;
    }

    public polynomial subtract(polynomial b){
        double[] a_val = this.getVal();
        double[] b_val = b.getVal();
        double[] c_val = new double[Math.max(a_val.length, b_val.length)];
        for(int i = 0; i< a_val.length; i++) c_val[i] += a_val[i];
        for(int j = 0; j< b_val.length; j++) c_val[j] -= b_val[j];
        polynomial c = new polynomial(c_val);
        return c;
    }

    public polynomial multiply(polynomial b){
        double[] a_val = this.getVal();
        double[] b_val = b.getVal();
        double[] c_val = new double[a_val.length + b_val.length -1]; //fix through reference of this stack overflow article https://www.geeksforgeeks.org/multiply-two-polynomials-2/

        for(int i = 0; i<a_val.length; i++){
            double ae = a_val[i];
            for(int j = 0; j<b_val.length; j++){
                double be = b_val[j];
                c_val[i+j] += ae*be;
            }
        }

        return new polynomial(c_val);
    }

}
