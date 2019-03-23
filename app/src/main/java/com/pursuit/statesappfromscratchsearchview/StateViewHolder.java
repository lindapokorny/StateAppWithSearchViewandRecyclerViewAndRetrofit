package com.pursuit.statesappfromscratchsearchview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pursuit.statesappfromscratchsearchview.model.State;
import com.pursuit.statesappfromscratchsearchview.model.StateWrapper;

class StateViewHolder extends RecyclerView.ViewHolder {
private TextView nameTextView;
private TextView capitalTextView;

    @Override
    public String toString() {
        return super.toString();
    }

    public StateViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.name_textview);
        capitalTextView = itemView.findViewById(R.id.capital_textview);
    }
    public void onBind(State state){
        nameTextView.setText(state.getName());
        capitalTextView.setText(state.getCapital());
    }

}