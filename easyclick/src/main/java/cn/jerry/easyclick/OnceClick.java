package cn.jerry.easyclick;

import android.view.View;

/**
 * click once in app
 * begin app install
 * end app uninstall
 *
 * 从App安装开始到App被卸载 只执行一次
 *
 * Created by jerry on 12/28/16.
 */

public abstract class OnceClick implements View.OnClickListener {

    @Override
    public void onClick(final View v) {
        DataStorage dataStorage = DataStorage.newInstance(v.getContext().getApplicationContext());

        if (!dataStorage.isClicked(v)) {
            dataStorage.setClicked(v);

            // 这里是真的在做click的事
            onOnceClick(v);
            v.setEnabled(false);

            // 防止重复点
            v.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v.setEnabled(true);
                }
            }, 1500);
        } else {
            otherCase(v);
        }
    }

    protected abstract void onOnceClick(View view);

    protected abstract void otherCase(View view);
}
