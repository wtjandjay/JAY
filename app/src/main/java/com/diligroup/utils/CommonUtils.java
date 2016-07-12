package com.diligroup.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.ActivityCompat;

import com.diligroup.R;

/**
 * Created by 郝九凤 on 2016/7/7.
 */
public class CommonUtils {
    Activity mContext;
    public CommonUtils(Activity mContext){
        this.mContext=mContext;
    }
    public void requestPermission(final String permission, String rationale, final int requestCode) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(mContext, permission)) {
            new AlertDialog.Builder(mContext)
                    .setTitle(R.string.permission_dialog_title)
                    .setMessage(rationale)
                    .setPositiveButton(R.string.permission_dialog_ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(mContext, new String[]{permission}, requestCode);
                        }
                    })
                    .setNegativeButton(R.string.permission_dialog_cancel, null)
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(mContext, new String[]{permission}, requestCode);
        }
    }
}
