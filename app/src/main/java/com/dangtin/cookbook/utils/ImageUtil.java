/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;

import java.io.ByteArrayOutputStream;

public class ImageUtil {

    public static int getScreenWidth(Activity act) {
        DisplayMetrics dm = new DisplayMetrics();
        act.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    public static double getScreenWidthAsInch(Activity act) {
        DisplayMetrics dm = new DisplayMetrics();
        act.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        int dens = dm.densityDpi;
        double wi = (double) width / (double) dens;
        double hi = (double) height / (double) dens;
        double x = Math.pow(wi, 2);
        double y = Math.pow(hi, 2);
        return Math.sqrt(x + y);
    }

    public static void calViewRatio(Activity act, View img, int x, int y, int subtract) {
        int w = getScreenWidth(act) - subtract;
        img.getLayoutParams().width = w;
        img.getLayoutParams().height = w * y / x;
    }

    public static String getFilePathFromUri(Context context, Uri uri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(uri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return "";
    }

    public static final String convertBitmapToBase64(Bitmap bitmap, String extention) {
        if (bitmap != null) {
            Bitmap.CompressFormat ext = extention.equals("jpg") == true ?
                    Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(ext, 100, stream);
            byte[] imageToByte = stream.toByteArray();
            return Base64.encodeToString(imageToByte, Base64.DEFAULT);
        }
        return "";
    }

    public static final String convertBitmapToBase64(Bitmap bitmap) {
        if (bitmap != null) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] imageToByte = stream.toByteArray();
            return Base64.encodeToString(imageToByte, Base64.DEFAULT);
        }
        return "";
    }

    public static Bitmap convertBase64ToBitmap(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    // Decode bitmap
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth,
                                            int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    public static Bitmap decodeBitmapFromResource(Resources res, int resId, int reqWidth,
                                                  int reqHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static Bitmap decodeBitmapFromFile(String imageFile, int reqWidth, int reqHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imageFile, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(imageFile, options);
    }

    public static Bitmap decodeBitmapFromBitmap(Bitmap bitmap, String extention, int reqWidth,
                                                int reqHeight) {
        Bitmap.CompressFormat ext = extention.equals("jpg") == true ? Bitmap.CompressFormat.JPEG :
                Bitmap.CompressFormat.PNG;
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        ByteArrayOutputStream blob = new ByteArrayOutputStream();
        bitmap.compress(ext, 100, blob);
        byte[] bitmapData = blob.toByteArray();
        BitmapFactory.decodeByteArray(bitmapData, 0, bitmapData.length, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bitmapData, 0, bitmapData.length, options);
    }

    public static Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return resizedBitmap;
    }
}
