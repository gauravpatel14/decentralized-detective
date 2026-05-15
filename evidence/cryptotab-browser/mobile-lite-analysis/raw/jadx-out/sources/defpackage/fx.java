package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fx {
    public static C0611ex a(cx cxVar) {
        C0440bx c0440bx = new C0440bx();
        c0440bx.c = new Wu1();
        C0611ex c0611ex = new C0611ex(c0440bx);
        c0440bx.b = c0611ex;
        c0440bx.a = cxVar.getClass();
        try {
            Object objA = cxVar.a(c0440bx);
            if (objA != null) {
                c0440bx.a = objA;
            }
        } catch (Exception e) {
            c0611ex.u.h(e);
        }
        return c0611ex;
    }
}
