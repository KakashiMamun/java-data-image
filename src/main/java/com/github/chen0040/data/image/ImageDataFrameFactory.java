package com.github.chen0040.data.image;


import com.github.chen0040.data.frame.BasicDataFrame;
import com.github.chen0040.data.frame.DataFrame;
import com.github.chen0040.data.frame.DataRow;

import java.awt.image.BufferedImage;
import java.util.Random;


/**
 * Created by xschen on 10/7/2016.
 */
public class ImageDataFrameFactory {
    public static int get_rgb(int alpha, int r, int g, int b)
    {
        return (alpha << 24) | (r << 16) | (g << 8) | b;
    }

    public static int get_r(int rgb)
    {
        return (rgb >> 16) & 0xff;
    }

    public static int get_b(int rgb)
    {
        return (rgb & 0xff);
    }

    public static int get_g(int rgb)
    {
        return (rgb >> 8) & 0xff;
    }

    public static int get_luminance(int r, int g, int b)
    {
        return (int)(r * 0.3+ g * 0.59 + b * 0.11);
    }

    public static int get_luminance(int rgb)
    {
        int r=((rgb >> 16) & 0xff);
        int g=((rgb >> 8) & 0xff);
        int b=(rgb & 0xff);

        int gray=get_luminance(r, g, b);

        return gray;
    }

    public static DataRow getPixelTuple(int x, int y, int rgb){
        ImageDataRow row = new ImageDataRow();
        row.setPixelX(x);
        row.setPixelY(y);

        double r = get_r(rgb);
        double g = get_g(rgb);
        double b = get_b(rgb);
        double l = get_luminance(rgb);
        row.setCell("r", r);
        row.setCell("g", g);
        row.setCell("b", b);
        row.setCell("l", l);

        return row;
    }

    private static Random rand = new Random();

    public static DataFrame dataFrame(BufferedImage img){
        DataFrame batch = new BasicDataFrame();
        for(int i=0; i < 3000; i++)
        {
            int x = rand.nextInt(img.getWidth());
            int y = rand.nextInt(img.getHeight());

            int rgb = img.getRGB(x, y);
            DataRow row = getPixelTuple(x, y, rgb);
            batch.addRow(row);
        }
        batch.lock();
        return batch;
    }


}
