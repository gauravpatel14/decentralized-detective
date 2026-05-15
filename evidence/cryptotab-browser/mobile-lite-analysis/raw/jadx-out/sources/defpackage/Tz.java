package defpackage;

import org.chromium.base.MemoryPressureListener;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Tz implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ Sz u;

    public /* synthetic */ Tz(Sz sz, int i) {
        this.t = i;
        this.u = sz;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                MemoryPressureListener.a(this.u);
                break;
            default:
                M21 m21 = MemoryPressureListener.a;
                if (m21 != null) {
                    m21.g(this.u);
                    break;
                }
                break;
        }
    }
}
