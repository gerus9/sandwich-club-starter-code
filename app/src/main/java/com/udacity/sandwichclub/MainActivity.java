package com.udacity.sandwichclub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.udacity.sandwichclub.adapter.SandwichAdapter;
import com.udacity.sandwichclub.adapter.SandwichCallback;

public class MainActivity extends AppCompatActivity implements SandwichCallback {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        setContentView(R.layout.activity_main);

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_names);

        RecyclerView recyclerView = findViewById(R.id.sandwiches_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new SandwichAdapter(context, sandwiches, this));
    }

    private void launchDetailActivity(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_POSITION, position);
        startActivity(intent);
    }

    @Override
    public void onSandwichSelected(int position) {
        launchDetailActivity(position);
    }
}
