public class complexPolynomial{
    private polynomial real;
    private polynomial complex;
    public complexPolynomial(int[] input, int[]c_input) {
        real = new polynomial(input);
        complex = new polynomial(c_input);
    }
    public polynomial getReal(){
        return real;
    }
    public  polynomial getComplex(){
        return complex;
    }
    public complexPolynomial add(complexPolynomial this, complexPolynomial b){
        return new complexPolynomial(this.getReal().add(b.getReal()).getVal(), this.getComplex().add(b.getComplex()).getVal());
    }
    public complexPolynomial subtract(complexPolynomial b){
        return new complexPolynomial(this.getReal().subtract(b.getReal()).getVal(), this.getComplex().subtract(b.getComplex()).getVal());
    }

    public complexPolynomial multiply(complexPolynomial b){
        int[] real = this.getReal().multiply(b.getReal()).add(this.getComplex().multiply(b.getComplex())).getVal();
        int[] complex = this.getReal().multiply(b.getComplex()).add(this.getComplex().multiply(b.getReal())).getVal();
        return new complexPolynomial(real, complex);
    }
}
