package com.sharathp.fragmentnavigation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sharathp.fragmentnavigation.R;

public class DummyFragment5 extends Fragment {
    private CallbackFive mCallbackFive;

    public static DummyFragment5 newInstance() {
        DummyFragment5 fragment = new DummyFragment5();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbackFive = (CallbackFive) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dummy_5, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn_frag5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallbackFive.fragFiveButtonClicked();
            }
        });
    }

    public interface CallbackFive {
        void fragFiveButtonClicked();
    }
}
