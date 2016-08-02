package com.sharathp.fragmentnavigation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sharathp.fragmentnavigation.R;

public class DummyFragment6 extends Fragment {
    private CallbackSix mCallbackSix;

    public static DummyFragment6 newInstance() {
        DummyFragment6 fragment = new DummyFragment6();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbackSix = (CallbackSix) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dummy_6, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn_frag6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallbackSix.fragSixButtonClicked();
            }
        });
    }

    public interface CallbackSix {
        void fragSixButtonClicked();
    }
}
