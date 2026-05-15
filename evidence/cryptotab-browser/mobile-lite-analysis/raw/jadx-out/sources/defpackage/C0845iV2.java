package defpackage;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: iV2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0845iV2 implements InterfaceC1157nX2 {
    public final /* synthetic */ HashSet a;
    public final /* synthetic */ GF2 b;
    public final /* synthetic */ ZipFile c;

    public C0845iV2(HashSet hashSet, GF2 gf2, ZipFile zipFile) {
        this.a = hashSet;
        this.b = gf2;
        this.c = zipFile;
    }

    @Override // defpackage.InterfaceC1157nX2
    public final void a(C1281pY2 c1281pY2, File file, boolean z) throws IllegalAccessException, IOException, InvocationTargetException {
        this.a.add(file);
        if (z) {
            return;
        }
        GF2 gf2 = this.b;
        String str = gf2.b;
        String absolutePath = gf2.a.getAbsolutePath();
        ZipEntry zipEntry = c1281pY2.b;
        Log.i("SplitCompat", "NativeLibraryExtractor: split '" + str + "' has native library '" + c1281pY2.a + "' that does not exist; extracting from '" + absolutePath + "!" + zipEntry.getName() + "' to '" + file.getAbsolutePath() + "'");
        byte[] bArr = new byte[4096];
        if (file.exists()) {
            file.delete();
        }
        InputStream inputStream = this.c.getInputStream(zipEntry);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                file.setWritable(false, true);
                file.setWritable(false, false);
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        fileOutputStream.close();
                        inputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } finally {
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                }
            }
            throw th;
        }
    }
}
