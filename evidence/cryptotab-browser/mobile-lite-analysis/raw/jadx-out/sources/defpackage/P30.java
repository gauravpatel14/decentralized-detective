package defpackage;

import android.content.ContentProvider;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class P30 implements ContentProvider.PipeDataWriter {
    @Override // android.content.ContentProvider.PipeDataWriter
    public final void writeDataToPipe(ParcelFileDescriptor parcelFileDescriptor, Uri uri, String str, Bundle bundle, Object obj) {
        byte[] bArr = (byte[]) obj;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
            if (bArr != null) {
                try {
                    fileOutputStream.write(bArr);
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            }
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception unused2) {
        }
    }
}
