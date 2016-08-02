package com.sharathp.fragmentnavigation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sharathp.fragmentnavigation.R;

public class DummyFragment1 extends Fragment {
    private CallbackOne mCallbackOne;

    public static DummyFragment1 newInstance() {
        DummyFragment1 fragment = new DummyFragment1();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbackOne = (CallbackOne) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dummy_1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn_frag1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallbackOne.fragOneButtonClicked();
            }
        });
    }

    public interface CallbackOne {
        void fragOneButtonClicked();
    }
}
