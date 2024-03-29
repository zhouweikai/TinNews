package com.weikai.tinnews.save.detail;

import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.weikai.tinnews.R;
import com.weikai.tinnews.common.BaseViewModel;

public class TitleViewModel extends BaseViewModel<TitleViewModel.TitleViewModelHolder> {
    private String title;
    public TitleViewModel(String title) {
        super(R.layout.title_layout);
        this.title = title;
    }

    public TitleViewModel(String title, @LayoutRes int layout) {
        super(layout);
        this.title = title;
    }

    @Override
    public TitleViewModelHolder createItemViewHolder(View view) {
        return new TitleViewModelHolder(view);
    }

    @Override
    public void bindViewHolder(TitleViewModelHolder holder) {
        holder.title.setText(title);
    }


    static class TitleViewModelHolder extends RecyclerView.ViewHolder {
        TextView title;
        TitleViewModelHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }
}

