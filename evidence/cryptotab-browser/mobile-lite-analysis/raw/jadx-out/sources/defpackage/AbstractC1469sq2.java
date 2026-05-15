package defpackage;

import android.content.Context;

/* JADX INFO: renamed from: sq2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1469sq2 {
    public static Lu1 a(Context context) {
        Lu1 lu1 = new Lu1(new c00(new C1411rq2(context.getApplicationContext())), new Ho(new C0293Xq0()));
        C1176nw c1176nw = lu1.i;
        if (c1176nw != null) {
            c1176nw.b();
        }
        for (C0970kY0 c0970kY0 : lu1.h) {
            if (c0970kY0 != null) {
                c0970kY0.x = true;
                c0970kY0.interrupt();
            }
        }
        C1176nw c1176nw2 = new C1176nw(lu1.c, lu1.d, lu1.e, lu1.g);
        lu1.i = c1176nw2;
        c1176nw2.start();
        for (int i = 0; i < lu1.h.length; i++) {
            C0970kY0 c0970kY02 = new C0970kY0(lu1.d, lu1.f, lu1.e, lu1.g);
            lu1.h[i] = c0970kY02;
            c0970kY02.start();
        }
        return lu1;
    }
}
