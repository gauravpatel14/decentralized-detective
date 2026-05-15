package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class kO {
    public static final void a(InterfaceC0577eO interfaceC0577eO, Throwable th) {
        try {
            z7 z7Var = (z7) interfaceC0577eO.l(iO.t);
            if (z7Var != null) {
                z7Var.c(interfaceC0577eO, th);
            } else {
                jO.a(interfaceC0577eO, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                z80.a(runtimeException, th);
                th = runtimeException;
            }
            jO.a(interfaceC0577eO, th);
        }
    }
}
