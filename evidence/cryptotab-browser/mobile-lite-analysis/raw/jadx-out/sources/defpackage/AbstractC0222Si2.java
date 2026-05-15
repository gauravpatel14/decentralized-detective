package defpackage;

/* JADX INFO: renamed from: Si2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0222Si2 {
    public static void a(int i, Object obj) {
        if (obj == null || b(i, obj)) {
            return;
        }
        c(obj, "kotlin.jvm.functions.Function" + i);
        throw null;
    }

    public static boolean b(int i, Object obj) {
        if (obj instanceof yk0) {
            return (obj instanceof Hk0 ? ((Hk0) obj).f() : obj instanceof InterfaceC0798hk0 ? 0 : obj instanceof InterfaceC0926jk0 ? 1 : obj instanceof xk0 ? 2 : obj instanceof Ak0 ? 4 : -1) == i;
        }
        return false;
    }

    public static void c(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(F.b(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        lz0.b(classCastException, AbstractC0222Si2.class.getName());
        throw classCastException;
    }
}
