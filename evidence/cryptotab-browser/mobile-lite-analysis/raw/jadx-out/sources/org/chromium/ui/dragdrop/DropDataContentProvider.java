package org.chromium.ui.dragdrop;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.webkit.MimeTypeMap;
import defpackage.AbstractC1499tM;
import defpackage.Gr1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class DropDataContentProvider extends ContentProvider {
    public DropDataProviderImpl t;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        final DropDataProviderImpl dropDataProviderImpl;
        dropDataProviderImpl = this.t;
        dropDataProviderImpl.getClass();
        str.getClass();
        switch (str) {
            case "onDragEnd":
                if (bundle.getBoolean("imageIsInUse")) {
                    synchronized (DropDataProviderImpl.p) {
                        if (dropDataProviderImpl.f == null) {
                            dropDataProviderImpl.f = new Handler(Looper.getMainLooper());
                        }
                        dropDataProviderImpl.f.postDelayed(new Runnable() { // from class: O30
                            @Override // java.lang.Runnable
                            public final void run() {
                                dropDataProviderImpl.a();
                            }
                        }, dropDataProviderImpl.a);
                        dropDataProviderImpl.g = SystemClock.elapsedRealtime();
                        break;
                    }
                } else {
                    dropDataProviderImpl.a();
                }
                return null;
            case "cache":
                Bundle bundle2 = new Bundle();
                byte[] bArr = (byte[]) bundle.getSerializable("bytes");
                String string = bundle.getString("imageContentExtension");
                String string2 = bundle.getString("imageFilename");
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j = dropDataProviderImpl.k;
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(string);
                Uri uriBuild = new Uri.Builder().scheme("content").authority(AbstractC1499tM.a.getPackageName() + ".DropDataProvider").path(String.valueOf(System.currentTimeMillis())).build();
                synchronized (DropDataProviderImpl.p) {
                    dropDataProviderImpl.b();
                    dropDataProviderImpl.k = jElapsedRealtime;
                    dropDataProviderImpl.b = bArr;
                    dropDataProviderImpl.c = string2;
                    dropDataProviderImpl.d = mimeTypeFromExtension;
                    dropDataProviderImpl.g = 0L;
                    dropDataProviderImpl.h = 0L;
                    dropDataProviderImpl.e = uriBuild;
                    break;
                }
                if (j > 0) {
                    Gr1.k(jElapsedRealtime - j, "Android.DragDrop.Image.UriCreatedInterval");
                }
                Gr1.f(bArr.length / 1024, 1, 100000, 50, "Android.DragDrop.Image.Size");
                bundle2.putParcelable("uri", uriBuild);
                return bundle2;
            case "setClearCachedDataIntervalMs":
                int i = bundle.getInt("clearCacheDelayedMs", 60000);
                synchronized (DropDataProviderImpl.p) {
                    dropDataProviderImpl.a = i;
                    break;
                }
                return null;
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public final String[] getStreamTypes(Uri uri, String str) {
        String[] strArr;
        DropDataProviderImpl dropDataProviderImpl = this.t;
        dropDataProviderImpl.getClass();
        synchronized (DropDataProviderImpl.p) {
            strArr = null;
            if (uri != null) {
                if (uri.equals(dropDataProviderImpl.e)) {
                    String str2 = dropDataProviderImpl.d;
                    if (str2 != null && str != null) {
                        int iIndexOf = str2.indexOf(47);
                        String strSubstring = str2.substring(0, iIndexOf);
                        String strSubstring2 = str2.substring(iIndexOf + 1);
                        int iIndexOf2 = str.indexOf(47);
                        String strSubstring3 = str.substring(0, iIndexOf2);
                        String strSubstring4 = str.substring(iIndexOf2 + 1);
                        if ((strSubstring3.equals("*") || strSubstring3.equals(strSubstring)) && (strSubstring4.equals("*") || strSubstring4.equals(strSubstring2))) {
                            strArr = new String[]{str2};
                        }
                    }
                }
            }
        }
        return strArr;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return this.t.c(uri);
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        this.t = new DropDataProviderImpl();
        return true;
    }

    @Override // android.content.ContentProvider
    public final AssetFileDescriptor openAssetFile(Uri uri, String str) {
        return this.t.d(this, uri);
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str) {
        AssetFileDescriptor assetFileDescriptorD = this.t.d(this, uri);
        if (assetFileDescriptorD != null) {
            return assetFileDescriptorD.getParcelFileDescriptor();
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        MatrixCursor matrixCursor;
        DropDataProviderImpl dropDataProviderImpl = this.t;
        dropDataProviderImpl.getClass();
        synchronized (DropDataProviderImpl.p) {
            char c = 0;
            if (uri == null) {
                matrixCursor = new MatrixCursor(DropDataProviderImpl.o, 0);
            } else if (uri.equals(dropDataProviderImpl.e)) {
                byte[] bArr = dropDataProviderImpl.b;
                String str3 = dropDataProviderImpl.c;
                if (strArr == null) {
                    strArr = DropDataProviderImpl.o;
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
                    objArr[c] = Integer.valueOf(bArr.length);
                }
                matrixCursor = new MatrixCursor(strArr3, 1);
                matrixCursor.addRow(objArr);
            } else {
                matrixCursor = new MatrixCursor(DropDataProviderImpl.o, 0);
            }
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }
}
