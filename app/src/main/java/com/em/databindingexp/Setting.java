package com.em.databindingexp;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * <pre>
 *      author  :   peceoqicka
 *      e-mail  :   ratchet@qq.com
 *      time    :   2017/09/21
 *      desc    :   设置实体类
 *      version :   1.0
 * </pre>
 */

public class Setting extends BaseObservable {
    @Bindable
    private String title;
    @Bindable
    private boolean isSelected;

    public Setting(String title, boolean isSelected) {
        this.title = title;
        this.isSelected = isSelected;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        notifyPropertyChanged(BR.selected);
    }
}
