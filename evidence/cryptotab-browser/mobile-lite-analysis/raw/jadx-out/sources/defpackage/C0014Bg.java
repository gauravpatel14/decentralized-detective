package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;

/* JADX INFO: renamed from: Bg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0014Bg extends BroadcastReceiver {
    public final /* synthetic */ int a;
    public final /* synthetic */ C0031Cg b;

    public /* synthetic */ C0014Bg(C0031Cg c0031Cg, int i) {
        this.a = i;
        this.b = c0031Cg;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int i;
        switch (this.a) {
            case 0:
                int i2 = 0;
                int intExtra = intent.getIntExtra("state", 0);
                C0031Cg c0031Cg = this.b;
                if (intExtra == 0) {
                    c0031Cg.g.a(1, false);
                } else if (intExtra == 1) {
                    c0031Cg.g.a(1, true);
                    i2 = 2;
                }
                c0031Cg.g.c.e();
                C0031Cg.a(i2, "Wired");
                break;
            case 1:
                int i3 = 0;
                int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                C0031Cg c0031Cg2 = this.b;
                if (intExtra2 == 0) {
                    c0031Cg2.g.a(3, false);
                    c0031Cg2.g.c.e();
                } else if (intExtra2 == 1) {
                    i3 = 1;
                } else if (intExtra2 == 2) {
                    c0031Cg2.g.a(3, true);
                    c0031Cg2.g.c.e();
                    i3 = 2;
                } else if (intExtra2 == 3) {
                    i3 = 3;
                }
                C0031Cg.a(i3, "Bluetooth");
                break;
            default:
                UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                C0031Cg c0031Cg3 = this.b;
                c0031Cg3.getClass();
                if (C0031Cg.d(usbDevice)) {
                    boolean zEquals = "android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(intent.getAction());
                    C0056Eg c0056Eg = c0031Cg3.g;
                    if (zEquals) {
                        c0056Eg.a(4, true);
                        i = 2;
                    } else {
                        if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(intent.getAction()) && !c0031Cg3.c()) {
                            c0056Eg.a(4, false);
                        }
                        i = 0;
                    }
                    c0056Eg.c.e();
                    C0031Cg.a(i, "USB");
                    break;
                }
                break;
        }
    }
}
