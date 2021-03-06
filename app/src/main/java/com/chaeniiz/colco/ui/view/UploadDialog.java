package com.chaeniiz.colco.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.chaeniiz.colco.R;
import com.chaeniiz.colco.ui.activity.UploadFeedActivity;
import com.chaeniiz.colco.ui.activity.UploadItemActivity;

public class UploadDialog extends Dialog implements View.OnClickListener {
    private static final int LAYOUT = R.layout.dialog_upload;

    private Context context;

    private Button btnUploadFeed;
    private Button btnUploadItem;
    private ImageButton btnDismiss;

    public UploadDialog(Context context){
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        btnUploadFeed = (Button) findViewById(R.id.btn_upload_feed);
        btnUploadItem = (Button) findViewById(R.id.btn_upload_item);
        btnDismiss = (ImageButton) findViewById(R.id.ib_close);

        btnUploadFeed.setOnClickListener(this);
        btnUploadItem.setOnClickListener(this);
        btnDismiss.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_upload_feed:
                Intent intent = new Intent(context, UploadFeedActivity.class);
                context.startActivity(intent);
                break;
            case R.id.btn_upload_item:
                Intent intent2 = new Intent(context, UploadItemActivity.class);
                context.startActivity(intent2);
                break;
            case R.id.ib_close:
                UploadDialog.this.dismiss();
                break;
        }
    }

}
