package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BT2 implements Runnable {
    public final /* synthetic */ IU2 t;

    public BT2(IU2 iu2) {
        this.t = iu2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        X13 x13 = this.t.n;
        C1391rR2 c1391rR2 = x13.a;
        C0899jR2 c0899jR2 = c1391rR2.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        if (x13.b()) {
            boolean zC = x13.c();
            IU2 iu2 = c1391rR2.p;
            TP2 tp2 = c1391rR2.h;
            if (zC) {
                C1391rR2.i(tp2);
                tp2.t.b(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                C1391rR2.j(iu2);
                iu2.n("auto", "_cmpx", bundle);
            } else {
                C1391rR2.i(tp2);
                String strA = tp2.t.a();
                if (TextUtils.isEmpty(strA)) {
                    WO2 wo2 = c1391rR2.i;
                    C1391rR2.k(wo2);
                    wo2.g.a("Cache still valid but referrer not found");
                } else {
                    C1391rR2.i(tp2);
                    long jA = ((tp2.u.a() / 3600000) - 1) * 3600000;
                    Uri uri = Uri.parse(strA);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(uri.getPath(), bundle2);
                    for (String str : uri.getQueryParameterNames()) {
                        bundle2.putString(str, uri.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", jA);
                    Object obj = pair.first;
                    String str2 = obj == null ? "app" : (String) obj;
                    C1391rR2.j(iu2);
                    iu2.n(str2, "_cmp", (Bundle) pair.second);
                }
                C1391rR2.i(tp2);
                tp2.t.b(null);
            }
            C1391rR2.i(tp2);
            tp2.u.b(0L);
        }
    }
}
