package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.zzd;

/* JADX INFO: renamed from: mI2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1076mI2 implements Runnable {
    public final /* synthetic */ LifecycleCallback t;
    public final /* synthetic */ String u;
    public final /* synthetic */ zzd v;

    public RunnableC1076mI2(zzd zzdVar, LifecycleCallback lifecycleCallback, String str) {
        this.v = zzdVar;
        this.t = lifecycleCallback;
        this.u = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        zzd zzdVar = this.v;
        int i = zzdVar.zzc;
        LifecycleCallback lifecycleCallback = this.t;
        if (i > 0) {
            if (zzdVar.zzd != null) {
                bundle = zzdVar.zzd.getBundle(this.u);
            } else {
                bundle = null;
            }
            lifecycleCallback.onCreate(bundle);
        }
        if (zzdVar.zzc >= 2) {
            lifecycleCallback.onStart();
        }
        if (zzdVar.zzc >= 3) {
            lifecycleCallback.onResume();
        }
        if (zzdVar.zzc >= 4) {
            lifecycleCallback.onStop();
        }
        if (zzdVar.zzc >= 5) {
            lifecycleCallback.onDestroy();
        }
    }
}
