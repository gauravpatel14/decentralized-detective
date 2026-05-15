package defpackage;

import J.N;
import android.net.Uri;
import android.util.Base64InputStream;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.chromium.media.MediaPlayerBridge;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class QN0 extends AbstractC1103mg {
    public final String h;
    public File i;
    public final /* synthetic */ MediaPlayerBridge j;

    public QN0(MediaPlayerBridge mediaPlayerBridge, String str) {
        this.j = mediaPlayerBridge;
        this.h = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // defpackage.AbstractC1103mg
    public final Object b() throws Throwable {
        ?? r1;
        Throwable th;
        FileOutputStream fileOutputStream;
        Base64InputStream base64InputStream;
        byte[] bArr;
        Boolean bool = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                this.i = File.createTempFile("decoded", "mediadata");
                fileOutputStream = new FileOutputStream(this.i);
            } catch (Throwable th2) {
                r1 = bool;
                th = th2;
            }
        } catch (IOException unused) {
        }
        try {
            base64InputStream = new Base64InputStream(new ByteArrayInputStream(this.h.getBytes(StandardCharsets.UTF_8)), 0);
            bArr = new byte[1024];
        } catch (IOException unused2) {
            fileOutputStream2 = fileOutputStream;
            Boolean bool2 = Boolean.FALSE;
            KP1.a(fileOutputStream2);
            bool = bool2;
        } catch (Throwable th3) {
            th = th3;
            r1 = fileOutputStream;
            KP1.a(r1);
            throw th;
        }
        while (true) {
            int i = base64InputStream.read(bArr);
            if (i == -1) {
                break;
            }
            fileOutputStream.write(bArr, 0, i);
            return bool;
        }
        base64InputStream.close();
        bool = Boolean.TRUE;
        KP1.a(fileOutputStream);
        return bool;
    }

    @Override // defpackage.AbstractC1103mg
    public final void k(Object obj) {
        Boolean bool = (Boolean) obj;
        if (this.c.get()) {
            n();
            return;
        }
        boolean zBooleanValue = bool.booleanValue();
        MediaPlayerBridge mediaPlayerBridge = this.j;
        if (zBooleanValue) {
            try {
                mediaPlayerBridge.a().setDataSource(AbstractC1499tM.a, Uri.fromFile(this.i));
            } catch (IOException unused) {
                bool = Boolean.FALSE;
            }
        }
        n();
        N._V_ZJO(30, bool.booleanValue(), mediaPlayerBridge.c, mediaPlayerBridge);
    }

    public final void n() {
        File file = this.i;
        if (file == null || file.delete()) {
            return;
        }
        Log.e("cr_media", "Failed to delete temporary file: " + this.i);
    }
}
