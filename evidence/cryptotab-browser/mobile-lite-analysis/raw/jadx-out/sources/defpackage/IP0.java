package defpackage;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IP0 {
    public LP0 a;

    public IP0(int i, int i2, String str) {
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        if (Build.VERSION.SDK_INT < 28) {
            this.a = new LP0(i, i2, str);
            return;
        }
        KP0 kp0 = new KP0(i, i2, str);
        JP0.c(i, i2, str);
        this.a = kp0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IP0)) {
            return false;
        }
        return this.a.equals(((IP0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
