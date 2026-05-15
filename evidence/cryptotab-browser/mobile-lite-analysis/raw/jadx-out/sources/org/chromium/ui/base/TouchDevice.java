package org.chromium.ui.base;

import android.view.InputDevice;
import defpackage.AbstractC1499tM;
import defpackage.C1233oj2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class TouchDevice {
    public static boolean a(int i, int i2) {
        return (i & i2) == i2;
    }

    public static int[] availablePointerAndHoverTypes() {
        InputDevice device;
        int[] deviceIds = InputDevice.getDeviceIds();
        int length = deviceIds.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            try {
                device = InputDevice.getDevice(deviceIds[i]);
            } catch (RuntimeException unused) {
                device = null;
            }
            if (device != null) {
                int sources = device.getSources();
                if (!a(sources, 8194) && !a(sources, 16386) && !a(sources, 1048584) && !a(sources, 65540)) {
                    z = false;
                }
                if (z) {
                    i2 |= 4;
                }
                if (a(sources, 4098) && (C1233oj2.b.f("ReportAllAvailablePointerTypes") || !z)) {
                    i2 |= 2;
                }
                if (a(sources, 8194) || a(sources, 1048584) || a(sources, 65540)) {
                    i3 = 2;
                }
            }
            i++;
        }
        if (i2 == 0) {
            i2 = 1;
        }
        if (i3 == 0) {
            i3 = 1;
        }
        return new int[]{i2, i3};
    }

    public static int maxTouchPoints() {
        if (AbstractC1499tM.a.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.jazzhand")) {
            return 5;
        }
        if (AbstractC1499tM.a.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.distinct") || AbstractC1499tM.a.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch")) {
            return 2;
        }
        return AbstractC1499tM.a.getPackageManager().hasSystemFeature("android.hardware.touchscreen") ? 1 : 0;
    }
}
