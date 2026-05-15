package com.google.android.gms.internal.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.location.LocationRequest;
import defpackage.lL2;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "LocationRequestInternalCreator")
@SafeParcelable.Reserved({2, 3, 4, 5, 6, 7, 8, ConnectionResult.SERVICE_INVALID, 10, ConnectionResult.LICENSE_CHECK_FAILED, 12, 13, 14, 1000})
@Deprecated
public final class zzdd extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new lL2();
    public final LocationRequest t;

    public zzdd(LocationRequest locationRequest, ArrayList arrayList, boolean z, boolean z2, String str, boolean z3, boolean z4, String str2, long j) {
        boolean z5;
        long j2;
        WorkSource workSource;
        int i;
        int i2;
        int i3 = locationRequest.t;
        long j3 = locationRequest.u;
        long jMin = locationRequest.v;
        long j4 = locationRequest.w;
        long j5 = locationRequest.x;
        int i4 = locationRequest.y;
        float f = locationRequest.z;
        boolean z6 = locationRequest.A;
        long j6 = locationRequest.B;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                workSource = null;
            } else {
                workSource = new WorkSource();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    boolean z7 = z6;
                    ClientIdentity clientIdentity = (ClientIdentity) it.next();
                    WorkSourceUtil.add(workSource, clientIdentity.uid, clientIdentity.packageName);
                    z6 = z7;
                    j6 = j6;
                }
            }
            z5 = z6;
            j2 = j6;
        } else {
            z5 = z6;
            j2 = j6;
            workSource = locationRequest.G;
        }
        if (z) {
            Preconditions.checkArgument(true, "granularity %d must be a Granularity.GRANULARITY_* constant", 1);
            i = 1;
        } else {
            i = locationRequest.C;
        }
        if (z2) {
            Preconditions.checkArgument(true, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", 2);
            i2 = 2;
        } else {
            i2 = locationRequest.D;
        }
        String str3 = locationRequest.E;
        if (str != null) {
            if (Build.VERSION.SDK_INT < 30) {
                str3 = str;
            }
        } else if (str2 != null && Build.VERSION.SDK_INT < 30) {
            str3 = str2;
        }
        String str4 = str3;
        boolean z8 = z3 ? true : locationRequest.F;
        z5 = z4 ? true : z5;
        if (j != Long.MAX_VALUE) {
            Preconditions.checkArgument(j == -1 || j >= 0, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            j2 = j;
        }
        if (jMin == -1) {
            jMin = j3;
        } else if (i3 != 105) {
            jMin = Math.min(jMin, j3);
        }
        this.t = new LocationRequest(i3, j3, jMin, Math.max(j4, j3), Long.MAX_VALUE, j5, i4, f, z5, j2 == -1 ? j3 : j2, i, i2, str4, z8, new WorkSource(workSource), locationRequest.H);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzdd) {
            return Objects.equal(this.t, ((zzdd) obj).t);
        }
        return false;
    }

    public final int hashCode() {
        return this.t.hashCode();
    }

    public final String toString() {
        return this.t.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.t, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
