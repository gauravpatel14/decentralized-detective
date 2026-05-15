package org.chromium.base;

import J.N;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import defpackage.AbstractC1214oR1;
import defpackage.AbstractC1499tM;
import defpackage.Pn;
import defpackage.bj1;
import defpackage.dj1;
import defpackage.fj1;
import org.chromium.base.PowerMonitor;
import org.chromium.base.task.PostTask;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class PowerMonitor {
    public static boolean a;
    public static int b;

    public static void a() {
        if (a) {
            return;
        }
        a = true;
        if (Pn.b.f("PostPowerMonitorBroadcastReceiverInitToBackground")) {
            PostTask.c(1, new bj1());
        } else {
            b();
        }
    }

    public static void b() {
        PowerManager powerManager;
        Context context = AbstractC1499tM.a;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        AbstractC1499tM.d(context, new dj1(), intentFilter);
        if (Build.VERSION.SDK_INT >= 29 && (powerManager = (PowerManager) context.getSystemService("power")) != null) {
            powerManager.addThermalStatusListener(new fj1());
        }
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), null, null, 0);
        if (intentRegisterReceiver != null) {
            final int intExtra = intentRegisterReceiver.getIntExtra("plugged", 0);
            PostTask.c(7, new Runnable() { // from class: cj1
                @Override // java.lang.Runnable
                public final void run() {
                    if (PowerMonitor.b == 0) {
                        PowerMonitor.b = intExtra == 0 ? 1 : 2;
                        N._V(2);
                    }
                }
            });
        }
    }

    public static int getCurrentThermalStatus() {
        if (Build.VERSION.SDK_INT < 29) {
            return -1;
        }
        if (!a) {
            a();
        }
        PowerManager powerManager = (PowerManager) AbstractC1499tM.a.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return powerManager.getCurrentThermalStatus();
    }

    public static int getRemainingBatteryCapacity() {
        if (!a) {
            a();
        }
        return ((BatteryManager) AbstractC1499tM.a.getSystemService("batterymanager")).getIntProperty(1);
    }

    public static boolean isBatteryPower() {
        if (!a) {
            a();
        }
        int i = b;
        if (i != 0) {
            if (i == 1) {
                return true;
            }
            if (i != 2) {
                throw new IllegalStateException(AbstractC1214oR1.a(b, "Unexpected value: "));
            }
        }
        return false;
    }
}
