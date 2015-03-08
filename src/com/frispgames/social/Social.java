package com.frispgames.social;

import com.unity3d.player.UnityPlayerActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by treach3r on 8/03/15.
 */
public class Social extends UnityPlayerActivity {

    private static Social singleton = null;
    private Context context;

    public static Social instance() {
        if(singleton == null) {
            singleton = new Social();
        }
        return singleton;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void shareImage(String text, String image) {
        Log.d("BouncyBones", "Sharing bro!");
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareIntent.putExtra(Intent.EXTRA_STREAM, image);
        shareIntent.setType("image/jpeg");
        startActivity(Intent.createChooser(shareIntent, "Bouncy Bones"));
    }
}