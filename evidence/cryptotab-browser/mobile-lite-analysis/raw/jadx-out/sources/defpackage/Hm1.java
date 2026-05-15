package defpackage;

import android.os.Handler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Function;
import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Hm1 {
    public Object b;
    public Exception d;
    public final Handler f;
    public boolean g;
    public int a = 0;
    public final LinkedList c = new LinkedList();
    public final LinkedList e = new LinkedList();

    public Hm1() {
        Thread.currentThread();
        this.f = new Handler();
    }

    public static Hm1 c(Object obj) {
        Hm1 hm1 = new Hm1();
        hm1.b(obj);
        return hm1;
    }

    public final void a(Callback callback) {
        int i = this.a;
        if (i == 2) {
            this.f.post(callback.c0(this.d));
        } else if (i == 0) {
            this.e.add(callback);
        }
    }

    public final void b(Object obj) {
        this.a = 1;
        this.b = obj;
        LinkedList linkedList = this.c;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            this.f.post(((Callback) it.next()).c0(obj));
        }
        linkedList.clear();
    }

    public final boolean d() {
        return this.a == 1;
    }

    public final void e(Exception exc) {
        this.a = 2;
        this.d = exc;
        LinkedList linkedList = this.e;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            this.f.post(((Callback) it.next()).c0(exc));
        }
        linkedList.clear();
    }

    public final Hm1 f(final Function function) {
        final Hm1 hm1 = new Hm1();
        i(new Callback() { // from class: Fm1
            @Override // org.chromium.base.Callback
            /* JADX INFO: renamed from: onResult */
            public final void a0(Object obj) {
                Hm1 hm12 = this.t;
                try {
                    hm12.b(function.apply(obj));
                } catch (Exception e) {
                    hm12.e(e);
                }
            }
        });
        a(new Callback() { // from class: Gm1
            @Override // org.chromium.base.Callback
            /* JADX INFO: renamed from: onResult */
            public final void a0(Object obj) {
                this.t.e((Exception) obj);
            }
        });
        return hm1;
    }

    public final void g(Callback callback) {
        if (this.g) {
            i(callback);
        } else {
            h(callback, new Em1());
            this.g = true;
        }
    }

    public final void h(Callback callback, Callback callback2) {
        i(callback);
        a(callback2);
    }

    public final void i(Callback callback) {
        int i = this.a;
        if (i == 1) {
            this.f.post(callback.c0(this.b));
        } else if (i == 0) {
            this.c.add(callback);
        }
    }
}
