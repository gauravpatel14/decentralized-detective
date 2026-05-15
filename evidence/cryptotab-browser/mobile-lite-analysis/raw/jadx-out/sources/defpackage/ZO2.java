package defpackage;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzaw;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ZO2 {
    public final String a;
    public final String b;
    public final long c;
    public final Bundle d;

    public ZO2(long j, Bundle bundle, String str, String str2) {
        this.a = str;
        this.b = str2;
        this.d = bundle;
        this.c = j;
    }

    public static ZO2 b(zzaw zzawVar) {
        String str = zzawVar.t;
        return new ZO2(zzawVar.w, zzawVar.u.f2(), str, zzawVar.v);
    }

    public final zzaw a() {
        return new zzaw(this.a, new zzau(new Bundle(this.d)), this.b, this.c);
    }

    public final String toString() {
        return "origin=" + this.b + ",name=" + this.a + ",params=" + this.d.toString();
    }
}
