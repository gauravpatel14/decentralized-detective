package org.chromium.ui.base;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import defpackage.AbstractC1499tM;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class IdleDetector extends BroadcastReceiver {
    public boolean a;
    public long b;

    public static IdleDetector create() {
        IdleDetector idleDetector = new IdleDetector();
        if (idleDetector.isScreenLocked()) {
            idleDetector.a = true;
            idleDetector.b = SystemClock.elapsedRealtime();
        } else {
            idleDetector.a = false;
            idleDetector.b = 0L;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        AbstractC1499tM.d(AbstractC1499tM.a, idleDetector, intentFilter);
        return idleDetector;
    }

    public final long getIdleTime() {
        if (this.a) {
            return TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime() - this.b);
        }
        return 0L;
    }

    public final boolean isScreenLocked() {
        Context context = AbstractC1499tM.a;
        if (((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return true;
        }
        if (((PowerManager) context.getSystemService("power")) == null) {
            return false;
        }
        return !r0.isInteractive();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            this.a = true;
            this.b = SystemClock.elapsedRealtime();
        } else if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
            this.a = false;
            this.b = 0L;
        }
    }
}
