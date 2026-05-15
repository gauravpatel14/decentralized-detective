package defpackage;

import android.text.SpannableString;
import java.util.Arrays;

/* JADX INFO: renamed from: fM1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0634fM1 {
    public static SpannableString a(String str, C0574eM1... c0574eM1Arr) {
        Object[] objArr;
        b(str, c0574eM1Arr);
        StringBuilder sb = new StringBuilder(str.length());
        int length = 0;
        for (C0574eM1 c0574eM1 : c0574eM1Arr) {
            c(c0574eM1, str, length);
            sb.append((CharSequence) str, length, c0574eM1.w);
            int length2 = c0574eM1.t.length() + c0574eM1.w;
            c0574eM1.w = sb.length();
            sb.append((CharSequence) str, length2, c0574eM1.x);
            length = c0574eM1.x + c0574eM1.u.length();
            c0574eM1.x = sb.length();
        }
        sb.append((CharSequence) str, length, str.length());
        SpannableString spannableString = new SpannableString(sb);
        for (C0574eM1 c0574eM12 : c0574eM1Arr) {
            if (c0574eM12.w != -1 && (objArr = c0574eM12.v) != null && objArr.length != 0) {
                for (Object obj : objArr) {
                    if (obj != null) {
                        spannableString.setSpan(obj, c0574eM12.w, c0574eM12.x, 0);
                    }
                }
            }
        }
        return spannableString;
    }

    public static void b(String str, C0574eM1... c0574eM1Arr) {
        for (C0574eM1 c0574eM1 : c0574eM1Arr) {
            int iIndexOf = str.indexOf(c0574eM1.t);
            c0574eM1.w = iIndexOf;
            c0574eM1.x = str.indexOf(c0574eM1.u, c0574eM1.t.length() + iIndexOf);
        }
        Arrays.sort(c0574eM1Arr);
    }

    public static void c(C0574eM1 c0574eM1, String str, int i) {
        int i2 = c0574eM1.w;
        if (i2 == -1 || c0574eM1.x == -1 || i2 < i) {
            c0574eM1.w = -1;
            throw new IllegalArgumentException("Input string is missing tags " + c0574eM1.t + c0574eM1.u + ": " + str);
        }
    }
}
