package com.github.chen0040.data.image;


import com.github.chen0040.data.frame.DataFrame;
import com.github.chen0040.data.image.utils.FileUtils;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.testng.Assert.*;


/**
 * Created by xschen on 24/5/2017.
 */
public class ImageDataFrameFactoryUnitTest {

   @Test
   public void test_load_image_into_frame() throws IOException {
      BufferedImage img= ImageIO.read(FileUtils.getResource("1.jpg"));

      DataFrame batch = ImageDataFrameFactory.dataFrame(img);

      System.out.println(batch.head(10));
   }
}
