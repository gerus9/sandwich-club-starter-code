package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

	public static final String EXTRA_POSITION = "extra_position";
	private static final int DEFAULT_POSITION = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		int position = getPosition(getIntent());
		if (position == DEFAULT_POSITION) {
			closeOnError();
		} else {
			String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
			String json = sandwiches[position];
			Sandwich sandwich = JsonUtils.parseSandwichJson(json);
			if (sandwich == null) {
				closeOnError();
			} else {
				populateUI(sandwich);
			}
		}
	}

	private int getPosition(Intent intent) {
		if (intent == null) {
			return DEFAULT_POSITION;
		}
		return intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
	}

	private void closeOnError() {
		finish();
		Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
	}

	private void populateUI(Sandwich sandwich) {
		setTitle(sandwich.getMainName());
		setImage(R.id.img_photo, sandwich.getImage());
		setText(R.id.txt_also_label, R.id.txt_also, getListAsString(sandwich.getAlsoKnownAs()));
		setText(R.id.txt_ingredients_label, R.id.txt_ingredients, getListAsString(sandwich.getIngredients()));
		setText(R.id.txt_origin_label, R.id.txt_origin, sandwich.getPlaceOfOrigin());
		setText(R.id.txt_description_label, R.id.txt_description, sandwich.getDescription());
	}

	private void setImage(int idImage, String image) {
		AppCompatImageView ingredientsIv = findViewById(idImage);
		if (ingredientsIv != null) {
			if (TextUtils.isEmpty(image)) {
				ingredientsIv.setVisibility(View.GONE);
			} else {
				Picasso.with(this).load(image).into(ingredientsIv);
			}
		}
	}

	private void setText(int idLabel, int idSubtitle, String text) {
		AppCompatTextView txtLabel = findViewById(idLabel);
		AppCompatTextView txtDescription = findViewById(idSubtitle);
		if(TextUtils.isEmpty(text)){
			if(txtLabel!=null) txtLabel.setVisibility(View.GONE);
			if(txtDescription!=null) txtDescription.setVisibility(View.GONE);
		} else {
			if(txtDescription!=null) txtDescription.setText(text);
		}
	}

	private String getListAsString(List<String> stringList) {
		return android.text.TextUtils.join(",", stringList);
	}
}
