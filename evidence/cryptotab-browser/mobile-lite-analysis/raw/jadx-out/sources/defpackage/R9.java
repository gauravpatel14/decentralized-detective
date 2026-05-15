package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class R9 extends AbstractC0003Al0 {
    public static final R9 j;
    public static volatile C1802yl0 k;
    public int e;
    public String f = "";
    public String g = "";
    public String h = "";
    public String i = "";

    static {
        R9 r9 = new R9();
        j = r9;
        AbstractC0003Al0.o(R9.class, r9);
    }

    @Override // defpackage.AbstractC0003Al0
    public final Object f(EnumC1862zl0 enumC1862zl0, Object obj, Object obj2) {
        switch (enumC1862zl0.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new rq1(j, "\u0001\u0004\u0000\u0001\u0002\b\u0004\u0000\u0000\u0000\u0002ဈ\u0000\u0004ဈ\u0001\u0006ဈ\u0002\bဈ\u0003", new Object[]{"e", "f", "g", "h", "i"});
            case 3:
                return new R9();
            case 4:
                return new C1750xl0(j);
            case 5:
                return j;
            case 6:
                C1802yl0 c1802yl0 = k;
                if (c1802yl0 == null) {
                    synchronized (R9.class) {
                        try {
                            c1802yl0 = k;
                            if (c1802yl0 == null) {
                                c1802yl0 = new C1802yl0();
                                k = c1802yl0;
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return c1802yl0;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
