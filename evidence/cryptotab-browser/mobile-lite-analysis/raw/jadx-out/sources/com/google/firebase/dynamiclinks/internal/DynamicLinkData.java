package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.X40;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "DynamicLinkDataCreator")
public class DynamicLinkData extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new X40();
    public String t;
    public String u;
    public int v;
    public long w;
    public Bundle x;
    public Uri y;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.t, false);
        SafeParcelWriter.writeString(parcel, 2, this.u, false);
        SafeParcelWriter.writeInt(parcel, 3, this.v);
        SafeParcelWriter.writeLong(parcel, 4, this.w);
        Bundle bundle = this.x;
        if (bundle == null) {
            bundle = new Bundle();
        }
        SafeParcelWriter.writeBundle(parcel, 5, bundle, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.y, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
