package defpackage;

import android.app.Activity;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import org.chromium.base.ApplicationStatus;
import org.chromium.chrome.browser.base.SplitCompatAppComponentFactory;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class EG implements Sd {
    public static EG u;
    public Boolean t;

    public static boolean b() {
        int i = AbstractC1872zv.a;
        EG eg = u;
        eg.a();
        return eg.t.booleanValue();
    }

    public final void a() {
        if (this.t != null) {
            return;
        }
        boolean z = true;
        if (Build.VERSION.SDK_INT < 28) {
            this.t = Boolean.valueOf(SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime() < 500);
            return;
        }
        int i = SplitCompatAppComponentFactory.a;
        if (i > -1) {
            z = i == 0;
        }
        this.t = Boolean.valueOf(z);
    }

    @Override // defpackage.Sd
    public final void e(Activity activity, int i) {
        if (i == 1) {
            a();
            ApplicationStatus.k(this);
        }
    }
}
