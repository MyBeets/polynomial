public class convolution {
    //multiply two functions and get the integral
    // integral of -infinite to infinite of f(x) g(u-x) dx
    //takes 2 lists of integers
    //takes the dot product of the two arrays shifts one
    convolution(){

    }
    //from this stack overflow thread https://stackoverflow.com/questions/31701089/vector-convolution-calculating-the-index-of-a-neighbour-element
    public static int[] convolve(int[] image, int[] kernel)
    {
        int[] output = new int[image.length];

        // loop through image
        for(int i = 0; i < image.length; i++)
        {
            System.out.println("Compute output["+i+"]");
            int outputValue = 0;

            // loop through kernel
            for(int j = 0; j < kernel.length; j++)
            {
                int neighbour = i + j - (kernel.length / 2);

                // discard out of bound neighbours
                if (neighbour >= 0 && neighbour < image.length)
                {
                    int imageValue = image[neighbour];
                    int kernelValue = kernel[j];
                    outputValue += imageValue * kernelValue;
                    System.out.println("image["+neighbour+"] and kernel["+j+"]");
                }
            }

            output[i] = outputValue;
        }

        return output;
    }
}
