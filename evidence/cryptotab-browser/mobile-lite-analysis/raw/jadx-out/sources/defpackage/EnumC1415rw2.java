package defpackage;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF12' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: rw2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class EnumC1415rw2 {
    public static final C1240ow2 v;
    public static final C1299pw2 w;
    public static final EnumC1415rw2 x;
    public static final /* synthetic */ EnumC1415rw2[] y;
    public final EnumC1473sw2 t;
    public final int u;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC1415rw2 EF10;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC1415rw2 EF11;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC1415rw2 EF12;

    static {
        EnumC1415rw2 enumC1415rw2 = new EnumC1415rw2("DOUBLE", 0, EnumC1473sw2.DOUBLE, 1);
        EnumC1415rw2 enumC1415rw22 = new EnumC1415rw2("FLOAT", 1, EnumC1473sw2.FLOAT, 5);
        EnumC1473sw2 enumC1473sw2 = EnumC1473sw2.LONG;
        EnumC1415rw2 enumC1415rw23 = new EnumC1415rw2("INT64", 2, enumC1473sw2, 0);
        EnumC1415rw2 enumC1415rw24 = new EnumC1415rw2("UINT64", 3, enumC1473sw2, 0);
        EnumC1473sw2 enumC1473sw22 = EnumC1473sw2.INT;
        EnumC1415rw2 enumC1415rw25 = new EnumC1415rw2("INT32", 4, enumC1473sw22, 0);
        EnumC1415rw2 enumC1415rw26 = new EnumC1415rw2("FIXED64", 5, enumC1473sw2, 1);
        EnumC1415rw2 enumC1415rw27 = new EnumC1415rw2("FIXED32", 6, enumC1473sw22, 5);
        EnumC1415rw2 enumC1415rw28 = new EnumC1415rw2("BOOL", 7, EnumC1473sw2.BOOLEAN, 0);
        C1177nw2 c1177nw2 = new C1177nw2("STRING", 8, EnumC1473sw2.STRING, 2);
        EnumC1473sw2 enumC1473sw23 = EnumC1473sw2.MESSAGE;
        C1240ow2 c1240ow2 = new C1240ow2("GROUP", 9, enumC1473sw23, 3);
        v = c1240ow2;
        C1299pw2 c1299pw2 = new C1299pw2("MESSAGE", 10, enumC1473sw23, 2);
        w = c1299pw2;
        C1356qw2 c1356qw2 = new C1356qw2("BYTES", 11, EnumC1473sw2.BYTE_STRING, 2);
        EnumC1415rw2 enumC1415rw29 = new EnumC1415rw2("UINT32", 12, enumC1473sw22, 0);
        x = enumC1415rw29;
        y = new EnumC1415rw2[]{enumC1415rw2, enumC1415rw22, enumC1415rw23, enumC1415rw24, enumC1415rw25, enumC1415rw26, enumC1415rw27, enumC1415rw28, c1177nw2, c1240ow2, c1299pw2, c1356qw2, enumC1415rw29, new EnumC1415rw2("ENUM", 13, EnumC1473sw2.ENUM, 0), new EnumC1415rw2("SFIXED32", 14, enumC1473sw22, 5), new EnumC1415rw2("SFIXED64", 15, enumC1473sw2, 1), new EnumC1415rw2("SINT32", 16, enumC1473sw22, 0), new EnumC1415rw2("SINT64", 17, enumC1473sw2, 0)};
    }

    public EnumC1415rw2(String str, int i, EnumC1473sw2 enumC1473sw2, int i2) {
        this.t = enumC1473sw2;
        this.u = i2;
    }

    public static EnumC1415rw2[] values() {
        return (EnumC1415rw2[]) y.clone();
    }
}
