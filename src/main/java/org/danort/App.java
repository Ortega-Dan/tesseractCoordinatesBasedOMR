package org.danort;

import java.awt.image.BufferedImage;
import java.awt.Color;
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

        for (int i = 0; i < 5; i++) {
            System.out.println();
            System.out.println("Image Level " + i);

            File imageFile = new File("src/main/java/resources/dark" + i + ".png");

            BufferedImage bi = ImageIO.read(imageFile);

            int width = bi.getWidth();
            int height = bi.getHeight();

            System.out.println(width + "x" + height);

            int howMany = width * height;
            int sum = 0;

            for (int col = 0; col < width; col++) {
                for (int row = 0; row < height; row++) {
                    // ANDing the resulting color integer with 255 (0xff) in order to get the result
                    // for the first channel (blue) ... since this is for grayscaled images all
                    // non-alpha channels should have the same level of light, otherwise there would
                    // be color seen
                    Color color = new Color(bi.getRGB(col, row));

                    int max = 0;

                    int r = color.getRed();
                    if (r > max) {
                        max = r;
                    }

                    int g = color.getGreen();
                    if (g > max) {
                        max = g;
                    }

                    int b = color.getBlue();
                    if (b > max) {
                        max = b;
                    }

                    sum += max;
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

}