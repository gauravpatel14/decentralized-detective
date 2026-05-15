package org.chromium.base.process_launcher;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import defpackage.Td0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FileDescriptorInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Td0();
    public final int t;
    public final ParcelFileDescriptor u;
    public final long v;
    public final long w;

    public FileDescriptorInfo(int i, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) {
        this.t = i;
        this.u = parcelFileDescriptor;
        this.v = j;
        this.w = j2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.t);
        parcel.writeParcelable(this.u, 1);
        parcel.writeLong(this.v);
        parcel.writeLong(this.w);
    }

    public FileDescriptorInfo(Parcel parcel) {
        this.t = parcel.readInt();
        this.u = (ParcelFileDescriptor) parcel.readParcelable(ParcelFileDescriptor.class.getClassLoader());
        this.v = parcel.readLong();
        this.w = parcel.readLong();
    }
}
