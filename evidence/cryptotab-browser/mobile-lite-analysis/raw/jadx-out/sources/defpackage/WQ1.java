package defpackage;

import java.nio.ByteBuffer;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WQ1 {
    public final int a;

    public WQ1(int i) {
        this.a = i;
    }

    public abstract void a(i70 i70Var);

    public final ByteBuffer b() {
        i70 i70Var = new i70(null, this.a);
        a(i70Var);
        ER0 er0T = i70Var.t();
        if (er0T.b.isEmpty()) {
            return er0T.a;
        }
        throw new UnsupportedOperationException("Handles are discarded.");
    }

    public final SE1 c(CoreImpl coreImpl, wS0 ws0) {
        MT mt = ws0.a;
        i70 i70Var = new i70(coreImpl, this.a + mt.a);
        i70Var.g(mt);
        i70Var.b(0, 8);
        i70Var.b(ws0.b, 12);
        int i = ws0.c;
        i70Var.b(i, 16);
        if ((i & 3) != 0) {
            i70Var.d(24, ws0.d);
        }
        a(i70Var);
        return new SE1(i70Var.t(), ws0);
    }
}
