package com.ruobin.demo.photosearcher.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ruobin.demo.photosearcher.R;
import com.ruobin.demo.photosearcher.data.PhotoSearchResult;
import com.ruobin.demo.photosearcher.data.source.PhotoDataSource;

import java.util.List;


public class PhotoListAdapter extends RecyclerView.Adapter {

    private Context context;

    private PhotoDataSource dataSource;

    private List<PhotoSearchResult.PhotoResponse.PhotoBasicInfo> items;

    public PhotoListAdapter(Context context, List<PhotoSearchResult.PhotoResponse.PhotoBasicInfo> items, PhotoDataSource dataSource) {
        this.context = context;
        this.items = items;
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.photo_list_item,parent, false);
        return new PhotoThumbnailViewHolder(context, dataSource, itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PhotoThumbnailViewHolder) {
            ((PhotoThumbnailViewHolder) holder).bindView(items, position);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
