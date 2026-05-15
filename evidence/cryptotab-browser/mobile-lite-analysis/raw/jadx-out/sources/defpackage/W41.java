package defpackage;

import java.lang.reflect.InvocationTargetException;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class W41 extends RC0 implements InterfaceC0926jk0 {
    public final /* synthetic */ InterfaceC0926jk0 u;
    public final /* synthetic */ Object v;
    public final /* synthetic */ InterfaceC0577eO w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W41(InterfaceC0926jk0 interfaceC0926jk0, Object obj, InterfaceC0577eO interfaceC0577eO) {
        super(1);
        this.u = interfaceC0926jk0;
        this.v = obj;
        this.w = interfaceC0577eO;
    }

    @Override // defpackage.InterfaceC0926jk0
    public final Object j(Object obj) throws IllegalAccessException, InvocationTargetException {
        UndeliveredElementException undeliveredElementExceptionA = X41.a(this.u, this.v, null);
        if (undeliveredElementExceptionA != null) {
            kO.a(this.w, undeliveredElementExceptionA);
        }
        return C0302Yj2.a;
    }
}
