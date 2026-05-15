package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class pO {
    public static final pO t;
    public static final /* synthetic */ pO[] u;

    static {
        pO pOVar = new pO("COROUTINE_SUSPENDED", 0);
        t = pOVar;
        u = new pO[]{pOVar, new pO("UNDECIDED", 1), new pO("RESUMED", 2)};
    }

    public static pO[] values() {
        return (pO[]) u.clone();
    }
}
