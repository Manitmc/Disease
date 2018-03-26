package gotz8.disease;

/**
 * Created by Gotnpd on 3/10/2560.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class TreatmentVirusAdapter extends PagerAdapter {
    Context mContext;

    TreatmentVirusAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return sliderImagesId.length;
    }

    private int[] sliderImagesId = new int[]{
            R.drawable.v1,
            R.drawable.v2,
            R.drawable.v3,
            R.drawable.v4,
            R.drawable.v5,
            R.drawable.v6,
            R.drawable.v7,
            R.drawable.v8,
            R.drawable.v9,
            R.drawable.v10,
            R.drawable.v11,
            R.drawable.v12,
            R.drawable.v13,
            R.drawable.v14,
            R.drawable.v15,
            R.drawable.v16,
            R.drawable.v17,
    };

    @Override
    public boolean isViewFromObject(View v, Object obj) {
        return v == obj;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int i) {
        ImageView mImageView = new ImageView(mContext);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mImageView.setImageResource(sliderImagesId[i]);
        ((ViewPager) container).addView(mImageView, 0);
        return mImageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int i, Object obj) {
        ((ViewPager) container).removeView((ImageView) obj);
    }
}
