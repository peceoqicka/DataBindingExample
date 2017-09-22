package com.em.databindingexp;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * <pre>
 *      author  :   E.M
 *      e-mail  :   ratchet@qq.com
 *      time    :   2017/09/21
 *      desc    :   通用适配器(DataBinding版),Java version
 *      version :   1.0
 * </pre>
 */
public abstract class BaseBindingAdapter<Data, Binding extends ViewDataBinding> extends RecyclerView.Adapter<BindingViewHolder> {
    private List<Data> dataList;

    public BaseBindingAdapter(List<Data> dataList) {
        this.dataList = dataList;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    protected abstract int getLayoutId(int viewType);

    protected abstract void onSetData(Binding binding, Data data);

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = getLayoutId(viewType);
        Binding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                layoutId, parent, false);
        return new BindingViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        Binding binding = DataBindingUtil.getBinding(holder.itemView);
        onSetData(binding, dataList.get(position));
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public abstract void onItemClick(View itemView, Data data);
}
