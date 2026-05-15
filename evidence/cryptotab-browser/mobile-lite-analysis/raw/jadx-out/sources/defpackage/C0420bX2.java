package defpackage;

import android.os.Looper;

/* JADX INFO: renamed from: bX2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0420bX2 extends TO2 {
    public LH2 c;
    public final ZW2 d;
    public final YW2 e;
    public final UW2 f;

    public C0420bX2(C1391rR2 c1391rR2) {
        super(c1391rR2);
        this.d = new ZW2(this);
        this.e = new YW2(this);
        this.f = new UW2(this);
    }

    @Override // defpackage.TO2
    public final boolean j() {
        return false;
    }

    public final void k() {
        g();
        if (this.c == null) {
            this.c = new LH2(Looper.getMainLooper());
        }
    }
}
