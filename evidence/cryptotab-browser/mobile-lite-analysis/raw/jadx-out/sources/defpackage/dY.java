package defpackage;

import android.content.Context;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class dY extends AbstractC1103mg {
    public final /* synthetic */ Callback h;
    public final /* synthetic */ Context i;

    public dY(Context context, Callback callback) {
        this.h = callback;
        this.i = context;
    }

    @Override // defpackage.AbstractC1103mg
    public final Object b() {
        C0939k33 c0939k33D;
        NB2 nb2;
        String strA = Sj1.a("bid_pref", "");
        Log.i("cr_DeviceRegistration", "Current browser id: " + strA);
        if (strA.isEmpty()) {
            C1056lx0 c1056lx0 = kx0.a;
            Context context = this.i;
            if (c1056lx0.a.compareAndSet(false, true)) {
                String strA2 = Sj1.a("referrer_pref", null);
                Log.i("cr_InstallReferrerController", "Current install referrer: null");
                if (c1056lx0.c == null) {
                    new C1178nx0(context, new jx0(c1056lx0));
                } else {
                    c1056lx0.c = strA2;
                    c1056lx0.b.countDown();
                }
            }
            C0029Cc c0029Cc = AbstractC0013Bc.a;
            Context context2 = this.i;
            if (c0029Cc.a.compareAndSet(false, true)) {
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context2);
                firebaseAnalytics.getClass();
                try {
                    synchronized (FirebaseAnalytics.class) {
                        try {
                            if (firebaseAnalytics.b == null) {
                                firebaseAnalytics.b = new NB2(0, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
                            }
                            nb2 = firebaseAnalytics.b;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    c0939k33D = Y62.c(nb2, new IF2(firebaseAnalytics));
                } catch (RuntimeException e) {
                    AN2 an2 = firebaseAnalytics.a;
                    an2.getClass();
                    an2.b(new C1553uL2(an2, "Failed to schedule task for getAppInstanceId", null));
                    c0939k33D = Y62.d(e);
                }
                c0939k33D.e(K62.a, new Ac(c0029Cc));
                c0939k33D.b(new Ac(c0029Cc));
            }
            C0717gY c0717gY = AbstractC0652fY.a;
            Context context3 = this.i;
            Callback callback = this.h;
            if (c0717gY.a.compareAndSet(false, true)) {
                Log.i("cr_DeviceRegistration", "Device registration");
                try {
                    c0717gY.a(context3, callback);
                } catch (Exception e2) {
                    Log.e("cr_DeviceRegistration", "Device registration error", e2);
                    c0717gY.a.set(false);
                    if (callback != null) {
                        callback.a0("");
                    }
                }
            }
        } else {
            Callback callback2 = this.h;
            if (callback2 != null) {
                callback2.a0(strA);
            }
        }
        return null;
    }

    @Override // defpackage.AbstractC1103mg
    public final /* bridge */ /* synthetic */ void k(Object obj) {
    }
}
