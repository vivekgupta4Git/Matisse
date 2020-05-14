package com.zhihu.matisse.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.InputStream;

public class ImageUtil {
  /**
   * 判断是否是长图
   */
  public static boolean isLongBitmap(Context context, Uri uri) {
    try {
      InputStream input = context.getContentResolver().openInputStream(uri);
      if (input == null)return false;
      BitmapFactory.Options options = new BitmapFactory.Options();
      options.inJustDecodeBounds = true;
      BitmapFactory.decodeStream(input, null, options);
      input.close();
      return options.outWidth * 3 <= options.outHeight;
    } catch (Exception e) {
      return false;
    }
  }
}
