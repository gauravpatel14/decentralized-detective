package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.RestrictedInheritance;
import defpackage.AbstractC0363aZ2;
import defpackage.AbstractC0760hD2;
import defpackage.AbstractC1313qD2;
import defpackage.BinderC1733xS2;
import defpackage.C0689gC2;
import defpackage.C1769yD2;
import defpackage.OC2;
import defpackage.ZT2;
import java.util.HashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*javatests/com/google/android/gmscore/integ/client/common/robolectric/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
public class GmsSignatureVerifier {
    private static final C0689gC2 zza;
    private static final C0689gC2 zzb;
    private static final HashMap zzc;

    static {
        OC2 oc2 = AbstractC0760hD2.u;
        C1769yD2 c1769yD2 = C1769yD2.x;
        ZT2 zt2 = AbstractC0363aZ2.d;
        Object[] objArr = {zt2.X0(), AbstractC0363aZ2.b.X0()};
        AbstractC1313qD2.a(2, objArr);
        C1769yD2 c1769yD2T = AbstractC0760hD2.t(2, objArr);
        Preconditions.checkNotNull(c1769yD2T);
        AbstractC0760hD2 abstractC0760hD2V = AbstractC0760hD2.v(c1769yD2T);
        BinderC1733xS2 binderC1733xS2 = AbstractC0363aZ2.c;
        Object[] objArr2 = {binderC1733xS2.X0(), AbstractC0363aZ2.a.X0()};
        AbstractC1313qD2.a(2, objArr2);
        C1769yD2 c1769yD2T2 = AbstractC0760hD2.t(2, objArr2);
        Preconditions.checkNotNull(c1769yD2T2);
        AbstractC0760hD2 abstractC0760hD2V2 = AbstractC0760hD2.v(c1769yD2T2);
        if (abstractC0760hD2V.isEmpty() && abstractC0760hD2V2.isEmpty()) {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
        zza = new C0689gC2();
        Object[] objArr3 = {zt2.X0()};
        AbstractC1313qD2.a(1, objArr3);
        C1769yD2 c1769yD2T3 = AbstractC0760hD2.t(1, objArr3);
        Preconditions.checkNotNull(c1769yD2T3);
        AbstractC0760hD2 abstractC0760hD2V3 = AbstractC0760hD2.v(c1769yD2T3);
        Object[] objArr4 = {binderC1733xS2.X0()};
        AbstractC1313qD2.a(1, objArr4);
        C1769yD2 c1769yD2T4 = AbstractC0760hD2.t(1, objArr4);
        Preconditions.checkNotNull(c1769yD2T4);
        AbstractC0760hD2 abstractC0760hD2V4 = AbstractC0760hD2.v(c1769yD2T4);
        if (abstractC0760hD2V3.isEmpty() && abstractC0760hD2V4.isEmpty()) {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
        zzb = new C0689gC2();
        zzc = new HashMap();
    }
}
