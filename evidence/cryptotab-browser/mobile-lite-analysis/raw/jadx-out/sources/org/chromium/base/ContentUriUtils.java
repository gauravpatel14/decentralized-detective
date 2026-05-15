package org.chromium.base;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import defpackage.AbstractC1499tM;
import defpackage.IL;
import defpackage.KP1;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContentUriUtils {
    public static IL a;
    public static final Object b = new Object();

    public static AssetFileDescriptor a(String str) {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        ContentResolver contentResolver = AbstractC1499tM.a.getContentResolver();
        Uri uri = Uri.parse(str);
        try {
            if (e(uri)) {
                String[] streamTypes = contentResolver.getStreamTypes(uri, "*/*");
                assetFileDescriptorOpenAssetFileDescriptor = (streamTypes == null || streamTypes.length <= 0) ? null : contentResolver.openTypedAssetFileDescriptor(uri, streamTypes[0], null);
            } else {
                assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
            }
            if (assetFileDescriptorOpenAssetFileDescriptor != null && assetFileDescriptorOpenAssetFileDescriptor.getStartOffset() != 0) {
                KP1.a(assetFileDescriptorOpenAssetFileDescriptor);
                throw new SecurityException("Cannot open files with non-zero offset type.");
            }
            return assetFileDescriptorOpenAssetFileDescriptor;
        } catch (Exception e) {
            Log.w("cr_ContentUriUtils", "Cannot open content uri: " + str, e);
            return null;
        }
    }

    public static Uri b(File file) {
        synchronized (b) {
            try {
                IL il = a;
                if (il == null) {
                    return null;
                }
                return il.a(file);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String c(Context context, Uri uri) {
        String[] streamTypes;
        String extensionFromMimeType;
        if (uri == null) {
            return "";
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() >= 1) {
                        cursorQuery.moveToFirst();
                        int columnIndex = cursorQuery.getColumnIndex("_display_name");
                        if (columnIndex == -1) {
                            return "";
                        }
                        String string = cursorQuery.getString(columnIndex);
                        int columnIndex2 = cursorQuery.getColumnIndex("flags");
                        if (columnIndex2 > -1 && (cursorQuery.getLong(columnIndex2) & 512) != 0 && (streamTypes = contentResolver.getStreamTypes(uri, "*/*")) != null && streamTypes.length > 0 && (extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(streamTypes[0])) != null) {
                            string = string + "." + extensionFromMimeType;
                        }
                        cursorQuery.close();
                        return string;
                    }
                } finally {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused) {
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (NullPointerException unused2) {
        }
        return "";
    }

    public static boolean contentUriExists(String str) {
        AssetFileDescriptor assetFileDescriptorA = a(str);
        boolean z = assetFileDescriptorA != null;
        if (assetFileDescriptorA != null) {
            try {
                assetFileDescriptorA.close();
            } catch (IOException unused) {
            }
        }
        return z;
    }

    public static boolean d(String str) {
        Uri uri;
        return (str == null || (uri = Uri.parse(str)) == null || !"content".equals(uri.getScheme())) ? false : true;
    }

    public static boolean delete(String str) {
        return AbstractC1499tM.a.getContentResolver().delete(Uri.parse(str), null, null) > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean e(android.net.Uri r8) {
        /*
            r0 = 0
            if (r8 != 0) goto L4
            return r0
        L4:
            android.content.Context r1 = defpackage.AbstractC1499tM.a
            boolean r1 = android.provider.DocumentsContract.isDocumentUri(r1, r8)
            if (r1 != 0) goto Ld
            return r0
        Ld:
            android.content.Context r1 = defpackage.AbstractC1499tM.a
            android.content.ContentResolver r2 = r1.getContentResolver()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r8
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.NullPointerException -> L4e
            if (r8 == 0) goto L49
            int r1 = r8.getCount()     // Catch: java.lang.Throwable -> L44
            r2 = 1
            if (r1 < r2) goto L49
            r8.moveToFirst()     // Catch: java.lang.Throwable -> L44
            java.lang.String r1 = "flags"
            int r1 = r8.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L44
            r3 = -1
            if (r1 <= r3) goto L3f
            long r3 = r8.getLong(r1)     // Catch: java.lang.Throwable -> L44
            r5 = 512(0x200, double:2.53E-321)
            long r3 = r3 & r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L3f
            goto L40
        L3f:
            r2 = r0
        L40:
            r8.close()     // Catch: java.lang.NullPointerException -> L4e
            return r2
        L44:
            r1 = move-exception
            r8.close()     // Catch: java.lang.Throwable -> L48
        L48:
            throw r1     // Catch: java.lang.NullPointerException -> L4e
        L49:
            if (r8 == 0) goto L4e
            r8.close()     // Catch: java.lang.NullPointerException -> L4e
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.base.ContentUriUtils.e(android.net.Uri):boolean");
    }

    public static long getContentUriFileSize(String str) {
        AssetFileDescriptor assetFileDescriptorA = a(str);
        long length = assetFileDescriptorA != null ? assetFileDescriptorA.getLength() : -1L;
        KP1.a(assetFileDescriptorA);
        return length;
    }

    public static String getContentUriFromFilePath(String str) {
        try {
            Uri uriB = b(new File(str));
            if (uriB != null) {
                return uriB.toString();
            }
            return null;
        } catch (IllegalArgumentException e) {
            Log.e("cr_ContentUriUtils", "Cannot retrieve content uri from file: " + str, e);
            return null;
        }
    }

    public static String getMimeType(String str) {
        ContentResolver contentResolver = AbstractC1499tM.a.getContentResolver();
        Uri uri = Uri.parse(str);
        if (!e(uri)) {
            return contentResolver.getType(uri);
        }
        String[] streamTypes = contentResolver.getStreamTypes(uri, "*/*");
        if (streamTypes == null || streamTypes.length <= 0) {
            return null;
        }
        return streamTypes[0];
    }

    public static String maybeGetDisplayName(String str) {
        try {
            String strC = c(AbstractC1499tM.a, Uri.parse(str));
            if (TextUtils.isEmpty(strC)) {
                return null;
            }
            return strC;
        } catch (Exception e) {
            Log.w("cr_ContentUriUtils", "Cannot open content uri: " + str, e);
            return null;
        }
    }

    public static int openContentUriForRead(String str) {
        AssetFileDescriptor assetFileDescriptorA = a(str);
        if (assetFileDescriptorA != null) {
            return assetFileDescriptorA.getParcelFileDescriptor().detachFd();
        }
        return -1;
    }
}
