package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ZA0 {
    public static final eT1 a = new eT1("COMPLETING_ALREADY");
    public static final eT1 b = new eT1("COMPLETING_WAITING_CHILDREN");
    public static final eT1 c = new eT1("COMPLETING_RETRY");
    public static final eT1 d = new eT1("TOO_LATE_TO_CANCEL");
    public static final eT1 e = new eT1("SEALED");
    public static final K60 f = new K60(false);
    public static final K60 g = new K60(true);

    public static final Object a(Object obj) {
        Vv0 vv0;
        Wv0 wv0 = obj instanceof Wv0 ? (Wv0) obj : null;
        return (wv0 == null || (vv0 = wv0.a) == null) ? obj : vv0;
    }
}
