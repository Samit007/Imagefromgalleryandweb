package com.example.imagefromweb;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.tvimage);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 0);

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {

                case 0:
                    if (resultCode == Activity.RESULT_OK) {
                        //data gives you the image uri. Try to convert that to bitmap
                        break;
                    } else if (resultCode == Activity.RESULT_CANCELED) {
                        Log.e("", "Selecting picture cancelled");
                    }
                    break;
            }
        } catch (Exception e) {
            Log.e("", "Exception in onActivityResult : " + e.getMessage());
        }
    }
}

//        // Image link from internet
//        new DownloadImageFromInternet((ImageView) findViewById(R.id.tvimage))
//                .execute("https://i.ebayimg.com/images/g/vUUAAOSwa9BbwopI/s-l300.jpg");
//
//
//    }

//    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
//        ImageView imageView;
//
//        public DownloadImageFromInternet(ImageView imageView) {
//            this.imageView = imageView;
//            Toast.makeText(getApplicationContext(), "Please wait, it may take a few minute...", Toast.LENGTH_SHORT).show();
//        }
//
//        protected Bitmap doInBackground(String... urls) {
//            String imageURL = urls[0];
//            Bitmap bimage = null;
//            try {
//                InputStream in = new java.net.URL(imageURL).openStream();
//                bimage = BitmapFactory.decodeStream(in);
//
//            } catch (Exception e) {
//                Log.e("Error Message", e.getMessage());
//                e.printStackTrace();
//            }
//            return bimage;
//        }
//
//        protected void onPostExecute(Bitmap result) {
//            imageView.setImageBitmap(result);
//        }

