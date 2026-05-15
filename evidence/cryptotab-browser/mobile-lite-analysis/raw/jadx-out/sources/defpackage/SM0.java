package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SM0 extends Binder implements Or0 {
    public final WeakReference t;

    public SM0(GO0 go0) {
        attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        this.t = new WeakReference(go0);
    }

    @Override // defpackage.Or0
    public final void N0(PlaybackStateCompat playbackStateCompat) {
        GO0 go0 = (GO0) this.t.get();
        if (go0 != null) {
            go0.d(2, playbackStateCompat, null);
        }
    }

    @Override // defpackage.Or0
    public final void U0(ParcelableVolumeInfo parcelableVolumeInfo) {
        throw new AssertionError();
    }

    @Override // defpackage.Or0
    public final void V(Bundle bundle) {
        throw new AssertionError();
    }

    @Override // defpackage.Or0
    public final void a0(ArrayList arrayList) {
        throw new AssertionError();
    }

    @Override // defpackage.Or0
    public final void g(CharSequence charSequence) {
        throw new AssertionError();
    }

    @Override // defpackage.Or0
    public final void m() {
        throw new AssertionError();
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        }
        if (i == 1598968902) {
            parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        }
        WeakReference weakReference = this.t;
        switch (i) {
            case 1:
                String string = parcel.readString();
                Bundle bundle = (Bundle) Nr0.a(parcel, Bundle.CREATOR);
                GO0 go0 = (GO0) weakReference.get();
                if (go0 != null) {
                    go0.d(1, string, bundle);
                }
                return true;
            case 2:
                m();
                return true;
            case 3:
                N0((PlaybackStateCompat) Nr0.a(parcel, PlaybackStateCompat.CREATOR));
                return true;
            case 4:
                p((MediaMetadataCompat) Nr0.a(parcel, MediaMetadataCompat.CREATOR));
                return true;
            case 5:
                a0(parcel.createTypedArrayList(MediaSessionCompat$QueueItem.CREATOR));
                return true;
            case 6:
                g((CharSequence) Nr0.a(parcel, TextUtils.CHAR_SEQUENCE_CREATOR));
                return true;
            case 7:
                V((Bundle) Nr0.a(parcel, Bundle.CREATOR));
                return true;
            case 8:
                U0((ParcelableVolumeInfo) Nr0.a(parcel, ParcelableVolumeInfo.CREATOR));
                return true;
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                int i3 = parcel.readInt();
                GO0 go02 = (GO0) weakReference.get();
                if (go02 != null) {
                    go02.d(9, Integer.valueOf(i3), null);
                }
                return true;
            case 10:
                parcel.readInt();
                return true;
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                boolean z = parcel.readInt() != 0;
                GO0 go03 = (GO0) weakReference.get();
                if (go03 != null) {
                    go03.d(11, Boolean.valueOf(z), null);
                }
                return true;
            case 12:
                int i4 = parcel.readInt();
                GO0 go04 = (GO0) weakReference.get();
                if (go04 != null) {
                    go04.d(12, Integer.valueOf(i4), null);
                }
                return true;
            case 13:
                GO0 go05 = (GO0) weakReference.get();
                if (go05 != null) {
                    go05.d(13, null, null);
                }
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }

    @Override // defpackage.Or0
    public final void p(MediaMetadataCompat mediaMetadataCompat) {
        throw new AssertionError();
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
