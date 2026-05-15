package defpackage;

import java.util.LinkedList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CW {
    public static CW b;
    public final LinkedList a = new LinkedList();

    public static CW b() {
        if (b == null) {
            b = new CW();
        }
        return b;
    }

    public final void a(Runnable runnable) {
        this.a.add(runnable);
    }
}
