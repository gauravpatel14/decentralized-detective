package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class K33 {
    public final String a;
    public final int b;
    public Boolean c;
    public Boolean d;
    public Long e;
    public Long f;

    public K33(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public static Boolean d(BigDecimal bigDecimal, C1148nO2 c1148nO2, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(c1148nO2);
        if (c1148nO2.p()) {
            if (c1148nO2.t() != 1) {
                if (c1148nO2.t() == 5) {
                    if (!c1148nO2.s() || !c1148nO2.r()) {
                        return null;
                    }
                } else if (!c1148nO2.q()) {
                    return null;
                }
                int iT = c1148nO2.t();
                if (c1148nO2.t() == 5) {
                    if (VX2.A(c1148nO2.o()) && VX2.A(c1148nO2.n())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(c1148nO2.o());
                            bigDecimal4 = new BigDecimal(c1148nO2.n());
                            bigDecimal3 = bigDecimal5;
                            bigDecimal2 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                }
                if (!VX2.A(c1148nO2.m())) {
                    return null;
                }
                try {
                    bigDecimal2 = new BigDecimal(c1148nO2.m());
                    bigDecimal3 = null;
                    bigDecimal4 = null;
                } catch (NumberFormatException unused2) {
                }
                if (iT == 5) {
                    if (bigDecimal3 == null) {
                        return null;
                    }
                } else if (bigDecimal2 == null) {
                    return null;
                }
                int i = iT - 1;
                if (i == 1) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
                }
                if (i == 2) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                }
                if (i != 3) {
                    if (i == 4 && bigDecimal3 != null) {
                        return Boolean.valueOf(bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0);
                    }
                    return null;
                }
                if (bigDecimal2 == null) {
                    return null;
                }
                if (d != 0.0d) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) < 0);
                }
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
            }
        }
        return null;
    }

    public static Boolean e(String str, BO2 bo2, WO2 wo2) {
        List listO;
        Preconditions.checkNotNull(bo2);
        if (str == null || !bo2.r() || bo2.s() == 1) {
            return null;
        }
        if (bo2.s() == 7) {
            if (bo2.l() == 0) {
                return null;
            }
        } else if (!bo2.q()) {
            return null;
        }
        int iS = bo2.s();
        boolean zP = bo2.p();
        String strN = (zP || iS == 2 || iS == 7) ? bo2.n() : bo2.n().toUpperCase(Locale.ENGLISH);
        if (bo2.l() == 0) {
            listO = null;
        } else {
            listO = bo2.o();
            if (!zP) {
                ArrayList arrayList = new ArrayList(listO.size());
                Iterator it = listO.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                }
                listO = Collections.unmodifiableList(arrayList);
            }
        }
        String str2 = iS == 2 ? strN : null;
        if (iS == 7) {
            if (listO == null || listO.isEmpty()) {
                return null;
            }
        } else if (strN == null) {
            return null;
        }
        if (!zP && iS != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (iS - 1) {
            case 1:
                if (str2 != null) {
                    try {
                    } catch (PatternSyntaxException unused) {
                        if (wo2 == null) {
                            return null;
                        }
                        wo2.i.b(str2, "Invalid regular expression in REGEXP audience filter. expression");
                        return null;
                    }
                    break;
                }
                break;
            case 6:
                if (listO != null) {
                    break;
                }
                break;
        }
        return null;
    }

    public static Boolean f(long j, C1148nO2 c1148nO2) {
        try {
            return d(new BigDecimal(j), c1148nO2, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean g(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    public abstract int a();

    public abstract boolean b();

    public abstract boolean c();
}
