package org.chromium.chrome.browser.pdf;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import defpackage.C0156Ne1;
import java.io.FileNotFoundException;
import java.util.HashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class PdfContentProvider extends ContentProvider {
    public static final String[] t = {"_display_name", "_size"};
    public static final Object u = new Object();
    public static final HashMap v = new HashMap();

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        if (r4.equals("application") == false) goto L24;
     */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String[] getStreamTypes(android.net.Uri r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.Object r0 = org.chromium.chrome.browser.pdf.PdfContentProvider.u
            monitor-enter(r0)
            r1 = 0
            if (r4 == 0) goto L52
            java.util.HashMap r2 = org.chromium.chrome.browser.pdf.PdfContentProvider.v     // Catch: java.lang.Throwable -> L50
            boolean r4 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L50
            if (r4 != 0) goto Lf
            goto L52
        Lf:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L50
            if (r5 != 0) goto L13
            goto L48
        L13:
            java.lang.String r4 = "application/pdf"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L1c
            goto L49
        L1c:
            java.lang.String r4 = "/pdf"
            boolean r4 = r5.endsWith(r4)
            if (r4 != 0) goto L2c
            java.lang.String r4 = "/*"
            boolean r4 = r5.endsWith(r4)
            if (r4 == 0) goto L48
        L2c:
            r4 = 47
            int r4 = r5.indexOf(r4)
            r0 = 0
            java.lang.String r4 = r5.substring(r0, r4)
            java.lang.String r5 = "*"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L49
            java.lang.String r5 = "application"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L48
            goto L49
        L48:
            return r1
        L49:
            java.lang.String r4 = "application/pdf"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            return r4
        L50:
            r4 = move-exception
            goto L54
        L52:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L50
            return r1
        L54:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L50
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.chrome.browser.pdf.PdfContentProvider.getStreamTypes(android.net.Uri, java.lang.String):java.lang.String[]");
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        synchronized (u) {
            if (uri != null) {
                try {
                    if (v.containsKey(uri)) {
                        return "application/pdf";
                    }
                } finally {
                }
            }
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        if (uri == null) {
            throw new FileNotFoundException("Cannot open an empty Uri.");
        }
        synchronized (u) {
            try {
                C0156Ne1 c0156Ne1 = (C0156Ne1) v.get(uri);
                if (c0156Ne1 == null) {
                    throw new FileNotFoundException("Uri has expired or doesn't exist.");
                }
                return c0156Ne1.c;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        synchronized (u) {
            char c = 0;
            if (uri != null) {
                HashMap map = v;
                if (map.containsKey(uri)) {
                    C0156Ne1 c0156Ne1 = (C0156Ne1) map.get(uri);
                    long statSize = c0156Ne1.c.getStatSize();
                    String str3 = c0156Ne1.b;
                    if (strArr == null) {
                        strArr = t;
                    }
                    int i = 0;
                    boolean z = false;
                    boolean z2 = false;
                    for (String str4 : strArr) {
                        if ("_display_name".equals(str4)) {
                            i++;
                            z = true;
                        } else if ("_size".equals(str4)) {
                            i++;
                            z2 = true;
                        }
                    }
                    String[] strArr3 = new String[i];
                    Object[] objArr = new Object[i];
                    if (z) {
                        strArr3[0] = "_display_name";
                        objArr[0] = str3;
                        c = 1;
                    }
                    if (z2) {
                        strArr3[c] = "_size";
                        objArr[c] = Long.valueOf(statSize);
                    }
                    MatrixCursor matrixCursor = new MatrixCursor(strArr3, 1);
                    matrixCursor.addRow(objArr);
                    return matrixCursor;
                }
            }
            return new MatrixCursor(t, 0);
        }
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }
}
