package defpackage;

import android.util.SparseArray;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class tX {
    public final Object a = new Object();
    public PV0 b;

    public abstract SparseArray a(aj0 aj0Var);

    public abstract boolean b();

    public final void c(aj0 aj0Var) {
        Zi0 zi0 = aj0Var.a;
        SparseArray sparseArrayA = a(aj0Var);
        b();
        sX sXVar = new sX(sparseArrayA);
        synchronized (this.a) {
            try {
                PV0 pv0 = this.b;
                if (pv0 == null) {
                    throw new IllegalStateException("Detector processor must first be set with setProcessor in order to receive detection results.");
                }
                pv0.a(sXVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d() {
        SparseArray sparseArray;
        synchronized (this.a) {
            try {
                PV0 pv0 = this.b;
                if (pv0 != null) {
                    int i = 0;
                    while (true) {
                        sparseArray = pv0.b;
                        if (i >= sparseArray.size()) {
                            break;
                        }
                        ((OV0) sparseArray.valueAt(i)).a.getClass();
                        i++;
                    }
                    sparseArray.clear();
                    this.b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
