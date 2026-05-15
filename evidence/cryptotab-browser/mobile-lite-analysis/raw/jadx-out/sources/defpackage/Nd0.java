package defpackage;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Nd0 {
    public static final Nd0 u;
    public static final Nd0 v;
    public static final Nd0[] w;
    public static final /* synthetic */ Nd0[] x;
    public final int t;

    /* JADX INFO: Fake field, exist only in values array */
    Nd0 EF0;

    static {
        JA0 ja0 = JA0.DOUBLE;
        Nd0 nd0 = new Nd0("DOUBLE", 0, 0, 1, ja0);
        JA0 ja02 = JA0.FLOAT;
        Nd0 nd02 = new Nd0("FLOAT", 1, 1, 1, ja02);
        JA0 ja03 = JA0.LONG;
        Nd0 nd03 = new Nd0("INT64", 2, 2, 1, ja03);
        Nd0 nd04 = new Nd0("UINT64", 3, 3, 1, ja03);
        JA0 ja04 = JA0.INT;
        Nd0 nd05 = new Nd0("INT32", 4, 4, 1, ja04);
        Nd0 nd06 = new Nd0("FIXED64", 5, 5, 1, ja03);
        Nd0 nd07 = new Nd0("FIXED32", 6, 6, 1, ja04);
        JA0 ja05 = JA0.BOOLEAN;
        Nd0 nd08 = new Nd0("BOOL", 7, 7, 1, ja05);
        JA0 ja06 = JA0.STRING;
        Nd0 nd09 = new Nd0("STRING", 8, 8, 1, ja06);
        JA0 ja07 = JA0.MESSAGE;
        Nd0 nd010 = new Nd0("MESSAGE", 9, 9, 1, ja07);
        JA0 ja08 = JA0.BYTE_STRING;
        Nd0 nd011 = new Nd0("BYTES", 10, 10, 1, ja08);
        Nd0 nd012 = new Nd0("UINT32", 11, 11, 1, ja04);
        JA0 ja09 = JA0.ENUM;
        Nd0 nd013 = new Nd0("ENUM", 12, 12, 1, ja09);
        Nd0 nd014 = new Nd0("SFIXED32", 13, 13, 1, ja04);
        Nd0 nd015 = new Nd0("SFIXED64", 14, 14, 1, ja03);
        Nd0 nd016 = new Nd0("SINT32", 15, 15, 1, ja04);
        Nd0 nd017 = new Nd0("SINT64", 16, 16, 1, ja03);
        Nd0 nd018 = new Nd0("GROUP", 17, 17, 1, ja07);
        Nd0 nd019 = new Nd0("DOUBLE_LIST", 18, 18, 2, ja0);
        Nd0 nd020 = new Nd0("FLOAT_LIST", 19, 19, 2, ja02);
        Nd0 nd021 = new Nd0("INT64_LIST", 20, 20, 2, ja03);
        Nd0 nd022 = new Nd0("UINT64_LIST", 21, 21, 2, ja03);
        Nd0 nd023 = new Nd0("INT32_LIST", 22, 22, 2, ja04);
        Nd0 nd024 = new Nd0("FIXED64_LIST", 23, 23, 2, ja03);
        Nd0 nd025 = new Nd0("FIXED32_LIST", 24, 24, 2, ja04);
        Nd0 nd026 = new Nd0("BOOL_LIST", 25, 25, 2, ja05);
        Nd0 nd027 = new Nd0("STRING_LIST", 26, 26, 2, ja06);
        Nd0 nd028 = new Nd0("MESSAGE_LIST", 27, 27, 2, ja07);
        Nd0 nd029 = new Nd0("BYTES_LIST", 28, 28, 2, ja08);
        Nd0 nd030 = new Nd0("UINT32_LIST", 29, 29, 2, ja04);
        Nd0 nd031 = new Nd0("ENUM_LIST", 30, 30, 2, ja09);
        Nd0 nd032 = new Nd0("SFIXED32_LIST", 31, 31, 2, ja04);
        Nd0 nd033 = new Nd0("SFIXED64_LIST", 32, 32, 2, ja03);
        Nd0 nd034 = new Nd0("SINT32_LIST", 33, 33, 2, ja04);
        Nd0 nd035 = new Nd0("SINT64_LIST", 34, 34, 2, ja03);
        Nd0 nd036 = new Nd0("DOUBLE_LIST_PACKED", 35, 35, 3, ja0);
        u = nd036;
        Nd0 nd037 = new Nd0("FLOAT_LIST_PACKED", 36, 36, 3, ja02);
        Nd0 nd038 = new Nd0("INT64_LIST_PACKED", 37, 37, 3, ja03);
        Nd0 nd039 = new Nd0("UINT64_LIST_PACKED", 38, 38, 3, ja03);
        Nd0 nd040 = new Nd0("INT32_LIST_PACKED", 39, 39, 3, ja04);
        Nd0 nd041 = new Nd0("FIXED64_LIST_PACKED", 40, 40, 3, ja03);
        Nd0 nd042 = new Nd0("FIXED32_LIST_PACKED", 41, 41, 3, ja04);
        Nd0 nd043 = new Nd0("BOOL_LIST_PACKED", 42, 42, 3, ja05);
        Nd0 nd044 = new Nd0("UINT32_LIST_PACKED", 43, 43, 3, ja04);
        Nd0 nd045 = new Nd0("ENUM_LIST_PACKED", 44, 44, 3, ja09);
        Nd0 nd046 = new Nd0("SFIXED32_LIST_PACKED", 45, 45, 3, ja04);
        Nd0 nd047 = new Nd0("SFIXED64_LIST_PACKED", 46, 46, 3, ja03);
        Nd0 nd048 = new Nd0("SINT32_LIST_PACKED", 47, 47, 3, ja04);
        Nd0 nd049 = new Nd0("SINT64_LIST_PACKED", 48, 48, 3, ja03);
        v = nd049;
        x = new Nd0[]{nd0, nd02, nd03, nd04, nd05, nd06, nd07, nd08, nd09, nd010, nd011, nd012, nd013, nd014, nd015, nd016, nd017, nd018, nd019, nd020, nd021, nd022, nd023, nd024, nd025, nd026, nd027, nd028, nd029, nd030, nd031, nd032, nd033, nd034, nd035, nd036, nd037, nd038, nd039, nd040, nd041, nd042, nd043, nd044, nd045, nd046, nd047, nd048, nd049, new Nd0("GROUP_LIST", 49, 49, 2, ja07), new Nd0("MAP", 50, 50, 4, JA0.VOID)};
        Nd0[] nd0ArrValues = values();
        w = new Nd0[nd0ArrValues.length];
        for (Nd0 nd050 : nd0ArrValues) {
            w[nd050.t] = nd050;
        }
    }

    public Nd0(String str, int i, int i2, int i3, JA0 ja0) {
        this.t = i2;
        int iB = aM1.b(i3);
        if (iB == 1 || iB == 3) {
            ja0.getClass();
        }
        if (i3 == 1) {
            ja0.ordinal();
        }
    }

    public static Nd0[] values() {
        return (Nd0[]) x.clone();
    }

    public final int a() {
        return this.t;
    }
}
