package defpackage;

import android.media.MediaFormat;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: vN0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1611vN0 {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:146:0x018d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0191  */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.media.MediaFormat r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC1611vN0.a(android.media.MediaFormat, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0065 A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:10:0x0014, B:22:0x0039, B:25:0x0042, B:40:0x0065, B:41:0x006a, B:47:0x007c, B:48:0x0081, B:49:0x013a), top: B:55:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:10:0x0014, B:22:0x0039, B:25:0x0042, B:40:0x0065, B:41:0x006a, B:47:0x007c, B:48:0x0081, B:49:0x013a), top: B:55:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.media.MediaFormat b(java.lang.String r16, int r17, int r18, byte[][] r19, org.chromium.media.HdrMetadata r20, boolean r21) {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC1611vN0.b(java.lang.String, int, int, byte[][], org.chromium.media.HdrMetadata, boolean):android.media.MediaFormat");
    }

    public static void c(MediaFormat mediaFormat, byte[][] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i].length != 0) {
                mediaFormat.setByteBuffer(AbstractC1214oR1.a(i, "csd-"), ByteBuffer.wrap(bArr[i]));
            }
        }
    }
}
