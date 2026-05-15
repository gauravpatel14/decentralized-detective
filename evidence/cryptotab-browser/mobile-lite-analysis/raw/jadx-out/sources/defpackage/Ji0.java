package defpackage;

import androidx.fragment.app.n;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ji0 {
    public ArrayList a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public String i;
    public int j;
    public CharSequence k;
    public int l;
    public CharSequence m;
    public ArrayList n;
    public ArrayList o;
    public boolean p;
    public ArrayList q;

    public final void b(Ii0 ii0) {
        this.a.add(ii0);
        ii0.d = this.b;
        ii0.e = this.c;
        ii0.f = this.d;
        ii0.g = this.e;
    }

    public final void c() {
        if (!this.h) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.g = true;
        this.i = null;
    }

    public abstract void d(int i, n nVar, String str, int i2);

    public final void e(int i, n nVar, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        d(i, nVar, str, 2);
    }

    public final void f(Runnable runnable, boolean z) {
        if (!z) {
            if (this.g) {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
            this.h = false;
        }
        if (this.q == null) {
            this.q = new ArrayList();
        }
        this.q.add(runnable);
    }
}
