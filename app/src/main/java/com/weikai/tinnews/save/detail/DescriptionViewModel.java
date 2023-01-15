package com.weikai.tinnews.save.detail;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.weikai.tinnews.R;
import com.weikai.tinnews.common.BaseViewModel;

public class DescriptionViewModel extends BaseViewModel<DescriptionViewModel.DescriptionViewHolder> {

    private final String description;

    public DescriptionViewModel(String description) {
        super(R.layout.description_layout);
        this.description = description;
    }

    @Override
    public DescriptionViewHolder createItemViewHolder(View view) {
        return new DescriptionViewHolder(view);
    }

    @Override
    public void bindViewHolder(DescriptionViewHolder holder) {
        holder.description.setText(description);
    }

    static class DescriptionViewHolder extends RecyclerView.ViewHolder {
        TextView description;
        DescriptionViewHolder(View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
        }
    }
}

