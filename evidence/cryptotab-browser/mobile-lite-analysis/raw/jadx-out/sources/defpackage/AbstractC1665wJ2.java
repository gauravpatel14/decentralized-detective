package defpackage;

import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: wJ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1665wJ2 {
    public final YL2 a;
    public Jt1 b;
    public final List c;

    public AbstractC1665wJ2() {
        AbstractC0700gL2.d(UL2.s);
        YL2 yl2 = new YL2("MediaControlChannel");
        this.a = yl2;
        if (!TextUtils.isEmpty(null)) {
            yl2.b = TextUtils.isEmpty(null) ? null : "[null] ";
        }
        this.c = Collections.synchronizedList(new ArrayList());
    }

    public final void a(long j, String str) {
        Jt1 jt1 = this.b;
        GoogleApiClient googleApiClient = jt1.a;
        if (googleApiClient == null) {
            throw new IllegalStateException("No GoogleApiClient available");
        }
        ty tyVar = jt1.c.e;
        String str2 = UL2.s;
        tyVar.getClass();
        googleApiClient.execute(new UO2(googleApiClient, str2, str)).setResultCallback(new TE2(jt1, j));
    }

    public final void b(C1501tM2 c1501tM2) {
        this.c.add(c1501tM2);
    }

    public final long c() {
        Jt1 jt1 = this.b;
        long j = jt1.b + 1;
        jt1.b = j;
        return j;
    }
}
