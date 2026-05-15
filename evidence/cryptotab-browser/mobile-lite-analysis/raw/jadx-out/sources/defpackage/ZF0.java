package defpackage;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import org.chromium.base.library_loader.Linker$LibInfo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ZF0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Linker$LibInfo linker$LibInfo = new Linker$LibInfo();
        linker$LibInfo.mRelroFd = -1;
        linker$LibInfo.t = parcel.readString();
        linker$LibInfo.mLoadAddress = parcel.readLong();
        linker$LibInfo.mLoadSize = parcel.readLong();
        linker$LibInfo.mRelroStart = parcel.readLong();
        linker$LibInfo.mRelroSize = parcel.readLong();
        if (parcel.readInt() != 0) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            if (parcelFileDescriptor != null) {
                linker$LibInfo.mRelroFd = parcelFileDescriptor.detachFd();
            }
        } else {
            linker$LibInfo.mRelroFd = -1;
        }
        return linker$LibInfo;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new Linker$LibInfo[i];
    }
}
