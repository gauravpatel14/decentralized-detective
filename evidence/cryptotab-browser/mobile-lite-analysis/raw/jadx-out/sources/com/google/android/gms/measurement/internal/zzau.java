package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.QE2;
import defpackage.ZE2;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "EventParamsCreator")
@SafeParcelable.Reserved({1})
public final class zzau extends AbstractSafeParcelable implements Iterable {
    public static final Parcelable.Creator CREATOR = new ZE2();
    public final Bundle t;

    public zzau(Bundle bundle) {
        this.t = bundle;
    }

    public final Bundle f2() {
        return new Bundle(this.t);
    }

    public final Double g2() {
        return Double.valueOf(this.t.getDouble("value"));
    }

    public final Object h2(String str) {
        return this.t.get(str);
    }

    public final String i2() {
        return this.t.getString("currency");
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new QE2(this);
    }

    public final String toString() {
        return this.t.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, f2(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
