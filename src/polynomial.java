public class polynomial {
    private int[] values;
    public polynomial(int[] input){
        values = input;
    }
    public int[] getVal(){
        return values;
    }

    public polynomial add(polynomial b){
        int[] a_val = this.getVal();
        int[] b_val = b.getVal();
        int[] c_val = new int[] {Math.max(a_val.length, b_val.length)};
        for(int i = 0; i<c_val.length; i++){
            if(i<a_val.length && i<b_val.length) c_val[i] = a_val[i] + b_val[i];
            else if(i<b_val.length) c_val[i] = b_val[i];
            else c_val[i] = a_val[i];
        }
        polynomial c = new polynomial(c_val);
        return c;
    }

    public polynomial subtract(polynomial b){
        int[] a_val = this.getVal();
        int[] b_val = b.getVal();
        int[] c_val = new int[] {Math.max(a_val.length, b_val.length)};
        for(int i = 0; i<c_val.length; i++){
            if(i<a_val.length && i<b_val.length) c_val[i] = a_val[i] - b_val[i];
            else if(i<b_val.length) c_val[i] = -b_val[i];
            else c_val[i] = a_val[i];
        }
        polynomial c = new polynomial(c_val);
        return c;
    }

    public polynomial multiply(polynomial b){
        int[] a_val = this.getVal();
        int[] b_val = b.getVal();
        int[] c_val = new int[a_val.length + b_val.length];

        for(int i = 0; i<a_val.length; i++){
            int ae = a_val[i];
            for(int j = 0; j<b_val.length; j++){
                int be = b_val[j];
                c_val[i+j] = ae*be;

            }
        }

        return new polynomial(c_val);
    }

}
