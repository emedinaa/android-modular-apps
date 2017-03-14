package com.emedinaa.peruvian_recipes.common.media;

import android.widget.ImageView;

import com.emedinaa.peruvian_recipes.common.media.transform.CircleTransform;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by emedinaa on 16/04/16.
 */
public class PicassoLoader implements ImageLoader {

    @Override
    public void load(String url, ImageView imageView) {
        Picasso.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    @Override
    public void loadCircle(String url, ImageView imageView) {
        Picasso.with(imageView.getContext())
                .load(url)
                .transform(new CircleTransform())
                .into(imageView);
    }

    @Override
    public void loadLocal(String path, ImageView imageView) {
        Picasso.with(imageView.getContext())
                .load(new File(path))
                .into(imageView);
    }
}
