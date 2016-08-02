package com.sharathp.fragmentnavigation.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sharathp.fragmentnavigation.R;
import com.sharathp.fragmentnavigation.fragments.BackstackNavigator;
import com.sharathp.fragmentnavigation.fragments.DummyFragment1;
import com.sharathp.fragmentnavigation.fragments.DummyFragment2;
import com.sharathp.fragmentnavigation.fragments.DummyFragment3;
import com.sharathp.fragmentnavigation.fragments.DummyFragment4;
import com.sharathp.fragmentnavigation.fragments.DummyFragment5;
import com.sharathp.fragmentnavigation.fragments.DummyFragment6;

public class MainActivity extends AppCompatActivity implements
        DummyFragment1.CallbackOne,
        DummyFragment2.CallbackTwo,
        DummyFragment3.CallbackThree,
        DummyFragment4.CallbackFour,
        DummyFragment5.CallbackFive,
        DummyFragment6.CallbackSix {

    private static final String TAG_TO_SECOND_FRAGMENT = "TO_SECOND_FRAGMENT";
    private static final String TAG_TO_THIRD_FRAGMENT = "TO_THIRD_FRAGMENT";
    private static final String TAG_TO_FOURTH_FRAGMENT = "TO_FOURTH_FRAGMENT";
    private static final String TAG_TO_FIFTH_FRAGMENT = "TO_FIFTH_FRAGMENT";
    private static final String TAG_TO_SIXTH_FRAGMENT = "TO_SIXTH_FRAGMENT";

    private int mContainerId;

    private BackstackNavigator mBackstackNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBackstackNavigator = new BackstackNavigator(getSupportFragmentManager());
        mContainerId = R.id.fl_container;

        setContentView(R.layout.activity_main);

        // add the first fragment without adding to backstack
        mBackstackNavigator.noAddToBackStack(mContainerId, DummyFragment1.newInstance());
    }

    @Override
    public void fragOneButtonClicked() {
        mBackstackNavigator.addToBackStack(mContainerId, TAG_TO_SECOND_FRAGMENT, DummyFragment2.newInstance(), null);
    }

    @Override
    public void fragTwoButtonClicked() {
        mBackstackNavigator.addToBackStack(mContainerId, TAG_TO_THIRD_FRAGMENT, DummyFragment3.newInstance(), TAG_TO_SECOND_FRAGMENT);
    }

    @Override
    public void fragThreeButtonClicked() {
        mBackstackNavigator.addToBackStack(mContainerId, TAG_TO_FOURTH_FRAGMENT, DummyFragment4.newInstance(), TAG_TO_SECOND_FRAGMENT);
    }

    @Override
    public void fragFourButtonClicked() {
        mBackstackNavigator.addToBackStack(mContainerId, TAG_TO_FIFTH_FRAGMENT, DummyFragment5.newInstance(), TAG_TO_THIRD_FRAGMENT);
    }

    @Override
    public void fragFiveButtonClicked() {
        mBackstackNavigator.addToBackStack(mContainerId, TAG_TO_SIXTH_FRAGMENT, DummyFragment6.newInstance(), null);
    }

    @Override
    public void fragSixButtonClicked() {
        // no-op
    }

    @Override
    public void onBackPressed() {
        if (mBackstackNavigator.handleBack()) {
            // navigator handled this, do nothing
            return;
        }
        super.onBackPressed();
    }
}
