package org.chromium.ui.widget;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import defpackage.LH0;
import defpackage.NH0;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class LoadingView extends ProgressBar {
    public static final /* synthetic */ int y = 0;
    public long t;
    public final ArrayList u;
    public final LH0 v;
    public boolean w;
    public final LH0 x;

    public LoadingView(Context context) {
        super(context);
        this.t = -1L;
        this.u = new ArrayList();
        this.v = new LH0(this, 0);
        this.x = new LH0(this, 1);
    }

    public final void a(NH0 nh0) {
        this.u.add(nh0);
    }

    public final void b() {
        removeCallbacks(this.v);
        removeCallbacks(this.x);
        this.u.clear();
    }

    public final void c() {
        removeCallbacks(this.v);
        LH0 lh0 = this.x;
        removeCallbacks(lh0);
        this.w = false;
        if (getVisibility() == 0) {
            postDelayed(lh0, Math.max(0L, (this.t + 500) - SystemClock.elapsedRealtime()));
        } else {
            d();
        }
    }

    public final void d() {
        setVisibility(8);
        Iterator it = this.u.iterator();
        while (it.hasNext()) {
            ((NH0) it.next()).R();
        }
    }

    public final void e(boolean z) {
        LH0 lh0 = this.v;
        removeCallbacks(lh0);
        removeCallbacks(this.x);
        this.w = true;
        setVisibility(8);
        if (z) {
            lh0.run();
        } else {
            postDelayed(lh0, 500L);
        }
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = -1L;
        this.u = new ArrayList();
        this.v = new LH0(this, 0);
        this.x = new LH0(this, 1);
    }
}
