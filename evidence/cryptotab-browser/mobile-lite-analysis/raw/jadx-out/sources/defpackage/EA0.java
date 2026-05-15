package defpackage;

import android.app.Activity;
import android.view.Window;
import java.lang.ref.WeakReference;
import org.chromium.base.ApplicationStatus;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class EA0 implements Runnable {
    public final /* synthetic */ WeakReference t;
    public final /* synthetic */ FA0 u;

    public EA0(FA0 fa0, WeakReference weakReference) {
        this.u = fa0;
        this.t = weakReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity = (Activity) this.t.get();
        FA0 fa0 = this.u;
        if (fa0.d || activity == null || activity.isDestroyed()) {
            return;
        }
        dj0 dj0Var = new dj0();
        AA0 aa0 = new AA0(dj0Var);
        if (!FA0.e) {
            fa0.c = null;
            fa0.b = null;
            return;
        }
        fa0.c = aa0;
        cj0 cj0Var = new cj0(dj0Var);
        AA0 aa02 = fa0.c;
        C1483tA0 c1483tA0 = new C1483tA0(activity, cj0Var, aa02);
        fa0.b = c1483tA0;
        int i = AbstractC1872zv.a;
        Activity activity2 = (Activity) c1483tA0.w.get();
        if (activity2 != null) {
            ApplicationStatus.h(c1483tA0, activity2);
            c1483tA0.e(activity2, ApplicationStatus.b(activity2));
            Window window = activity2.getWindow();
            cj0Var.b.set(true);
            if (window != null) {
                aa02.getClass();
                window.addOnFrameMetricsAvailableListener(cj0Var, AbstractC1819zA0.a);
            }
        }
        fa0.a = true;
    }
}
