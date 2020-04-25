package com.udacity.sandwichclub.adapter;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.udacity.sandwichclub.R;

public class SandwichViewHolder extends RecyclerView.ViewHolder {

	AppCompatTextView txtItem;
	AppCompatImageView imgItem;

	public SandwichViewHolder(View itemView) {
		super(itemView);
		txtItem = itemView.findViewById(R.id.txt_item);
		imgItem = itemView.findViewById(R.id.image_item);
	}
}
