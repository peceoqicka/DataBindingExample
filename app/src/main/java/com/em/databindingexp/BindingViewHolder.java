package com.em.databindingexp;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class BindingViewHolder extends RecyclerView.ViewHolder {
    public BindingViewHolder(View root) {
        super(root);
    }

    public View find(int viewId) {
        return itemView.findViewById(viewId);
    }

    public BindingViewHolder setVisibility(@IdRes int viewId, boolean visible) {
        View view = find(viewId);
        if (view != null) {
            if (visible) {
                if (view.getVisibility() == View.GONE || view.getVisibility() == View.INVISIBLE) {
                    view.setVisibility(View.VISIBLE);
                }
            } else {
                if (view.getVisibility() == View.VISIBLE) {
                    view.setVisibility(View.GONE);
                }
            }
        }
        return this;
    }

    public BindingViewHolder setText(@IdRes int textViewId, String text) {
        if (text != null) {
            TextView textView = (TextView) find(textViewId);
            if (textView != null) {
                textView.setText(text);
            }
        }
        return this;
    }
}