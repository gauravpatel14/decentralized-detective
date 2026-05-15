package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.C0362aY2;
import defpackage.YX2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "UserAttributeParcelCreator")
public final class zzlo extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new YX2();
    public final int t;
    public final String u;
    public final long v;
    public final Long w;
    public final String x;
    public final String y;
    public final Double z;

    public zzlo(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        this.t = i;
        this.u = str;
        this.v = j;
        this.w = l;
        if (i == 1) {
            this.z = f != null ? Double.valueOf(f.doubleValue()) : null;
        } else {
            this.z = d;
        }
        this.x = str2;
        this.y = str3;
    }

    public final Object f2() {
        Long l = this.w;
        if (l != null) {
            return l;
        }
        Double d = this.z;
        if (d != null) {
            return d;
        }
        String str = this.x;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        YX2.a(this, parcel);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zzlo(C0362aY2 c0362aY2) {
        String str = c0362aY2.c;
        this(c0362aY2.d, c0362aY2.e, str, c0362aY2.b);
    }

    public zzlo(long j, Object obj, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        this.t = 2;
        this.u = str;
        this.v = j;
        this.y = str2;
        if (obj == null) {
            this.w = null;
            this.z = null;
            this.x = null;
            return;
        }
        if (obj instanceof Long) {
            this.w = (Long) obj;
            this.z = null;
            this.x = null;
        } else if (obj instanceof String) {
            this.w = null;
            this.z = null;
            this.x = (String) obj;
        } else {
            if (obj instanceof Double) {
                this.w = null;
                this.z = (Double) obj;
                this.x = null;
                return;
            }
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }
}
