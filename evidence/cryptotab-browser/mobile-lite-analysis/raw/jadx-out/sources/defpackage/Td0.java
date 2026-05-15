package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import org.chromium.base.process_launcher.FileDescriptorInfo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Td0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new FileDescriptorInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new FileDescriptorInfo[i];
    }
}
