package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class U82 {
    public static final eT1 a = new eT1("NO_THREAD_ELEMENTS");

    public static final void a(InterfaceC0577eO interfaceC0577eO, Object obj) {
        if (obj == a) {
            return;
        }
        if (!(obj instanceof a92)) {
            Object objP = interfaceC0577eO.p(null, T82.w);
            if (objP == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            }
            ((V82) objP).u.set(obj);
            return;
        }
        a92 a92Var = (a92) obj;
        V82[] v82Arr = a92Var.c;
        int length = v82Arr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            v82Arr[length].u.set(a92Var.b[length]);
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }

    public static final Object b(InterfaceC0577eO interfaceC0577eO, Object obj) {
        if (obj == null) {
            obj = interfaceC0577eO.p(0, T82.v);
        }
        return obj == 0 ? a : obj instanceof Integer ? interfaceC0577eO.p(new a92(interfaceC0577eO, ((Number) obj).intValue()), T82.x) : ((V82) obj).b(interfaceC0577eO);
    }
}
