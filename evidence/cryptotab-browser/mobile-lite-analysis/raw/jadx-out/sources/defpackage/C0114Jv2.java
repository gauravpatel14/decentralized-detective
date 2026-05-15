package defpackage;

import android.view.WindowInsetsAnimation;

/* JADX INFO: renamed from: Jv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0114Jv2 extends AbstractC0122Kv2 {
    public final WindowInsetsAnimation e;

    public C0114Jv2(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.e = windowInsetsAnimation;
    }

    @Override // defpackage.AbstractC0122Kv2
    public final long a() {
        return this.e.getDurationMillis();
    }

    @Override // defpackage.AbstractC0122Kv2
    public final float b() {
        return this.e.getInterpolatedFraction();
    }

    @Override // defpackage.AbstractC0122Kv2
    public final int c() {
        return this.e.getTypeMask();
    }

    @Override // defpackage.AbstractC0122Kv2
    public final void d(float f) {
        this.e.setFraction(f);
    }
}
