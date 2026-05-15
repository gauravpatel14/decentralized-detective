package defpackage;

import android.os.Bundle;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class jI2 implements KU2 {
    public final /* synthetic */ AN2 a;

    public jI2(AN2 an2) {
        this.a = an2;
    }

    @Override // defpackage.KU2
    public final void a(String str) {
        AN2 an2 = this.a;
        an2.b(new C1203oK2(an2, str));
    }

    @Override // defpackage.KU2
    public final String b() {
        AN2 an2 = this.a;
        RH2 rh2 = new RH2();
        an2.b(new C0345aL2(an2, rh2));
        return rh2.Y0(50L);
    }

    @Override // defpackage.KU2
    public final void c(String str, String str2, Bundle bundle) {
        AN2 an2 = this.a;
        an2.b(new C1776yJ2(an2, str, str2, bundle));
    }

    @Override // defpackage.KU2
    public final List d(String str, String str2) {
        AN2 an2 = this.a;
        RH2 rh2 = new RH2();
        an2.b(new CJ2(an2, str, str2, rh2));
        List list = (List) RH2.Z0(rh2.X0(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    @Override // defpackage.KU2
    public final Map e(String str, String str2, boolean z) {
        AN2 an2 = this.a;
        RH2 rh2 = new RH2();
        an2.b(new pL2(an2, str, str2, z, rh2));
        Bundle bundleX0 = rh2.X0(5000L);
        if (bundleX0 == null || bundleX0.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(bundleX0.size());
        for (String str3 : bundleX0.keySet()) {
            Object obj = bundleX0.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }

    @Override // defpackage.KU2
    public final void f(String str) {
        AN2 an2 = this.a;
        an2.b(new C1551uK2(an2, str));
    }

    @Override // defpackage.KU2
    public final int g(String str) {
        AN2 an2 = this.a;
        RH2 rh2 = new RH2();
        an2.b(new EL2(an2, str, rh2));
        Integer num = (Integer) RH2.Z0(rh2.X0(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    @Override // defpackage.KU2
    public final String h() {
        AN2 an2 = this.a;
        RH2 rh2 = new RH2();
        an2.b(new hL2(an2, rh2));
        return rh2.Y0(500L);
    }

    @Override // defpackage.KU2
    public final void i(Bundle bundle) {
        AN2 an2 = this.a;
        an2.b(new sJ2(an2, bundle));
    }

    @Override // defpackage.KU2
    public final void j(String str, String str2, Bundle bundle) {
        AN2 an2 = this.a;
        an2.b(new C1021lM2(an2, str, str2, bundle));
    }

    @Override // defpackage.KU2
    public final String k() {
        AN2 an2 = this.a;
        RH2 rh2 = new RH2();
        an2.b(new VK2(an2, rh2));
        return rh2.Y0(500L);
    }

    @Override // defpackage.KU2
    public final long zzb() {
        AN2 an2 = this.a;
        RH2 rh2 = new RH2();
        an2.b(new C0573eL2(an2, rh2));
        Long l = (Long) RH2.Z0(rh2.X0(500L), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long jNextLong = new Random(System.nanoTime() ^ an2.a.currentTimeMillis()).nextLong();
        int i = an2.d + 1;
        an2.d = i;
        return jNextLong + ((long) i);
    }

    @Override // defpackage.KU2
    public final String zzi() {
        AN2 an2 = this.a;
        RH2 rh2 = new RH2();
        an2.b(new C1081mL2(an2, rh2));
        return rh2.Y0(500L);
    }
}
