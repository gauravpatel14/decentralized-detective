package defpackage;

import org.chromium.content.browser.BrowserStartupControllerImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class iv implements Runnable {
    public final /* synthetic */ InterfaceC0550dv t;
    public final /* synthetic */ BrowserStartupControllerImpl u;

    public iv(BrowserStartupControllerImpl browserStartupControllerImpl, InterfaceC0550dv interfaceC0550dv) {
        this.u = browserStartupControllerImpl;
        this.t = interfaceC0550dv;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.u.g;
        InterfaceC0550dv interfaceC0550dv = this.t;
        if (z) {
            interfaceC0550dv.b();
        } else {
            interfaceC0550dv.a();
        }
    }
}
