package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class qW0 {
    public static final eT1 a = new eT1("UNLOCK_FAIL");
    public static final eT1 b;
    public static final eT1 c;
    public static final J60 d;
    public static final J60 e;

    static {
        eT1 et1 = new eT1("LOCKED");
        b = et1;
        eT1 et12 = new eT1("UNLOCKED");
        c = et12;
        d = new J60(et1);
        e = new J60(et12);
    }

    public static pW0 a() {
        pW0 pw0 = new pW0();
        pw0._state = e;
        return pw0;
    }
}
