package com.weikai.tinnews.common;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseViewModel<V extends RecyclerView.ViewHolder> {

    private final int itemResourceId;


    public BaseViewModel(int itemResourceId) {
        this.itemResourceId = itemResourceId;
    }


    public V createViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemResourceId, parent, false);
        return createItemViewHolder(view);
    }


    public abstract V createItemViewHolder(View view);


    public abstract void bindViewHolder(V holder);


    public int getViewType() {
        return itemResourceId;
    }
}

