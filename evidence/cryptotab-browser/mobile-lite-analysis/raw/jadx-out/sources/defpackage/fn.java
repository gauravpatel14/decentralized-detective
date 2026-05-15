package defpackage;

import org.chromium.mojo.bindings.DeserializationException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class fn extends zI1 implements KS0 {
    public final gn t;

    public fn(gn gnVar) {
        this.t = gnVar;
    }

    @Override // defpackage.KS0
    public final boolean g(ER0 er0) {
        try {
            SE1 se1A = er0.a();
            if (!se1A.d.c(0, 2)) {
                return false;
            }
            this.t.a(en.d(se1A.b()).b);
            return true;
        } catch (DeserializationException unused) {
            return false;
        }
    }
}
