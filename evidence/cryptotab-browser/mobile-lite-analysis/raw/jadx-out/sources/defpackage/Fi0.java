package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Fi0 {
    public static final /* synthetic */ Fi0[] A;
    public static final Fi0 t;
    public static final Fi0 u;
    public static final Fi0 v;
    public static final Fi0 w;
    public static final Fi0 x;
    public static final Fi0 y;
    public static final Fi0 z;

    /* JADX INFO: Fake field, exist only in values array */
    Fi0 EF0;

    static {
        Fi0 fi0 = new Fi0("PENALTY_LOG", 0);
        Fi0 fi02 = new Fi0("PENALTY_DEATH", 1);
        Fi0 fi03 = new Fi0("DETECT_FRAGMENT_REUSE", 2);
        t = fi03;
        Fi0 fi04 = new Fi0("DETECT_FRAGMENT_TAG_USAGE", 3);
        u = fi04;
        Fi0 fi05 = new Fi0("DETECT_WRONG_NESTED_HIERARCHY", 4);
        v = fi05;
        Fi0 fi06 = new Fi0("DETECT_RETAIN_INSTANCE_USAGE", 5);
        w = fi06;
        Fi0 fi07 = new Fi0("DETECT_SET_USER_VISIBLE_HINT", 6);
        x = fi07;
        Fi0 fi08 = new Fi0("DETECT_TARGET_FRAGMENT_USAGE", 7);
        y = fi08;
        Fi0 fi09 = new Fi0("DETECT_WRONG_FRAGMENT_CONTAINER", 8);
        z = fi09;
        A = new Fi0[]{fi0, fi02, fi03, fi04, fi05, fi06, fi07, fi08, fi09};
    }

    public static Fi0[] values() {
        return (Fi0[]) A.clone();
    }
}
