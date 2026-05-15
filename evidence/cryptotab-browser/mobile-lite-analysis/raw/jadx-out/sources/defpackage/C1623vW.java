package defpackage;

import java.util.Set;

/* JADX INFO: renamed from: vW, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1623vW implements nI {
    @Override // defpackage.nI
    public final Object a(Xv1 xv1) {
        Set setC = xv1.c(C1523ti.class);
        Tl0 tl0 = Tl0.b;
        if (tl0 == null) {
            synchronized (Tl0.class) {
                try {
                    tl0 = Tl0.b;
                    if (tl0 == null) {
                        tl0 = new Tl0();
                        Tl0.b = tl0;
                    }
                } finally {
                }
            }
        }
        return new C1680wW(setC, tl0);
    }
}
