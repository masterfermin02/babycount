package com.babycount.fpapp.babycount.Counts;

import com.babycount.fpapp.babycount.BasePresenter;
import com.babycount.fpapp.babycount.BaseView;

public interface CountContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

        void loadItems(boolean forceUpdate);

    }
}
