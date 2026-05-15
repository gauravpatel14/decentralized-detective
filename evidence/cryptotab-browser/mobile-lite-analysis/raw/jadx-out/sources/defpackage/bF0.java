package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class bF0 {
    private static final /* synthetic */ bF0[] $VALUES;
    public static final ZE0 Companion;
    public static final bF0 ON_ANY;
    public static final bF0 ON_CREATE;
    public static final bF0 ON_DESTROY;
    public static final bF0 ON_PAUSE;
    public static final bF0 ON_RESUME;
    public static final bF0 ON_START;
    public static final bF0 ON_STOP;

    static {
        bF0 bf0 = new bF0("ON_CREATE", 0);
        ON_CREATE = bf0;
        bF0 bf02 = new bF0("ON_START", 1);
        ON_START = bf02;
        bF0 bf03 = new bF0("ON_RESUME", 2);
        ON_RESUME = bf03;
        bF0 bf04 = new bF0("ON_PAUSE", 3);
        ON_PAUSE = bf04;
        bF0 bf05 = new bF0("ON_STOP", 4);
        ON_STOP = bf05;
        bF0 bf06 = new bF0("ON_DESTROY", 5);
        ON_DESTROY = bf06;
        bF0 bf07 = new bF0("ON_ANY", 6);
        ON_ANY = bf07;
        $VALUES = new bF0[]{bf0, bf02, bf03, bf04, bf05, bf06, bf07};
        Companion = new ZE0();
    }

    public static bF0[] values() {
        return (bF0[]) $VALUES.clone();
    }

    public final cF0 a() {
        switch (AbstractC0337aF0.a[ordinal()]) {
            case 1:
            case 2:
                return cF0.v;
            case 3:
            case 4:
                return cF0.w;
            case 5:
                return cF0.x;
            case 6:
                return cF0.t;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}
