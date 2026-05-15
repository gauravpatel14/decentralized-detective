package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class X13 {
    public final C1391rR2 a;

    public X13(C1391rR2 c1391rR2) {
        this.a = c1391rR2;
    }

    public final void a(String str, Bundle bundle) {
        String string;
        C1391rR2 c1391rR2 = this.a;
        C0899jR2 c0899jR2 = c1391rR2.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        if (c1391rR2.g()) {
            return;
        }
        if (bundle.isEmpty()) {
            string = null;
        } else {
            if (true == str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        TP2 tp2 = c1391rR2.h;
        C1391rR2.i(tp2);
        tp2.t.b(string);
        C1391rR2.i(tp2);
        tp2.u.b(c1391rR2.n.currentTimeMillis());
    }

    public final boolean b() {
        TP2 tp2 = this.a.h;
        C1391rR2.i(tp2);
        return tp2.u.a() > 0;
    }

    public final boolean c() {
        if (!b()) {
            return false;
        }
        C1391rR2 c1391rR2 = this.a;
        long jCurrentTimeMillis = c1391rR2.n.currentTimeMillis();
        TP2 tp2 = c1391rR2.h;
        C1391rR2.i(tp2);
        return jCurrentTimeMillis - tp2.u.a() > c1391rR2.g.m(null, AbstractC0579eO2.Q);
    }
}
