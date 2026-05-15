package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IF2 implements Callable {
    public final /* synthetic */ FirebaseAnalytics a;

    public IF2(FirebaseAnalytics firebaseAnalytics) {
        this.a = firebaseAnalytics;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        AN2 an2 = this.a.a;
        an2.getClass();
        RH2 rh2 = new RH2();
        an2.b(new IL2(an2, rh2));
        return rh2.Y0(120000L);
    }
}
