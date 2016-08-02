package com.sharathp.fragmentnavigation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sharathp.fragmentnavigation.R;

public class DummyFragment3 extends Fragment {
    private CallbackThree mCallbackThree;

    public static DummyFragment3 newInstance() {
        DummyFragment3 fragment = new DummyFragment3();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbackThree = (CallbackThree) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dummy_3, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn_frag3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallbackThree.fragThreeButtonClicked();
            }
        });
    }

    public interface CallbackThree {
        void fragThreeButtonClicked();
    }
}
