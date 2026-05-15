package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import com.google.errorprone.annotations.RestrictedInheritance;
import defpackage.AbstractC0363aZ2;
import defpackage.C1363r33;
import defpackage.C1368rC2;
import defpackage.DC2;
import defpackage.NO2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*javatests.*/com/google/android/gms/common/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
public class PackageSignatureVerifier {
    static volatile C1368rC2 zza;
    private static DC2 zzb;

    private static DC2 zza(Context context) {
        DC2 dc2;
        synchronized (PackageSignatureVerifier.class) {
            try {
                if (zzb == null) {
                    DC2 dc22 = new DC2();
                    AbstractC0363aZ2.a(context);
                    zzb = dc22;
                }
                dc2 = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dc2;
    }

    @ShowFirstParty
    @KeepForSdk
    public PackageVerificationResult queryPackageSignatureVerified(Context context, String str) {
        boolean zZzg;
        boolean zHonorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(context);
        zza(context);
        NO2 no2 = AbstractC0363aZ2.a;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                AbstractC0363aZ2.d();
                zZzg = AbstractC0363aZ2.e.zzg();
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule$LoadingException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            zZzg = false;
        }
        if (!zZzg) {
            throw new zzae();
        }
        String strConcat = String.valueOf(str).concat(true != zHonorsDebugCertificates ? "-0" : "-1");
        if (zza != null && zza.a.equals(strConcat)) {
            return zza.b;
        }
        zza(context);
        C1363r33 c1363r33C = AbstractC0363aZ2.c(str, zHonorsDebugCertificates, false);
        if (c1363r33C.a) {
            zza = new C1368rC2(strConcat, PackageVerificationResult.zzd(str, c1363r33C.d));
            return zza.b;
        }
        Preconditions.checkNotNull(c1363r33C.b);
        return PackageVerificationResult.zza(str, c1363r33C.b, c1363r33C.c);
    }

    @ShowFirstParty
    @KeepForSdk
    public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(Context context, String str) {
        try {
            PackageVerificationResult packageVerificationResultQueryPackageSignatureVerified = queryPackageSignatureVerified(context, str);
            packageVerificationResultQueryPackageSignatureVerified.zzb();
            return packageVerificationResultQueryPackageSignatureVerified;
        } catch (SecurityException e) {
            PackageVerificationResult packageVerificationResultQueryPackageSignatureVerified2 = queryPackageSignatureVerified(context, str);
            if (!packageVerificationResultQueryPackageSignatureVerified2.zzc()) {
                return packageVerificationResultQueryPackageSignatureVerified2;
            }
            Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", e);
            return packageVerificationResultQueryPackageSignatureVerified2;
        }
    }
}
