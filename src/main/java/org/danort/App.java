package org.danort;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * THIS CLASS' MAIN METHOD IS GETTING THE PIXELATION PERCENTAGE FROM A PNG
 * GRAYSCALE IMAGE (IT DOESN'T WORK FOR COLORED PNGS SINCE THE CALCULATION IS
 * BEING DONE BY CONSIDERING ONLY ONE OF THE COLOR CHANNELS)
 *
 */
public class App {
    public static void main(String[] args) throws Exception {

        // THE IMAGE GIVEN WOULD BE A SUBIMAGE EXTRACTED FROM THE CALCULATED COORDINATES
        // CORRESPONDING TO THE AREA TO ANALIZE ... AND THE AREA WILL BE BROUGHT FROM
        // THE CORRESPONDENCE TO THE COORDINATES GOT FROM KEYS FROM TEXT
        // TO GET THAT SUB AREA DO... 
        // originalBufferedImage.getSubimage(x, y, width, height) 

        // File imageFile = new
        // File("/home/danort/Desktop/WORKING_DAVIVIENDA/javaOmr/image.png");
        File imageFile = new File("src/main/java/resources/dark0.png");

        BufferedImage bi = ImageIO.read(imageFile);

        int width = bi.getWidth();
        int height = bi.getHeight();

        System.out.println(width + "x" + height);

        int howMany = width * height;
        int sum = 0;

        for (int c = 0; c < width; c++) {
            for (int r = 0; r < height; r++) {
                // ANDing the resulting color integer with 255 (0xff) in order to get the result
                // for the first channel (blue) ... since this is for grayscaled images all
                // non-alpha channels should have the same level of light, otherwise there would
                // be color seen
                sum += (bi.getRGB(c, r) & 0xff);
            }
        }

        System.out.println("Sum = " + sum);
        int avg = sum / howMany;
        System.out.println("Avg = " + sum / howMany);
        int lightOrWhitePercentage = (avg * 100) / 255;
        System.out.println("Light or white % = " + lightOrWhitePercentage);
        System.out.println("Pixelation % = " + (lightOrWhitePercentage - 100) * -1);

    }

}
