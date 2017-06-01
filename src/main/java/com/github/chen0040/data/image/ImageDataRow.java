package com.github.chen0040.data.image;


import com.github.chen0040.data.frame.BasicDataRow;
import com.github.chen0040.data.frame.DataRow;
import lombok.Getter;
import lombok.Setter;


/**
 * Created by xschen on 1/6/2017.
 */
@Getter
@Setter
public class ImageDataRow extends BasicDataRow {
   private int pixelX;
   private int pixelY;

   @Override
   public void copy(DataRow row){
      super.copy(row);
      if(row instanceof ImageDataRow) {
         ImageDataRow obj = (ImageDataRow) row;
         pixelX = obj.pixelX;
         pixelY = obj.pixelY;
      }
   }
}
