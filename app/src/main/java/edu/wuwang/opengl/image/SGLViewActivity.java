/*
 *
 * SGLViewActivity.java
 *
 * Created by Wuwang on 2016/10/15
 */
package edu.wuwang.opengl.image;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import androidx.appcompat.widget.PopupMenu;

import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.wuwang.opengl.BaseActivity;
import edu.wuwang.opengl.R;
import edu.wuwang.opengl.image.filter.ColorFilter;
import edu.wuwang.opengl.image.filter.ContrastColorFilter;

/**
 * Description:
 */
public class SGLViewActivity extends BaseActivity {

    private SGLView mGLView;
    private boolean isHalf = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        mGLView = (SGLView) findViewById(R.id.glView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGLView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGLView.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_filter, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mDeal) {
            isHalf = !isHalf;
            if (isHalf) {
                item.setTitle("处理一半");
            } else {
                item.setTitle("全部处理");
            }
            mGLView.getRender().refresh();
        } else if (item.getItemId() == R.id.mDefault) {
            mGLView.setFilter(new ContrastColorFilter(this, ColorFilter.Filter.NONE));
        } else if (item.getItemId() == R.id.mGray) {
            mGLView.setFilter(new ContrastColorFilter(this, ColorFilter.Filter.GRAY));
        } else if (item.getItemId() == R.id.mCool) {
            mGLView.setFilter(new ContrastColorFilter(this, ColorFilter.Filter.COOL));
        } else if (item.getItemId() == R.id.mWarm) {
            mGLView.setFilter(new ContrastColorFilter(this, ColorFilter.Filter.WARM));
        } else if (item.getItemId() == R.id.mBlur) {
            mGLView.setFilter(new ContrastColorFilter(this, ColorFilter.Filter.BLUR));
        } else if (item.getItemId() == R.id.mMagn) {
            mGLView.setFilter(new ContrastColorFilter(this, ColorFilter.Filter.MAGN));
        }
        mGLView.getRender().getFilter().setHalf(isHalf);
        mGLView.requestRender();
        return super.onOptionsItemSelected(item);
    }

}
