package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.util.Log;
import java.util.Iterator;

/* JADX INFO: renamed from: Cg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0031Cg {
    public boolean a;
    public boolean b;
    public C0014Bg c;
    public C0014Bg d;
    public final UsbManager e = (UsbManager) AbstractC1499tM.a.getSystemService("usb");
    public C0014Bg f;
    public final C0056Eg g;

    public C0031Cg(C0056Eg c0056Eg) {
        this.g = c0056Eg;
    }

    public static void a(int i, String str) {
        Gr1.h(i, 4, "Media.AudioDeviceConnectionStatus.".concat(str));
    }

    public static boolean d(UsbDevice usbDevice) {
        for (int i = 0; i < usbDevice.getInterfaceCount(); i++) {
            UsbInterface usbInterface = usbDevice.getInterface(i);
            if (usbInterface.getInterfaceClass() == 1 && usbInterface.getInterfaceSubclass() == 2) {
                return true;
            }
        }
        return false;
    }

    public final void b() {
        AbstractC1499tM.a.unregisterReceiver(this.c);
        this.c = null;
        if (this.a) {
            AbstractC1499tM.a.unregisterReceiver(this.d);
            this.d = null;
        }
        AbstractC1499tM.a.unregisterReceiver(this.f);
        this.f = null;
    }

    public final boolean c() {
        try {
            Iterator<UsbDevice> it = this.e.getDeviceList().values().iterator();
            while (it.hasNext()) {
                if (d(it.next())) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public final void e(boolean z) {
        BluetoothAdapter adapter;
        boolean zHasSystemFeature = AbstractC1499tM.a.getPackageManager().hasSystemFeature("android.hardware.telephony");
        C0056Eg c0056Eg = this.g;
        c0056Eg.a(2, zHasSystemFeature);
        c0056Eg.a(4, c());
        boolean z2 = false;
        c0056Eg.a(0, true);
        this.a = z;
        if (z) {
            adapter = ((BluetoothManager) AbstractC1499tM.a.getSystemService("bluetooth")).getAdapter();
            if (adapter == null) {
                Log.w("cr_media", "Couldn't get BluetoothAdapter. Bluetooth not supported on this device");
            }
        } else {
            Log.w("cr_media", "getBluetoothAdapter() requires BLUETOOTH permission");
            adapter = null;
        }
        this.b = Build.VERSION.SDK_INT >= 33 && adapter != null && adapter.isLeAudioSupported() == 10;
        if (this.a) {
            if (adapter != null) {
                boolean z3 = adapter.getProfileConnectionState(1) == 2;
                boolean z4 = this.b && adapter.getProfileConnectionState(22) == 2;
                if (adapter.isEnabled() && (z3 || z4)) {
                    z2 = true;
                }
            }
            c0056Eg.a(3, z2);
            this.d = new C0014Bg(this, 1);
            IntentFilter intentFilter = new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            if (this.b) {
                intentFilter.addAction("android.bluetooth.action.LE_AUDIO_CONNECTION_STATE_CHANGED");
            }
            AbstractC1499tM.d(AbstractC1499tM.a, this.d, intentFilter);
        } else {
            Log.w("cr_media", "registerBluetoothIntentsIfNeeded: Requires BLUETOOTH permission");
        }
        IntentFilter intentFilter2 = new IntentFilter("android.intent.action.HEADSET_PLUG");
        C0014Bg c0014Bg = new C0014Bg(this, 0);
        this.c = c0014Bg;
        AbstractC1499tM.d(AbstractC1499tM.a, c0014Bg, intentFilter2);
        this.f = new C0014Bg(this, 2);
        IntentFilter intentFilter3 = new IntentFilter();
        intentFilter3.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter3.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        AbstractC1499tM.d(AbstractC1499tM.a, this.f, intentFilter3);
    }
}
