package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzcl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class uI2 extends YG2 implements DI2 {
    @Override // defpackage.DI2
    public final void beginAdUnitExposure(String str, long j) {
        Parcel parcelW0 = W0();
        parcelW0.writeString(str);
        parcelW0.writeLong(j);
        Y0(23, parcelW0);
    }

    @Override // defpackage.DI2
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel parcelW0 = W0();
        parcelW0.writeString(str);
        parcelW0.writeString(str2);
        hH2.c(parcelW0, bundle);
        Y0(9, parcelW0);
    }

    @Override // defpackage.DI2
    public final void endAdUnitExposure(String str, long j) {
        Parcel parcelW0 = W0();
        parcelW0.writeString(str);
        parcelW0.writeLong(j);
        Y0(24, parcelW0);
    }

    @Override // defpackage.DI2
    public final void generateEventId(NI2 ni2) {
        Parcel parcelW0 = W0();
        hH2.d(parcelW0, ni2);
        Y0(22, parcelW0);
    }

    @Override // defpackage.DI2
    public final void getAppInstanceId(NI2 ni2) {
        Parcel parcelW0 = W0();
        hH2.d(parcelW0, ni2);
        Y0(20, parcelW0);
    }

    @Override // defpackage.DI2
    public final void getCachedAppInstanceId(NI2 ni2) {
        Parcel parcelW0 = W0();
        hH2.d(parcelW0, ni2);
        Y0(19, parcelW0);
    }

    @Override // defpackage.DI2
    public final void getConditionalUserProperties(String str, String str2, NI2 ni2) {
        Parcel parcelW0 = W0();
        parcelW0.writeString(str);
        parcelW0.writeString(str2);
        hH2.d(parcelW0, ni2);
        Y0(10, parcelW0);
    }

    @Override // defpackage.DI2
    public final void getCurrentScreenClass(NI2 ni2) {
        Parcel parcelW0 = W0();
        hH2.d(parcelW0, ni2);
        Y0(17, parcelW0);
    }

    @Override // defpackage.DI2
    public final void getCurrentScreenName(NI2 ni2) {
        Parcel parcelW0 = W0();
        hH2.d(parcelW0, ni2);
        Y0(16, parcelW0);
    }

    @Override // defpackage.DI2
    public final void getGmpAppId(NI2 ni2) {
        Parcel parcelW0 = W0();
        hH2.d(parcelW0, ni2);
        Y0(21, parcelW0);
    }

    @Override // defpackage.DI2
    public final void getMaxUserProperties(String str, NI2 ni2) {
        Parcel parcelW0 = W0();
        parcelW0.writeString(str);
        hH2.d(parcelW0, ni2);
        Y0(6, parcelW0);
    }

    @Override // defpackage.DI2
    public final void getUserProperties(String str, String str2, boolean z, NI2 ni2) {
        Parcel parcelW0 = W0();
        parcelW0.writeString(str);
        parcelW0.writeString(str2);
        ClassLoader classLoader = hH2.a;
        parcelW0.writeInt(z ? 1 : 0);
        hH2.d(parcelW0, ni2);
        Y0(5, parcelW0);
    }

    @Override // defpackage.DI2
    public final void initialize(Zr0 zr0, zzcl zzclVar, long j) {
        Parcel parcelW0 = W0();
        hH2.d(parcelW0, zr0);
        hH2.c(parcelW0, zzclVar);
        parcelW0.writeLong(j);
        Y0(1, parcelW0);
    }

    @Override // defpackage.DI2
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        Parcel parcelW0 = W0();
        parcelW0.writeString(str);
        parcelW0.writeString(str2);
        hH2.c(parcelW0, bundle);
        parcelW0.writeInt(1);
        parcelW0.writeInt(1);
        parcelW0.writeLong(j);
        Y0(2, parcelW0);
    }

    @Override // defpackage.DI2
    public final void logHealthData(int i, String str, Zr0 zr0, Zr0 zr02, Zr0 zr03) {
        Parcel parcelW0 = W0();
        parcelW0.writeInt(5);
        parcelW0.writeString(str);
        hH2.d(parcelW0, zr0);
        hH2.d(parcelW0, zr02);
        hH2.d(parcelW0, zr03);
        Y0(33, parcelW0);
    }

    @Override // defpackage.DI2
    public final void onActivityCreated(Zr0 zr0, Bundle bundle, long j) {
        Parcel parcelW0 = W0();
        hH2.d(parcelW0, zr0);
        hH2.c(parcelW0, bundle);
        parcelW0.writeLong(j);
        Y0(27, parcelW0);
    }

    @Override // defpackage.DI2
    public final void onActivityDestroyed(Zr0 zr0, long j) {
        Parcel parcelW0 = W0();
        hH2.d(parcelW0, zr0);
        parcelW0.writeLong(j);
        Y0(28, parcelW0);
    }

    @Override // defpackage.DI2
    public final void onActivityPaused(Zr0 zr0, long j) {
        Parcel parcelW0 = W0();
        hH2.d(parcelW0, zr0);
        parcelW0.writeLong(j);
        Y0(29, parcelW0);
    }

    @Override // defpackage.DI2
    public final void onActivityResumed(Zr0 zr0, long j) {
        Parcel parcelW0 = W0();
        hH2.d(parcelW0, zr0);
        parcelW0.writeLong(j);
        Y0(30, parcelW0);
    }

    @Override // defpackage.DI2
    public final void onActivitySaveInstanceState(Zr0 zr0, NI2 ni2, long j) {
        Parcel parcelW0 = W0();
        hH2.d(parcelW0, zr0);
        hH2.d(parcelW0, ni2);
        parcelW0.writeLong(j);
        Y0(31, parcelW0);
    }

    @Override // defpackage.DI2
    public final void onActivityStarted(Zr0 zr0, long j) {
        Parcel parcelW0 = W0();
        hH2.d(parcelW0, zr0);
        parcelW0.writeLong(j);
        Y0(25, parcelW0);
    }

    @Override // defpackage.DI2
    public final void onActivityStopped(Zr0 zr0, long j) {
        Parcel parcelW0 = W0();
        hH2.d(parcelW0, zr0);
        parcelW0.writeLong(j);
        Y0(26, parcelW0);
    }

    @Override // defpackage.DI2
    public final void setConditionalUserProperty(Bundle bundle, long j) {
        Parcel parcelW0 = W0();
        hH2.c(parcelW0, bundle);
        parcelW0.writeLong(j);
        Y0(8, parcelW0);
    }

    @Override // defpackage.DI2
    public final void setCurrentScreen(Zr0 zr0, String str, String str2, long j) {
        Parcel parcelW0 = W0();
        hH2.d(parcelW0, zr0);
        parcelW0.writeString(str);
        parcelW0.writeString(str2);
        parcelW0.writeLong(j);
        Y0(15, parcelW0);
    }

    @Override // defpackage.DI2
    public final void setDataCollectionEnabled(boolean z) {
        throw null;
    }

    @Override // defpackage.DI2
    public final void setUserProperty(String str, String str2, Zr0 zr0, boolean z, long j) {
        Parcel parcelW0 = W0();
        parcelW0.writeString("fcm");
        parcelW0.writeString("_ln");
        hH2.d(parcelW0, zr0);
        parcelW0.writeInt(1);
        parcelW0.writeLong(j);
        Y0(4, parcelW0);
    }
}
