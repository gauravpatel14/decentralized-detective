package defpackage;

import android.os.Build;
import android.view.animation.Interpolator;

/* JADX INFO: renamed from: Lv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0134Lv2 {
    public AbstractC0122Kv2 a;

    public C0134Lv2(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new C0114Jv2(AbstractC0095Hv2.f(i, interpolator, j));
        } else {
            this.a = new C0086Gv2(i, interpolator, j);
        }
    }
}
