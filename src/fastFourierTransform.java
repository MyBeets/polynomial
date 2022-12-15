public class fastFourierTransform {

    public static complexPolynomial[] fft(complexPolynomial[] x){ // taken from https://introcs.cs.princeton.edu/java/97data/FFT.java.html
        int n = x.length;

        // base case
        if (n == 1) return new complexPolynomial[] { x[0] };

        // radix 2 Cooley-Tukey FFT
        if (n % 2 != 0) {
            throw new IllegalArgumentException("n is not a power of 2");
        }

        // compute FFT of even terms
        complexPolynomial[] even = new complexPolynomial[n/2];
        for (int k = 0; k < n/2; k++) {
            even[k] = x[2*k];
        }
        complexPolynomial[] evenFFT = fft(even);

        // compute FFT of odd terms
        complexPolynomial[] odd  = even;  // reuse the array (to avoid n log n space)
        for (int k = 0; k < n/2; k++) {
            odd[k] = x[(2*k) + 1];
        }
        complexPolynomial[] oddFFT = fft(odd);

        // combine
        complexPolynomial[] y = new complexPolynomial[n];
        for (int k = 0; k < n/2; k++) {
            double kth = (-2 * k * StrictMath.PI)/1.0 / n;
            complexPolynomial wk = new complexPolynomial(new double[]{StrictMath.cos(kth)}, new double[] {StrictMath.sin(kth)});
            y[k]       = evenFFT[k].add(wk.multiply(oddFFT[k]));
            y[k + n/2] = evenFFT[k].add(wk.multiply(oddFFT[k]));
        }
        return y;
    }
    public static void main(String[] args){
        double[] inputs = {-0.03480425839330703, 0.07910192950176387, 0.7233322451735928, 0.1659819820667019};

        //problem size n
        int n = 4;
        complexPolynomial[] x = new complexPolynomial[n];

        // original data
        for (int i = 0; i < n; i++) {
            x[i] = new complexPolynomial(new double[]{inputs[i]}, new double[] {0});
        }
        System.out.print("x : ");
        for(var e:x){System.out.print(e + "|");}
        System.out.println();

        System.out.println();
        complexPolynomial[] y = fft(x);
        //complexPolynomial[] y = fft(new complexPolynomial[]{x[0]});
        System.out.print("y : ");
        for(var e:y){System.out.print(e + "|");}

    }
}
