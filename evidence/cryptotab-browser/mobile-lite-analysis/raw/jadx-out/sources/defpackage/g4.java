package defpackage;

import android.app.Application;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class g4 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ Object u;
    public final /* synthetic */ Object v;

    public /* synthetic */ g4(int i, Object obj, Object obj2) {
        this.t = i;
        this.v = obj;
        this.u = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                ((h4) this.u).t = this.v;
                return;
            case 1:
                ((Application) this.v).unregisterActivityLifecycleCallbacks((h4) this.u);
                return;
            default:
                try {
                    Method method = i4.d;
                    Object obj = this.u;
                    Object obj2 = this.v;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        i4.e.invoke(obj2, obj, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e) {
                    if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                        throw e;
                    }
                    return;
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    return;
                }
        }
    }

    public g4(h4 h4Var, Object obj) {
        this.t = 0;
        this.u = h4Var;
        this.v = obj;
    }
}
