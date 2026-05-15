package defpackage;

import android.os.Handler;
import java.util.Iterator;
import java.util.Objects;
import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class H21 implements F21 {
    public final Handler t;
    public Object u;
    public final M21 v;

    public H21() {
        int i = AbstractC1872zv.a;
        this.t = new Handler();
        this.v = new M21();
    }

    @Override // defpackage.F21
    public final void b(Callback callback) {
        this.v.g(callback);
    }

    public void d(Object obj) {
        int i = AbstractC1872zv.a;
        if (Objects.equals(obj, this.u)) {
            return;
        }
        this.u = obj;
        Iterator it = this.v.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((Callback) l21.next()).a0(this.u);
            }
        }
    }

    @Override // java.util.function.Supplier
    public Object get() {
        int i = AbstractC1872zv.a;
        return this.u;
    }

    @Override // defpackage.F21
    public final Object k(final Callback callback) {
        this.v.e(callback);
        final Object obj = this.u;
        if (obj != null) {
            this.t.post(new Runnable() { // from class: G21
                @Override // java.lang.Runnable
                public final void run() {
                    H21 h21 = this.t;
                    if (h21.u == obj) {
                        M21 m21 = h21.v;
                        Callback callback2 = callback;
                        if (m21.f(callback2)) {
                            callback2.a0(h21.u);
                        }
                    }
                }
            });
        }
        return this.u;
    }

    public H21(Object obj) {
        int i = AbstractC1872zv.a;
        this.t = new Handler();
        this.v = new M21();
        this.u = obj;
    }
}
