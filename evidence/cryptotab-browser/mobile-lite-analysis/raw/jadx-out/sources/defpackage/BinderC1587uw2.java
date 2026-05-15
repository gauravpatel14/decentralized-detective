package defpackage;

import android.os.Binder;
import android.os.Process;

/* JADX INFO: renamed from: uw2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC1587uw2 extends Binder {
    public final z70 t;

    public BinderC1587uw2(z70 z70Var) {
        this.t = z70Var;
    }

    public final void a(final C1759xw2 c1759xw2) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        this.t.a.c(c1759xw2.a).m(ExecutorC0857if0.t, new N41(c1759xw2) { // from class: tw2
            public final C1759xw2 a;

            {
                this.a = c1759xw2;
            }

            @Override // defpackage.N41
            public final void onComplete(G62 g62) {
                this.a.b.d(null);
            }
        });
    }
}
