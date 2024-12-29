package com.example.rantelcar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.BrandViewHolder> {

    private List<Brand> brandList;
    private BrandViewHolder holder;
    private int position;

    public BrandAdapter(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public static class BrandViewHolder extends RecyclerView.ViewHolder {
        ImageView brandImage;
        TextView brandName;

        public BrandViewHolder(@NonNull View itemView) {
            super(itemView);
            brandImage = itemView.findViewById(R.id.brandImage);
            brandName = itemView.findViewById(R.id.brandName);
        }
    }

    @NonNull
    @Override
    public BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_brand, parent, false);
        return new BrandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandViewHolder holder, int position) {
        Brand brand = brandList.get(position);
        holder.brandImage.setImageResource(brand.getImageResId());
        holder.brandName.setText(brand.getName());
    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }

    public interface OnBrandClickListener {
        void onBrandClick(Brand brand);
    }

    private OnBrandClickListener listener;

    public BrandAdapter(List<Brand> brandList, OnBrandClickListener listener) {
        this.brandList = brandList;
        this.listener = listener;
    }


}
