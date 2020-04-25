package com.udacity.sandwichclub.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonUtils {

	private static String TAG = JsonUtils.class.getSimpleName();

	public static Sandwich parseSandwichJson(String json) {

		if (!TextUtils.isEmpty(json)) {
			try {
				JSONObject jsonSandwich = new JSONObject(json);
				Sandwich sandwich = new Sandwich();

				sandwich.setMainName(getJSONText(jsonSandwich, "mainName"));
				sandwich.setAlsoKnownAs(getArrayList(jsonSandwich, "alsoKnownAs"));
				sandwich.setPlaceOfOrigin(getJSONText(jsonSandwich, "placeOfOrigin"));
				sandwich.setDescription(getJSONText(jsonSandwich, "description"));
				sandwich.setImage(getJSONText(jsonSandwich, "image"));
				sandwich.setIngredients(getArrayList(jsonSandwich, "ingredients"));
				return sandwich;
			} catch (JSONException exception) {
				Log.e(TAG, "Json invalid", exception);
			}
		}
		return null;
	}

	private static List<String> getArrayList(JSONObject jsonSandwich, String key) {
		if (jsonSandwich.has(key)) {
			try {
				JSONArray jsonArray = jsonSandwich.getJSONArray(key);

				List<String> list = new ArrayList<>();
				for (int i = 0, l = jsonArray.length(); i < l; i++) {
					String value = jsonArray.getString(i);
					list.add(value);
				}
				return list;
			} catch (JSONException e) {
				return Collections.emptyList();
			}
		}
		return Collections.emptyList();
	}

	private static String getJSONText(@NonNull JSONObject jsonSandwich, String key) throws JSONException {
		return jsonSandwich.has(key) ? jsonSandwich.getString(key) : "";
	}
}
