package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.Mq2;
import defpackage.iI1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "ShortDynamicLinkImplCreator")
public final class ShortDynamicLinkImpl extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new iI1();
    public final Uri t;
    public final Uri u;
    public final List v;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @SafeParcelable.Class(creator = "WarningImplCreator")
    public class WarningImpl extends AbstractSafeParcelable {
        public static final Parcelable.Creator CREATOR = new Mq2();
        public final String t;

        public WarningImpl(String str) {
            this.t = str;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, this.t, false);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    public ShortDynamicLinkImpl(Uri uri, Uri uri2, ArrayList arrayList) {
        this.t = uri;
        this.u = uri2;
        this.v = arrayList == null ? new ArrayList() : arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.t, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.u, i, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.v, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
