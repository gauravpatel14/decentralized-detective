package defpackage;

import J.N;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: zO1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1841zO1 implements Zu1 {
    public Bitmap a;
    public final XZ0 b;
    public final Rect c;

    public C1841zO1(Bitmap bitmap) {
        int i;
        int i2;
        this.a = bitmap;
        XZ0 xz0 = null;
        if (bitmap != null) {
            try {
                byte[] ninePatchChunk = bitmap.getNinePatchChunk();
                if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
                    ByteBuffer byteBufferOrder = ByteBuffer.wrap(ninePatchChunk).order(ByteOrder.nativeOrder());
                    if (byteBufferOrder.get() != 0 && (i = byteBufferOrder.get()) != 0 && (i & 1) == 0 && (i2 = byteBufferOrder.get()) != 0 && (i2 & 1) == 0) {
                        byteBufferOrder.get();
                        byteBufferOrder.getInt();
                        byteBufferOrder.getInt();
                        Rect rect = new Rect();
                        rect.left = byteBufferOrder.getInt();
                        rect.right = byteBufferOrder.getInt();
                        rect.top = byteBufferOrder.getInt();
                        rect.bottom = byteBufferOrder.getInt();
                        byteBufferOrder.getInt();
                        int[] iArr = new int[i];
                        for (int i3 = 0; i3 < i; i3++) {
                            iArr[i3] = byteBufferOrder.getInt();
                        }
                        int[] iArr2 = new int[i2];
                        for (int i4 = 0; i4 < i2; i4++) {
                            iArr2[i4] = byteBufferOrder.getInt();
                        }
                        xz0 = new XZ0(bitmap.getWidth(), bitmap.getHeight(), rect, iArr, iArr2);
                    }
                }
            } catch (BufferUnderflowException unused) {
            }
        }
        this.b = xz0;
        this.c = new Rect(0, 0, this.a.getWidth(), this.a.getHeight());
    }

    @Override // defpackage.Zu1
    public final Rect a() {
        return this.c;
    }

    @Override // defpackage.Zu1
    public final XZ0 b() {
        return this.b;
    }

    @Override // defpackage.Zu1
    public final Bitmap c() {
        Bitmap bitmap = this.a;
        this.a = null;
        return bitmap;
    }

    @Override // defpackage.Zu1
    public final long d() {
        XZ0 xz0 = this.b;
        if (xz0 == null) {
            return N._J(26);
        }
        Rect rect = xz0.a;
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        Rect rect2 = xz0.b;
        return N._J_IIIIIIII(0, i, i2, i3, i4, rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    @Override // defpackage.Zu1
    public final boolean e() {
        return false;
    }
}
