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
/* JADX INFO: renamed from: aJ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0344aJ2 {
    public static final EnumC0344aJ2 u;
    public static final EnumC0344aJ2 v;
    public static final EnumC0344aJ2[] w;
    public static final /* synthetic */ EnumC0344aJ2[] x;
    public final int t;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0344aJ2 EF0;

    static {
        EnumC0833iL2 enumC0833iL2 = EnumC0833iL2.DOUBLE;
        EnumC0344aJ2 enumC0344aJ2 = new EnumC0344aJ2("DOUBLE", 0, 0, 1, enumC0833iL2);
        EnumC0833iL2 enumC0833iL22 = EnumC0833iL2.FLOAT;
        EnumC0344aJ2 enumC0344aJ22 = new EnumC0344aJ2("FLOAT", 1, 1, 1, enumC0833iL22);
        EnumC0833iL2 enumC0833iL23 = EnumC0833iL2.LONG;
        EnumC0344aJ2 enumC0344aJ23 = new EnumC0344aJ2("INT64", 2, 2, 1, enumC0833iL23);
        EnumC0344aJ2 enumC0344aJ24 = new EnumC0344aJ2("UINT64", 3, 3, 1, enumC0833iL23);
        EnumC0833iL2 enumC0833iL24 = EnumC0833iL2.INT;
        EnumC0344aJ2 enumC0344aJ25 = new EnumC0344aJ2("INT32", 4, 4, 1, enumC0833iL24);
        EnumC0344aJ2 enumC0344aJ26 = new EnumC0344aJ2("FIXED64", 5, 5, 1, enumC0833iL23);
        EnumC0344aJ2 enumC0344aJ27 = new EnumC0344aJ2("FIXED32", 6, 6, 1, enumC0833iL24);
        EnumC0833iL2 enumC0833iL25 = EnumC0833iL2.BOOLEAN;
        EnumC0344aJ2 enumC0344aJ28 = new EnumC0344aJ2("BOOL", 7, 7, 1, enumC0833iL25);
        EnumC0833iL2 enumC0833iL26 = EnumC0833iL2.STRING;
        EnumC0344aJ2 enumC0344aJ29 = new EnumC0344aJ2("STRING", 8, 8, 1, enumC0833iL26);
        EnumC0833iL2 enumC0833iL27 = EnumC0833iL2.MESSAGE;
        EnumC0344aJ2 enumC0344aJ210 = new EnumC0344aJ2("MESSAGE", 9, 9, 1, enumC0833iL27);
        EnumC0833iL2 enumC0833iL28 = EnumC0833iL2.BYTE_STRING;
        EnumC0344aJ2 enumC0344aJ211 = new EnumC0344aJ2("BYTES", 10, 10, 1, enumC0833iL28);
        EnumC0344aJ2 enumC0344aJ212 = new EnumC0344aJ2("UINT32", 11, 11, 1, enumC0833iL24);
        EnumC0833iL2 enumC0833iL29 = EnumC0833iL2.ENUM;
        EnumC0344aJ2 enumC0344aJ213 = new EnumC0344aJ2("ENUM", 12, 12, 1, enumC0833iL29);
        EnumC0344aJ2 enumC0344aJ214 = new EnumC0344aJ2("SFIXED32", 13, 13, 1, enumC0833iL24);
        EnumC0344aJ2 enumC0344aJ215 = new EnumC0344aJ2("SFIXED64", 14, 14, 1, enumC0833iL23);
        EnumC0344aJ2 enumC0344aJ216 = new EnumC0344aJ2("SINT32", 15, 15, 1, enumC0833iL24);
        EnumC0344aJ2 enumC0344aJ217 = new EnumC0344aJ2("SINT64", 16, 16, 1, enumC0833iL23);
        EnumC0344aJ2 enumC0344aJ218 = new EnumC0344aJ2("GROUP", 17, 17, 1, enumC0833iL27);
        EnumC0344aJ2 enumC0344aJ219 = new EnumC0344aJ2("DOUBLE_LIST", 18, 18, 2, enumC0833iL2);
        EnumC0344aJ2 enumC0344aJ220 = new EnumC0344aJ2("FLOAT_LIST", 19, 19, 2, enumC0833iL22);
        EnumC0344aJ2 enumC0344aJ221 = new EnumC0344aJ2("INT64_LIST", 20, 20, 2, enumC0833iL23);
        EnumC0344aJ2 enumC0344aJ222 = new EnumC0344aJ2("UINT64_LIST", 21, 21, 2, enumC0833iL23);
        EnumC0344aJ2 enumC0344aJ223 = new EnumC0344aJ2("INT32_LIST", 22, 22, 2, enumC0833iL24);
        EnumC0344aJ2 enumC0344aJ224 = new EnumC0344aJ2("FIXED64_LIST", 23, 23, 2, enumC0833iL23);
        EnumC0344aJ2 enumC0344aJ225 = new EnumC0344aJ2("FIXED32_LIST", 24, 24, 2, enumC0833iL24);
        EnumC0344aJ2 enumC0344aJ226 = new EnumC0344aJ2("BOOL_LIST", 25, 25, 2, enumC0833iL25);
        EnumC0344aJ2 enumC0344aJ227 = new EnumC0344aJ2("STRING_LIST", 26, 26, 2, enumC0833iL26);
        EnumC0344aJ2 enumC0344aJ228 = new EnumC0344aJ2("MESSAGE_LIST", 27, 27, 2, enumC0833iL27);
        EnumC0344aJ2 enumC0344aJ229 = new EnumC0344aJ2("BYTES_LIST", 28, 28, 2, enumC0833iL28);
        EnumC0344aJ2 enumC0344aJ230 = new EnumC0344aJ2("UINT32_LIST", 29, 29, 2, enumC0833iL24);
        EnumC0344aJ2 enumC0344aJ231 = new EnumC0344aJ2("ENUM_LIST", 30, 30, 2, enumC0833iL29);
        EnumC0344aJ2 enumC0344aJ232 = new EnumC0344aJ2("SFIXED32_LIST", 31, 31, 2, enumC0833iL24);
        EnumC0344aJ2 enumC0344aJ233 = new EnumC0344aJ2("SFIXED64_LIST", 32, 32, 2, enumC0833iL23);
        EnumC0344aJ2 enumC0344aJ234 = new EnumC0344aJ2("SINT32_LIST", 33, 33, 2, enumC0833iL24);
        EnumC0344aJ2 enumC0344aJ235 = new EnumC0344aJ2("SINT64_LIST", 34, 34, 2, enumC0833iL23);
        EnumC0344aJ2 enumC0344aJ236 = new EnumC0344aJ2("DOUBLE_LIST_PACKED", 35, 35, 3, enumC0833iL2);
        u = enumC0344aJ236;
        EnumC0344aJ2 enumC0344aJ237 = new EnumC0344aJ2("FLOAT_LIST_PACKED", 36, 36, 3, enumC0833iL22);
        EnumC0344aJ2 enumC0344aJ238 = new EnumC0344aJ2("INT64_LIST_PACKED", 37, 37, 3, enumC0833iL23);
        EnumC0344aJ2 enumC0344aJ239 = new EnumC0344aJ2("UINT64_LIST_PACKED", 38, 38, 3, enumC0833iL23);
        EnumC0344aJ2 enumC0344aJ240 = new EnumC0344aJ2("INT32_LIST_PACKED", 39, 39, 3, enumC0833iL24);
        EnumC0344aJ2 enumC0344aJ241 = new EnumC0344aJ2("FIXED64_LIST_PACKED", 40, 40, 3, enumC0833iL23);
        EnumC0344aJ2 enumC0344aJ242 = new EnumC0344aJ2("FIXED32_LIST_PACKED", 41, 41, 3, enumC0833iL24);
        EnumC0344aJ2 enumC0344aJ243 = new EnumC0344aJ2("BOOL_LIST_PACKED", 42, 42, 3, enumC0833iL25);
        EnumC0344aJ2 enumC0344aJ244 = new EnumC0344aJ2("UINT32_LIST_PACKED", 43, 43, 3, enumC0833iL24);
        EnumC0344aJ2 enumC0344aJ245 = new EnumC0344aJ2("ENUM_LIST_PACKED", 44, 44, 3, enumC0833iL29);
        EnumC0344aJ2 enumC0344aJ246 = new EnumC0344aJ2("SFIXED32_LIST_PACKED", 45, 45, 3, enumC0833iL24);
        EnumC0344aJ2 enumC0344aJ247 = new EnumC0344aJ2("SFIXED64_LIST_PACKED", 46, 46, 3, enumC0833iL23);
        EnumC0344aJ2 enumC0344aJ248 = new EnumC0344aJ2("SINT32_LIST_PACKED", 47, 47, 3, enumC0833iL24);
        EnumC0344aJ2 enumC0344aJ249 = new EnumC0344aJ2("SINT64_LIST_PACKED", 48, 48, 3, enumC0833iL23);
        v = enumC0344aJ249;
        x = new EnumC0344aJ2[]{enumC0344aJ2, enumC0344aJ22, enumC0344aJ23, enumC0344aJ24, enumC0344aJ25, enumC0344aJ26, enumC0344aJ27, enumC0344aJ28, enumC0344aJ29, enumC0344aJ210, enumC0344aJ211, enumC0344aJ212, enumC0344aJ213, enumC0344aJ214, enumC0344aJ215, enumC0344aJ216, enumC0344aJ217, enumC0344aJ218, enumC0344aJ219, enumC0344aJ220, enumC0344aJ221, enumC0344aJ222, enumC0344aJ223, enumC0344aJ224, enumC0344aJ225, enumC0344aJ226, enumC0344aJ227, enumC0344aJ228, enumC0344aJ229, enumC0344aJ230, enumC0344aJ231, enumC0344aJ232, enumC0344aJ233, enumC0344aJ234, enumC0344aJ235, enumC0344aJ236, enumC0344aJ237, enumC0344aJ238, enumC0344aJ239, enumC0344aJ240, enumC0344aJ241, enumC0344aJ242, enumC0344aJ243, enumC0344aJ244, enumC0344aJ245, enumC0344aJ246, enumC0344aJ247, enumC0344aJ248, enumC0344aJ249, new EnumC0344aJ2("GROUP_LIST", 49, 49, 2, enumC0833iL27), new EnumC0344aJ2("MAP", 50, 50, 4, EnumC0833iL2.VOID)};
        EnumC0344aJ2[] enumC0344aJ2ArrValues = values();
        w = new EnumC0344aJ2[enumC0344aJ2ArrValues.length];
        for (EnumC0344aJ2 enumC0344aJ250 : enumC0344aJ2ArrValues) {
            w[enumC0344aJ250.t] = enumC0344aJ250;
        }
    }

    public EnumC0344aJ2(String str, int i, int i2, int i3, EnumC0833iL2 enumC0833iL2) {
        this.t = i2;
        int i4 = i3 - 1;
        if (i4 == 1 || i4 == 3) {
            enumC0833iL2.getClass();
        }
        if (i3 == 1) {
            EnumC0833iL2 enumC0833iL22 = EnumC0833iL2.VOID;
            enumC0833iL2.ordinal();
        }
    }

    public static EnumC0344aJ2[] values() {
        return (EnumC0344aJ2[]) x.clone();
    }

    public final int a() {
        return this.t;
    }
}
