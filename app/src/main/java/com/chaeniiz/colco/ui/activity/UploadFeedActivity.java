package com.chaeniiz.colco.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.chaeniiz.colco.R;
import com.chaeniiz.colco.data.model.UploadImage;
import com.chaeniiz.colco.ui.adapter.UploadImageAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UploadFeedActivity extends BaseActivity {

    RecyclerView rvUploadImage;
    UploadImageAdapter adapter;
    List<UploadImage> items = new ArrayList<>();
    UploadImage[] item = new UploadImage[10];
    int imageCount = 0;

    TextView tvItemCount;
    ImageButton ibtnUploadFeed;
    ImageButton ibtnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvItemCount = findViewById(R.id.tv_item_count);

        rvUploadImage = findViewById(R.id.rv_upload_image);
        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvUploadImage.setLayoutManager(lm);

        ibtnUploadFeed = (ImageButton) findViewById(R.id.ibtn_upload_feed);
        ibtnUploadFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });

        ibtnClose = (ImageButton) findViewById(R.id.btn_close);
        ibtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0) {
            try {
                Bitmap image = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());

                item[imageCount] = new UploadImage(image);
                items.add(item[imageCount]);
                imageCount++;

                rvUploadImage.setAdapter(new UploadImageAdapter(this, items, R.layout.activity_upload_feed));
                tvItemCount.setText(imageCount + "/10");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_upload_feed;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.menu_upload;
    }
}
