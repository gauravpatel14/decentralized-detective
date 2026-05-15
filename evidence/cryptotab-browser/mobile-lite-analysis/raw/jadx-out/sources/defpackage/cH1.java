package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class cH1 {
    public final String a;
    public final String b;
    public final String c;
    public final bH1 d;

    public cH1(String str, String str2, String str3, bH1 bh1) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = bh1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.cH1 a(android.os.Bundle r9) {
        /*
            java.lang.String r0 = "androidx.browser.trusted.sharing.KEY_ACTION"
            java.lang.String r0 = r9.getString(r0)
            java.lang.String r1 = "androidx.browser.trusted.sharing.KEY_METHOD"
            java.lang.String r1 = r9.getString(r1)
            java.lang.String r2 = "androidx.browser.trusted.sharing.KEY_ENCTYPE"
            java.lang.String r2 = r9.getString(r2)
            java.lang.String r3 = "androidx.browser.trusted.sharing.KEY_PARAMS"
            android.os.Bundle r9 = r9.getBundle(r3)
            r3 = 0
            if (r9 != 0) goto L1d
            r4 = r3
            goto L6a
        L1d:
            java.lang.String r4 = "androidx.browser.trusted.sharing.KEY_FILES"
            java.util.ArrayList r4 = r9.getParcelableArrayList(r4)
            if (r4 == 0) goto L58
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r4 = r4.iterator()
        L2e:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L59
            java.lang.Object r6 = r4.next()
            android.os.Bundle r6 = (android.os.Bundle) r6
            if (r6 != 0) goto L3e
        L3c:
            r8 = r3
            goto L54
        L3e:
            java.lang.String r7 = "androidx.browser.trusted.sharing.KEY_FILE_NAME"
            java.lang.String r7 = r6.getString(r7)
            java.lang.String r8 = "androidx.browser.trusted.sharing.KEY_ACCEPTED_TYPES"
            java.util.ArrayList r6 = r6.getStringArrayList(r8)
            if (r7 == 0) goto L3c
            if (r6 != 0) goto L4f
            goto L3c
        L4f:
            aH1 r8 = new aH1
            r8.<init>(r7, r6)
        L54:
            r5.add(r8)
            goto L2e
        L58:
            r5 = r3
        L59:
            bH1 r4 = new bH1
            java.lang.String r6 = "androidx.browser.trusted.sharing.KEY_TITLE"
            java.lang.String r6 = r9.getString(r6)
            java.lang.String r7 = "androidx.browser.trusted.sharing.KEY_TEXT"
            java.lang.String r9 = r9.getString(r7)
            r4.<init>(r6, r9, r5)
        L6a:
            if (r0 == 0) goto L75
            if (r4 != 0) goto L6f
            goto L75
        L6f:
            cH1 r9 = new cH1
            r9.<init>(r0, r1, r2, r4)
            return r9
        L75:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cH1.a(android.os.Bundle):cH1");
    }
}
