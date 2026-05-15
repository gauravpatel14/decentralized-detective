package org.chromium.base.library_loader;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import defpackage.ZF0;
import java.io.IOException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class Linker$LibInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new ZF0();
    public long mLoadAddress;
    public long mLoadSize;
    public int mRelroFd;
    public long mRelroSize;
    public long mRelroStart;
    public String t;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.t);
        parcel.writeLong(this.mLoadAddress);
        parcel.writeLong(this.mLoadSize);
        parcel.writeLong(this.mRelroStart);
        parcel.writeLong(this.mRelroSize);
        parcel.writeInt(this.mRelroFd >= 0 ? 1 : 0);
        int i2 = this.mRelroFd;
        if (i2 >= 0) {
            try {
                ParcelFileDescriptor parcelFileDescriptorFromFd = ParcelFileDescriptor.fromFd(i2);
                parcelFileDescriptorFromFd.writeToParcel(parcel, 0);
                parcelFileDescriptorFromFd.close();
            } catch (IOException e) {
                Log.e("cr_Linker", "Can't write LibInfo file descriptor to parcel", e);
            }
        }
    }
}
