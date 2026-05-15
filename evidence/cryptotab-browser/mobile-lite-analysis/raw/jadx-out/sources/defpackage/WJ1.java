package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WJ1 {
    public C0178Or1 a = null;
    public final ArrayList b = new ArrayList();
    public long c = 120;
    public long d = 120;
    public long e = 250;
    public long f = 250;
    public boolean g = true;

    public static void e(ps1 ps1Var) {
        int i = ps1Var.C;
        if (!ps1Var.k() && (i & 4) == 0) {
            ps1Var.d();
        }
    }

    public abstract void a(ps1 ps1Var);

    public abstract boolean b(ps1 ps1Var, ps1 ps1Var2, int i, int i2, int i3, int i4);

    public abstract boolean c(ps1 ps1Var, int i, int i2, int i3, int i4);

    public abstract boolean d(ps1 ps1Var);

    public boolean f(ps1 ps1Var, List list) {
        return !this.g || ps1Var.k();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(defpackage.ps1 r10) {
        /*
            r9 = this;
            Or1 r0 = r9.a
            if (r0 == 0) goto L90
            r1 = 1
            r10.s(r1)
            ps1 r2 = r10.A
            r3 = 0
            if (r2 == 0) goto L13
            ps1 r2 = r10.B
            if (r2 != 0) goto L13
            r10.A = r3
        L13:
            r10.B = r3
            int r2 = r10.C
            r2 = r2 & 16
            if (r2 == 0) goto L1d
            goto L90
        L1d:
            androidx.recyclerview.widget.RecyclerView r0 = r0.a
            r0.A0()
            Rz r2 = r0.y
            Qz r3 = r2.b
            Or1 r4 = r2.a
            int r5 = r2.d
            r6 = 0
            android.view.View r7 = r10.t
            if (r5 != r1) goto L3d
            android.view.View r1 = r2.e
            if (r1 != r7) goto L35
        L33:
            r1 = r6
            goto L66
        L35:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot call removeViewIfHidden within removeView(At) for a different view"
            r10.<init>(r0)
            throw r10
        L3d:
            r8 = 2
            if (r5 == r8) goto L88
            r2.d = r8     // Catch: java.lang.Throwable -> L51
            androidx.recyclerview.widget.RecyclerView r5 = r4.a     // Catch: java.lang.Throwable -> L51
            int r5 = r5.indexOfChild(r7)     // Catch: java.lang.Throwable -> L51
            r8 = -1
            if (r5 != r8) goto L53
            r2.j(r7)     // Catch: java.lang.Throwable -> L51
        L4e:
            r2.d = r6
            goto L66
        L51:
            r10 = move-exception
            goto L85
        L53:
            boolean r8 = r3.d(r5)     // Catch: java.lang.Throwable -> L51
            if (r8 == 0) goto L63
            r3.f(r5)     // Catch: java.lang.Throwable -> L51
            r2.j(r7)     // Catch: java.lang.Throwable -> L51
            r4.k(r5)     // Catch: java.lang.Throwable -> L51
            goto L4e
        L63:
            r2.d = r6
            goto L33
        L66:
            if (r1 == 0) goto L74
            ps1 r2 = androidx.recyclerview.widget.RecyclerView.N(r7)
            gs1 r3 = r0.v
            r3.l(r2)
            r3.i(r2)
        L74:
            r2 = r1 ^ 1
            r0.C0(r2)
            if (r1 != 0) goto L90
            boolean r10 = r10.o()
            if (r10 == 0) goto L90
            r0.removeDetachedView(r7, r6)
            goto L90
        L85:
            r2.d = r6
            throw r10
        L88:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot call removeViewIfHidden within removeViewIfHidden"
            r10.<init>(r0)
            throw r10
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.WJ1.g(ps1):void");
    }

    public final void h() {
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((InterfaceC0240Tr1) arrayList.get(i)).a();
        }
        arrayList.clear();
    }

    public abstract void i(ps1 ps1Var);

    public abstract void j();

    public abstract boolean k();

    public abstract void l();
}
