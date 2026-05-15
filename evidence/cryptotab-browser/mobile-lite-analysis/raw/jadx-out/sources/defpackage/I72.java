package defpackage;

import org.chromium.mojo.bindings.DeserializationException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class I72 extends zI1 implements KS0 {
    public final J72 t;

    public I72(J72 j72) {
        this.t = j72;
    }

    @Override // defpackage.KS0
    public final boolean g(ER0 er0) {
        try {
            SE1 se1A = er0.a();
            if (!se1A.d.c(0, 2)) {
                return false;
            }
            this.t.a(H72.d(se1A.b()).b);
            return true;
        } catch (DeserializationException unused) {
            return false;
        }
    }
}
