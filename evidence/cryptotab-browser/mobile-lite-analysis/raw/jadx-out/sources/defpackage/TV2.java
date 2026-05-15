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
public final class TV2 {
    public static final TV2 u;
    public static final TV2 v;
    public static final TV2[] w;
    public static final /* synthetic */ TV2[] x;
    public final int t;

    /* JADX INFO: Fake field, exist only in values array */
    TV2 EF0;

    static {
        RW2 rw2 = RW2.DOUBLE;
        TV2 tv2 = new TV2("DOUBLE", 0, 0, 1, rw2);
        RW2 rw22 = RW2.FLOAT;
        TV2 tv22 = new TV2("FLOAT", 1, 1, 1, rw22);
        RW2 rw23 = RW2.LONG;
        TV2 tv23 = new TV2("INT64", 2, 2, 1, rw23);
        TV2 tv24 = new TV2("UINT64", 3, 3, 1, rw23);
        RW2 rw24 = RW2.INT;
        TV2 tv25 = new TV2("INT32", 4, 4, 1, rw24);
        TV2 tv26 = new TV2("FIXED64", 5, 5, 1, rw23);
        TV2 tv27 = new TV2("FIXED32", 6, 6, 1, rw24);
        RW2 rw25 = RW2.BOOLEAN;
        TV2 tv28 = new TV2("BOOL", 7, 7, 1, rw25);
        RW2 rw26 = RW2.STRING;
        TV2 tv29 = new TV2("STRING", 8, 8, 1, rw26);
        RW2 rw27 = RW2.MESSAGE;
        TV2 tv210 = new TV2("MESSAGE", 9, 9, 1, rw27);
        RW2 rw28 = RW2.BYTE_STRING;
        TV2 tv211 = new TV2("BYTES", 10, 10, 1, rw28);
        TV2 tv212 = new TV2("UINT32", 11, 11, 1, rw24);
        RW2 rw29 = RW2.ENUM;
        TV2 tv213 = new TV2("ENUM", 12, 12, 1, rw29);
        TV2 tv214 = new TV2("SFIXED32", 13, 13, 1, rw24);
        TV2 tv215 = new TV2("SFIXED64", 14, 14, 1, rw23);
        TV2 tv216 = new TV2("SINT32", 15, 15, 1, rw24);
        TV2 tv217 = new TV2("SINT64", 16, 16, 1, rw23);
        TV2 tv218 = new TV2("GROUP", 17, 17, 1, rw27);
        TV2 tv219 = new TV2("DOUBLE_LIST", 18, 18, 2, rw2);
        TV2 tv220 = new TV2("FLOAT_LIST", 19, 19, 2, rw22);
        TV2 tv221 = new TV2("INT64_LIST", 20, 20, 2, rw23);
        TV2 tv222 = new TV2("UINT64_LIST", 21, 21, 2, rw23);
        TV2 tv223 = new TV2("INT32_LIST", 22, 22, 2, rw24);
        TV2 tv224 = new TV2("FIXED64_LIST", 23, 23, 2, rw23);
        TV2 tv225 = new TV2("FIXED32_LIST", 24, 24, 2, rw24);
        TV2 tv226 = new TV2("BOOL_LIST", 25, 25, 2, rw25);
        TV2 tv227 = new TV2("STRING_LIST", 26, 26, 2, rw26);
        TV2 tv228 = new TV2("MESSAGE_LIST", 27, 27, 2, rw27);
        TV2 tv229 = new TV2("BYTES_LIST", 28, 28, 2, rw28);
        TV2 tv230 = new TV2("UINT32_LIST", 29, 29, 2, rw24);
        TV2 tv231 = new TV2("ENUM_LIST", 30, 30, 2, rw29);
        TV2 tv232 = new TV2("SFIXED32_LIST", 31, 31, 2, rw24);
        TV2 tv233 = new TV2("SFIXED64_LIST", 32, 32, 2, rw23);
        TV2 tv234 = new TV2("SINT32_LIST", 33, 33, 2, rw24);
        TV2 tv235 = new TV2("SINT64_LIST", 34, 34, 2, rw23);
        TV2 tv236 = new TV2("DOUBLE_LIST_PACKED", 35, 35, 3, rw2);
        u = tv236;
        TV2 tv237 = new TV2("FLOAT_LIST_PACKED", 36, 36, 3, rw22);
        TV2 tv238 = new TV2("INT64_LIST_PACKED", 37, 37, 3, rw23);
        TV2 tv239 = new TV2("UINT64_LIST_PACKED", 38, 38, 3, rw23);
        TV2 tv240 = new TV2("INT32_LIST_PACKED", 39, 39, 3, rw24);
        TV2 tv241 = new TV2("FIXED64_LIST_PACKED", 40, 40, 3, rw23);
        TV2 tv242 = new TV2("FIXED32_LIST_PACKED", 41, 41, 3, rw24);
        TV2 tv243 = new TV2("BOOL_LIST_PACKED", 42, 42, 3, rw25);
        TV2 tv244 = new TV2("UINT32_LIST_PACKED", 43, 43, 3, rw24);
        TV2 tv245 = new TV2("ENUM_LIST_PACKED", 44, 44, 3, rw29);
        TV2 tv246 = new TV2("SFIXED32_LIST_PACKED", 45, 45, 3, rw24);
        TV2 tv247 = new TV2("SFIXED64_LIST_PACKED", 46, 46, 3, rw23);
        TV2 tv248 = new TV2("SINT32_LIST_PACKED", 47, 47, 3, rw24);
        TV2 tv249 = new TV2("SINT64_LIST_PACKED", 48, 48, 3, rw23);
        v = tv249;
        x = new TV2[]{tv2, tv22, tv23, tv24, tv25, tv26, tv27, tv28, tv29, tv210, tv211, tv212, tv213, tv214, tv215, tv216, tv217, tv218, tv219, tv220, tv221, tv222, tv223, tv224, tv225, tv226, tv227, tv228, tv229, tv230, tv231, tv232, tv233, tv234, tv235, tv236, tv237, tv238, tv239, tv240, tv241, tv242, tv243, tv244, tv245, tv246, tv247, tv248, tv249, new TV2("GROUP_LIST", 49, 49, 2, rw27), new TV2("MAP", 50, 50, 4, RW2.VOID)};
        TV2[] tv2ArrValues = values();
        w = new TV2[tv2ArrValues.length];
        for (TV2 tv250 : tv2ArrValues) {
            w[tv250.t] = tv250;
        }
    }

    public TV2(String str, int i, int i2, int i3, RW2 rw2) {
        this.t = i2;
        RW2 rw22 = RW2.VOID;
        int i4 = i3 - 1;
        if (i4 == 1 || i4 == 3) {
            rw2.getClass();
        }
        if (i3 == 1) {
            rw2.ordinal();
        }
    }

    public static TV2[] values() {
        return (TV2[]) x.clone();
    }

    public final int a() {
        return this.t;
    }
}
