package com.pursuit.statesappfromscratchsearchview;

import com.pursuit.statesappfromscratchsearchview.model.StateWrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StateService {
    @GET("jpriebe/d62a45e29f24e843c974/raw/b1d3066d245e742018bce56e41788ac7afa60e29/us_state_capitals.json")
    Call <StateWrapper> getState();
}
