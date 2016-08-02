package com.sharathp.fragmentnavigation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sharathp.fragmentnavigation.R;

public class DummyFragment4 extends Fragment {
    private CallbackFour mCallbackFour;

    public static DummyFragment4 newInstance() {
        DummyFragment4 fragment = new DummyFragment4();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbackFour = (CallbackFour) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dummy_4, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn_frag4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallbackFour.fragFourButtonClicked();
            }
        });
    }

    public interface CallbackFour {
        void fragFourButtonClicked();
    }
}
