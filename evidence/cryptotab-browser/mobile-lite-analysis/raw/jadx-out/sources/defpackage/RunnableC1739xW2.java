package defpackage;

import android.content.ComponentName;
import android.content.Context;

/* JADX INFO: renamed from: xW2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1739xW2 implements Runnable {
    public final /* synthetic */ AW2 t;

    public RunnableC1739xW2(AW2 aw2) {
        this.t = aw2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AW2 aw2 = this.t;
        CW2 cw2 = aw2.v;
        Context context = cw2.a.a;
        aw2.v.a.getClass();
        CW2.u(cw2, new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
