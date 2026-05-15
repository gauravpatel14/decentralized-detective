package defpackage;

import android.content.Intent;
import android.media.Rating;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.a;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.versionedparcelable.ParcelImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class uP0 extends MediaSession.Callback {
    public final /* synthetic */ AbstractC1615vP0 a;

    public uP0(AbstractC1615vP0 abstractC1615vP0) {
        this.a = abstractC1615vP0;
    }

    public static void b(wP0 wp0) {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        MediaSession mediaSession = wp0.a;
        String str = null;
        try {
            str = (String) mediaSession.getClass().getMethod("getCallingPackage", null).invoke(mediaSession, null);
        } catch (Exception e) {
            Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e);
        }
        if (TextUtils.isEmpty(str)) {
            str = "android.media.session.MediaController";
        }
        wp0.f(new IP0(-1, -1, str));
    }

    public final wP0 a() {
        wP0 wp0;
        synchronized (this.a.a) {
            wp0 = (wP0) this.a.d.get();
        }
        if (wp0 == null || this.a != wp0.b()) {
            return null;
        }
        return wp0;
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        InterfaceC1694wn2 interfaceC1694wn2;
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        CP0.a(bundle);
        b(wp0A);
        try {
            if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                Bundle bundle2 = new Bundle();
                MediaSessionCompat$Token mediaSessionCompat$Token = wp0A.c;
                a aVarA = mediaSessionCompat$Token.a();
                bundle2.putBinder("android.support.v4.media.session.EXTRA_BINDER", aVarA == null ? null : aVarA.asBinder());
                synchronized (mediaSessionCompat$Token.t) {
                    interfaceC1694wn2 = mediaSessionCompat$Token.w;
                }
                if (interfaceC1694wn2 == null) {
                    bundle2.putParcelable("android.support.v4.media.session.SESSION_TOKEN2", null);
                } else {
                    Bundle bundle3 = new Bundle();
                    bundle3.putParcelable("a", new ParcelImpl(interfaceC1694wn2));
                    bundle2.putParcelable("android.support.v4.media.session.SESSION_TOKEN2", bundle3);
                }
                resultReceiver.send(0, bundle2);
            } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                AbstractC1615vP0 abstractC1615vP0 = this.a;
                abstractC1615vP0.getClass();
            } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                AbstractC1615vP0 abstractC1615vP02 = this.a;
                bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX");
                abstractC1615vP02.getClass();
            } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                AbstractC1615vP0 abstractC1615vP03 = this.a;
                abstractC1615vP03.getClass();
            } else if (!str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                this.a.getClass();
            }
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
        }
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onCustomAction(String str, Bundle bundle) {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        CP0.a(bundle);
        b(wp0A);
        try {
            boolean zEquals = str.equals("android.support.v4.media.session.action.PLAY_FROM_URI");
            AbstractC1615vP0 abstractC1615vP0 = this.a;
            if (zEquals) {
                CP0.a(bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                abstractC1615vP0.getClass();
            } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                abstractC1615vP0.getClass();
            } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                CP0.a(bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                abstractC1615vP0.getClass();
            } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                CP0.a(bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                abstractC1615vP0.getClass();
            } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                CP0.a(bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                abstractC1615vP0.getClass();
            } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED");
                abstractC1615vP0.getClass();
            } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE");
                abstractC1615vP0.getClass();
            } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE");
                abstractC1615vP0.getClass();
            } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
                CP0.a(bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                abstractC1615vP0.getClass();
            } else if (str.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                bundle.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f);
                abstractC1615vP0.getClass();
            } else {
                abstractC1615vP0.getClass();
            }
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
        }
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onFastForward() {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        b(wp0A);
        this.a.b();
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final boolean onMediaButtonEvent(Intent intent) {
        wP0 wp0;
        HandlerC1504tP0 handlerC1504tP0;
        KeyEvent keyEvent;
        wP0 wp0A = a();
        if (wp0A == null) {
            return false;
        }
        b(wp0A);
        AbstractC1615vP0 abstractC1615vP0 = this.a;
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 27) {
            abstractC1615vP0.getClass();
        } else {
            synchronized (abstractC1615vP0.a) {
                wp0 = (wP0) abstractC1615vP0.d.get();
                handlerC1504tP0 = abstractC1615vP0.e;
            }
            if (wp0 != null && handlerC1504tP0 != null && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null && keyEvent.getAction() == 0) {
                IP0 ip0C = wp0.c();
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 79 || keyCode == 85) {
                    if (keyEvent.getRepeatCount() != 0) {
                        abstractC1615vP0.a(wp0, handlerC1504tP0);
                    } else if (abstractC1615vP0.c) {
                        handlerC1504tP0.removeMessages(1);
                        abstractC1615vP0.c = false;
                        PlaybackStateCompat playbackStateCompatD = wp0.d();
                        if (((playbackStateCompatD == null ? 0L : playbackStateCompatD.x) & 32) != 0) {
                            abstractC1615vP0.g();
                        }
                    } else {
                        abstractC1615vP0.c = true;
                        handlerC1504tP0.sendMessageDelayed(handlerC1504tP0.obtainMessage(1, ip0C), ViewConfiguration.getDoubleTapTimeout());
                    }
                    z = true;
                } else {
                    abstractC1615vP0.a(wp0, handlerC1504tP0);
                }
            }
        }
        wp0A.f(null);
        return z || super.onMediaButtonEvent(intent);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPause() {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        b(wp0A);
        this.a.c();
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlay() {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        b(wp0A);
        this.a.d();
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlayFromMediaId(String str, Bundle bundle) {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        CP0.a(bundle);
        b(wp0A);
        this.a.getClass();
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlayFromSearch(String str, Bundle bundle) {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        CP0.a(bundle);
        b(wp0A);
        this.a.getClass();
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlayFromUri(Uri uri, Bundle bundle) {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        CP0.a(bundle);
        b(wp0A);
        this.a.getClass();
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepare() {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        b(wp0A);
        this.a.getClass();
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepareFromMediaId(String str, Bundle bundle) {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        CP0.a(bundle);
        b(wp0A);
        this.a.getClass();
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepareFromSearch(String str, Bundle bundle) {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        CP0.a(bundle);
        b(wp0A);
        this.a.getClass();
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepareFromUri(Uri uri, Bundle bundle) {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        CP0.a(bundle);
        b(wp0A);
        this.a.getClass();
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onRewind() {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        b(wp0A);
        this.a.e();
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSeekTo(long j) {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        b(wp0A);
        this.a.f(j);
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSetPlaybackSpeed(float f) {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        b(wp0A);
        this.a.getClass();
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSetRating(Rating rating) {
        float f;
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        b(wp0A);
        RatingCompat ratingCompat = null;
        if (rating != null) {
            int ratingStyle = rating.getRatingStyle();
            if (rating.isRated()) {
                switch (ratingStyle) {
                    case 1:
                        ratingCompat = new RatingCompat(1, rating.hasHeart() ? 1.0f : 0.0f);
                        break;
                    case 2:
                        ratingCompat = new RatingCompat(2, rating.isThumbUp() ? 1.0f : 0.0f);
                        break;
                    case 3:
                    case 4:
                    case 5:
                        float starRating = rating.getStarRating();
                        if (ratingStyle == 3) {
                            f = 3.0f;
                        } else if (ratingStyle == 4) {
                            f = 4.0f;
                        } else if (ratingStyle != 5) {
                            Log.e("Rating", "Invalid rating style (" + ratingStyle + ") for a star rating");
                        } else {
                            f = 5.0f;
                        }
                        if (starRating >= 0.0f && starRating <= f) {
                            ratingCompat = new RatingCompat(ratingStyle, starRating);
                        } else {
                            Log.e("Rating", "Trying to set out of range star-based rating");
                        }
                        break;
                    case 6:
                        float percentRating = rating.getPercentRating();
                        if (percentRating >= 0.0f && percentRating <= 100.0f) {
                            ratingCompat = new RatingCompat(6, percentRating);
                        } else {
                            Log.e("Rating", "Invalid percentage-based rating value");
                        }
                        break;
                }
            } else {
                switch (ratingStyle) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        ratingCompat = new RatingCompat(ratingStyle, -1.0f);
                        break;
                }
            }
            ratingCompat.getClass();
        }
        this.a.getClass();
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSkipToNext() {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        b(wp0A);
        this.a.g();
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSkipToPrevious() {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        b(wp0A);
        this.a.h();
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSkipToQueueItem(long j) {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        b(wp0A);
        this.a.getClass();
        wp0A.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onStop() {
        wP0 wp0A = a();
        if (wp0A == null) {
            return;
        }
        b(wp0A);
        this.a.getClass();
        wp0A.f(null);
    }
}
