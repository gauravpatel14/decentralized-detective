package org.chromium.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import defpackage.p51;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class OptimizedFrameLayout extends FrameLayout {
    public final ArrayList t;

    public OptimizedFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = new ArrayList();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int childMeasureSpec;
        int i4;
        OptimizedFrameLayout optimizedFrameLayout = this;
        int i5 = i;
        int i6 = i2;
        int childCount = getChildCount();
        boolean z = (View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == 1073741824) ? false : true;
        ArrayList arrayList = optimizedFrameLayout.t;
        arrayList.clear();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int iCombineMeasuredStates = 0;
        int i7 = 0;
        int iMax = 0;
        int iMax2 = 0;
        while (i7 < childCount) {
            View childAt = optimizedFrameLayout.getChildAt(i7);
            if (getMeasureAllChildren()) {
                i4 = childCount;
            } else {
                i4 = childCount;
                if (childAt.getVisibility() != 8) {
                }
                i7++;
                optimizedFrameLayout = this;
                i5 = i;
                i6 = i2;
                childCount = i4;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i5, paddingLeft + paddingRight + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width);
            int childMeasureSpec3 = ViewGroup.getChildMeasureSpec(i6, paddingTop + paddingBottom + layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height);
            childAt.measure(childMeasureSpec2, childMeasureSpec3);
            iMax = Math.max(iMax, childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            iMax2 = Math.max(iMax2, childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            if (z && (layoutParams.width == -1 || layoutParams.height == -1)) {
                arrayList.add(new p51(childAt, childMeasureSpec2, childMeasureSpec3));
            }
            i7++;
            optimizedFrameLayout = this;
            i5 = i;
            i6 = i2;
            childCount = i4;
        }
        int i8 = paddingLeft + paddingRight;
        int i9 = paddingTop + paddingBottom;
        int iMax3 = Math.max(iMax2 + i9, getSuggestedMinimumHeight());
        int iMax4 = Math.max(iMax + i8, getSuggestedMinimumWidth());
        Drawable foreground = getForeground();
        if (foreground != null) {
            iMax3 = Math.max(iMax3, foreground.getMinimumHeight());
            iMax4 = Math.max(iMax4, foreground.getMinimumWidth());
        }
        setMeasuredDimension(View.resolveSizeAndState(iMax4, i, iCombineMeasuredStates), View.resolveSizeAndState(iMax3, i2, iCombineMeasuredStates << 16));
        int size = arrayList.size();
        if (size > 1) {
            int i10 = 0;
            while (i10 < size) {
                p51 p51Var = (p51) arrayList.get(i10);
                View view = p51Var.a;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int i11 = marginLayoutParams.width;
                int i12 = size;
                if (i11 == -1) {
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredWidth() - paddingLeft) - paddingRight) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin), 1073741824);
                    i3 = i8;
                } else {
                    i3 = i8;
                    childMeasureSpec = ViewGroup.getChildMeasureSpec(i, marginLayoutParams.leftMargin + i8 + marginLayoutParams.rightMargin, i11);
                }
                int i13 = marginLayoutParams.height;
                int iMakeMeasureSpec = i13 == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredHeight() - paddingTop) - paddingBottom) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i2, marginLayoutParams.topMargin + i9 + marginLayoutParams.bottomMargin, i13);
                if (p51Var.b != childMeasureSpec || p51Var.c != iMakeMeasureSpec) {
                    view.measure(childMeasureSpec, iMakeMeasureSpec);
                }
                i10++;
                size = i12;
                i8 = i3;
            }
        }
        arrayList.clear();
    }
}
