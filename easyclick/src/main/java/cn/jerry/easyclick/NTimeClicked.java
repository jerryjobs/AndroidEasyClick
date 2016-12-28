package cn.jerry.easyclick;

import android.view.View;

/**
 * 多次点的情况
 *
 * Created by jerry on 12/28/16.
 */

public abstract class NTimeClicked implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        DataStorage dataStorage = DataStorage.newInstance(v.getContext());
        String key = Utils.genKey(v);
        int times = dataStorage.getInt(key);
        int nextTimes = times + 1;
        dataStorage.putInt(key, nextTimes);
        nClick(nextTimes, v);
    }

    protected abstract void nClick(int index, View view);
}
