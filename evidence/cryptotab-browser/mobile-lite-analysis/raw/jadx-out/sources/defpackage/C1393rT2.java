package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcl;

/* JADX INFO: renamed from: rT2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1393rT2 {
    public final Context a;
    public final String b;
    public final String c;
    public final String d;
    public final Boolean e;
    public final long f;
    public final zzcl g;
    public final boolean h;
    public final Long i;
    public final String j;

    public C1393rT2(Context context, zzcl zzclVar, Long l) {
        this.h = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.a = applicationContext;
        this.i = l;
        if (zzclVar != null) {
            this.g = zzclVar;
            this.b = zzclVar.y;
            this.c = zzclVar.x;
            this.d = zzclVar.w;
            this.h = zzclVar.v;
            this.f = zzclVar.u;
            this.j = zzclVar.A;
            Bundle bundle = zzclVar.z;
            if (bundle != null) {
                this.e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
