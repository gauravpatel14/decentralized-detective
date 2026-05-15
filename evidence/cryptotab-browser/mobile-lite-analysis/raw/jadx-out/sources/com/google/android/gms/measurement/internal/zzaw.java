package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.C0763hF2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "EventParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzaw extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new C0763hF2();
    public final String t;
    public final zzau u;
    public final String v;
    public final long w;

    public zzaw(zzaw zzawVar, long j) {
        Preconditions.checkNotNull(zzawVar);
        this.t = zzawVar.t;
        this.u = zzawVar.u;
        this.v = zzawVar.v;
        this.w = j;
    }

    public final String toString() {
        return "origin=" + this.v + ",name=" + this.t + ",params=" + String.valueOf(this.u);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        C0763hF2.a(this, parcel, i);
    }

    public zzaw(String str, zzau zzauVar, String str2, long j) {
        this.t = str;
        this.u = zzauVar;
        this.v = str2;
        this.w = j;
    }
}
