package defpackage;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: renamed from: ha0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0787ha0 extends My0 {
    @Override // defpackage.LS0
    public final boolean N(ER0 er0, KS0 ks0) {
        try {
            SE1 se1A = er0.a();
            wS0 ws0 = se1A.d;
            if (!ws0.b(ws0.a(4) ? 5 : 1)) {
                return false;
            }
            int i = ws0.b;
            CoreImpl coreImpl = this.t;
            if (i == -1) {
                return Oy0.a(coreImpl, AbstractC0852ia0.a, se1A, ks0);
            }
            if (i != 0) {
                return false;
            }
            ((P90) this.u).x0(C0484ca0.d(se1A.b()).b, new C0656fa0(coreImpl, ks0, ws0.d));
            return true;
        } catch (DeserializationException e) {
            System.err.println(e.toString());
            return false;
        }
    }

    @Override // defpackage.KS0
    public final boolean g(ER0 er0) {
        try {
            SE1 se1A = er0.a();
            wS0 ws0 = se1A.d;
            int i = 4;
            if (!ws0.a(4)) {
                i = 0;
            }
            if (ws0.b(i) && ws0.b == -2) {
                return Oy0.b(AbstractC0852ia0.a, se1A);
            }
            return false;
        } catch (DeserializationException e) {
            System.err.println(e.toString());
            return false;
        }
    }
}
