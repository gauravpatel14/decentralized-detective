package defpackage;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class aj0 {
    public final Zi0 a;
    public ByteBuffer b;
    public Bitmap c;

    public aj0() {
        Zi0 zi0 = new Zi0();
        zi0.f = -1;
        this.a = zi0;
        this.b = null;
        this.c = null;
    }

    public final ByteBuffer a() {
        Bitmap bitmap = this.c;
        if (bitmap == null) {
            return this.b;
        }
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = this.c.getHeight();
        int i = width * height;
        this.c.getPixels(new int[i], 0, width, 0, 0, width, height);
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((Color.blue(r9[i2]) * 0.114f) + (Color.green(r9[i2]) * 0.587f) + (Color.red(r9[i2]) * 0.299f));
        }
        return ByteBuffer.wrap(bArr);
    }
}
