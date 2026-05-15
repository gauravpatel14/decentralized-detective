package defpackage;

import androidx.concurrent.futures.AbstractResolvableFuture$Failure$1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class I {
    public final Throwable a;

    static {
        new I(new AbstractResolvableFuture$Failure$1("Failure occurred while trying to finish a future."));
    }

    public I(Throwable th) {
        boolean z = N.w;
        th.getClass();
        this.a = th;
    }
}
