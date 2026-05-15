package defpackage;

import android.view.InputDevice;

/* JADX INFO: renamed from: hY, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0783hY {
    public static boolean a(int i, int i2) {
        InputDevice device = InputDevice.getDevice(i);
        return device != null && (device.getSources() & i2) == i2;
    }
}
