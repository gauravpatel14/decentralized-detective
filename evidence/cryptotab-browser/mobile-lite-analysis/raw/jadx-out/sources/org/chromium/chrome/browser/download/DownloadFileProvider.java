package org.chromium.chrome.browser.download;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import defpackage.AbstractC1499tM;
import defpackage.F;
import defpackage.F10;
import defpackage.I10;
import defpackage.J10;
import defpackage.Xd0;
import defpackage.Zd0;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class DownloadFileProvider extends Zd0 {
    public static final String[] z = {"_display_name", "_size"};

    public static Uri f(String str, String str2) {
        return new Uri.Builder().scheme("content").authority(AbstractC1499tM.a.getPackageName() + ".DownloadFileProvider").path(str).appendQueryParameter("file", str2).build();
    }

    public static String g(Uri uri, F10 f10) {
        if (uri == null) {
            return null;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        if (path.charAt(0) == File.separatorChar && path.length() > 1) {
            path = path.substring(1);
        }
        String queryParameter = uri.getQueryParameter("file");
        String str = File.separator;
        if (queryParameter.contains(".." + str)) {
            return null;
        }
        if (path.equals("download")) {
            return J10.b() + str + queryParameter;
        }
        I10 i10A = F10.a();
        if (path.equals("external_volume")) {
            ArrayList arrayList = i10A.a;
            if (!arrayList.isEmpty()) {
                return F.b(((File) arrayList.get(0)).getAbsolutePath(), str, queryParameter);
            }
        }
        if (path.equals("download_external")) {
            ArrayList arrayList2 = i10A.b;
            if (!arrayList2.isEmpty()) {
                return F.b(((File) arrayList2.get(0)).getAbsolutePath(), str, queryParameter);
            }
        }
        return null;
    }

    @Override // defpackage.Zd0, android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    @Override // defpackage.Zd0, android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external deletes");
    }

    @Override // defpackage.Zd0, android.content.ContentProvider
    public final String getType(Uri uri) {
        if (uri == null) {
            return null;
        }
        String queryParameter = uri.getQueryParameter("file");
        if (TextUtils.isEmpty(queryParameter)) {
            return null;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(Uri.parse(queryParameter).toString()));
    }

    @Override // defpackage.Zd0, android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // defpackage.Zd0, android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        int i;
        String strG = g(uri, new F10());
        if (strG == null) {
            throw new FileNotFoundException();
        }
        if ("r".equals(str)) {
            i = 268435456;
        } else if ("w".equals(str) || "wt".equals(str)) {
            i = 738197504;
        } else if ("wa".equals(str)) {
            i = 704643072;
        } else if ("rw".equals(str)) {
            i = 939524096;
        } else {
            if (!"rwt".equals(str)) {
                throw new IllegalArgumentException(Xd0.a("Invalid mode: ", str));
            }
            i = 1006632960;
        }
        return ParcelFileDescriptor.open(new File(strG), i);
    }

    @Override // defpackage.Zd0, android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        if (strArr == null) {
            strArr = z;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        String strG = g(uri, new F10());
        if (TextUtils.isEmpty(strG)) {
            return new MatrixCursor(strArr3, 1);
        }
        File file = new File(strG);
        if (!file.exists() || !file.isFile()) {
            return new MatrixCursor(strArr3, 1);
        }
        int i2 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = file.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(file.length());
            }
            i2 = i;
        }
        String[] strArr4 = new String[i2];
        System.arraycopy(strArr3, 0, strArr4, 0, i2);
        Object[] objArr2 = new Object[i2];
        System.arraycopy(objArr, 0, objArr2, 0, i2);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // defpackage.Zd0, android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
