package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class uF0 extends ViewGroup {
    public final boolean A;
    public int[] B;
    public int[] C;
    public final Drawable D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public boolean t;
    public final int u;
    public int v;
    public int w;
    public final int x;
    public int y;
    public final float z;

    public uF0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t = true;
        this.u = -1;
        this.v = 0;
        this.x = 8388659;
        C1342qa2 c1342qa2F = C1342qa2.f(context, attributeSet, AbstractC0305Yp1.LinearLayoutCompat, i);
        AbstractC0604eo2.n(this, context, AbstractC0305Yp1.LinearLayoutCompat, attributeSet, c1342qa2F.b, i, 0);
        int i2 = AbstractC0305Yp1.LinearLayoutCompat_android_orientation;
        TypedArray typedArray = c1342qa2F.b;
        int i3 = typedArray.getInt(i2, -1);
        if (i3 >= 0 && this.w != i3) {
            this.w = i3;
            requestLayout();
        }
        int i4 = typedArray.getInt(AbstractC0305Yp1.LinearLayoutCompat_android_gravity, -1);
        if (i4 >= 0 && this.x != i4) {
            i4 = (8388615 & i4) == 0 ? i4 | 8388611 : i4;
            this.x = (i4 & 112) == 0 ? i4 | 48 : i4;
            requestLayout();
        }
        boolean z = typedArray.getBoolean(AbstractC0305Yp1.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            this.t = z;
        }
        this.z = typedArray.getFloat(AbstractC0305Yp1.LinearLayoutCompat_android_weightSum, -1.0f);
        this.u = typedArray.getInt(AbstractC0305Yp1.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.A = typedArray.getBoolean(AbstractC0305Yp1.LinearLayoutCompat_measureWithLargestChild, false);
        Drawable drawableB = c1342qa2F.b(AbstractC0305Yp1.LinearLayoutCompat_divider);
        if (drawableB != this.D) {
            this.D = drawableB;
            if (drawableB != null) {
                this.E = drawableB.getIntrinsicWidth();
                this.F = drawableB.getIntrinsicHeight();
            } else {
                this.E = 0;
                this.F = 0;
            }
            setWillNotDraw(drawableB == null);
            requestLayout();
        }
        this.G = typedArray.getInt(AbstractC0305Yp1.LinearLayoutCompat_showDividers, 0);
        this.H = typedArray.getDimensionPixelSize(AbstractC0305Yp1.LinearLayoutCompat_dividerPadding, 0);
        c1342qa2F.g();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C1489tF0;
    }

    public final void g(Canvas canvas, int i) {
        Drawable drawable = this.D;
        int paddingLeft = getPaddingLeft();
        int i2 = this.H;
        drawable.setBounds(paddingLeft + i2, i, (getWidth() - getPaddingRight()) - i2, this.F + i);
        this.D.draw(canvas);
    }

    @Override // android.view.View
    public final int getBaseline() {
        int i;
        int i2 = this.u;
        if (i2 < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (i2 == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.v;
        if (this.w == 1 && (i = this.x & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.y) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.y;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((C1489tF0) childAt.getLayoutParams())).topMargin + baseline;
    }

    public final void h(Canvas canvas, int i) {
        Drawable drawable = this.D;
        int paddingTop = getPaddingTop();
        int i2 = this.H;
        drawable.setBounds(i, paddingTop + i2, this.E + i, (getHeight() - getPaddingBottom()) - i2);
        this.D.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public C1489tF0 generateDefaultLayoutParams() {
        int i = this.w;
        if (i == 0) {
            return new C1489tF0(-2, -2);
        }
        if (i == 1) {
            return new C1489tF0(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public C1489tF0 generateLayoutParams(AttributeSet attributeSet) {
        return new C1489tF0(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public C1489tF0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C1489tF0 ? new C1489tF0((C1489tF0) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C1489tF0((ViewGroup.MarginLayoutParams) layoutParams) : new C1489tF0(layoutParams);
    }

    public final boolean l(int i) {
        int i2 = this.G;
        if (i == 0) {
            return (i2 & 1) != 0;
        }
        if (i == getChildCount()) {
            return (i2 & 4) != 0;
        }
        if ((i2 & 2) == 0) {
            return false;
        }
        for (int i3 = i - 1; i3 >= 0; i3--) {
            if (getChildAt(i3).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int paddingRight;
        int i = this.F;
        int i2 = this.E;
        if (this.D == null) {
            return;
        }
        int i3 = 0;
        if (this.w == 1) {
            int childCount = getChildCount();
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != null && childAt.getVisibility() != 8 && l(i3)) {
                    g(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((C1489tF0) childAt.getLayoutParams())).topMargin) - i);
                }
                i3++;
            }
            if (l(childCount)) {
                View childAt2 = getChildAt(childCount - 1);
                g(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - i : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((C1489tF0) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int childCount2 = getChildCount();
        boolean z = Jp2.a;
        boolean z2 = getLayoutDirection() == 1;
        while (i3 < childCount2) {
            View childAt3 = getChildAt(i3);
            if (childAt3 != null && childAt3.getVisibility() != 8 && l(i3)) {
                C1489tF0 c1489tF0 = (C1489tF0) childAt3.getLayoutParams();
                h(canvas, z2 ? childAt3.getRight() + ((LinearLayout.LayoutParams) c1489tF0).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) c1489tF0).leftMargin) - i2);
            }
            i3++;
        }
        if (l(childCount2)) {
            View childAt4 = getChildAt(childCount2 - 1);
            if (childAt4 != null) {
                C1489tF0 c1489tF02 = (C1489tF0) childAt4.getLayoutParams();
                if (z2) {
                    left = childAt4.getLeft();
                    paddingRight = ((LinearLayout.LayoutParams) c1489tF02).leftMargin;
                    right = (left - paddingRight) - i2;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) c1489tF02).rightMargin;
                }
            } else if (z2) {
                right = getPaddingLeft();
            } else {
                left = getWidth();
                paddingRight = getPaddingRight();
                right = (left - paddingRight) - i2;
            }
            h(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a0  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uF0.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x04fe  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x07c9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0142  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r42, int r43) {
        /*
            Method dump skipped, instruction units count: 2201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uF0.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
