package defpackage;

import android.app.Notification;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class J01 {
    public static void a(Notification.Builder builder, boolean z) {
        builder.setAllowSystemGeneratedContextualActions(z);
    }

    public static void b(Notification.Builder builder) {
        builder.setBubbleMetadata(null);
    }

    public static void c(Notification.Action.Builder builder) {
        builder.setContextual(false);
    }
}
