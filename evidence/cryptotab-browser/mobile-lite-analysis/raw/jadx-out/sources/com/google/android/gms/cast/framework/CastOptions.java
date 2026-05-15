package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.MF2;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "CastOptionsCreator")
@SafeParcelable.Reserved({1})
public class CastOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new MF2();
    public final boolean A;
    public String t;
    public final ArrayList u;
    public final boolean v;
    public final LaunchOptions w;
    public final boolean x;
    public final boolean y;
    public final double z;

    public CastOptions(String str, ArrayList arrayList, boolean z, LaunchOptions launchOptions, boolean z2, CastMediaOptions castMediaOptions, boolean z3, double d, boolean z4) {
        this.t = TextUtils.isEmpty(str) ? "" : str;
        int size = arrayList == null ? 0 : arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        this.u = arrayList2;
        if (size > 0) {
            arrayList2.addAll(arrayList);
        }
        this.v = z;
        this.w = launchOptions == null ? new LaunchOptions() : launchOptions;
        this.x = z2;
        this.y = z3;
        this.z = d;
        this.A = z4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.t, false);
        SafeParcelWriter.writeStringList(parcel, 3, Collections.unmodifiableList(this.u), false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.v);
        SafeParcelWriter.writeParcelable(parcel, 5, this.w, i, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.x);
        SafeParcelWriter.writeParcelable(parcel, 7, null, i, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.y);
        SafeParcelWriter.writeDouble(parcel, 9, this.z);
        SafeParcelWriter.writeBoolean(parcel, 10, this.A);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
