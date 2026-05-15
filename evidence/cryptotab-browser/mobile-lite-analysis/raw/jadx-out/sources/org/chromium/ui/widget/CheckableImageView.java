package org.chromium.ui.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class CheckableImageView extends ChromeImageView implements Checkable {
    public static final int[] x = {R.attr.state_checked};
    public boolean w;

    public CheckableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.w;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        return !this.w ? super.onCreateDrawableState(i) : View.mergeDrawableStates(super.onCreateDrawableState(i + 1), x);
    }

    @Override // android.widget.Checkable
    public final void setChecked(boolean z) {
        if (this.w == z) {
            return;
        }
        this.w = z;
        refreshDrawableState();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public final void setImageDrawable(Drawable drawable) {
        if (drawable == getDrawable()) {
            return;
        }
        super.setImageDrawable(drawable);
        refreshDrawableState();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.w);
    }
}
