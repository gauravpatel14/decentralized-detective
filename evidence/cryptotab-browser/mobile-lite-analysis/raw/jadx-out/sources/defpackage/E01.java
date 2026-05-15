package defpackage;

import android.app.Notification;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class E01 extends H01 {
    public CharSequence d;

    @Override // defpackage.H01
    public final void a(L01 l01) {
        Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(l01.b).setBigContentTitle(null).bigText(this.d);
        if (this.c) {
            bigTextStyleBigText.setSummaryText(this.b);
        }
    }

    @Override // defpackage.H01
    public final String b() {
        return "androidx.core.app.NotificationCompat$BigTextStyle";
    }
}
