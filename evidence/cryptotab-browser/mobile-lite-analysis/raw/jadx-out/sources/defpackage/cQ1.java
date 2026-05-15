package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cQ1 extends ZP1 {
    public static boolean d(String str, String str2) {
        return f(0, 2, str, str2, false) >= 0;
    }

    public static final int e(CharSequence charSequence, String str, int i, boolean z) {
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        int length = charSequence.length();
        if (i < 0) {
            i = 0;
        }
        int length2 = charSequence.length();
        if (length > length2) {
            length = length2;
        }
        C1417ry0 c1417ry0 = new C1417ry0(i, length, 1);
        boolean z2 = charSequence instanceof String;
        int i2 = c1417ry0.v;
        int i3 = c1417ry0.u;
        int i4 = c1417ry0.t;
        if (!z2 || str == null) {
            if ((i2 > 0 && i4 <= i3) || (i2 < 0 && i3 <= i4)) {
                while (!i(i4, str.length(), charSequence, str, z)) {
                    if (i4 != i3) {
                        i4 += i2;
                    }
                }
                return i4;
            }
            return -1;
        }
        if ((i2 > 0 && i4 <= i3) || (i2 < 0 && i3 <= i4)) {
            while (true) {
                String str2 = (String) charSequence;
                int length3 = str.length();
                if (!(!z ? str.regionMatches(0, str2, i4, length3) : str.regionMatches(z, 0, str2, i4, length3))) {
                    if (i4 == i3) {
                        break;
                    }
                    i4 += i2;
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static /* synthetic */ int f(int i, int i2, CharSequence charSequence, String str, boolean z) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return e(charSequence, str, i, z);
    }

    public static boolean g(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isWhitespace(cCharAt) && !Character.isSpaceChar(cCharAt)) {
                return false;
            }
        }
        return true;
    }

    public static final C0982kg2 h(String str) {
        return new C0982kg2(new OW(str, 0, 0, new aQ1(Arrays.asList("\r\n", "\n", "\r"), false)), new bQ1(str));
    }

    public static final boolean i(int i, int i2, CharSequence charSequence, String str, boolean z) {
        char upperCase;
        char upperCase2;
        if (i < 0 || str.length() - i2 < 0 || i > charSequence.length() - i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            char cCharAt2 = charSequence.charAt(i + i3);
            if (cCharAt != cCharAt2 && (!z || ((upperCase = Character.toUpperCase(cCharAt)) != (upperCase2 = Character.toUpperCase(cCharAt2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)))) {
                return false;
            }
        }
        return true;
    }

    public static CharSequence j(String str) {
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            char cCharAt = str.charAt(!z ? i : length);
            boolean z2 = Character.isWhitespace(cCharAt) || Character.isSpaceChar(cCharAt);
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1);
    }
}
