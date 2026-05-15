package org.chromium.gfx.mojom;

import defpackage.C0965kV;
import defpackage.MT;
import defpackage.WQ1;
import defpackage.i70;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Rect extends WQ1 {
    public static final MT[] f;
    public static final MT g;
    public int b;
    public int c;
    public int d;
    public int e;

    static {
        MT[] mtArr = {new MT(24, 0)};
        f = mtArr;
        g = mtArr[0];
    }

    public Rect(int i) {
        super(24);
    }

    public static Rect d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            Rect rect = new Rect(c0965kV.c(f).b);
            rect.b = c0965kV.n(8);
            rect.c = c0965kV.n(12);
            rect.d = c0965kV.n(16);
            rect.e = c0965kV.n(20);
            return rect;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(g);
        i70VarS.b(this.b, 8);
        i70VarS.b(this.c, 12);
        i70VarS.b(this.d, 16);
        i70VarS.b(this.e, 20);
    }
}
