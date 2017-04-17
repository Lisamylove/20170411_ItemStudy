package xixinxin.bawie.com.studydemoyunifang.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/**
 * 1:姓名  席鑫鑫
 * 2:时间  2017/4/17 7:46
 */
public class MyGridView extends GridLayoutManager {
    public MyGridView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public MyGridView(Context context, int spanCount) {
        super(context, spanCount);
    }

    public MyGridView(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }

    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
        int spec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        super.onMeasure(recycler, state, widthSpec, spec);
    }
}
