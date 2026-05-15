package defpackage;

import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Zd extends H21 implements gX {
    public C0264Vw0 w;
    public H21 x;
    public final Yd y = new Callback() { // from class: Yd
        @Override // org.chromium.base.Callback
        /* JADX INFO: renamed from: onResult */
        public final void a0(Object obj) {
            this.t.g();
        }
    };
    public int z = 1;

    /* JADX WARN: Type inference failed for: r0v0, types: [Yd] */
    public Zd() {
        super.d(new C0261Vp2());
    }

    @Override // defpackage.H21
    public final void d(Object obj) {
        throw new IllegalStateException("#set(...) should not be called directly on ApplicationViewportInsetSupplier.");
    }

    @Override // defpackage.gX
    public final void destroy() {
        boolean z;
        C0264Vw0 c0264Vw0 = this.w;
        boolean z2 = false;
        Yd yd = this.y;
        if (c0264Vw0 != null) {
            c0264Vw0.b(yd);
            z = true;
        } else {
            z = false;
        }
        this.w = null;
        if (z) {
            g();
        }
        H21 h21 = this.x;
        if (h21 != null) {
            h21.b(yd);
            z2 = true;
        }
        this.x = null;
        if (z2) {
            g();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            r7 = this;
            Vp2 r0 = new Vp2
            r0.<init>()
            Vw0 r1 = r7.w
            r2 = 0
            if (r1 == 0) goto L18
            int r3 = defpackage.AbstractC1872zv.a
            java.lang.Object r1 = r1.u
            if (r1 != 0) goto L11
            goto L18
        L11:
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L19
        L18:
            r1 = r2
        L19:
            H21 r3 = r7.x
            if (r3 == 0) goto L2b
            int r4 = defpackage.AbstractC1872zv.a
            java.lang.Object r3 = r3.u
            if (r3 != 0) goto L24
            goto L2b
        L24:
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L2c
        L2b:
            r3 = r2
        L2c:
            int r4 = r1 + r3
            r0.a = r3
            int r5 = r7.z
            r6 = 1
            if (r5 != r6) goto L36
            r2 = r4
        L36:
            r0.c = r2
            r2 = 3
            if (r5 == r2) goto L3d
            if (r5 != r6) goto L3e
        L3d:
            int r3 = -r1
        L3e:
            r0.b = r3
            super.d(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Zd.g():void");
    }
}
