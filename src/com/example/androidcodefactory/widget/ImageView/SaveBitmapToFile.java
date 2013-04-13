package com.example.androidcodefactory.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;

import android.graphics.Bitmap;

public class SaveBitmapToFile {

	/**
	 * 
	 * @Title: saveBitmapToFile
	 * @Description: Save Bitmap To File
	 * @param: @param path example /sdcard/temp/temp.jpg(.png)
	 * @param: @param bmp Bitmap for saving
	 * @param: @return
	 * @return: boolean
	 * @throw
	 */
	public static boolean saveBitmapToFile(String path, Bitmap bmp){
		boolean rt = false;
		if((null == path) || (path.length() <= 0) || (null == bmp)){
			rt = false;
		}
		int i = path.lastIndexOf('.');
		if(i <= 0){
			rt = false;
		}
		String ext = path.substring( i + 1).toUpperCase();
		Bitmap.CompressFormat bcf = null;
		if(ext.equals("JPG") || ext.equals("JPEG")){
			bcf = Bitmap.CompressFormat.JPEG;
		} else if(ext.equals("PNG")){
			bcf = Bitmap.CompressFormat.PNG;
		} else {
			rt = false;
		}
		try{
			File f = new File(path);
			File p = f.getParentFile();
			if((null != p) && !p.exists()){
				p.mkdirs();
			}
			if(!f.exists()){
				f.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(f);
			bmp.compress(bcf, 100, fos);
			fos.flush();
			fos.close();
			rt = true;
		} catch(Exception e){
			e.printStackTrace();
		}
		return rt;
	}
}
