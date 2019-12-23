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
                .doOnNext(info -> Glide.with(context).load(info.getUrl()).into(thumbnailImageView))
                .subscribeOn(AndroidSchedulers.mainThread());
    }
}