package defpackage;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class N23 extends LifecycleCallback {
    public final ArrayList t;

    public N23(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.t = new ArrayList();
        this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
    }

    public static N23 a(Activity activity) {
        N23 n23;
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        synchronized (fragment) {
            try {
                n23 = (N23) fragment.getCallbackOrNull("TaskOnStopCallback", N23.class);
                if (n23 == null) {
                    n23 = new N23(fragment);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return n23;
    }

    public final void b(r13 r13Var) {
        synchronized (this.t) {
            this.t.add(new WeakReference(r13Var));
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        synchronized (this.t) {
            try {
                Iterator it = this.t.iterator();
                while (it.hasNext()) {
                    r13 r13Var = (r13) ((WeakReference) it.next()).get();
                    if (r13Var != null) {
                        r13Var.zzc();
                    }
                }
                this.t.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
