package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public enum VG2 {
    u("ADD"),
    v("AND"),
    w("APPLY"),
    x("ASSIGN"),
    y("BITWISE_AND"),
    z("BITWISE_LEFT_SHIFT"),
    A("BITWISE_NOT"),
    B("BITWISE_OR"),
    C("BITWISE_RIGHT_SHIFT"),
    D("BITWISE_UNSIGNED_RIGHT_SHIFT"),
    E("BITWISE_XOR"),
    F("BLOCK"),
    G("BREAK"),
    H("CASE"),
    I("CONST"),
    f5J("CONTINUE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("CONTROL"),
    K("CREATE_ARRAY"),
    L("CREATE_OBJECT"),
    M("DEFAULT"),
    N("DEFINE_FUNCTION"),
    O("DIVIDE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("DO"),
    P("EQUALS"),
    Q("EXPRESSION_LIST"),
    R("FN"),
    S("FOR_IN"),
    T("FOR_IN_CONST"),
    U("FOR_IN_LET"),
    V("FOR_LET"),
    W("FOR_OF"),
    X("FOR_OF_CONST"),
    Y("FOR_OF_LET"),
    Z("GET"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("GET_CONTAINER_VARIABLE"),
    a0("GET_INDEX"),
    b0("GET_PROPERTY"),
    c0("GREATER_THAN"),
    d0("GREATER_THAN_EQUALS"),
    e0("IDENTITY_EQUALS"),
    f0("IDENTITY_NOT_EQUALS"),
    g0("IF"),
    h0("LESS_THAN"),
    i0("LESS_THAN_EQUALS"),
    j0("MODULUS"),
    k0("MULTIPLY"),
    l0("NEGATE"),
    m0("NOT"),
    n0("NOT_EQUALS"),
    o0("NULL"),
    p0("OR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("PLUS_EQUALS"),
    q0("POST_DECREMENT"),
    r0("POST_INCREMENT"),
    s0("QUOTE"),
    t0("PRE_DECREMENT"),
    u0("PRE_INCREMENT"),
    v0("RETURN"),
    w0("SET_PROPERTY"),
    x0("SUBTRACT"),
    y0("SWITCH"),
    z0("TERNARY"),
    A0("TYPEOF"),
    B0("UNDEFINED"),
    C0("VAR"),
    D0("WHILE");

    public static final HashMap E0 = new HashMap();
    public final int t;

    static {
        for (VG2 vg2 : values()) {
            E0.put(Integer.valueOf(vg2.t), vg2);
        }
    }

    VG2(String str) {
        this.t = i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.valueOf(this.t).toString();
    }
}
