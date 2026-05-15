package org.chromium.ui.display;

import J.N;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import defpackage.AbstractC1499tM;
import defpackage.jg1;
import defpackage.o00;
import defpackage.p00;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class DisplayAndroidManager {
    public static DisplayAndroidManager e;
    public long a;
    public int b;
    public final SparseArray c = new SparseArray();
    public final p00 d = new p00(this);

    public static Display a(Context context) {
        Display display;
        if (Build.VERSION.SDK_INT < 30) {
            return ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        }
        try {
            display = context.getDisplay();
        } catch (UnsupportedOperationException unused) {
            display = null;
        }
        return display != null ? display : ((DisplayManager) AbstractC1499tM.a.getSystemService("display")).getDisplay(0);
    }

    public static DisplayAndroidManager b() {
        if (e == null) {
            DisplayAndroidManager displayAndroidManager = new DisplayAndroidManager();
            e = displayAndroidManager;
            Display display = ((DisplayManager) AbstractC1499tM.a.getSystemService("display")).getDisplay(0);
            if (display == null) {
                display = ((WindowManager) AbstractC1499tM.a.getSystemService("window")).getDefaultDisplay();
            }
            displayAndroidManager.b = display.getDisplayId();
            int displayId = display.getDisplayId();
            jg1 jg1Var = new jg1(display);
            displayAndroidManager.c.put(displayId, jg1Var);
            jg1Var.f(display);
            p00 p00Var = displayAndroidManager.d;
            p00Var.getClass();
            ((DisplayManager) AbstractC1499tM.a.getSystemService("display")).registerDisplayListener(p00Var, null);
        }
        return e;
    }

    public static void onNativeSideCreated(long j) {
        DisplayAndroidManager displayAndroidManagerB = b();
        displayAndroidManagerB.a = j;
        N._V_IJO(57, displayAndroidManagerB.b, j, displayAndroidManagerB);
        int i = 0;
        while (true) {
            SparseArray sparseArray = displayAndroidManagerB.c;
            if (i >= sparseArray.size()) {
                return;
            }
            displayAndroidManagerB.c((o00) sparseArray.valueAt(i));
            i++;
        }
    }

    public final void c(o00 o00Var) {
        int i;
        int i2;
        long j = this.a;
        if (j == 0) {
            return;
        }
        int i3 = o00Var.b;
        Point point = o00Var.c;
        int i4 = point.x;
        int i5 = point.y;
        float f = o00Var.d;
        int i6 = o00Var.i;
        if (i6 == 0) {
            i = 0;
        } else {
            if (i6 == 1) {
                i2 = 90;
            } else if (i6 != 2) {
                if (i6 == 3) {
                    i2 = 270;
                }
                i = 0;
            } else {
                i2 = 180;
            }
            i = i2;
        }
        N._V_ZZFFIIIIIIJO(0, o00Var.o && o00Var.p, o00Var.m, f, o00Var.n, i3, i4, i5, i, o00Var.g, o00Var.h, j, this);
    }
}
