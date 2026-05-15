package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.zzb;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SB2 implements Runnable {
    public final /* synthetic */ LifecycleCallback t;
    public final /* synthetic */ String u;
    public final /* synthetic */ zzb v;

    public SB2(zzb zzbVar, LifecycleCallback lifecycleCallback, String str) {
        this.v = zzbVar;
        this.t = lifecycleCallback;
        this.u = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        zzb zzbVar = this.v;
        int i = zzbVar.zzc;
        LifecycleCallback lifecycleCallback = this.t;
        if (i > 0) {
            if (zzbVar.zzd != null) {
                bundle = zzbVar.zzd.getBundle(this.u);
            } else {
                bundle = null;
            }
            lifecycleCallback.onCreate(bundle);
        }
        if (zzbVar.zzc >= 2) {
            lifecycleCallback.onStart();
        }
        if (zzbVar.zzc >= 3) {
            lifecycleCallback.onResume();
        }
        if (zzbVar.zzc >= 4) {
            lifecycleCallback.onStop();
        }
        if (zzbVar.zzc >= 5) {
            lifecycleCallback.onDestroy();
        }
    }
}
