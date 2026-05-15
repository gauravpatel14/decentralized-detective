package defpackage;

import android.app.Activity;
import org.chromium.base.BundleUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class xU0 implements ex0 {
    public ex0 a;
    public final String b;

    public xU0(String str) {
        this.b = str;
    }

    @Override // defpackage.ex0
    public final void a(Activity activity) {
        if (this.a == null) {
            this.a = !BundleUtils.e() ? new C1400ra() : new YM1();
        }
        this.a.a(activity);
    }

    @Override // defpackage.ex0
    public final void b(String str, fx0 fx0Var) {
        if (this.a == null) {
            this.a = !BundleUtils.e() ? new C1400ra() : new YM1();
        }
        this.a.b(str, fx0Var);
    }

    @Override // defpackage.ex0
    public final void c() {
        if (this.a == null) {
            this.a = !BundleUtils.e() ? new C1400ra() : new YM1();
        }
        this.a.c();
    }
}
