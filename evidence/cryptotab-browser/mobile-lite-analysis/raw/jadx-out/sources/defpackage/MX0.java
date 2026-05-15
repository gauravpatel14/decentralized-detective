package defpackage;

import androidx.core.widget.NestedScrollView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MX0 implements BY {
    public final /* synthetic */ NestedScrollView a;

    public MX0(NestedScrollView nestedScrollView) {
        this.a = nestedScrollView;
    }

    @Override // defpackage.BY
    public final boolean a(float f) {
        if (f == 0.0f) {
            return false;
        }
        c();
        this.a.j((int) f);
        return true;
    }

    @Override // defpackage.BY
    public final float b() {
        return -this.a.m();
    }

    @Override // defpackage.BY
    public final void c() {
        this.a.w.abortAnimation();
    }
}
