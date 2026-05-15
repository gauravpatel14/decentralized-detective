package defpackage;

import java.util.HashMap;

/* JADX INFO: renamed from: fn1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0668fn1 implements Cloneable {
    public Class t;
    public C1860zg0 u = null;
    public final Object[] v = new Object[1];
    public InterfaceC0208Ri2 w;
    public C1860zg0 x;
    public float y;

    static {
        new HashMap();
        new HashMap();
    }

    public C0668fn1(float... fArr) {
        b(fArr);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C0668fn1 clone() {
        C0668fn1 c0668fn1;
        try {
            c0668fn1 = (C0668fn1) super.clone();
            c0668fn1.getClass();
            c0668fn1.u = this.u.clone();
            c0668fn1.w = this.w;
        } catch (CloneNotSupportedException unused) {
            c0668fn1 = null;
        }
        c0668fn1.x = c0668fn1.u;
        return c0668fn1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(float... r9) {
        /*
            r8 = this;
            java.lang.Class r0 = java.lang.Float.TYPE
            r8.t = r0
            int r0 = r9.length
            r1 = 2
            int r1 = java.lang.Math.max(r0, r1)
            HC0[] r1 = new defpackage.HC0[r1]
            r2 = 1
            r3 = 0
            r4 = 0
            if (r0 != r2) goto L2c
            HC0 r0 = new HC0
            r0.<init>(r3)
            r1[r4] = r0
            r9 = r9[r4]
            HC0 r0 = new HC0
            r3 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r3, r9)
            r1[r2] = r0
            boolean r9 = java.lang.Float.isNaN(r9)
            if (r9 == 0) goto L2a
            goto L50
        L2a:
            r2 = r4
            goto L50
        L2c:
            r5 = r9[r4]
            HC0 r6 = new HC0
            r6.<init>(r3, r5)
            r1[r4] = r6
            r3 = r2
        L36:
            if (r3 >= r0) goto L2a
            float r5 = (float) r3
            int r6 = r0 + (-1)
            float r6 = (float) r6
            float r5 = r5 / r6
            r6 = r9[r3]
            HC0 r7 = new HC0
            r7.<init>(r5, r6)
            r1[r3] = r7
            boolean r5 = java.lang.Float.isNaN(r6)
            if (r5 == 0) goto L4d
            r4 = r2
        L4d:
            int r3 = r3 + 1
            goto L36
        L50:
            if (r2 == 0) goto L59
            java.lang.String r9 = "Animator"
            java.lang.String r0 = "Bad value (NaN) in float animator"
            android.util.Log.w(r9, r0)
        L59:
            zg0 r9 = new zg0
            r9.<init>(r1)
            r8.u = r9
            r8.x = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0668fn1.b(float[]):void");
    }

    public final String toString() {
        return ": " + this.u.toString();
    }
}
