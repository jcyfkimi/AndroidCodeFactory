package com.example.androidcodefactory.widget.ImageView;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class GetBitmapFromImageView {
	
	/**
	 * 
	 * @Title: getBitmap
	 * @Description: get bitmap from imageview object
	 * @param: @param img ImageView object
	 * @param: @return
	 * @return: Bitmap
	 * @throw
	 */
	public static Bitmap getBitmap(ImageView img){
		img.setDrawingCacheEnabled(true);
		Bitmap bm = img.getDrawingCache();
		img.setDrawingCacheEnabled(false);
		return bm;
	}

}
