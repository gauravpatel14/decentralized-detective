package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.C0770hN2;
import defpackage.C0936k13;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "NotificationOptionsCreator")
@SafeParcelable.Reserved({1})
public class NotificationOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final int f23J;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public final int O;
    public final int P;
    public final int Q;
    public final int R;
    public final int S;
    public final int T;
    public final int U;
    public final int V;
    public final int W;
    public final int X;
    public final C0770hN2 Y;
    public final ArrayList t;
    public final int[] u;
    public final long v;
    public final String w;
    public final int x;
    public final int y;
    public final int z;

    static {
        Arrays.asList("com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK", "com.google.android.gms.cast.framework.action.STOP_CASTING");
        CREATOR = new C0936k13();
    }

    public NotificationOptions(List list, int[] iArr, long j, String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, IBinder iBinder) {
        C0770hN2 c0770hN2 = null;
        if (list != null) {
            this.t = new ArrayList(list);
        } else {
            this.t = null;
        }
        if (iArr != null) {
            this.u = Arrays.copyOf(iArr, iArr.length);
        } else {
            this.u = null;
        }
        this.v = j;
        this.w = str;
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.A = i4;
        this.B = i5;
        this.C = i6;
        this.D = i7;
        this.E = i8;
        this.F = i9;
        this.G = i10;
        this.H = i11;
        this.I = i12;
        this.f23J = i13;
        this.K = i14;
        this.L = i15;
        this.M = i16;
        this.N = i17;
        this.O = i18;
        this.P = i19;
        this.Q = i20;
        this.R = i21;
        this.S = i22;
        this.T = i23;
        this.U = i24;
        this.V = i25;
        this.W = i26;
        this.X = i27;
        if (iBinder != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.INotificationActionsProvider");
            c0770hN2 = iInterfaceQueryLocalInterface instanceof C0770hN2 ? (C0770hN2) iInterfaceQueryLocalInterface : new C0770hN2(iBinder, "com.google.android.gms.cast.framework.media.INotificationActionsProvider");
        }
        this.Y = c0770hN2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringList(parcel, 2, this.t, false);
        int[] iArr = this.u;
        SafeParcelWriter.writeIntArray(parcel, 3, Arrays.copyOf(iArr, iArr.length), false);
        SafeParcelWriter.writeLong(parcel, 4, this.v);
        SafeParcelWriter.writeString(parcel, 5, this.w, false);
        SafeParcelWriter.writeInt(parcel, 6, this.x);
        SafeParcelWriter.writeInt(parcel, 7, this.y);
        SafeParcelWriter.writeInt(parcel, 8, this.z);
        SafeParcelWriter.writeInt(parcel, 9, this.A);
        SafeParcelWriter.writeInt(parcel, 10, this.B);
        SafeParcelWriter.writeInt(parcel, 11, this.C);
        SafeParcelWriter.writeInt(parcel, 12, this.D);
        SafeParcelWriter.writeInt(parcel, 13, this.E);
        SafeParcelWriter.writeInt(parcel, 14, this.F);
        SafeParcelWriter.writeInt(parcel, 15, this.G);
        SafeParcelWriter.writeInt(parcel, 16, this.H);
        SafeParcelWriter.writeInt(parcel, 17, this.I);
        SafeParcelWriter.writeInt(parcel, 18, this.f23J);
        SafeParcelWriter.writeInt(parcel, 19, this.K);
        SafeParcelWriter.writeInt(parcel, 20, this.L);
        SafeParcelWriter.writeInt(parcel, 21, this.M);
        SafeParcelWriter.writeInt(parcel, 22, this.N);
        SafeParcelWriter.writeInt(parcel, 23, this.O);
        SafeParcelWriter.writeInt(parcel, 24, this.P);
        SafeParcelWriter.writeInt(parcel, 25, this.Q);
        SafeParcelWriter.writeInt(parcel, 26, this.R);
        SafeParcelWriter.writeInt(parcel, 27, this.S);
        SafeParcelWriter.writeInt(parcel, 28, this.T);
        SafeParcelWriter.writeInt(parcel, 29, this.U);
        SafeParcelWriter.writeInt(parcel, 30, this.V);
        SafeParcelWriter.writeInt(parcel, 31, this.W);
        SafeParcelWriter.writeInt(parcel, 32, this.X);
        C0770hN2 c0770hN2 = this.Y;
        SafeParcelWriter.writeIBinder(parcel, 33, c0770hN2 == null ? null : c0770hN2.t, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
