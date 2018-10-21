/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kfitzgerald
 */
package ait.msc.wk6;

import java.io.*;

public class IntegralImage
{
    static int width;
    static int height;
    static int rotation=45; //sets the initial rotation to 45 degrees
    static int[][] image;
    /**
     * This method sets the width and height of the image that will be used
     * to create the integral images, in this application the width and height
     * are set by the user.
     **/
    static void SetDimensions(int w, int h)
    {
        width = w;
        height = h;
        image = new int[height][width];
    }
    /**
     * This method fills all elements in a 2D array to 0
     * this array will be used for the rotated integral images
     * only.
     */
    static int[][] FillEmptyArray(int[][] arr)
    {
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[0].length; j++)
                arr[i][j]=0;
        return arr;
    }
    static int Sum(int y, int x)
    {
        /**
         * Take in the pixel location y,x
         * The new variables downX and downY are set equal to the pixel location
         */
        int sum = 0, downX=x, downY=y;
        if(rotation==45)
        {
            /**
             * For integral images rotated 45 degrees
             * start at the y pixel location and progress out form
             * the left edge of the original image summing all values
             * until the x position is reached.
             * Initially this sums the values working forward stepping out
             * from the edge of the image.  Then starting at the pixel location
             * and stepping in (decrementing x and y each time) summing values
             * as the algorithm progresses
             */
            //System.out.print(">>------");
            for(int i=downY; i<image.length; i++)
            {
                for(int j=0; j<=downX; j++)
                {
                    sum+=image[i][j];//System.out.print("("+i+","+j+")");
                }
                downX-=1;
            }
            //System.out.print("\n\n\n");
            for(int i=y-1; i>=0; i--)
            {
                for(int j=x-1; j>=0; j--)
                {
                    sum+=image[i][j];//System.out.print("("+i+","+j+")");
                }
                x-=1;
            }
            //System.out.print("------<<\n");
        }
        else if(rotation==135)
        {
            //System.out.print("\n\nRotated Integral Image by 135 Deg\n");
            //System.out.print(">>------\n");
                        /**
             * For integral images rotated 135 degrees
             * start at the y pixel location and progress out form
             * the right edge of the original image summing all values
             * until the x position is reached.
             * Initially this sums the values working forward stepping out
             * from the edge of the image.  Then starting at the pixel location
             * and stepping in (decrementing x and y each time) summing values
             * as the algorithm progresses
             */
            for(int i=downY; i<image.length; i++)
            {
                for(int j=(image[0].length-1); j>=downX; j--)
                {
                    sum+=image[i][j];//System.out.print("("+i+","+j+")");
                }
                //System.out.print("\n");
                downX+=1;
            }
            for(int i=y-1; i>=0; i--)
            {
                for(int j=x+1; j<image[0].length; j++)
                {
                    sum+=image[i][j];//System.out.print("("+i+","+j+")");
                }
                x+=1;
                //System.out.print("\n");
            }
            //System.out.print("------<<\n");System.out.print("\n");
        }
        else
        {
            System.out.println("Not a rotation currently supported");
        }


        return sum;
    }

    static int[][] RotIntImage()
    {

        /**
         * Print off the rotation and create a new
         * 2D rotated integral image with the same width
         * and height of the original image.  Then fill
         * all positions within the new rotated integral image
         * to 0.
         */
        System.out.println("Rotation Selected :-> "+rotation);
        int[][] rii = new int[height][width];
        rii=FillEmptyArray(rii);

        //Set the fist position in the new rii to that of the regional image
        rii[0][0]=image[0][0];
        /**
         * For each position in the new rotated integral image
         * sum all values according to the orientation.  The sum of each
         * pixel location is calculated in the Sum(y,x) method.
         */
        for(int y=0; y<image.length; y++)
            for(int x=0; x<image[0].length; x++)
                rii[y][x]=Sum(y,x);

        return rii;
    }
    static int[][] IntImage()
    {
        /**
         * Create a new integral image to the same size as the origional image
         */
        int[][] IntImage = new int[height][width];

        /**
         * Fill the integral image with the same values as the image
         */
        for(int i=0; i<image.length; i++)
            for(int j=0; j<image[0].length; j++)
                IntImage[i][j]=image[i][j];

        /**
         *Sums the first column by starting at the second position and adding
         * it with that of the previous position and continues on until the end
         * Then sums the first row with that of the first by starting at
         * the second position and adding it with that of the previous position
         * and continues on until the end
         */

        for (int i = 1; i < IntImage.length; i++)
            IntImage[i][0] += IntImage[i - 1][0];
        for (int j = 1; j < IntImage[0].length; j++)
                IntImage[0][j] += IntImage[0][j - 1];
        
        /**
         * Sums the remainder of positions in the image
         */

        for (int i = 1; i < image.length; i++)
                for (int j = 1; j < IntImage[0].length; j++)
                        IntImage[i][j] += (IntImage[i][j - 1] + IntImage[i - 1][j]) - IntImage[i - 1][j - 1];

        return IntImage;
    }
    /**
     * This method is called to print out any 2D array
     * whether it is the image, integral or rotated integral
     * image
     *
     */
    static StringBuffer print(int[][] array)
    {
        StringBuffer data = new StringBuffer("");
        for(int i=0; i<array.length; i++)
        {
            for(int j=0; j<array[0].length; j++)
            {
                data.append(array[i][j]+" ");
            }
            data.append("\n");
        }
        return data;
    }
    public static void main(String[]args) throws Exception
    {
        /*
         * Ask the user to specify the width and height
         * of the image representation
         */
        int w = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Enter Width"));
        int h = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Enter Height"));
        SetDimensions(w,h);//sets the width and height of the new image
        /*Creates integral images and rotated integral images the same size
         * as the image the user specified.
         */
        int[][] IImage = new int[h][w];
        int[][] RIImage = new int[h][w];

        /*
         * cnt will used to fill the image array, starting at 1
         * and incrementing by one each time, each element is filled
         */
        
        String randYN = javax.swing.JOptionPane.showInputDialog("Enter Y for random matrix or N for position MAtrix");
        if(randYN.equalsIgnoreCase("y"))
        {
            for(int i=0; i<image.length; i++)
                for(int j=0; j<image[0].length; j++)
                    image[i][j]=(int)(Math.random()*255);
        }
        else
        {
            int cnt=1;
            for(int i=0; i<image.length; i++)
                for(int j=0; j<image[0].length; j++){
                    image[i][j]=cnt;cnt++;}//(int)(Math.random()*255);
        }
        
        try
        {
            FileOutputStream f = new FileOutputStream("Integral Image Results.txt");
            PrintWriter p1 = new PrintWriter(f);
            p1.println("\n----------- Image ------------\n");
            p1.print(print(image));
            /*
            * Calculates the Prints off the integral image equivalent
            */
            IImage = IntImage();
            p1.println("\n--- Integral Image ---\n");
            p1.print(print(IImage));
            
            /**
            * Calculates the Prints off the 45 rotated integral image equivalent
            */
            rotation=45;
            RIImage = RotIntImage();
            p1.println("\n--- Integral Image 45 ---\n");
            p1.print(print(RIImage));

            /*
            * Calculates the Prints off the 135 rotated integral image equivalent
            */
            rotation=135;
            RIImage = RotIntImage();
            p1.print("\n------- Integral Image 135 -------\n");
            p1.print(print(RIImage));
            p1.close(); 
        }
        catch(IOException e)
        {
            System.out.println("Exception in writefile..");
            e.printStackTrace();
        }
    }
}
