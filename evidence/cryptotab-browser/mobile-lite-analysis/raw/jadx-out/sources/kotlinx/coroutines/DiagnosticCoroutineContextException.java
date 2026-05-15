package kotlinx.coroutines;

import defpackage.InterfaceC0577eO;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DiagnosticCoroutineContextException extends RuntimeException {
    public final InterfaceC0577eO t;

    public DiagnosticCoroutineContextException(InterfaceC0577eO interfaceC0577eO) {
        this.t = interfaceC0577eO;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.t.toString();
    }
}
