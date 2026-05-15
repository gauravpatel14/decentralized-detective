package defpackage;

import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: iQ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CallableC0839iQ2 implements Callable {
    public final /* synthetic */ TQ2 a;
    public final /* synthetic */ String b;

    public /* synthetic */ CallableC0839iQ2(TQ2 tq2, String str) {
        this.a = tq2;
        this.b = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        TQ2 tq2 = this.a;
        C0513dE2 c0513dE2 = tq2.b.c;
        QX2.H(c0513dE2);
        String str = this.b;
        C1275pS2 c1275pS2Z = c0513dE2.z(str);
        HashMap map = new HashMap();
        map.put("platform", "android");
        map.put("package_name", str);
        tq2.a.g.l();
        map.put("gmp_version", 64000L);
        if (c1275pS2Z != null) {
            String strI = c1275pS2Z.I();
            if (strI != null) {
                map.put("app_version", strI);
            }
            map.put("app_version_int", Long.valueOf(c1275pS2Z.C()));
            map.put("dynamite_version", Long.valueOf(c1275pS2Z.D()));
        }
        return map;
    }
}
