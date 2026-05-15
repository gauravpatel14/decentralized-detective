package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.view.KeyEvent;
import defpackage.Or0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {
    PlaybackStateCompat A();

    void A0(Uri uri, Bundle bundle);

    void D(MediaDescriptionCompat mediaDescriptionCompat);

    boolean E();

    void E0(long j);

    void F(MediaDescriptionCompat mediaDescriptionCompat);

    void F0(int i);

    PendingIntent H();

    int I();

    void K(int i);

    void L();

    String L0();

    void N(String str, Bundle bundle);

    void O();

    void Q0(float f);

    void T(Or0 or0);

    void U();

    boolean V0(KeyEvent keyEvent);

    void W();

    void Z(String str, Bundle bundle, MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper);

    void b0();

    String c();

    void c0(int i, int i2);

    long d();

    void f0(int i);

    Bundle getExtras();

    MediaMetadataCompat getMetadata();

    void h0();

    void i(String str, Bundle bundle);

    void i0(Or0 or0);

    CharSequence j0();

    void l(RatingCompat ratingCompat, Bundle bundle);

    void l0();

    void m0(String str, Bundle bundle);

    void n(MediaDescriptionCompat mediaDescriptionCompat, int i);

    Bundle n0();

    void next();

    void previous();

    void q0(String str, Bundle bundle);

    int s0();

    void stop();

    void t(boolean z);

    void t0(long j);

    void u(RatingCompat ratingCompat);

    void u0(String str, Bundle bundle);

    void w0(int i, int i2);

    ParcelableVolumeInfo x0();

    void y(Uri uri, Bundle bundle);

    void y0();
}
