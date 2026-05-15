package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class W82 {
    public static final ThreadLocal a = new ThreadLocal();

    public static p80 a() {
        ThreadLocal threadLocal = a;
        p80 p80Var = (p80) threadLocal.get();
        if (p80Var != null) {
            return p80Var;
        }
        ar arVar = new ar(Thread.currentThread());
        threadLocal.set(arVar);
        return arVar;
    }
}
