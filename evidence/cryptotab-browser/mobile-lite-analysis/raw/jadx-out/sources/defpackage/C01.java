package defpackage;

import android.app.Notification;
import android.graphics.drawable.Icon;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class C01 {
    public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
        bigPictureStyle.bigPicture(icon);
    }

    public static void b(Notification.BigPictureStyle bigPictureStyle) {
        bigPictureStyle.setContentDescription(null);
    }

    public static void c(Notification.BigPictureStyle bigPictureStyle) {
        bigPictureStyle.showBigPictureWhenCollapsed(false);
    }
}
