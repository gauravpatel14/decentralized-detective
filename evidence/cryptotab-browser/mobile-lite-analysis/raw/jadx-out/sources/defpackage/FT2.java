package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FT2 implements Runnable {
    public final /* synthetic */ IU2 A;
    public final /* synthetic */ String t;
    public final /* synthetic */ String u;
    public final /* synthetic */ long v;
    public final /* synthetic */ Bundle w;
    public final /* synthetic */ boolean x;
    public final /* synthetic */ boolean y;
    public final /* synthetic */ boolean z;

    public FT2(IU2 iu2, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3) {
        this.A = iu2;
        this.t = str;
        this.u = str2;
        this.v = j;
        this.w = bundle;
        this.x = z;
        this.y = z2;
        this.z = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.A.p(this.t, this.u, this.v, this.w, this.x, this.y, this.z);
    }
}
