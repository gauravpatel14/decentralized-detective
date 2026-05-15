package defpackage;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Km2 {
    public static final long b = TimeUnit.HOURS.toSeconds(1);
    public static final Pattern c = Pattern.compile("\\AA[\\w-]{38}\\z");
    public static Km2 d;
    public final C1093mU1 a;

    public Km2(C1093mU1 c1093mU1) {
        this.a = c1093mU1;
    }

    public final boolean a(C1631vi c1631vi) {
        if (TextUtils.isEmpty(c1631vi.c)) {
            return true;
        }
        long j = c1631vi.f + c1631vi.e;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.a.getClass();
        return j < timeUnit.toSeconds(System.currentTimeMillis()) + b;
    }
}
