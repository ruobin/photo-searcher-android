package com.ruobin.demo.photosearcher.search;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ruobin.demo.photosearcher.R;
import com.ruobin.demo.photosearcher.data.PhotoBasicInfo;
import com.ruobin.demo.photosearcher.data.source.PhotoDataSource;

import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class PhotoThumbnailViewHolder extends RecyclerView.ViewHolder {

    Context context;

    PhotoDataSource photoDataSource;

    private ImageView thumbnailImageView;

    public PhotoThumbnailViewHolder(Context context, PhotoDataSource photoDataSource, @NonNull View itemView) {
        super(itemView);
        this.context = context;
        this.photoDataSource = photoDataSource;
        thumbnailImageView = itemView.findViewById(R.id.thumbnail_imageview);
    }

    public void bindView(List<PhotoBasicInfo> items, int position) {

        photoDataSource.getPhotoDetailedInfo(items.get(position).getId())
                .subscribe(info ->
                        Glide.with(context).load(info.getPhoto().getUrls().getUrl().get(0).get_content()).into(thumbnailImageView));
    }
}