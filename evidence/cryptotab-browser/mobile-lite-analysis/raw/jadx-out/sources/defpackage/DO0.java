package defpackage;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.mediarouter.app.d;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DO0 extends Animation {
    public final /* synthetic */ int t;
    public final /* synthetic */ int u;
    public final /* synthetic */ ViewGroup v;

    public DO0(int i, int i2, ViewGroup viewGroup) {
        this.t = i;
        this.u = i2;
        this.v = viewGroup;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f, Transformation transformation) {
        d.r(this.v, this.t - ((int) ((r3 - this.u) * f)));
    }
}
