package com.google.android.gms.cast.framework.media;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat$Token;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.Preconditions;
import defpackage.AbstractC0700gL2;
import defpackage.C0025By;
import defpackage.ON0;
import defpackage.YL2;
import defpackage.vS2;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class MediaNotificationService extends Service {
    public static final YL2 v = new YL2("MediaNotificationService");
    public ON0 t;
    public C0025By u;

    public MediaNotificationService() {
        new ArrayList();
        new vS2(this);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        C0025By c0025ByB = C0025By.b(this);
        this.u = c0025ByB;
        c0025ByB.getClass();
        Preconditions.checkMainThread("Must be called from the main thread.");
        throw null;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        ((NotificationManager) getSystemService("notification")).cancel(1);
        this.u.getClass();
        Preconditions.checkMainThread("Must be called from the main thread.");
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        MediaMetadata mediaMetadata;
        int intExtra;
        CastDevice castDevice;
        ON0 on0;
        if (intent != null && "com.google.android.gms.cast.framework.action.UPDATE_NOTIFICATION".equals(intent.getAction())) {
            MediaInfo mediaInfo = (MediaInfo) intent.getParcelableExtra("extra_media_info");
            if (mediaInfo != null && (mediaMetadata = mediaInfo.w) != null && (intExtra = intent.getIntExtra("extra_remote_media_client_player_state", 0)) != 0 && (castDevice = (CastDevice) intent.getParcelableExtra("extra_cast_device")) != null) {
                boolean z = intExtra == 2;
                int i3 = mediaInfo.u;
                String strF2 = mediaMetadata.f2("com.google.android.gms.cast.metadata.TITLE");
                MediaSessionCompat$Token mediaSessionCompat$Token = (MediaSessionCompat$Token) intent.getParcelableExtra("extra_media_session_token");
                boolean booleanExtra = intent.getBooleanExtra("extra_can_skip_next", false);
                boolean booleanExtra2 = intent.getBooleanExtra("extra_can_skip_prev", false);
                String str = castDevice.w;
                ON0 on02 = new ON0(z, i3, strF2, str, mediaSessionCompat$Token, booleanExtra, booleanExtra2);
                Object obj = null;
                if (!intent.getBooleanExtra("extra_media_notification_force_update", false) && (on0 = this.t) != null && z == on0.a && i3 == on0.b && AbstractC0700gL2.a(strF2, on0.c) && AbstractC0700gL2.a(str, on0.d) && booleanExtra == on0.e && booleanExtra2 == on0.f) {
                    ArrayList arrayList = mediaMetadata.t;
                    WebImage webImage = arrayList != null && !arrayList.isEmpty() ? (WebImage) arrayList.get(0) : null;
                    if (webImage != null) {
                        webImage.getUrl();
                    }
                    obj.getClass();
                    throw null;
                }
                this.t = on02;
                new ArrayList();
                new ArrayList();
                new ArrayList();
                Notification notification = new Notification();
                notification.when = System.currentTimeMillis();
                notification.audioStreamType = -1;
                new ArrayList();
                throw null;
            }
            stopForeground(true);
        }
        return 2;
    }
}
