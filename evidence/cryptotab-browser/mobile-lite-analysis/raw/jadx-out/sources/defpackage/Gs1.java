package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Gs1 {
    public static final Ls1 a;

    static {
        Ls1 ls1 = null;
        try {
            ls1 = (Ls1) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (ls1 == null) {
            ls1 = new Ls1();
        }
        a = ls1;
    }

    public static iF a(Class cls) {
        a.getClass();
        return new iF(cls);
    }
}
