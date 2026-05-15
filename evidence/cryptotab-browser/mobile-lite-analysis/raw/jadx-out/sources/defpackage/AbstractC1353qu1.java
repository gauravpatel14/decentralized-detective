package defpackage;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;

/* JADX INFO: renamed from: qu1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1353qu1 {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, bF0 bf0) {
        if (activity instanceof InterfaceC0762hF0) {
            AbstractC0514dF0 lifecycle = ((InterfaceC0762hF0) activity).getLifecycle();
            if (lifecycle instanceof C0886jF0) {
                ((C0886jF0) lifecycle).e(bf0);
            }
        }
    }

    public static void b(iI iIVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            C1530tu1.Companion.getClass();
            iIVar.registerActivityLifecycleCallbacks(new C1530tu1());
        }
        FragmentManager fragmentManager = iIVar.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new FragmentC1585uu1(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}
