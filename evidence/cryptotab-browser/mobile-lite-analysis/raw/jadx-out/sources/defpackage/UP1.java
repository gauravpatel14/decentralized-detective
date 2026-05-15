package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UP1 extends SP1 {
    public static String b(String str) {
        C0982kg2 c0982kg2H = cQ1.h(str);
        TP1 tp1 = new TP1("    ");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        Iterator it = c0982kg2H.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object objJ = tp1.j(it.next());
            i++;
            if (i > 1) {
                sb.append((CharSequence) "\n");
            }
            SP1.a(sb, objJ, null);
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0043 A[PHI: r8
      0x0043: PHI (r8v2 java.lang.String) = (r8v1 java.lang.String), (r8v3 java.lang.String) binds: [B:13:0x0041, B:29:0x0073] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(java.lang.String r13) {
        /*
            java.lang.String r0 = "|"
            boolean r1 = defpackage.cQ1.g(r0)
            if (r1 != 0) goto L9c
            kg2 r1 = defpackage.cQ1.h(r13)
            java.util.List r1 = defpackage.HE1.a(r1)
            int r13 = r13.length()
            r1.size()
            int r2 = defpackage.OG.c(r1)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r1 = r1.iterator()
            r4 = 0
            r5 = r4
        L28:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L85
            java.lang.Object r6 = r1.next()
            int r7 = r5 + 1
            if (r5 < 0) goto L7d
            java.lang.String r6 = (java.lang.String) r6
            r8 = 0
            if (r5 == 0) goto L3d
            if (r5 != r2) goto L45
        L3d:
            boolean r5 = defpackage.cQ1.g(r6)
            if (r5 == 0) goto L45
        L43:
            r6 = r8
            goto L76
        L45:
            int r5 = r6.length()
            r9 = r4
        L4a:
            r10 = -1
            if (r9 >= r5) goto L60
            char r11 = r6.charAt(r9)
            boolean r12 = java.lang.Character.isWhitespace(r11)
            if (r12 != 0) goto L5d
            boolean r11 = java.lang.Character.isSpaceChar(r11)
            if (r11 == 0) goto L61
        L5d:
            int r9 = r9 + 1
            goto L4a
        L60:
            r9 = r10
        L61:
            if (r9 != r10) goto L64
            goto L73
        L64:
            boolean r5 = r6.startsWith(r0, r9)
            if (r5 == 0) goto L73
            int r5 = r0.length()
            int r5 = r5 + r9
            java.lang.String r8 = r6.substring(r5)
        L73:
            if (r8 == 0) goto L76
            goto L43
        L76:
            if (r6 == 0) goto L7b
            r3.add(r6)
        L7b:
            r5 = r7
            goto L28
        L7d:
            java.lang.ArithmeticException r13 = new java.lang.ArithmeticException
            java.lang.String r0 = "Index overflow has happened."
            r13.<init>(r0)
            throw r13
        L85:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r13)
            java.lang.String r9 = "..."
            r10 = 0
            java.lang.String r5 = "\n"
            java.lang.String r7 = ""
            r8 = -1
            r4 = r0
            r6 = r7
            defpackage.MG.g(r3, r4, r5, r6, r7, r8, r9, r10)
            java.lang.String r13 = r0.toString()
            return r13
        L9c:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "marginPrefix must be non-blank string."
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.UP1.c(java.lang.String):java.lang.String");
    }
}
