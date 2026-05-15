package defpackage;

import J.N;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.SparseArray;
import android.view.Display;
import org.chromium.ui.display.DisplayAndroidManager;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class p00 implements DisplayManager.DisplayListener {
    public final /* synthetic */ DisplayAndroidManager a;

    public p00(DisplayAndroidManager displayAndroidManager) {
        this.a = displayAndroidManager;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
        jg1 jg1Var = (jg1) this.a.c.get(i);
        Display display = ((DisplayManager) AbstractC1499tM.a.getSystemService("display")).getDisplay(i);
        if (jg1Var == null || display == null) {
            return;
        }
        jg1Var.f(display);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
        gg1 gg1Var;
        DisplayAndroidManager displayAndroidManager = this.a;
        if (i == displayAndroidManager.b) {
            return;
        }
        SparseArray sparseArray = displayAndroidManager.c;
        jg1 jg1Var = (jg1) sparseArray.get(i);
        if (jg1Var == null) {
            return;
        }
        if (jg1.v) {
            jg1Var.r.unregisterComponentCallbacks(jg1Var.s);
        }
        if (Build.VERSION.SDK_INT >= 34 && (gg1Var = jg1Var.u) != null) {
            jg1Var.t.unregisterHdrSdrRatioChangedListener(gg1Var);
            jg1Var.u = null;
        }
        long j = displayAndroidManager.a;
        if (j != 0) {
            N._V_IJO(56, i, j, displayAndroidManager);
        }
        sparseArray.remove(i);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
    }
}
