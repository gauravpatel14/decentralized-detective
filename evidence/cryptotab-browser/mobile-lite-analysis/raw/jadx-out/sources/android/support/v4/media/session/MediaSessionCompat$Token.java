package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.BP0;
import defpackage.InterfaceC1694wn2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class MediaSessionCompat$Token implements Parcelable {
    public static final Parcelable.Creator CREATOR = new BP0(1);
    public final Object u;
    public a v;
    public final Object t = new Object();
    public InterfaceC1694wn2 w = null;

    public MediaSessionCompat$Token(Object obj, c cVar) {
        this.u = obj;
        this.v = cVar;
    }

    public final a a() {
        a aVar;
        synchronized (this.t) {
            aVar = this.v;
        }
        return aVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionCompat$Token)) {
            return false;
        }
        MediaSessionCompat$Token mediaSessionCompat$Token = (MediaSessionCompat$Token) obj;
        Object obj2 = this.u;
        if (obj2 == null) {
            return mediaSessionCompat$Token.u == null;
        }
        Object obj3 = mediaSessionCompat$Token.u;
        if (obj3 == null) {
            return false;
        }
        return obj2.equals(obj3);
    }

    public final int hashCode() {
        Object obj = this.u;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable((Parcelable) this.u, i);
    }
}
