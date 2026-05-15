package defpackage;

import android.util.SparseArray;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ws1 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ Xs1 u;

    public /* synthetic */ Ws1(Xs1 xs1, int i) {
        this.t = i;
        this.u = xs1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                SparseArray sparseArray = this.u.h;
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    ((bt1) sparseArray.valueAt(i)).getClass();
                }
                sparseArray.clear();
                break;
            default:
                Xs1 xs1 = this.u;
                ServiceConnectionC0608et1 serviceConnectionC0608et1 = xs1.i;
                if (serviceConnectionC0608et1.G == xs1) {
                    serviceConnectionC0608et1.i();
                }
                break;
        }
    }
}
