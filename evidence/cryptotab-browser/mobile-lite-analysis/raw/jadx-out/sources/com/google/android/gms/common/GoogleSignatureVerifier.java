package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import com.google.errorprone.annotations.RestrictedInheritance;
import defpackage.AbstractBinderC1095mV2;
import defpackage.AbstractC0363aZ2;
import defpackage.AbstractC1684wY2;
import defpackage.BinderC1396rW2;
import defpackage.C1363r33;
import defpackage.NO2;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier zza;
    private static volatile Set zzb;
    private final Context zzc;
    private volatile String zzd;

    public GoogleSignatureVerifier(Context context) {
        this.zzc = context.getApplicationContext();
    }

    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            try {
                if (zza == null) {
                    AbstractC0363aZ2.a(context);
                    zza = new GoogleSignatureVerifier(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zza;
    }

    public static final AbstractBinderC1095mV2 zza(PackageInfo packageInfo, AbstractBinderC1095mV2... abstractBinderC1095mV2Arr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            BinderC1396rW2 binderC1396rW2 = new BinderC1396rW2(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < abstractBinderC1095mV2Arr.length; i++) {
                if (abstractBinderC1095mV2Arr[i].equals(binderC1396rW2)) {
                    return abstractBinderC1095mV2Arr[i];
                }
            }
        }
        return null;
    }

    public static final boolean zzb(PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (!z) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z ? zza(packageInfo2, AbstractC1684wY2.a) : zza(packageInfo2, AbstractC1684wY2.a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final C1363r33 zzc(String str, boolean z, boolean z2) {
        boolean zZzi;
        C1363r33 c1363r33;
        C1363r33 c1363r332;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return new C1363r33(false, 1, "null pkg", null);
        }
        if (str.equals(this.zzd)) {
            return C1363r33.e;
        }
        NO2 no2 = AbstractC0363aZ2.a;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                AbstractC0363aZ2.d();
                zZzi = AbstractC0363aZ2.e.zzi();
            } finally {
            }
        } catch (RemoteException | DynamiteModule$LoadingException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            zZzi = false;
        }
        if (zZzi) {
            c1363r332 = AbstractC0363aZ2.c(str, GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc), true);
        } else {
            try {
                PackageInfo packageInfo = this.zzc.getPackageManager().getPackageInfo(str, 64);
                boolean zHonorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc);
                if (packageInfo == null) {
                    c1363r332 = new C1363r33(false, 1, "null pkg", null);
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        c1363r33 = new C1363r33(false, 1, "single cert required", null);
                    } else {
                        BinderC1396rW2 binderC1396rW2 = new BinderC1396rW2(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            C1363r33 c1363r33B = AbstractC0363aZ2.b(str2, binderC1396rW2, zHonorsDebugCertificates, false);
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            if (c1363r33B.a && (applicationInfo = packageInfo.applicationInfo) != null && (applicationInfo.flags & 2) != 0) {
                                threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                                try {
                                    C1363r33 c1363r33B2 = AbstractC0363aZ2.b(str2, binderC1396rW2, false, true);
                                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                                    if (c1363r33B2.a) {
                                        c1363r33 = new C1363r33(false, 1, "debuggable release cert app rejected", null);
                                    }
                                } finally {
                                }
                            }
                            c1363r332 = c1363r33B;
                        } finally {
                        }
                    }
                    c1363r332 = c1363r33;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                return new C1363r33(false, 1, "no pkg ".concat(str), e2);
            }
        }
        if (c1363r332.a) {
            this.zzd = str;
        }
        return c1363r332;
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zzb(packageInfo, false)) {
            return true;
        }
        if (zzb(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(String str) {
        C1363r33 c1363r33Zzc = zzc(str, false, false);
        c1363r33Zzc.getClass();
        return c1363r33Zzc.a;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isUidGoogleSigned(int i) {
        int length;
        String[] packagesForUid = this.zzc.getPackageManager().getPackagesForUid(i);
        C1363r33 c1363r33 = null;
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    Preconditions.checkNotNull(c1363r33);
                    break;
                }
                c1363r33 = zzc(packagesForUid[i2], false, false);
                if (c1363r33.a) {
                    break;
                }
                i2++;
            }
        } else {
            c1363r33 = new C1363r33(false, 1, "no pkgs", null);
        }
        c1363r33.getClass();
        return c1363r33.a;
    }
}
