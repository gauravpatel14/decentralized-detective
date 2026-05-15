package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: renamed from: xb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C1744xb extends SeekBar {
    public final yb t;

    public C1744xb(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Q82.a(getContext(), this);
        yb ybVar = new yb(this);
        this.t = ybVar;
        ybVar.a(attributeSet, i);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        yb ybVar = this.t;
        Drawable drawable = ybVar.e;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        C1744xb c1744xb = ybVar.d;
        if (drawable.setState(c1744xb.getDrawableState())) {
            c1744xb.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.t.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.t.d(canvas);
    }
}
