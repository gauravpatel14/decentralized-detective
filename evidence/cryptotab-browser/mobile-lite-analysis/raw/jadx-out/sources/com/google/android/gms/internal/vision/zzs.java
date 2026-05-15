package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.Y23;
import defpackage.Zi0;
import defpackage.aj0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "FrameMetadataParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new Y23();
    public int t;
    public int u;
    public int v;
    public long w;
    public int x;

    public static zzs f2(aj0 aj0Var) {
        zzs zzsVar = new zzs();
        Zi0 zi0 = aj0Var.a;
        zzsVar.t = zi0.a;
        zzsVar.u = zi0.b;
        zzsVar.x = zi0.e;
        zzsVar.v = zi0.c;
        zzsVar.w = zi0.d;
        return zzsVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.t);
        SafeParcelWriter.writeInt(parcel, 3, this.u);
        SafeParcelWriter.writeInt(parcel, 4, this.v);
        SafeParcelWriter.writeLong(parcel, 5, this.w);
        SafeParcelWriter.writeInt(parcel, 6, this.x);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
