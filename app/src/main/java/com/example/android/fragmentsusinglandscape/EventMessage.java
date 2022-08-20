package com.example.android.fragmentsusinglandscape;

public class EventMessage {
    public boolean ismFragment() {
        return mFragment;
    }

    private boolean mFragment;

    public EventMessage(boolean mFragment) {
        this.mFragment = mFragment;
    }
}
