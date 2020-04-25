package com.udacity.sandwichclub.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.udacity.sandwichclub.R;

class SandwichViewHolder extends RecyclerView.ViewHolder {

	AppCompatTextView txtItem;

	SandwichViewHolder(View itemView) {
		super(itemView);
		txtItem = itemView.findViewById(R.id.txt_item);
	}
}
