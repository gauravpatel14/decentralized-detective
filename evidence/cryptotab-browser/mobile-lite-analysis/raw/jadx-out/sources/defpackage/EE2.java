package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzau;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class EE2 {
    public final String a;
    public final String b;
    public final String c;
    public final long d;
    public final long e;
    public final zzau f;

    public EE2(C1391rR2 c1391rR2, String str, String str2, String str3, long j, Bundle bundle) {
        zzau zzauVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.a = str2;
        this.b = str3;
        this.c = true == TextUtils.isEmpty(str) ? null : str;
        this.d = j;
        this.e = 0L;
        if (bundle.isEmpty()) {
            zzauVar = new zzau(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    WO2 wo2 = c1391rR2.i;
                    C1391rR2.k(wo2);
                    wo2.f.a("Param name can't be null");
                    it.remove();
                } else {
                    C0653fY2 c0653fY2 = c1391rR2.l;
                    C1391rR2.i(c0653fY2);
                    Object objK = c0653fY2.k(bundle2.get(next), next);
                    if (objK == null) {
                        WO2 wo22 = c1391rR2.i;
                        C1391rR2.k(wo22);
                        wo22.i.b(c1391rR2.m.c(next), "Param value can't be null");
                        it.remove();
                    } else {
                        C0653fY2 c0653fY22 = c1391rR2.l;
                        C1391rR2.i(c0653fY22);
                        c0653fY22.w(bundle2, next, objK);
                    }
                }
            }
            zzauVar = new zzau(bundle2);
        }
        this.f = zzauVar;
    }

    public final EE2 a(C1391rR2 c1391rR2, long j) {
        return new EE2(c1391rR2, this.c, this.a, this.b, this.d, j, this.f);
    }

    public final String toString() {
        return "Event{appId='" + this.a + "', name='" + this.b + "', params=" + this.f.toString() + "}";
    }

    public EE2(C1391rR2 c1391rR2, String str, String str2, String str3, long j, long j2, zzau zzauVar) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzauVar);
        this.a = str2;
        this.b = str3;
        this.c = true == TextUtils.isEmpty(str) ? null : str;
        this.d = j;
        this.e = j2;
        if (j2 != 0 && j2 > j) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.i.c(WO2.n(str2), WO2.n(str3), "Event created with reverse previous/current timestamps. appId, name");
        }
        this.f = zzauVar;
    }
}
