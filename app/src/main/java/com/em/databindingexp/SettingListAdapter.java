package com.em.databindingexp;

import android.support.annotation.NonNull;
import android.view.View;

import com.em.databindingexp.databinding.ItemSettingBinding;

import java.util.List;

/**
 * <pre>
 *      author  :   peceoqicka
 *      e-mail  :   ratchet@qq.com
 *      time    :   2017/09/21
 *      desc    :   设置列表适配器(使用DataBinding)
 *      version :   1.0
 * </pre>
 */

public class SettingListAdapter extends
        com.em.databindingexp.ktbinding.BaseBindingAdapter<Setting, ItemSettingBinding> {
    public SettingListAdapter(List<Setting> settings) {
        super(settings);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_setting;
    }

    @Override
    protected void onSetData(@NonNull ItemSettingBinding binding, Setting setting) {
        binding.setSetting(setting);
        binding.setAdapter(this);
    }

    @Override
    public void onItemClick(@NonNull View itemView, Setting setting) {
        System.out.println("" + setting.getTitle());
        setting.setSelected(!setting.isSelected());
    }
}
