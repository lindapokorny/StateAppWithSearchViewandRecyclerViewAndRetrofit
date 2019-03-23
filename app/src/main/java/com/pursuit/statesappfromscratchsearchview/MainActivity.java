package com.pursuit.statesappfromscratchsearchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.TextView;

import com.pursuit.statesappfromscratchsearchview.model.State;
import com.pursuit.statesappfromscratchsearchview.model.StateWrapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity<stateService> extends AppCompatActivity implements SearchView.OnQueryTextListener {

    Retrofit retrofit;
    RecyclerView recyclerView;
    private TextView nameTextview;
    private TextView capitalTextview;
    List<State> state;
    private StateAdapter stateAdapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = RetrofitSingleton.getInstance();
        StateService stateService = retrofit.create(StateService.class);
        Call<StateWrapper> stateWrapperCall = stateService.getState();
        stateWrapperCall.enqueue(new Callback<StateWrapper>() {
            @Override
            public void onResponse(Call<StateWrapper> call, Response<StateWrapper> response) {
                Log.d("Linda", "call" + response.body().AL.getName());
            }

            @Override
            public void onFailure(Call<StateWrapper> call, Throwable t) {
                Log.d("Naomy", "failed" + t.getMessage());
            }
        });
        recyclerView = findViewById(R.id.main_activity_recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        nameTextview = findViewById(R.id.name_textview);
        capitalTextview = findViewById(R.id.capital_textview);
        recyclerView.setAdapter(new StateAdapter((new LinkedList<State>())));
        searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String s) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}