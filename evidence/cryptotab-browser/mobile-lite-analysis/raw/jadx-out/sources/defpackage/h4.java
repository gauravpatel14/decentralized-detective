package defpackage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class h4 implements Application.ActivityLifecycleCallbacks {
    public Object t;
    public Activity u;
    public final int v;
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;

    public h4(Activity activity) {
        this.u = activity;
        this.v = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.u == activity) {
            this.u = null;
            this.x = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (!this.x || this.y || this.w) {
            return;
        }
        Object obj = this.t;
        try {
            Object obj2 = i4.c.get(activity);
            if (obj2 == obj && activity.hashCode() == this.v) {
                i4.g.postAtFrontOfQueue(new g4(2, i4.b.get(activity), obj2));
                this.y = true;
                this.t = null;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.u == activity) {
            this.w = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
