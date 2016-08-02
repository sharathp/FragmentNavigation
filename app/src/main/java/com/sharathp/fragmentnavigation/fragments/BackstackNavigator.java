package com.sharathp.fragmentnavigation.fragments;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.HashMap;
import java.util.Map;

public class BackstackNavigator {
    // key is the "current" tag, value is the (previous) tag to be popped (inclusive)
    private final Map<String, String> mTagMap = new HashMap<>();
    private final FragmentManager mFragmentManager;

    public BackstackNavigator(final FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    public boolean handleBack() {
        final int backStackEntryCount = mFragmentManager.getBackStackEntryCount();
        if (backStackEntryCount == 0) {
            return false;
        }

        final FragmentManager.BackStackEntry topBackStackEntry = mFragmentManager.getBackStackEntryAt(backStackEntryCount - 1);

        // find the tag to be popped inclusively using the tag of the top most back stack entry
        final String tagToPopInclusive = mTagMap.get(topBackStackEntry.getName());

        if (tagToPopInclusive == null) {
            return false;
        }

        mFragmentManager.popBackStackImmediate(tagToPopInclusive, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        return true;
    }

    public int noAddToBackStack(@IdRes final int containerId, final Fragment fragment) {
        // only allow the first fragment to be "no addToBackStack"
        if (mFragmentManager.getBackStackEntryCount() > 0) {
            throw new IllegalStateException("Only the first transaction can be pushed without adding to backstack");
        }

        return add(containerId, fragment, false, null);
    }

    public int addToBackStack(@IdRes final int containerId, final String tag, final Fragment fragment, final String tagInclusiveToPop) {

        // TODO - also verify that tagInclusiveToPop actually exists in the back stack?
        if (tagInclusiveToPop != null) {
            mTagMap.put(tag, tagInclusiveToPop);
        }

        return add(containerId, fragment, true, tag);
    }

    private int add(@IdRes final int containerId, final Fragment fragment, final boolean addToBackStack, final String tag) {
        final FragmentTransaction transaction = mFragmentManager.beginTransaction();

        if (addToBackStack) {
            transaction.addToBackStack(tag);
        }

        // use commitAllowingStateLoss bug: https://code.google.com/p/android/issues/detail?id=19917
        return transaction.replace(containerId, fragment, tag).commitAllowingStateLoss();
    }
}