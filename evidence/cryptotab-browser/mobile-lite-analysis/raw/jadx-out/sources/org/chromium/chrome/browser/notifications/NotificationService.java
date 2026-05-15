package org.chromium.chrome.browser.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import defpackage.P01;
import defpackage.eN1;
import org.chromium.base.BundleUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class NotificationService extends eN1 {

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class Receiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Bundle extras;
            P01 p01A = null;
            if (intent != null && (extras = intent.getExtras()) != null) {
                try {
                    p01A = P01.a(extras);
                } catch (Exception e) {
                    Log.e("NotificationEvent", "Failed to create", e);
                }
            }
            if (p01A != null) {
                p01A.b();
            }
            ((BroadcastReceiver) BundleUtils.g(context, "org.chromium.chrome.browser.notifications.NotificationServiceImpl$Receiver")).onReceive(context, intent);
        }
    }

    public NotificationService() {
        super("N11", "NotificationService");
    }
}
