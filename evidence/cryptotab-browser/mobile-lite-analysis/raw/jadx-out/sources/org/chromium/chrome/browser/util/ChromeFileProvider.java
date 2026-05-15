package org.chromium.chrome.browser.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import defpackage.Zd0;
import java.util.Arrays;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ChromeFileProvider extends Zd0 {
    public static final Object z = new Object();

    public static Uri f(Uri uri) {
        if (uri == null || !uri.getPath().contains("BlockedFile_")) {
            return uri;
        }
        synchronized (z) {
        }
        return null;
    }

    @Override // defpackage.Zd0, android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        if (uri == null || !uri.getPath().contains("BlockedFile_")) {
            return super.delete(uri, str, strArr);
        }
        synchronized (z) {
        }
        return 0;
    }

    @Override // defpackage.Zd0, android.content.ContentProvider
    public final String getType(Uri uri) {
        Uri uriF = f(uri);
        if (uriF != null) {
            return super.getType(uriF);
        }
        return null;
    }

    @Override // defpackage.Zd0, android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str) {
        Uri uriF = f(uri);
        if (uriF != null) {
            return super.openFile(uriF, str);
        }
        return null;
    }

    @Override // defpackage.Zd0, android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String[] strArr3;
        Uri uriF = f(uri);
        if (uriF == null) {
            return null;
        }
        Cursor cursorQuery = super.query(uriF, strArr, str, strArr2, str2);
        MatrixCursor matrixCursor = (MatrixCursor) cursorQuery;
        String[] columnNames = matrixCursor.getColumnNames();
        int length = columnNames.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                strArr3 = (String[]) Arrays.copyOf(columnNames, columnNames.length + 1);
                strArr3[columnNames.length] = "_data";
                break;
            }
            if ("_data".equals(columnNames[i])) {
                strArr3 = columnNames;
                break;
            }
            i++;
        }
        if (columnNames == strArr3) {
            return cursorQuery;
        }
        MatrixCursor matrixCursor2 = new MatrixCursor(strArr3, matrixCursor.getCount());
        cursorQuery.moveToPosition(-1);
        while (cursorQuery.moveToNext()) {
            MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor2.newRow();
            for (int i2 = 0; i2 < columnNames.length; i2++) {
                int type = matrixCursor.getType(i2);
                if (type == 1) {
                    rowBuilderNewRow.add(Integer.valueOf(matrixCursor.getInt(i2)));
                } else if (type == 2) {
                    rowBuilderNewRow.add(Float.valueOf(matrixCursor.getFloat(i2)));
                } else if (type == 3) {
                    rowBuilderNewRow.add(matrixCursor.getString(i2));
                } else if (type != 4) {
                    rowBuilderNewRow.add(null);
                } else {
                    rowBuilderNewRow.add(matrixCursor.getBlob(i2));
                }
            }
        }
        cursorQuery.close();
        return matrixCursor2;
    }
}
