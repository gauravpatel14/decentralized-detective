package defpackage;

import org.chromium.base.task.PostTask;
import org.chromium.content.browser.BrowserStartupControllerImpl;

/* JADX INFO: renamed from: hv, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0807hv implements Runnable {
    public final /* synthetic */ boolean t;
    public final /* synthetic */ BrowserStartupControllerImpl u;

    public RunnableC0807hv(BrowserStartupControllerImpl browserStartupControllerImpl, boolean z) {
        this.u = browserStartupControllerImpl;
        this.t = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BrowserStartupControllerImpl browserStartupControllerImpl = this.u;
        if (browserStartupControllerImpl.e) {
            return;
        }
        browserStartupControllerImpl.h = this.t ? 1 : 0;
        if (browserStartupControllerImpl.a() > 0) {
            PostTask.c(7, new RunnableC0609ev(browserStartupControllerImpl));
        }
    }
}
