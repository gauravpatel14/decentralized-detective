package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class dx0 implements Yw0 {
    public final C0323Zw0 w;
    public C0383aw2 x;
    public final Rect u = new Rect();
    public final M21 v = new M21();
    public Rect z = new Rect();
    public final int t = 4;
    public List y = Collections.emptyList();

    public dx0(C0323Zw0 c0323Zw0, C0383aw2 c0383aw2) {
        this.w = c0323Zw0;
        c0323Zw0.z.add(this);
        if (c0383aw2 != null) {
            a(c0383aw2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072 A[PHI: r1
      0x0072: PHI (r1v3 int) = (r1v2 int), (r1v6 int) binds: [B:20:0x0061, B:23:0x006b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085 A[PHI: r1
      0x0085: PHI (r1v4 int) = (r1v3 int), (r1v5 int) binds: [B:25:0x0074, B:28:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(defpackage.C0383aw2 r9) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dx0.a(aw2):void");
    }

    @Override // defpackage.y41
    public final C0383aw2 c(View view, C0383aw2 c0383aw2) {
        AbstractC0228Sv2 c0192Pv2;
        int i = AbstractC1872zv.a;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 35) {
            return c0383aw2;
        }
        a(c0383aw2);
        if (i2 >= 30) {
            c0192Pv2 = new C0215Rv2(c0383aw2);
        } else if (i2 >= 29) {
            c0192Pv2 = new C0192Pv2(c0383aw2);
        } else {
            C0166Nv2 c0166Nv2 = new C0166Nv2(c0383aw2);
            c0166Nv2.c = c0383aw2.f();
            c0192Pv2 = c0166Nv2;
        }
        c0192Pv2.c(this.t, bx0.e);
        return c0192Pv2.b();
    }
}
