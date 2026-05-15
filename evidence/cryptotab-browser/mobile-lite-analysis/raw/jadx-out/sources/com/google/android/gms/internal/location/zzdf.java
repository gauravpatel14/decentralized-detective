package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.B03;
import defpackage.BinderC0461cK2;
import defpackage.BinderC1496tK2;
import defpackage.C0647fU2;
import defpackage.C13;
import defpackage.C1498tL2;
import defpackage.InterfaceC0534dW2;
import defpackage.J23;
import defpackage.W13;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "LocationRequestUpdateDataCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
public final class zzdf extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new C1498tL2();
    public final int t;
    public final zzdd u;
    public final J23 v;
    public final C13 w;
    public final PendingIntent x;
    public final InterfaceC0534dW2 y;
    public final String z;

    public zzdf(int i, zzdd zzddVar, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, IBinder iBinder3, String str) {
        J23 w13;
        C13 b03;
        this.t = i;
        this.u = zzddVar;
        InterfaceC0534dW2 c0647fU2 = null;
        if (iBinder != null) {
            int i2 = BinderC1496tK2.u;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
            w13 = iInterfaceQueryLocalInterface instanceof J23 ? (J23) iInterfaceQueryLocalInterface : new W13(iBinder, "com.google.android.gms.location.ILocationListener");
        } else {
            w13 = null;
        }
        this.v = w13;
        this.x = pendingIntent;
        if (iBinder2 != null) {
            int i3 = BinderC0461cK2.u;
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
            b03 = iInterfaceQueryLocalInterface2 instanceof C13 ? (C13) iInterfaceQueryLocalInterface2 : new B03(iBinder2, "com.google.android.gms.location.ILocationCallback");
        } else {
            b03 = null;
        }
        this.w = b03;
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            c0647fU2 = iInterfaceQueryLocalInterface3 instanceof InterfaceC0534dW2 ? (InterfaceC0534dW2) iInterfaceQueryLocalInterface3 : new C0647fU2(iBinder3, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
        }
        this.y = c0647fU2;
        this.z = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.t);
        SafeParcelWriter.writeParcelable(parcel, 2, this.u, i, false);
        J23 j23 = this.v;
        SafeParcelWriter.writeIBinder(parcel, 3, j23 == null ? null : j23.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.x, i, false);
        C13 c13 = this.w;
        SafeParcelWriter.writeIBinder(parcel, 5, c13 == null ? null : c13.asBinder(), false);
        InterfaceC0534dW2 interfaceC0534dW2 = this.y;
        SafeParcelWriter.writeIBinder(parcel, 6, interfaceC0534dW2 != null ? interfaceC0534dW2.asBinder() : null, false);
        SafeParcelWriter.writeString(parcel, 8, this.z, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
