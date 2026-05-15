package defpackage;

import android.app.Activity;
import java.util.HashSet;
import org.chromium.base.ApplicationStatus;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d4 {
    public static volatile b4 a;

    public static void a() {
        b4 b4Var = a;
        b4Var.getClass();
        b4.u.clear();
        for (Activity activity : ApplicationStatus.a()) {
            if (ApplicationStatus.b(activity) == 3) {
                Integer numValueOf = Integer.valueOf(activity.hashCode());
                HashSet hashSet = b4.u;
                if (!hashSet.contains(numValueOf)) {
                    hashSet.add(numValueOf);
                    b4Var.t.a(activity);
                }
            }
        }
    }
}
