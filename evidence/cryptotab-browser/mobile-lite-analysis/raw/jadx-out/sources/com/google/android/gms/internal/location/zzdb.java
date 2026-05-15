package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.C0523dL2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "LocationReceiverCreator")
public final class zzdb extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new C0523dL2();
    public final int t;
    public final IBinder u;
    public final IBinder v;
    public final PendingIntent w;
    public final String x;
    public final String y;

    public zzdb(int i, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, String str, String str2) {
        this.t = i;
        this.u = iBinder;
        this.v = iBinder2;
        this.w = pendingIntent;
        this.x = Build.VERSION.SDK_INT >= 30 ? null : str;
        this.y = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.t);
        SafeParcelWriter.writeIBinder(parcel, 2, this.u, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.v, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.w, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.x, false);
        SafeParcelWriter.writeString(parcel, 6, this.y, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
