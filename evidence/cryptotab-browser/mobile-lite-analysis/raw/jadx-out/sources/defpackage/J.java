package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class J {
    public static final J d = new J(null, null);
    public final Runnable a;
    public final Executor b;
    public J c;

    public J(Runnable runnable, Executor executor) {
        this.a = runnable;
        this.b = executor;
    }
}
