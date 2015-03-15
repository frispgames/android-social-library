package com.frispgames.frispsocial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import com.unity3d.player.UnityPlayer;

public class FrispSocial {

    public static void shareImage(String caption, String message, String media) {
        try {
            byte[] byteArray = Base64.decode(media, 0);

            Uri image = getImageUri(UnityActivity(), byteArray);

            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("image/*");
            shareIntent.putExtra(Intent.EXTRA_TEXT, message);
            shareIntent.putExtra(Intent.EXTRA_STREAM, image);
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            unityActivity().startActivity(Intent.createChooser(shareIntent, caption));

        } catch (Exception e) {
          e.printStackTrace();
        }
    }

    private static Uri getImageUri(Context Context, byte[] byteArray) {
        try {
            Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

            ByteArrayOutputStream bytes = new ByteArrayOutputStream();

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

            String path = MediaStore.Images.Media.insertImage(Context.getContentResolver(), bitmap, "Screenshot", null);

            return Uri.parse(path);
        } catch (Exception ex) {
            Log.d("FrispSocial", ex.getMessage());
        }

        return Uri.parse("");
    }

    private static Activity unityActivity() {
        return UnityPlayer.currentActivity;
    }
}