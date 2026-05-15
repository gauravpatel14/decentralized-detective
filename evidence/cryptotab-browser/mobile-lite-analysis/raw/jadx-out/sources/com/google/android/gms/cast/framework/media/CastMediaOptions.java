package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.JK2;
import defpackage.RB2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "CastMediaOptionsCreator")
@SafeParcelable.Reserved({1})
public class CastMediaOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public final String t;
    public final String u;
    public final JK2 v;
    public final NotificationOptions w;
    public final boolean x;

    static {
        Preconditions.checkNotEmpty("CastMediaOptions", "The log tag cannot be null or empty.");
        CREATOR = new RB2();
    }

    public CastMediaOptions(String str, String str2, IBinder iBinder, NotificationOptions notificationOptions, boolean z) {
        JK2 jk2;
        this.t = str;
        this.u = str2;
        if (iBinder == null) {
            jk2 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.IImagePicker");
            jk2 = iInterfaceQueryLocalInterface instanceof JK2 ? (JK2) iInterfaceQueryLocalInterface : new JK2(iBinder, "com.google.android.gms.cast.framework.media.IImagePicker");
        }
        this.v = jk2;
        this.w = notificationOptions;
        this.x = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.t, false);
        SafeParcelWriter.writeString(parcel, 3, this.u, false);
        JK2 jk2 = this.v;
        SafeParcelWriter.writeIBinder(parcel, 4, jk2 == null ? null : jk2.t, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.w, i, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.x);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
