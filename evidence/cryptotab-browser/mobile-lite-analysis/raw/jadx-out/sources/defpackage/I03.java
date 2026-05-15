package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class I03 implements H03 {
    public static final CT2 a;
    public static final ET2 b;
    public static final AT2 c;
    public static final AT2 d;
    public static final GT2 e;

    static {
        IT2 it2 = new IT2(AbstractC1619vT2.a(), false, true);
        a = it2.c("measurement.test.boolean_flag", false);
        b = new ET2(it2, "measurement.test.double_flag", Double.valueOf(-3.0d));
        c = it2.a(-2L, "measurement.test.int_flag");
        d = it2.a(-1L, "measurement.test.long_flag");
        e = new GT2(it2, "measurement.test.string_flag", "---");
    }
}
