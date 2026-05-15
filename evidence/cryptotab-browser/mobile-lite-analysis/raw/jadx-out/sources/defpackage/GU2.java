package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class GU2 implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ IU2 t;

    public /* synthetic */ GU2(IU2 iu2) {
        this.t = iu2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        C1391rR2 c1391rR2 = this.t.a;
        try {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.n.a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                return;
            }
            Uri data = intent.getData();
            if (data != null && data.isHierarchical()) {
                C1391rR2.i(c1391rR2.l);
                String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                String str = ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) ? "gs" : "auto";
                String queryParameter = data.getQueryParameter("referrer");
                boolean z = bundle == null;
                C0899jR2 c0899jR2 = c1391rR2.j;
                C1391rR2.k(c0899jR2);
                c0899jR2.o(new DU2(this, z, data, str, queryParameter));
                return;
            }
            return;
        } catch (RuntimeException e) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.f.b(e, "Throwable caught in onActivityCreated");
            return;
        } finally {
            C1791yV2 c1791yV2 = c1391rR2.o;
            C1391rR2.j(c1791yV2);
            c1791yV2.p(activity, bundle);
        }
        C1791yV2 c1791yV22 = c1391rR2.o;
        C1391rR2.j(c1791yV22);
        c1791yV22.p(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        C1791yV2 c1791yV2 = this.t.a.o;
        C1391rR2.j(c1791yV2);
        synchronized (c1791yV2.l) {
            try {
                if (activity == c1791yV2.g) {
                    c1791yV2.g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (c1791yV2.a.g.r()) {
            c1791yV2.f.remove(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        C1791yV2 c1791yV2 = this.t.a.o;
        C1391rR2.j(c1791yV2);
        synchronized (c1791yV2.l) {
            c1791yV2.k = false;
            c1791yV2.h = true;
        }
        long jElapsedRealtime = c1791yV2.a.n.elapsedRealtime();
        if (c1791yV2.a.g.r()) {
            TU2 tu2Q = c1791yV2.q(activity);
            c1791yV2.d = c1791yV2.c;
            c1791yV2.c = null;
            C0899jR2 c0899jR2 = c1791yV2.a.j;
            C1391rR2.k(c0899jR2);
            c0899jR2.o(new RunnableC1622vV2(c1791yV2, tu2Q, jElapsedRealtime));
        } else {
            c1791yV2.c = null;
            C0899jR2 c0899jR22 = c1791yV2.a.j;
            C1391rR2.k(c0899jR22);
            c0899jR22.o(new RunnableC1565uV2(c1791yV2, jElapsedRealtime));
        }
        C0420bX2 c0420bX2 = this.t.a.k;
        C1391rR2.j(c0420bX2);
        long jElapsedRealtime2 = c0420bX2.a.n.elapsedRealtime();
        C0899jR2 c0899jR23 = c0420bX2.a.j;
        C1391rR2.k(c0899jR23);
        c0899jR23.o(new QW2(c0420bX2, jElapsedRealtime2));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        C0420bX2 c0420bX2 = this.t.a.k;
        C1391rR2.j(c0420bX2);
        long jElapsedRealtime = c0420bX2.a.n.elapsedRealtime();
        C0899jR2 c0899jR2 = c0420bX2.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new PW2(c0420bX2, jElapsedRealtime));
        C1791yV2 c1791yV2 = this.t.a.o;
        C1391rR2.j(c1791yV2);
        synchronized (c1791yV2.l) {
            c1791yV2.k = true;
            if (activity != c1791yV2.g) {
                synchronized (c1791yV2.l) {
                    c1791yV2.g = activity;
                    c1791yV2.h = false;
                }
                if (c1791yV2.a.g.r()) {
                    c1791yV2.i = null;
                    C0899jR2 c0899jR22 = c1791yV2.a.j;
                    C1391rR2.k(c0899jR22);
                    c0899jR22.o(new RunnableC1679wV2(c1791yV2));
                }
            }
        }
        if (!c1791yV2.a.g.r()) {
            c1791yV2.c = c1791yV2.i;
            C0899jR2 c0899jR23 = c1791yV2.a.j;
            C1391rR2.k(c0899jR23);
            c0899jR23.o(new RunnableC1514tV2(c1791yV2));
            return;
        }
        c1791yV2.k(activity, c1791yV2.q(activity), false);
        AK2 ak2M = c1791yV2.a.m();
        long jElapsedRealtime2 = ak2M.a.n.elapsedRealtime();
        C0899jR2 c0899jR24 = ak2M.a.j;
        C1391rR2.k(c0899jR24);
        c0899jR24.o(new YH2(ak2M, jElapsedRealtime2));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        TU2 tu2;
        C1791yV2 c1791yV2 = this.t.a.o;
        C1391rR2.j(c1791yV2);
        if (!c1791yV2.a.g.r() || bundle == null || (tu2 = (TU2) c1791yV2.f.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", tu2.c);
        bundle2.putString("name", tu2.a);
        bundle2.putString("referrer_name", tu2.b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
