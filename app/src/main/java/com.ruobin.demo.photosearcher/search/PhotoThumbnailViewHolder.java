package com.ruobin.demo.photosearcher.search;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ruobin.demo.photosearcher.R;
import com.ruobin.demo.photosearcher.data.PhotoSearchResult;
import com.ruobin.demo.photosearcher.data.source.PhotoDataSource;

import java.util.List;
import io.reactivex.Observable;

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

    public void bindView(List<PhotoSearchResult.PhotoResponse.PhotoBasicInfo> items, int position) {
        photoDataSource.getPhotoSizesInfo(items.get(position).getId())
                .map(info -> info.getSizes().getSize())
                .subscribe(sizes -> Observable.fromIterable(sizes)
                        .filter(size -> size.getLabel().equalsIgnoreCase("Large Square"))
                        .subscribe(size ->
                                Glide.with(context)
                                        .load(size.getSource())
                                        .placeholder(R.drawable.ic_launcher_background)
                                        .into(thumbnailImageView)));

    }
}