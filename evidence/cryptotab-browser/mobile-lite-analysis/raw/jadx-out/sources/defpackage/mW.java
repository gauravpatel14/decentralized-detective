package defpackage;

import androidx.fragment.app.f;
import androidx.fragment.app.y;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mW implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ y u;
    public final /* synthetic */ f v;

    public /* synthetic */ mW(y yVar, f fVar, int i) {
        this.t = i;
        this.u = yVar;
        this.v = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                this.u.c(this.v);
                break;
            default:
                this.u.c(this.v);
                break;
        }
    }
}
