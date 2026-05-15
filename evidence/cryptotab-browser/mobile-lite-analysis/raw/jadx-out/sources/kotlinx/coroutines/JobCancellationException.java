package kotlinx.coroutines;

import defpackage.YA0;
import defpackage.lz0;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class JobCancellationException extends CancellationException {
    public final transient YA0 t;

    public JobCancellationException(String str, Throwable th, YA0 ya0) {
        super(str);
        this.t = ya0;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!lz0.a(jobCancellationException.getMessage(), getMessage()) || !lz0.a(jobCancellationException.t, this.t) || !lz0.a(jobCancellationException.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        int iHashCode = (this.t.hashCode() + (getMessage().hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.t;
    }
}
