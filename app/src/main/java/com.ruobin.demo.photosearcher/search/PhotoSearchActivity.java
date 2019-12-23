package com.ruobin.demo.photosearcher.search;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ruobin.demo.photosearcher.PhotoSearcherApplication;
import com.ruobin.demo.photosearcher.R;
import com.ruobin.demo.photosearcher.data.PhotoSearchResult;
import com.ruobin.demo.photosearcher.data.source.PhotoDataSource;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class PhotoSearchActivity extends Activity {

    @Inject
    PhotoSearchViewModel viewModel;

    @Inject
    PhotoDataSource photoDataSource;

    private RecyclerView photoListView;

    private PhotoListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((PhotoSearcherApplication) getApplication()).getComponent().inject(this);
        setContentView(R.layout.activity_search);
        photoListView = findViewById(R.id.photo_list_view);
        photoListView.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new PhotoListAdapter(this, null, photoDataSource);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bindViewModel();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unBindViewModel();
    }

    private void bindViewModel() {
        viewModel.getPhotoList("cars")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::updateRecylerView);
    }

    private void unBindViewModel() {

    }

    private void updateRecylerView(PhotoSearchResult searchResult) {
        adapter = new PhotoListAdapter(this, searchResult.getPhotos().getPhotoList(), photoDataSource);
        photoListView.setAdapter(adapter);
        photoListView.setLayoutManager(new GridLayoutManager(this, 3));
        photoListView.getAdapter().notifyDataSetChanged();
    }
}
