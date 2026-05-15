package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import defpackage.C0445c23;
import defpackage.HandlerC0531dU2;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public abstract class GmsClientSupervisor {
    static HandlerThread zza = null;
    private static final Object zzb = new Object();
    private static C0445c23 zzc = null;
    private static Executor zzd = null;
    private static boolean zze = false;

    @KeepForSdk
    public static int getDefaultBindFlags() {
        return 4225;
    }

    @KeepForSdk
    public static GmsClientSupervisor getInstance(Context context) {
        synchronized (zzb) {
            try {
                if (zzc == null) {
                    zzc = new C0445c23(context.getApplicationContext(), zze ? getOrStartHandlerThread().getLooper() : context.getMainLooper(), zzd);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzc;
    }

    @KeepForSdk
    public static HandlerThread getOrStartHandlerThread() {
        synchronized (zzb) {
            try {
                HandlerThread handlerThread = zza;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                zza = handlerThread2;
                handlerThread2.start();
                return zza;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public static void setDefaultBindExecutor(Executor executor) {
        synchronized (zzb) {
            C0445c23 c0445c23 = zzc;
            if (c0445c23 != null) {
                synchronized (c0445c23.a) {
                    c0445c23.h = executor;
                }
            }
            zzd = executor;
        }
    }

    @KeepForSdk
    public static void setUseHandlerThreadForCallbacks() {
        synchronized (zzb) {
            try {
                C0445c23 c0445c23 = zzc;
                if (c0445c23 != null && !zze) {
                    Looper looper = getOrStartHandlerThread().getLooper();
                    synchronized (c0445c23.a) {
                        c0445c23.c = new HandlerC0531dU2(looper, c0445c23.d);
                    }
                }
                zze = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zzc(new zzo(componentName, 4225), serviceConnection, str, null);
    }

    @KeepForSdk
    public void unbindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zza(new zzo(componentName, 4225), serviceConnection, str);
    }

    public abstract void zza(zzo zzoVar, ServiceConnection serviceConnection, String str);

    public final void zzb(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        zza(new zzo(str, str2, 4225, z), serviceConnection, str3);
    }

    public abstract boolean zzc(zzo zzoVar, ServiceConnection serviceConnection, String str, Executor executor);

    @KeepForSdk
    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str, Executor executor) {
        return zzc(new zzo(componentName, 4225), serviceConnection, str, executor);
    }

    @KeepForSdk
    public void unbindService(String str, ServiceConnection serviceConnection, String str2) {
        zza(new zzo(str, 4225, false), serviceConnection, str2);
    }

    @KeepForSdk
    public static HandlerThread getOrStartHandlerThread(int i) {
        synchronized (zzb) {
            try {
                HandlerThread handlerThread = zza;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", i);
                zza = handlerThread2;
                handlerThread2.start();
                return zza;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public boolean bindService(String str, ServiceConnection serviceConnection, String str2) {
        return zzc(new zzo(str, 4225, false), serviceConnection, str2, null);
    }
}
