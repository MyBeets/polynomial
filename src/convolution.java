public class convolution {
    //multiply two functions and get the integral
    // integral of -infinite to infinite of f(x) g(u-x) dx
    //takes 2 lists of integers
    //takes the dot product of the two arrays shifts one
    convolution(){

    }
    public int[] convolve(int[] a, int[] b){
        int[] c = new int[a.length];
        for(int ae : a){
            for(int be: b){
                ae*be
            }
        }
        return new int[0];
    }
}
