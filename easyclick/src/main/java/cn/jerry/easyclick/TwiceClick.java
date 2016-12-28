package cn.jerry.easyclick;

import android.view.View;

/**
 * Created by jerry on 12/28/16.
 */

public abstract class TwiceClick implements View.OnClickListener {

    @Override
    public void onClick(View v) {

        DataStorage dataStorage = DataStorage.newInstance(v.getContext());
        if (dataStorage.isTwiceClick(v)) {
            secondClick(v);
        } else {
            firstClick(v);
        }
    }

    protected abstract void firstClick(View view);

    protected abstract void secondClick(View view);
}
