package com.google.android.gms.common.config;

import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import defpackage.C0895jN2;
import defpackage.C1140nI2;
import defpackage.LK2;
import defpackage.OF2;
import defpackage.TB2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public abstract class GservicesValue {
    private static final Object zzc = new Object();
    protected final String zza;
    protected final Object zzb;
    private Object zzd = null;

    public GservicesValue(String str, Object obj) {
        this.zza = str;
        this.zzb = obj;
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public static boolean isInitialized() {
        synchronized (zzc) {
        }
        return false;
    }

    @KeepForSdk
    public static GservicesValue value(String str, Float f) {
        return new LK2(str, f);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public final Object get() {
        Object objZza;
        Object obj = this.zzd;
        if (obj != null) {
            return obj;
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        Object obj2 = zzc;
        synchronized (obj2) {
        }
        synchronized (obj2) {
            try {
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        }
        try {
            objZza = zza(this.zza);
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                objZza = zza(this.zza);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
        return objZza;
    }

    @KeepForSdk
    @Deprecated
    public final Object getBinderSafe() {
        return get();
    }

    @KeepForSdk
    public void override(Object obj) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.zzd = obj;
        Object obj2 = zzc;
        synchronized (obj2) {
            synchronized (obj2) {
            }
        }
    }

    @KeepForSdk
    public void resetOverride() {
        this.zzd = null;
    }

    public abstract Object zza(String str);

    @KeepForSdk
    public static GservicesValue value(String str, Integer num) {
        return new C1140nI2(str, num);
    }

    @KeepForSdk
    public static GservicesValue value(String str, Long l) {
        return new OF2(str, l);
    }

    @KeepForSdk
    public static GservicesValue value(String str, String str2) {
        return new C0895jN2(str, str2);
    }

    @KeepForSdk
    public static GservicesValue value(String str, boolean z) {
        return new TB2(str, Boolean.valueOf(z));
    }
}
