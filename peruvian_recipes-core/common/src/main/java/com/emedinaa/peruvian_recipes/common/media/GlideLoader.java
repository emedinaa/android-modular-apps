package com.emedinaa.peruvian_recipes.common.media;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.emedinaa.peruvian_recipes.common.media.transform.CropCircleTransformation;

import java.io.File;

/**
 * Created by emedinaa on 16/04/16.
 */
public class GlideLoader implements ImageLoader{

    @Override
    public void load(String url, ImageView imageView)
    {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @Override
    public void loadCircle(String url, ImageView imageView) {
        Glide.with(imageView.getContext()).load(url)
                .bitmapTransform(new CropCircleTransformation(imageView.getContext()))
                .into(imageView);
    }

    @Override
    public void loadLocal(String path, ImageView imageView) {
        Glide.with(imageView.getContext()).load(new File(path)).into(imageView);
    }

    /**
     * References
     * https://github.com/wasabeef/glide-transformations
     */
}
