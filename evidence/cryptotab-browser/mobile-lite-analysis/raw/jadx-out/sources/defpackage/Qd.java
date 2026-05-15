package defpackage;

import org.chromium.base.ApplicationStatus;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Qd implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        if (ApplicationStatus.e != null) {
            return;
        }
        Pd pd = new Pd();
        ApplicationStatus.e = pd;
        ApplicationStatus.g(pd);
    }
}
