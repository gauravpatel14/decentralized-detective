package org.chromium.ui.events.devices;

import J.N;
import android.hardware.input.InputManager;
import android.util.ArrayMap;
import android.view.InputDevice;
import defpackage.AbstractC1499tM;
import defpackage.Gr1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class InputDeviceObserver implements InputManager.InputDeviceListener {
    public static final InputDeviceObserver d = new InputDeviceObserver();
    public final ArrayMap a = new ArrayMap();
    public InputManager b;
    public int c;

    public static void addObserver() {
        InputDeviceObserver inputDeviceObserver = d;
        int i = inputDeviceObserver.c;
        inputDeviceObserver.c = i + 1;
        if (i == 0) {
            InputManager inputManager = (InputManager) AbstractC1499tM.a.getSystemService("input");
            inputDeviceObserver.b = inputManager;
            inputManager.registerInputDeviceListener(inputDeviceObserver, null);
        }
    }

    public static void removeObserver() {
        InputDeviceObserver inputDeviceObserver = d;
        int i = inputDeviceObserver.c - 1;
        inputDeviceObserver.c = i;
        if (i == 0) {
            inputDeviceObserver.b.unregisterInputDeviceListener(inputDeviceObserver);
            inputDeviceObserver.b = null;
        }
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public final void onInputDeviceAdded(int i) {
        N._V_O(53, this);
        InputDevice device = InputDevice.getDevice(i);
        if (device == null) {
            return;
        }
        int sources = device.getSources() & 257;
        ArrayMap arrayMap = this.a;
        if (sources == 257) {
            arrayMap.put(Integer.valueOf(i), 257);
            Gr1.b("Android.InputDevice.Keyboard.Active", true);
        } else if ((device.getSources() & 8194) == 8194) {
            arrayMap.put(Integer.valueOf(i), 8194);
            Gr1.b("Android.InputDevice.Mouse.Active", true);
        }
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public final void onInputDeviceChanged(int i) {
        N._V_O(53, this);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public final void onInputDeviceRemoved(int i) {
        N._V_O(53, this);
        Integer numValueOf = Integer.valueOf(i);
        ArrayMap arrayMap = this.a;
        if (arrayMap.containsKey(numValueOf)) {
            if (((Integer) arrayMap.get(Integer.valueOf(i))).intValue() == 257) {
                Gr1.b("Android.InputDevice.Keyboard.Active", false);
            } else if (((Integer) arrayMap.get(Integer.valueOf(i))).intValue() == 8194) {
                Gr1.b("Android.InputDevice.Mouse.Active", false);
            }
            arrayMap.remove(Integer.valueOf(i));
        }
    }
}
