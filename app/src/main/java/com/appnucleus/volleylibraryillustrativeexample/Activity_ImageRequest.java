package com.appnucleus.volleylibraryillustrativeexample;

import volley.AppController;
import volley.Config_URL;

import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Cache;
import com.android.volley.Cache.Entry;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class Activity_ImageRequest extends Activity
{
	private static final String TAG = Activity_ImageRequest.class
			.getSimpleName();
	private Button btnImageReq;
	private NetworkImageView imgNetWorkView;
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);

		btnImageReq = (Button) findViewById(R.id.btnImageReq);
		imgNetWorkView = (NetworkImageView) findViewById(R.id.imgNetwork);
		imageView = (ImageView) findViewById(R.id.imgView);

		btnImageReq.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				makeImageRequest();
			}
		});
	}

	private void makeImageRequest() {
		ImageLoader imageLoader = AppController.getInstance().getImageLoader();

		// If you are using NetworkImageView
		imgNetWorkView.setImageUrl(Config_URL.get_Image_URL(), imageLoader);

		
		// If you are using normal ImageView
		/*imageLoader.get(Config_URL.URL_IMAGE, new ImageListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Log.e(TAG, "Image Load Error: " + error.getMessage());
			}

			@Override
			public void onResponse(ImageContainer response, boolean arg1) {
				if (response.getBitmap() != null) {
					// load image into imageview
					imageView.setImageBitmap(response.getBitmap());
				}
			}
		});*/

		// Loading image with placeholder and error image
		imageLoader.get(Config_URL.get_Image_URL(), ImageLoader.getImageListener(
				imageView, R.mipmap.ico_loading, R.mipmap.ico_error));
		
		Cache cache = AppController.getInstance().getRequestQueue().getCache();
		Entry entry = cache.get(Config_URL.get_Image_URL());
		if(entry != null){
			try {
				String data = new String(entry.data, "UTF-8");
				// handle data, like converting it to xml, json, bitmap etc.,
			} catch (UnsupportedEncodingException e) {		
				e.printStackTrace();
			}
		}else{
			// cached response doesn't exists. Make a network call here
		}

	}
}
