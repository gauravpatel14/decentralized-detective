package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import defpackage.AbstractBinderC1095mV2;
import defpackage.AbstractC0363aZ2;
import defpackage.NO2;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: aZ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0363aZ2 {
    public static volatile zzag e;
    public static Context g;
    public static final NO2 a = new NO2(AbstractBinderC1095mV2.W0("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
    public static final EQ2 b = new EQ2(AbstractBinderC1095mV2.W0("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
    public static final BinderC1733xS2 c = new BinderC1733xS2(AbstractBinderC1095mV2.W0("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
    public static final ZT2 d = new ZT2(AbstractBinderC1095mV2.W0("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
    public static final Object f = new Object();

    public static synchronized void a(Context context) {
        if (g != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            g = context.getApplicationContext();
        }
    }

    public static C1363r33 b(final String str, final AbstractBinderC1095mV2 abstractBinderC1095mV2, final boolean z, boolean z2) {
        try {
            d();
            Preconditions.checkNotNull(g);
            try {
                if (e.zzh(new zzs(str, abstractBinderC1095mV2, z, z2), new ObjectWrapper(g.getPackageManager()))) {
                    return C1363r33.e;
                }
                new Callable() { // from class: com.google.android.gms.common.zze
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        boolean z3 = z;
                        String str2 = str;
                        AbstractBinderC1095mV2 abstractBinderC1095mV22 = abstractBinderC1095mV2;
                        if (!z3) {
                            String str3 = AbstractC0363aZ2.b(str2, abstractBinderC1095mV22, true, false).a ? "debug cert rejected" : "not allowed";
                            MessageDigest messageDigestZza = AndroidUtilsLight.zza("SHA-256");
                            Preconditions.checkNotNull(messageDigestZza);
                            return str3 + ": pkg=" + str2 + ", sha256=" + Hex.bytesToStringLowercase(messageDigestZza.digest(abstractBinderC1095mV22.X0())) + ", atk=" + z3 + ", ver=12451000.false";
                        }
                        NO2 no2 = AbstractC0363aZ2.a;
                        MessageDigest messageDigestZza2 = AndroidUtilsLight.zza("SHA-256");
                        Preconditions.checkNotNull(messageDigestZza2);
                        return str3 + ": pkg=" + str2 + ", sha256=" + Hex.bytesToStringLowercase(messageDigestZza2.digest(abstractBinderC1095mV22.X0())) + ", atk=" + z3 + ", ver=12451000.false";
                    }
                };
                return new R23(false, 1, null, null);
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return new C1363r33(false, 1, "module call", e2);
            }
        } catch (DynamiteModule$LoadingException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            return new C1363r33(false, 1, "module init: ".concat(String.valueOf(e3.getMessage())), e3);
        }
    }

    public static C1363r33 c(String str, boolean z, boolean z2) {
        C1363r33 c1363r33;
        C1363r33 c1363r332;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.checkNotNull(g);
            try {
                d();
                zzo zzoVar = new zzo(str, z, false, new ObjectWrapper(g), false, true);
                try {
                    zzq zzqVarZze = z2 ? e.zze(zzoVar) : e.zzf(zzoVar);
                    if (zzqVarZze.zzb()) {
                        c1363r332 = new C1363r33(true, zzqVarZze.zzc(), null, null);
                    } else {
                        String strZza = zzqVarZze.zza();
                        PackageManager.NameNotFoundException nameNotFoundException = zzqVarZze.zzd() == 4 ? new PackageManager.NameNotFoundException() : null;
                        if (strZza == null) {
                            strZza = "error checking package certificate";
                        }
                        int iZzc = zzqVarZze.zzc();
                        zzqVarZze.zzd();
                        c1363r332 = new C1363r33(false, iZzc, strZza, nameNotFoundException);
                    }
                } catch (RemoteException e2) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                    c1363r33 = new C1363r33(false, 1, "module call", e2);
                    c1363r332 = c1363r33;
                }
            } catch (DynamiteModule$LoadingException e3) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
                c1363r33 = new C1363r33(false, 1, "module init: ".concat(String.valueOf(e3.getMessage())), e3);
            }
            return c1363r332;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public static void d() {
        if (e != null) {
            return;
        }
        Preconditions.checkNotNull(g);
        synchronized (f) {
            try {
                if (e == null) {
                    e = zzaf.zzb(m50.c(g, m50.d, "com.google.android.gms.googlecertificates").b("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
