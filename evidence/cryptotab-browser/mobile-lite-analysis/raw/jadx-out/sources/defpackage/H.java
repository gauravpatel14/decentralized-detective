package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class H {
    public static final H b;
    public static final H c;
    public final CancellationException a;

    static {
        if (N.w) {
            c = null;
            b = null;
        } else {
            c = new H(false, null);
            b = new H(true, null);
        }
    }

    public H(boolean z, CancellationException cancellationException) {
        this.a = cancellationException;
    }
}
