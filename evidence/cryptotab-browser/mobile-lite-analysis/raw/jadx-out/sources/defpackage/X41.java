package defpackage;

import java.lang.reflect.InvocationTargetException;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class X41 {
    public static final UndeliveredElementException a(InterfaceC0926jk0 interfaceC0926jk0, Object obj, UndeliveredElementException undeliveredElementException) throws IllegalAccessException, InvocationTargetException {
        try {
            interfaceC0926jk0.j(obj);
        } catch (Throwable th) {
            if (undeliveredElementException == null || undeliveredElementException.getCause() == th) {
                return new UndeliveredElementException("Exception in undelivered element handler for " + obj, th);
            }
            z80.a(undeliveredElementException, th);
        }
        return undeliveredElementException;
    }
}
