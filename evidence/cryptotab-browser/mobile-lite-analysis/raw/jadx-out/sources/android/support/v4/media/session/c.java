package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import defpackage.IP0;
import defpackage.Mr0;
import defpackage.Or0;
import defpackage.Qr0;
import defpackage.wP0;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends Binder implements a {
    public static final /* synthetic */ int u = 0;
    public final AtomicReference t;

    public c(wP0 wp0) {
        attachInterface(this, "android.support.v4.media.session.IMediaSession");
        this.t = new AtomicReference(wp0);
    }

    @Override // android.support.v4.media.session.a
    public final PlaybackStateCompat A() {
        wP0 wp0 = (wP0) this.t.get();
        if (wp0 == null) {
            return null;
        }
        PlaybackStateCompat playbackStateCompat = wp0.f;
        MediaMetadataCompat mediaMetadataCompat = wp0.g;
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long j = playbackStateCompat.u;
        long j2 = -1;
        if (j == -1) {
            return playbackStateCompat;
        }
        int i = playbackStateCompat.t;
        if (i != 3 && i != 4 && i != 5) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.A <= 0) {
            return playbackStateCompat;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = ((long) (playbackStateCompat.w * (jElapsedRealtime - r7))) + j;
        if (mediaMetadataCompat != null) {
            Bundle bundle = mediaMetadataCompat.t;
            if (bundle.containsKey("android.media.metadata.DURATION")) {
                j2 = bundle.getLong("android.media.metadata.DURATION", 0L);
            }
        }
        long j4 = (j2 < 0 || j3 <= j2) ? j3 < 0 ? 0L : j3 : j2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = playbackStateCompat.B;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        return new PlaybackStateCompat(playbackStateCompat.t, j4, playbackStateCompat.v, playbackStateCompat.w, playbackStateCompat.x, playbackStateCompat.y, playbackStateCompat.z, jElapsedRealtime, arrayList, playbackStateCompat.C, playbackStateCompat.D);
    }

    @Override // android.support.v4.media.session.a
    public final void A0(Uri uri, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void D(MediaDescriptionCompat mediaDescriptionCompat) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final boolean E() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void E0(long j) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void F(MediaDescriptionCompat mediaDescriptionCompat) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void F0(int i) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final PendingIntent H() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final int I() {
        return ((wP0) this.t.get()) != null ? 0 : -1;
    }

    @Override // android.support.v4.media.session.a
    public final void K(int i) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void L() {
    }

    @Override // android.support.v4.media.session.a
    public final String L0() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void N(String str, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void O() {
    }

    @Override // android.support.v4.media.session.a
    public final void Q0(float f) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void T(Or0 or0) {
        wP0 wp0 = (wP0) this.t.get();
        if (wp0 == null) {
            return;
        }
        wp0.e.unregister(or0);
        Binder.getCallingPid();
        Binder.getCallingUid();
        synchronized (wp0.d) {
        }
    }

    @Override // android.support.v4.media.session.a
    public final void U() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final boolean V0(KeyEvent keyEvent) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void W() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void Z(String str, Bundle bundle, MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final String c() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void c0(int i, int i2) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final long d() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void f0(int i) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final Bundle getExtras() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final MediaMetadataCompat getMetadata() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void h0() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void i(String str, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void i0(Or0 or0) {
        wP0 wp0 = (wP0) this.t.get();
        if (wp0 == null) {
            return;
        }
        wp0.e.register(or0, new IP0(Binder.getCallingPid(), Binder.getCallingUid(), "android.media.session.MediaController"));
        synchronized (wp0.d) {
        }
    }

    @Override // android.support.v4.media.session.a
    public final CharSequence j0() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void l(RatingCompat ratingCompat, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void l0() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void m0(String str, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void n(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final Bundle n0() {
        return null;
    }

    @Override // android.support.v4.media.session.a
    public final void next() {
        throw new AssertionError();
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
        }
        if (i == 1598968902) {
            parcel2.writeString("android.support.v4.media.session.IMediaSession");
            return true;
        }
        Or0 or0 = null;
        Or0 or02 = null;
        switch (i) {
            case 1:
                Z(parcel.readString(), (Bundle) Qr0.a(parcel, Bundle.CREATOR), (MediaSessionCompat$ResultReceiverWrapper) Qr0.a(parcel, MediaSessionCompat$ResultReceiverWrapper.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                boolean zV0 = V0((KeyEvent) Qr0.a(parcel, KeyEvent.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(zV0 ? 1 : 0);
                return true;
            case 3:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof Or0)) {
                        Mr0 mr0 = new Mr0();
                        mr0.t = strongBinder;
                        or0 = mr0;
                    } else {
                        or0 = (Or0) iInterfaceQueryLocalInterface;
                    }
                }
                i0(or0);
                parcel2.writeNoException();
                return true;
            case 4:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof Or0)) {
                        Mr0 mr02 = new Mr0();
                        mr02.t = strongBinder2;
                        or02 = mr02;
                    } else {
                        or02 = (Or0) iInterfaceQueryLocalInterface2;
                    }
                }
                T(or02);
                parcel2.writeNoException();
                return true;
            case 5:
                boolean zE = E();
                parcel2.writeNoException();
                parcel2.writeInt(zE ? 1 : 0);
                return true;
            case 6:
                String strL0 = L0();
                parcel2.writeNoException();
                parcel2.writeString(strL0);
                return true;
            case 7:
                String strC = c();
                parcel2.writeNoException();
                parcel2.writeString(strC);
                return true;
            case 8:
                PendingIntent pendingIntentH = H();
                parcel2.writeNoException();
                Qr0.b(parcel2, pendingIntentH);
                return true;
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                long jD = d();
                parcel2.writeNoException();
                parcel2.writeLong(jD);
                return true;
            case 10:
                ParcelableVolumeInfo parcelableVolumeInfoX0 = x0();
                parcel2.writeNoException();
                Qr0.b(parcel2, parcelableVolumeInfoX0);
                return true;
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                int i3 = parcel.readInt();
                int i4 = parcel.readInt();
                parcel.readString();
                c0(i3, i4);
                parcel2.writeNoException();
                return true;
            case 12:
                int i5 = parcel.readInt();
                int i6 = parcel.readInt();
                parcel.readString();
                w0(i5, i6);
                parcel2.writeNoException();
                return true;
            case 13:
                W();
                parcel2.writeNoException();
                return true;
            case 14:
                q0(parcel.readString(), (Bundle) Qr0.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                u0(parcel.readString(), (Bundle) Qr0.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 16:
                A0((Uri) Qr0.a(parcel, Uri.CREATOR), (Bundle) Qr0.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 17:
                t0(parcel.readLong());
                parcel2.writeNoException();
                return true;
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                l0();
                parcel2.writeNoException();
                return true;
            case 19:
                stop();
                parcel2.writeNoException();
                return true;
            case 20:
                next();
                parcel2.writeNoException();
                return true;
            case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                previous();
                parcel2.writeNoException();
                return true;
            case 22:
                y0();
                parcel2.writeNoException();
                return true;
            case ConnectionResult.API_DISABLED /* 23 */:
                h0();
                parcel2.writeNoException();
                return true;
            case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                E0(parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 25:
                u((RatingCompat) Qr0.a(parcel, RatingCompat.CREATOR));
                parcel2.writeNoException();
                return true;
            case 26:
                i(parcel.readString(), (Bundle) Qr0.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 27:
                MediaMetadataCompat metadata = getMetadata();
                parcel2.writeNoException();
                Qr0.b(parcel2, metadata);
                return true;
            case 28:
                PlaybackStateCompat playbackStateCompatA = A();
                parcel2.writeNoException();
                Qr0.b(parcel2, playbackStateCompatA);
                return true;
            case 29:
                parcel2.writeNoException();
                parcel2.writeInt(-1);
                return true;
            case 30:
                CharSequence charSequenceJ0 = j0();
                parcel2.writeNoException();
                if (charSequenceJ0 != null) {
                    parcel2.writeInt(1);
                    TextUtils.writeToParcel(charSequenceJ0, parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 31:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                Qr0.b(parcel2, extras);
                return true;
            case 32:
                L();
                parcel2.writeNoException();
                parcel2.writeInt(0);
                return true;
            case 33:
                U();
                parcel2.writeNoException();
                return true;
            case 34:
                m0(parcel.readString(), (Bundle) Qr0.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 35:
                N(parcel.readString(), (Bundle) Qr0.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 36:
                y((Uri) Qr0.a(parcel, Uri.CREATOR), (Bundle) Qr0.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 37:
                int iS0 = s0();
                parcel2.writeNoException();
                parcel2.writeInt(iS0);
                return true;
            case 38:
                parcel2.writeNoException();
                parcel2.writeInt(0);
                return true;
            case 39:
                f0(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 40:
                parcel.readInt();
                parcel2.writeNoException();
                return true;
            case 41:
                F((MediaDescriptionCompat) Qr0.a(parcel, MediaDescriptionCompat.CREATOR));
                parcel2.writeNoException();
                return true;
            case 42:
                n((MediaDescriptionCompat) Qr0.a(parcel, MediaDescriptionCompat.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 43:
                D((MediaDescriptionCompat) Qr0.a(parcel, MediaDescriptionCompat.CREATOR));
                parcel2.writeNoException();
                return true;
            case 44:
                K(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 45:
                O();
                parcel2.writeNoException();
                parcel2.writeInt(0);
                return true;
            case 46:
                t(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 47:
                int I = I();
                parcel2.writeNoException();
                parcel2.writeInt(I);
                return true;
            case 48:
                F0(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 49:
                Q0(parcel.readFloat());
                parcel2.writeNoException();
                return true;
            case 50:
                Bundle bundleN0 = n0();
                parcel2.writeNoException();
                Qr0.b(parcel2, bundleN0);
                return true;
            case 51:
                l((RatingCompat) Qr0.a(parcel, RatingCompat.CREATOR), (Bundle) Qr0.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }

    @Override // android.support.v4.media.session.a
    public final void previous() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void q0(String str, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final int s0() {
        return ((wP0) this.t.get()) != null ? 0 : -1;
    }

    @Override // android.support.v4.media.session.a
    public final void stop() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void t(boolean z) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void t0(long j) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void u(RatingCompat ratingCompat) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void u0(String str, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void w0(int i, int i2) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final ParcelableVolumeInfo x0() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void y(Uri uri, Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.a
    public final void y0() {
        throw new AssertionError();
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.support.v4.media.session.a
    public final void b0() {
    }
}
