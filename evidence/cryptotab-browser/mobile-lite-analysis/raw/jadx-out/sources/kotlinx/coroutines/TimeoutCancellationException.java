package kotlinx.coroutines;

import defpackage.RunnableC0853ia2;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TimeoutCancellationException extends CancellationException {
    public final transient RunnableC0853ia2 t;

    public TimeoutCancellationException(String str, RunnableC0853ia2 runnableC0853ia2) {
        super(str);
        this.t = runnableC0853ia2;
    }
}
