package com.pursuit.statesappfromscratchsearchview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pursuit.statesappfromscratchsearchview.model.State;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateViewHolder> {
    List<State> state;

    public StateAdapter(List<State> stateList) {
        this.state = stateList;
    }

    @NonNull
    @Override
    public StateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.state__tile_view, viewGroup, false);
        return new StateViewHolder(view) {
            @Override
            public String toString() {
                return super.toString();
            }
        };

    }

    @Override
    public void onBindViewHolder(@NonNull StateViewHolder stateViewHolder, int i) {
        stateViewHolder.onBind(state.get(i));

    }

    @Override
    public int getItemCount() {
        return state.size();
    }
}