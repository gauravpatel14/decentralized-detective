package defpackage;

import org.chromium.base.task.PostTask;
import org.chromium.content.browser.BrowserStartupControllerImpl;

/* JADX INFO: renamed from: gv, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0741gv implements Runnable {
    public final /* synthetic */ BrowserStartupControllerImpl t;

    public RunnableC0741gv(BrowserStartupControllerImpl browserStartupControllerImpl) {
        this.t = browserStartupControllerImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0675fv c0675fv = new C0675fv(this);
        BrowserStartupControllerImpl browserStartupControllerImpl = this.t;
        if (browserStartupControllerImpl.f) {
            PostTask.c(7, new iv(browserStartupControllerImpl, c0675fv));
        } else {
            browserStartupControllerImpl.a.add(c0675fv);
        }
    }
}
