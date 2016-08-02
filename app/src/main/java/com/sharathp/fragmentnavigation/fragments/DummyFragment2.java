package com.sharathp.fragmentnavigation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sharathp.fragmentnavigation.R;

public class DummyFragment2 extends Fragment {
    private CallbackTwo mCallbackTwo;

    public static DummyFragment2 newInstance() {
        DummyFragment2 fragment = new DummyFragment2();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbackTwo = (CallbackTwo) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dummy_2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn_frag2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallbackTwo.fragTwoButtonClicked();
            }
        });
    }

    public interface CallbackTwo {
        void fragTwoButtonClicked();
    }
}
