package defpackage;

import android.content.Context;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TE1 {
    public static TE1 e;
    public String a = null;
    public Boolean b = null;
    public Boolean c = null;
    public final ArrayDeque d = new ArrayDeque();

    public static synchronized TE1 a() {
        try {
            if (e == null) {
                e = new TE1();
            }
        } catch (Throwable th) {
            throw th;
        }
        return e;
    }

    public final boolean b(Context context) {
        if (this.c == null) {
            this.c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        this.b.booleanValue();
        return this.c.booleanValue();
    }

    public final boolean c(Context context) {
        if (this.b == null) {
            this.b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        this.b.booleanValue();
        return this.b.booleanValue();
    }
}
