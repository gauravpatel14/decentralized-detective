package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import android.os.ResultReceiver;
import androidx.versionedparcelable.ParcelImpl;
import defpackage.InterfaceC1694wn2;
import defpackage.Pr0;
import defpackage.a91;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver extends ResultReceiver {
    public WeakReference t;

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        a aVar;
        b bVar = (b) this.t.get();
        if (bVar == null || bundle == null) {
            return;
        }
        synchronized (bVar.b) {
            MediaSessionCompat$Token mediaSessionCompat$Token = bVar.e;
            IBinder binder = bundle.getBinder("android.support.v4.media.session.EXTRA_BINDER");
            int i2 = c.u;
            InterfaceC1694wn2 interfaceC1694wn2 = null;
            if (binder == null) {
                aVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = binder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) {
                    Pr0 pr0 = new Pr0();
                    pr0.t = binder;
                    aVar = pr0;
                } else {
                    aVar = (a) iInterfaceQueryLocalInterface;
                }
            }
            synchronized (mediaSessionCompat$Token.t) {
                mediaSessionCompat$Token.v = aVar;
            }
            MediaSessionCompat$Token mediaSessionCompat$Token2 = bVar.e;
            try {
                Bundle bundle2 = (Bundle) bundle.getParcelable("android.support.v4.media.session.SESSION_TOKEN2");
                if (bundle2 != null) {
                    bundle2.setClassLoader(a91.class.getClassLoader());
                    Parcelable parcelable = bundle2.getParcelable("a");
                    if (!(parcelable instanceof ParcelImpl)) {
                        throw new IllegalArgumentException("Invalid parcel");
                    }
                    interfaceC1694wn2 = ((ParcelImpl) parcelable).t;
                }
            } catch (RuntimeException unused) {
            }
            synchronized (mediaSessionCompat$Token2.t) {
                mediaSessionCompat$Token2.w = interfaceC1694wn2;
            }
            bVar.a();
        }
    }
}
