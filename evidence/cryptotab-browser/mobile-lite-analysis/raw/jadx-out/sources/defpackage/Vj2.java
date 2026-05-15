package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import org.chromium.base.UnguessableToken;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Vj2 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        long j = parcel.readLong();
        long j2 = parcel.readLong();
        if (j == 0 || j2 == 0) {
            return null;
        }
        return new UnguessableToken(j, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new UnguessableToken[i];
    }
}
