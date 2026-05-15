package org.chromium.ui.base;

import J.N;
import android.os.Build;
import android.view.MotionEvent;
import defpackage.C1233oj2;
import defpackage.InterfaceC0880j80;
import defpackage.kV0;
import org.chromium.base.TraceEvent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class EventForwarder {
    public final boolean a;
    public final boolean b;
    public long c;
    public float d;
    public float e;
    public float f;
    public int g;
    public int h;
    public InterfaceC0880j80 i;

    public EventForwarder(long j, boolean z, boolean z2) {
        this.c = j;
        this.a = z;
        this.b = z2;
    }

    public static boolean c(MotionEvent motionEvent) {
        if (motionEvent.isFromSource(8194) && motionEvent.getToolType(0) == 1) {
            return motionEvent.getAction() == 12 || motionEvent.getButtonState() != 0;
        }
        return false;
    }

    public static EventForwarder create(long j, boolean z) {
        return new EventForwarder(j, z, Build.VERSION.SDK_INT >= 34 && C1233oj2.b.f("ConvertTrackpadEventsToMouse"));
    }

    public final MotionEvent a(MotionEvent motionEvent) {
        if (!b()) {
            return motionEvent;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.d);
        return motionEventObtain;
    }

    public final boolean b() {
        return this.d != 0.0f;
    }

    public final void d(int i, long j, float f) {
        long j2 = this.c;
        if (j2 == 0) {
            return;
        }
        N._Z_FIJJO(0, f, i, j2, j, this);
    }

    public final void destroy() {
        this.c = 0L;
    }

    public final boolean e(MotionEvent motionEvent) {
        TraceEvent.a("sendMouseEvent", null);
        boolean z = false;
        try {
            if (b()) {
                motionEvent = a(motionEvent);
                z = true;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 11 || actionMasked == 12) {
                this.g = motionEvent.getButtonState();
            }
            boolean zF = f(motionEvent);
            if (z) {
                motionEvent.recycle();
            }
            TraceEvent.b("sendMouseEvent");
            return zF;
        } catch (Throwable th) {
            if (z) {
                motionEvent.recycle();
            }
            TraceEvent.b("sendMouseEvent");
            throw th;
        }
    }

    public final boolean f(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9 || actionMasked == 10) {
            return false;
        }
        if (actionMasked == 0 || actionMasked == 1) {
            return true;
        }
        boolean z = this.b && c(motionEvent);
        long j = this.c;
        long jA = kV0.a(motionEvent);
        N._V_FFFFFIIIIIIJJO(1, motionEvent.getX(), motionEvent.getY(), motionEvent.getPressure(0), motionEvent.getOrientation(0), motionEvent.getAxisValue(25, 0), actionMasked, motionEvent.getPointerId(0), motionEvent.getActionButton(), motionEvent.getButtonState(), motionEvent.getMetaState(), z ? 3 : motionEvent.getToolType(0), j, jA, this);
        return true;
    }
}
