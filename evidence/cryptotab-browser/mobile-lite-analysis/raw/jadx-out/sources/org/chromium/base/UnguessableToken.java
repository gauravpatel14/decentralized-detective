package org.chromium.base;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.Vj2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class UnguessableToken extends TokenBase implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Vj2();

    public UnguessableToken(long j, long j2) {
        super(j, j2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final UnguessableToken parcelAndUnparcelForTesting() {
        Parcel parcelObtain = Parcel.obtain();
        writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        UnguessableToken unguessableToken = (UnguessableToken) CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return unguessableToken;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.t);
        parcel.writeLong(this.u);
    }
}
