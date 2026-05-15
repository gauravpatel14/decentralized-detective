package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.C1810yy0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C1810yy0();
    public final IntentSender t;
    public final Intent u;
    public final int v;
    public final int w;

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i, int i2) {
        this.t = intentSender;
        this.u = intent;
        this.v = i;
        this.w = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.t, i);
        parcel.writeParcelable(this.u, i);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
    }
}
