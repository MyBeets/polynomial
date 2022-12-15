//updated according to the princeton Complex class linked here https://introcs.cs.princeton.edu/java/32class/complexPolynomial.java.html

public class complexPolynomial{
    private polynomial real;
    private polynomial complex;

    public complexPolynomial(double[] input, double[]c_input) {
        real = new polynomial(input);
        complex = new polynomial(c_input);
    }

    public complexPolynomial(polynomial input, polynomial c_input) {
        real = input;
        complex = c_input;
    }
    public polynomial getReal(){
        return real;
    }
    public  polynomial getComplex(){
        return complex;
    }
    public complexPolynomial add(complexPolynomial this, complexPolynomial b){
        return new complexPolynomial(this.getReal().add(b.getReal()), this.getComplex().add(b.getComplex()));
    }
    public complexPolynomial subtract(complexPolynomial b){
        return new complexPolynomial(this.getReal().subtract(b.getReal()), this.getComplex().subtract(b.getComplex()));
    }

    public complexPolynomial multiply(complexPolynomial b){
        //System.out.println("r1:  " + this.getReal().multiply(b.getReal()).getVal()[0]);
        //System.out.println("r2:  " + -this.getComplex().multiply(b.getComplex()).getVal()[0]);
        //System.out.println("c1:  " + this.getReal().multiply(b.getComplex()).getVal()[0]);
        //System.out.println("c2:  " + this.getComplex().multiply(b.getReal()).getVal()[0]);
        polynomial r1 = this.getReal().multiply(b.getReal());

        polynomial r2 = this.getComplex().multiply(b.getComplex());

        polynomial c1 = this.getReal().multiply(b.getComplex());

        polynomial c2 = this.getComplex().multiply(b.getReal());

        double[] real = r1.subtract(r2).getVal();
        double[] complex = c1.add(c2).getVal();

        return new complexPolynomial(real, complex);
    }

    public complexPolynomial scale(double a){
        double[] complex = this.complex.getVal();
        double[] scaled_complex = new double[complex.length];
        for(int i = 0; i<complex.length; i++) scaled_complex[i] = a*complex[i];
        double[] real = this.real.getVal();
        double[] scaled_real = new double[real.length];
        for(int i = 0; i<real.length; i++) scaled_real[i] = a*real[i];
        return new complexPolynomial(scaled_real, scaled_complex);
    }

    public complexPolynomial conjugate(){
        //return new Complex(re, -im); -- from the princeton
        double[] complex = this.complex.getVal();
        double[] neg_complex = new double[complex.length];
        for(int i = 0; i<complex.length; i++) neg_complex[i] = -complex[i];
        return new complexPolynomial(this.real.getVal(), neg_complex);
    }

    public String toString(){
        String real = "";
        String complex = "";
        for(int i = 0; i<this.getReal().getVal().length; i++) if(this.getReal().getVal()[i] != 0 )real += " " + this.getReal().getVal()[i] + "x^" + i +" ";
        for(int i = 0; i<this.getComplex().getVal().length; i++) if(this.getComplex().getVal()[i] != 0 ) complex += " " + this.getComplex().getVal()[i] + "x^" + i + "i" +" ";
        return  real + complex;
    }
}
