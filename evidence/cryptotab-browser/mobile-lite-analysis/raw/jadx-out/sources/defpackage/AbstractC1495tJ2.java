package defpackage;

import com.google.android.gms.internal.play_billing.zzfe;

/* JADX INFO: renamed from: tJ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1495tJ2 implements Cloneable {
    public final LJ2 t;
    public LJ2 u;

    public AbstractC1495tJ2(LJ2 lj2) {
        this.t = lj2;
        if (lj2.j()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.u = (LJ2) lj2.k(4);
    }

    public static void e(Object obj, Object obj2) {
        ZN2.c.a(obj.getClass()).e(obj, obj2);
    }

    public final LJ2 a() {
        LJ2 lj2B = b();
        lj2B.getClass();
        if (LJ2.i(lj2B, true)) {
            return lj2B;
        }
        throw new zzfe();
    }

    public final LJ2 b() {
        if (!this.u.j()) {
            return this.u;
        }
        LJ2 lj2 = this.u;
        lj2.getClass();
        ZN2.c.a(lj2.getClass()).b(lj2);
        lj2.f();
        return this.u;
    }

    public final void c() {
        if (this.u.j()) {
            return;
        }
        d();
    }

    public final Object clone() {
        AbstractC1495tJ2 abstractC1495tJ2 = (AbstractC1495tJ2) this.t.k(5);
        abstractC1495tJ2.u = b();
        return abstractC1495tJ2;
    }

    public final void d() {
        LJ2 lj2 = (LJ2) this.t.k(4);
        e(lj2, this.u);
        this.u = lj2;
    }
}
