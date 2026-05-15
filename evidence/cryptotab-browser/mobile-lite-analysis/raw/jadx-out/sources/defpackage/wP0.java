package defpackage;

import android.content.Context;
import android.media.session.MediaSession;
import android.os.Handler;
import android.os.RemoteCallbackList;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.c;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class wP0 {
    public final MediaSession a;
    public final c b;
    public final MediaSessionCompat$Token c;
    public final Object d = new Object();
    public final RemoteCallbackList e = new RemoteCallbackList();
    public PlaybackStateCompat f;
    public MediaMetadataCompat g;
    public AbstractC1615vP0 h;
    public IP0 i;

    public wP0(Context context, String str) {
        MediaSession mediaSessionA = a(context, str);
        this.a = mediaSessionA;
        c cVar = new c(this);
        this.b = cVar;
        this.c = new MediaSessionCompat$Token(mediaSessionA.getSessionToken(), cVar);
        mediaSessionA.setFlags(3);
    }

    public MediaSession a(Context context, String str) {
        return new MediaSession(context, str);
    }

    public final AbstractC1615vP0 b() {
        AbstractC1615vP0 abstractC1615vP0;
        synchronized (this.d) {
            abstractC1615vP0 = this.h;
        }
        return abstractC1615vP0;
    }

    public IP0 c() {
        IP0 ip0;
        synchronized (this.d) {
            ip0 = this.i;
        }
        return ip0;
    }

    public final PlaybackStateCompat d() {
        return this.f;
    }

    public final void e(AbstractC1615vP0 abstractC1615vP0, Handler handler) {
        synchronized (this.d) {
            this.h = abstractC1615vP0;
            this.a.setCallback(abstractC1615vP0 == null ? null : abstractC1615vP0.b, handler);
            if (abstractC1615vP0 != null) {
                synchronized (abstractC1615vP0.a) {
                    try {
                        abstractC1615vP0.d = new WeakReference(this);
                        HandlerC1504tP0 handlerC1504tP0 = abstractC1615vP0.e;
                        HandlerC1504tP0 handlerC1504tP02 = null;
                        if (handlerC1504tP0 != null) {
                            handlerC1504tP0.removeCallbacksAndMessages(null);
                        }
                        if (handler != null) {
                            handlerC1504tP02 = new HandlerC1504tP0(abstractC1615vP0, handler.getLooper());
                        }
                        abstractC1615vP0.e = handlerC1504tP02;
                    } finally {
                    }
                }
            }
        }
    }

    public void f(IP0 ip0) {
        synchronized (this.d) {
            this.i = ip0;
        }
    }
}
