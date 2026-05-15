package defpackage;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lW implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ Serializable u;

    public /* synthetic */ lW(Serializable serializable, int i) {
        this.t = i;
        this.u = serializable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                InterfaceC0798hk0 interfaceC0798hk0 = (InterfaceC0798hk0) ((Es1) this.u).t;
                if (interfaceC0798hk0 != null) {
                    interfaceC0798hk0.c();
                }
                break;
            default:
                AbstractC0118Ki0.a(4, (ArrayList) this.u);
                break;
        }
    }
}
