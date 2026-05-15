package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class cF0 {
    public static final cF0 t;
    public static final cF0 u;
    public static final cF0 v;
    public static final cF0 w;
    public static final cF0 x;
    public static final /* synthetic */ cF0[] y;

    static {
        cF0 cf0 = new cF0("DESTROYED", 0);
        t = cf0;
        cF0 cf02 = new cF0("INITIALIZED", 1);
        u = cf02;
        cF0 cf03 = new cF0("CREATED", 2);
        v = cf03;
        cF0 cf04 = new cF0("STARTED", 3);
        w = cf04;
        cF0 cf05 = new cF0("RESUMED", 4);
        x = cf05;
        y = new cF0[]{cf0, cf02, cf03, cf04, cf05};
    }

    public static cF0[] values() {
        return (cF0[]) y.clone();
    }

    public final boolean a(cF0 cf0) {
        return compareTo(cf0) >= 0;
    }
}
