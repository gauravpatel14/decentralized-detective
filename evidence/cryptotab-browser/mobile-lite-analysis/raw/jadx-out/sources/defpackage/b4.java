package defpackage;

import android.app.Activity;
import java.util.HashSet;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class b4 implements Sd {
    public static final HashSet u = new HashSet();
    public final ex0 t;

    public b4(ex0 ex0Var) {
        this.t = ex0Var;
    }

    @Override // defpackage.Sd
    public final void e(Activity activity, int i) {
        if (i != 1 && i != 3) {
            if (i == 6) {
                u.remove(Integer.valueOf(activity.hashCode()));
            }
        } else {
            Integer numValueOf = Integer.valueOf(activity.hashCode());
            HashSet hashSet = u;
            if (hashSet.contains(numValueOf)) {
                return;
            }
            hashSet.add(numValueOf);
            this.t.a(activity);
        }
    }
}
