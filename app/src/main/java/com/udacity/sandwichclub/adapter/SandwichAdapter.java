package com.udacity.sandwichclub.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.sandwichclub.R;

public class SandwichAdapter extends RecyclerView.Adapter<SandwichViewHolder> {

	private Context context;
	private String[] listSandwiches;
	private SandwichCallback sandwichCallback;

	public SandwichAdapter(@NonNull Context context, @NonNull String[] listSandwiches, @NonNull SandwichCallback callback) {
		this.context = context;
		this.listSandwiches = listSandwiches;
		this.sandwichCallback = callback;
	}

	@Override
	public SandwichViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new SandwichViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent, false));
	}

	@Override
	public void onBindViewHolder(SandwichViewHolder holder, final int position) {
		holder.txtItem.setText(listSandwiches[position]);
		holder.root.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				sandwichCallback.onSandwichSelected(position);
			}
		});
	}

	@Override
	public int getItemCount() {
		return listSandwiches.length;
	}
}
