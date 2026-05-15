package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzaw;
import com.google.android.gms.measurement.internal.zzlo;
import com.google.android.gms.measurement.internal.zzq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: iO2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0837iO2 extends YG2 implements InterfaceC1086mO2 {
    public C0837iO2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // defpackage.InterfaceC1086mO2
    public final byte[] G(zzaw zzawVar, String str) {
        Parcel parcelW0 = W0();
        hH2.c(parcelW0, zzawVar);
        parcelW0.writeString(str);
        Parcel parcelX0 = X0(9, parcelW0);
        byte[] bArrCreateByteArray = parcelX0.createByteArray();
        parcelX0.recycle();
        return bArrCreateByteArray;
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void G0(zzlo zzloVar, zzq zzqVar) {
        Parcel parcelW0 = W0();
        hH2.c(parcelW0, zzloVar);
        hH2.c(parcelW0, zzqVar);
        Y0(2, parcelW0);
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void J(zzq zzqVar) {
        Parcel parcelW0 = W0();
        hH2.c(parcelW0, zzqVar);
        Y0(20, parcelW0);
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void K0(zzaw zzawVar, zzq zzqVar) {
        Parcel parcelW0 = W0();
        hH2.c(parcelW0, zzawVar);
        hH2.c(parcelW0, zzqVar);
        Y0(1, parcelW0);
    }

    @Override // defpackage.InterfaceC1086mO2
    public final List Q(String str, String str2, boolean z, zzq zzqVar) {
        Parcel parcelW0 = W0();
        parcelW0.writeString(str);
        parcelW0.writeString(str2);
        ClassLoader classLoader = hH2.a;
        parcelW0.writeInt(z ? 1 : 0);
        hH2.c(parcelW0, zzqVar);
        Parcel parcelX0 = X0(14, parcelW0);
        ArrayList arrayListCreateTypedArrayList = parcelX0.createTypedArrayList(zzlo.CREATOR);
        parcelX0.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void R0(zzq zzqVar) {
        Parcel parcelW0 = W0();
        hH2.c(parcelW0, zzqVar);
        Y0(4, parcelW0);
    }

    @Override // defpackage.InterfaceC1086mO2
    public final String S(zzq zzqVar) {
        Parcel parcelW0 = W0();
        hH2.c(parcelW0, zzqVar);
        Parcel parcelX0 = X0(11, parcelW0);
        String string = parcelX0.readString();
        parcelX0.recycle();
        return string;
    }

    @Override // defpackage.InterfaceC1086mO2
    public final List T0(String str, String str2, zzq zzqVar) {
        Parcel parcelW0 = W0();
        parcelW0.writeString(str);
        parcelW0.writeString(str2);
        hH2.c(parcelW0, zzqVar);
        Parcel parcelX0 = X0(16, parcelW0);
        ArrayList arrayListCreateTypedArrayList = parcelX0.createTypedArrayList(zzac.CREATOR);
        parcelX0.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // defpackage.InterfaceC1086mO2
    public final List d0(String str, String str2, String str3) {
        Parcel parcelW0 = W0();
        parcelW0.writeString(null);
        parcelW0.writeString(str2);
        parcelW0.writeString(str3);
        Parcel parcelX0 = X0(17, parcelW0);
        ArrayList arrayListCreateTypedArrayList = parcelX0.createTypedArrayList(zzac.CREATOR);
        parcelX0.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void g0(zzq zzqVar) {
        Parcel parcelW0 = W0();
        hH2.c(parcelW0, zzqVar);
        Y0(18, parcelW0);
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void j(long j, String str, String str2, String str3) {
        Parcel parcelW0 = W0();
        parcelW0.writeLong(j);
        parcelW0.writeString(str);
        parcelW0.writeString(str2);
        parcelW0.writeString(str3);
        Y0(10, parcelW0);
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void o(zzq zzqVar) {
        Parcel parcelW0 = W0();
        hH2.c(parcelW0, zzqVar);
        Y0(6, parcelW0);
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void o0(zzac zzacVar, zzq zzqVar) {
        Parcel parcelW0 = W0();
        hH2.c(parcelW0, zzacVar);
        hH2.c(parcelW0, zzqVar);
        Y0(12, parcelW0);
    }

    @Override // defpackage.InterfaceC1086mO2
    public final void x(Bundle bundle, zzq zzqVar) {
        Parcel parcelW0 = W0();
        hH2.c(parcelW0, bundle);
        hH2.c(parcelW0, zzqVar);
        Y0(19, parcelW0);
    }

    @Override // defpackage.InterfaceC1086mO2
    public final List z(String str, String str2, String str3, boolean z) {
        Parcel parcelW0 = W0();
        parcelW0.writeString(null);
        parcelW0.writeString(str2);
        parcelW0.writeString(str3);
        ClassLoader classLoader = hH2.a;
        parcelW0.writeInt(z ? 1 : 0);
        Parcel parcelX0 = X0(15, parcelW0);
        ArrayList arrayListCreateTypedArrayList = parcelX0.createTypedArrayList(zzlo.CREATOR);
        parcelX0.recycle();
        return arrayListCreateTypedArrayList;
    }
}
