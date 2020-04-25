package com.udacity.sandwichclub.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.sandwichclub.R;

class SandwichViewHolder extends RecyclerView.ViewHolder {

	AppCompatTextView txtItem;
	ViewGroup root;

	SandwichViewHolder(View itemView) {
		super(itemView);
		root = itemView.findViewById(R.id.root);
		txtItem = itemView.findViewById(R.id.txt_item);
	}
}
