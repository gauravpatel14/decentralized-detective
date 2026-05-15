package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: vn0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1636vn0 extends AbstractC0771hO implements DW {
    private volatile C1636vn0 _immediate;
    public final Handler u;
    public final String v;
    public final boolean w;
    public final C1636vn0 x;

    public C1636vn0(Handler handler, String str, boolean z) {
        this.u = handler;
        this.v = str;
        this.w = z;
        this._immediate = z ? this : null;
        C1636vn0 c1636vn0 = this._immediate;
        if (c1636vn0 == null) {
            c1636vn0 = new C1636vn0(handler, str, true);
            this._immediate = c1636vn0;
        }
        this.x = c1636vn0;
    }

    @Override // defpackage.DW
    public final L00 b(long j, final RunnableC0853ia2 runnableC0853ia2, InterfaceC0577eO interfaceC0577eO) {
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.u.postDelayed(runnableC0853ia2, j)) {
            return new L00() { // from class: un0
                @Override // defpackage.L00
                public final void d() {
                    this.t.u.removeCallbacks(runnableC0853ia2);
                }
            };
        }
        k(interfaceC0577eO, runnableC0853ia2);
        return C1123n01.t;
    }

    @Override // defpackage.AbstractC0771hO
    public final void c(InterfaceC0577eO interfaceC0577eO, Runnable runnable) {
        if (this.u.post(runnable)) {
            return;
        }
        k(interfaceC0577eO, runnable);
    }

    @Override // defpackage.AbstractC0771hO
    public final boolean d() {
        return (this.w && lz0.a(Looper.myLooper(), this.u.getLooper())) ? false : true;
    }

    @Override // defpackage.AbstractC0771hO
    public AbstractC0771hO e(int i) {
        qF0.a(1);
        return this;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C1636vn0) && ((C1636vn0) obj).u == this.u;
    }

    public final int hashCode() {
        return System.identityHashCode(this.u);
    }

    public final void k(InterfaceC0577eO interfaceC0577eO, Runnable runnable) {
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        RA0 ra0 = (RA0) interfaceC0577eO.l(QA0.t);
        if (ra0 != null) {
            ((YA0) ra0).g(cancellationException);
        }
        j00.b.c(interfaceC0577eO, runnable);
    }

    @Override // defpackage.AbstractC0771hO
    public final String toString() {
        C1636vn0 c1636vn0;
        String str;
        C0649fW c0649fW = j00.a;
        C1636vn0 c1636vn02 = AbstractC0571eK0.a;
        if (this == c1636vn02) {
            str = "Dispatchers.Main";
        } else {
            try {
                c1636vn0 = c1636vn02.x;
            } catch (UnsupportedOperationException unused) {
                c1636vn0 = null;
            }
            str = this == c1636vn0 ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.v;
        if (string == null) {
            string = this.u.toString();
        }
        return this.w ? F.a(string, ".immediate") : string;
    }

    public C1636vn0(Handler handler) {
        this(handler, null, false);
    }
}
