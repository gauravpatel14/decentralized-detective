package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zzd;
import defpackage.DL2;
import defpackage.SC2;
import defpackage.y33;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "LocationRequestCreator")
@SafeParcelable.Reserved({4, 5, 1000})
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new y33();
    public final boolean A;
    public long B;
    public final int C;
    public final int D;
    public final String E;
    public final boolean F;
    public final WorkSource G;
    public final zzd H;
    public int t;
    public long u;
    public long v;
    public final long w;
    public final long x;
    public final int y;
    public final float z;

    public LocationRequest(int i, long j, long j2, long j3, long j4, long j5, int i2, float f, boolean z, long j6, int i3, int i4, String str, boolean z2, WorkSource workSource, zzd zzdVar) {
        this.t = i;
        long j7 = j;
        this.u = j7;
        this.v = j2;
        this.w = j3;
        this.x = j4 == Long.MAX_VALUE ? j5 : Math.min(Math.max(1L, j4 - SystemClock.elapsedRealtime()), j5);
        this.y = i2;
        this.z = f;
        this.A = z;
        this.B = j6 != -1 ? j6 : j7;
        this.C = i3;
        this.D = i4;
        this.E = str;
        this.F = z2;
        this.G = workSource;
        this.H = zzdVar;
    }

    public static String h2(long j) {
        String string;
        if (j == Long.MAX_VALUE) {
            return "∞";
        }
        StringBuilder sb = DL2.a;
        synchronized (sb) {
            sb.setLength(0);
            DL2.a(j, sb);
            string = sb.toString();
        }
        return string;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            int i = this.t;
            if (i == locationRequest.t && ((i == 105 || this.u == locationRequest.u) && this.v == locationRequest.v && f2() == locationRequest.f2() && ((!f2() || this.w == locationRequest.w) && this.x == locationRequest.x && this.y == locationRequest.y && this.z == locationRequest.z && this.A == locationRequest.A && this.C == locationRequest.C && this.D == locationRequest.D && this.F == locationRequest.F && this.G.equals(locationRequest.G) && Objects.equal(this.E, locationRequest.E) && Objects.equal(this.H, locationRequest.H)))) {
                return true;
            }
        }
        return false;
    }

    public final boolean f2() {
        long j = this.w;
        return j > 0 && (j >> 1) >= this.u;
    }

    public final void g2(long j) {
        Preconditions.checkArgument(j >= 0, "intervalMillis must be greater than or equal to 0");
        long j2 = this.v;
        long j3 = this.u;
        if (j2 == j3 / 6) {
            this.v = j / 6;
        }
        if (this.B == j3) {
            this.B = j;
        }
        this.u = j;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.t), Long.valueOf(this.u), Long.valueOf(this.v), this.G);
    }

    public final String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        int i = this.t;
        if (i == 105) {
            sb.append(SC2.b(i));
        } else {
            sb.append("@");
            if (f2()) {
                DL2.a(this.u, sb);
                sb.append("/");
                DL2.a(this.w, sb);
            } else {
                DL2.a(this.u, sb);
            }
            sb.append(" ");
            sb.append(SC2.b(this.t));
        }
        if (this.t == 105 || this.v != this.u) {
            sb.append(", minUpdateInterval=");
            sb.append(h2(this.v));
        }
        float f = this.z;
        if (f > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(f);
        }
        if (!(this.t == 105) ? this.B != this.u : this.B != Long.MAX_VALUE) {
            sb.append(", maxUpdateAge=");
            sb.append(h2(this.B));
        }
        long j = this.x;
        if (j != Long.MAX_VALUE) {
            sb.append(", duration=");
            DL2.a(j, sb);
        }
        int i2 = this.y;
        if (i2 != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(i2);
        }
        int i3 = this.D;
        if (i3 != 0) {
            sb.append(", ");
            if (i3 == 0) {
                str2 = "THROTTLE_BACKGROUND";
            } else if (i3 == 1) {
                str2 = "THROTTLE_ALWAYS";
            } else {
                if (i3 != 2) {
                    throw new IllegalArgumentException();
                }
                str2 = "THROTTLE_NEVER";
            }
            sb.append(str2);
        }
        int i4 = this.C;
        if (i4 != 0) {
            sb.append(", ");
            if (i4 == 0) {
                str = "GRANULARITY_PERMISSION_LEVEL";
            } else if (i4 == 1) {
                str = "GRANULARITY_COARSE";
            } else {
                if (i4 != 2) {
                    throw new IllegalArgumentException();
                }
                str = "GRANULARITY_FINE";
            }
            sb.append(str);
        }
        if (this.A) {
            sb.append(", waitForAccurateLocation");
        }
        if (this.F) {
            sb.append(", bypass");
        }
        String str3 = this.E;
        if (str3 != null) {
            sb.append(", moduleId=");
            sb.append(str3);
        }
        WorkSource workSource = this.G;
        if (!WorkSourceUtil.isEmpty(workSource)) {
            sb.append(", ");
            sb.append(workSource);
        }
        zzd zzdVar = this.H;
        if (zzdVar != null) {
            sb.append(", impersonation=");
            sb.append(zzdVar);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.t);
        SafeParcelWriter.writeLong(parcel, 2, this.u);
        SafeParcelWriter.writeLong(parcel, 3, this.v);
        SafeParcelWriter.writeInt(parcel, 6, this.y);
        SafeParcelWriter.writeFloat(parcel, 7, this.z);
        SafeParcelWriter.writeLong(parcel, 8, this.w);
        SafeParcelWriter.writeBoolean(parcel, 9, this.A);
        SafeParcelWriter.writeLong(parcel, 10, this.x);
        SafeParcelWriter.writeLong(parcel, 11, this.B);
        SafeParcelWriter.writeInt(parcel, 12, this.C);
        SafeParcelWriter.writeInt(parcel, 13, this.D);
        SafeParcelWriter.writeString(parcel, 14, this.E, false);
        SafeParcelWriter.writeBoolean(parcel, 15, this.F);
        SafeParcelWriter.writeParcelable(parcel, 16, this.G, i, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.H, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
