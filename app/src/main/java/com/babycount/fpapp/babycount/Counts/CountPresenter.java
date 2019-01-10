package com.babycount.fpapp.babycount.Counts;

import android.support.annotation.NonNull;
import static com.google.common.base.Preconditions.checkNotNull;

public class CountPresenter implements CountContract.Presenter {

    private CountContract.View mCountView;

    public CountPresenter(@NonNull CountContract.View countView)
    {
        mCountView = checkNotNull(countView, "countView cannot be null!");
        mCountView.setPresenter(this);
    }

    @Override
    public void start() {

        loadItems(false);
    }

    public void loadItems(boolean forceUpdate)
    {

    }
}
