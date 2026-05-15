package defpackage;

import android.content.Context;
import org.chromium.base.task.PostTask;
import org.chromium.content.browser.BrowserStartupControllerImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AW0 implements InterfaceC1751xm {
    public int a;
    public boolean b;
    public boolean c;
    public BW0 d;

    @Override // defpackage.InterfaceC1751xm
    public final boolean a(Context context, S62 s62) {
        this.b = true;
        return BrowserStartupControllerImpl.d().e() ? f(s62) : e();
    }

    @Override // defpackage.InterfaceC1751xm
    public final boolean b(Context context, S62 s62, Cm cm) {
        this.a = s62.a;
        C1681wW0 c1681wW0 = new C1681wW0(cm);
        int iC = c(context, s62, c1681wW0);
        boolean z = false;
        if (iC == 2) {
            return false;
        }
        if (iC == 1) {
            PostTask.c(7, new RunnableC1792yW0(this, cm));
            return true;
        }
        RunnableC1851zW0 runnableC1851zW0 = new RunnableC1851zW0(this, context, s62, c1681wW0);
        RunnableC1792yW0 runnableC1792yW0 = new RunnableC1792yW0(this, c1681wW0);
        if (BrowserStartupControllerImpl.d().e()) {
            this.c = false;
            PostTask.c(7, runnableC1851zW0);
        } else {
            BrowserStartupControllerImpl browserStartupControllerImplD = BrowserStartupControllerImpl.d();
            if (browserStartupControllerImplD.j && !browserStartupControllerImplD.f && browserStartupControllerImplD.g) {
                z = true;
            }
            this.c = g();
            PostTask.c(7, new RunnableC1738xW0(this, z, runnableC1851zW0, runnableC1792yW0));
        }
        return true;
    }

    public abstract int c(Context context, S62 s62, C1681wW0 c1681wW0);

    public abstract void d(Context context, S62 s62, C1681wW0 c1681wW0);

    public abstract boolean e();

    public abstract boolean f(S62 s62);

    public boolean g() {
        return false;
    }
}
