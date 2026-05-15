package defpackage;

import org.chromium.mojo.bindings.DeserializationException;

/* JADX INFO: renamed from: ea0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0594ea0 extends zI1 implements KS0 {
    public final C0656fa0 t;

    public C0594ea0(C0656fa0 c0656fa0) {
        this.t = c0656fa0;
    }

    @Override // defpackage.KS0
    public final boolean g(ER0 er0) {
        try {
            SE1 se1A = er0.a();
            if (!se1A.d.c(0, 2)) {
                return false;
            }
            this.t.a(da0.d(se1A.b()).b);
            return true;
        } catch (DeserializationException unused) {
            return false;
        }
    }
}
