package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RC0 implements Hk0, Serializable {
    public final int t;

    public RC0(int i) {
        this.t = i;
    }

    @Override // defpackage.Hk0
    public final int f() {
        return this.t;
    }

    public final String toString() {
        Gs1.a.getClass();
        return Ls1.a(this);
    }
}
