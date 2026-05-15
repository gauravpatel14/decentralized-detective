package defpackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: iT0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CallableC0842iT0 implements Callable {
    public final File a;
    public final File b;
    public final yO c;
    public final oT0 d;

    public CallableC0842iT0(File file, File file2, yO yOVar) {
        oT0 ot0 = new oT0();
        this.a = file;
        this.b = file2;
        this.d = ot0;
        this.c = yOVar;
    }

    public final void a(String str, String str2) throws IOException {
        FileWriter fileWriter = new FileWriter(this.b, true);
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() / 1000);
        sb.append(",");
        sb.append(str2);
        if (str != null) {
            sb.append(",");
            sb.append(str);
        }
        sb.append('\n');
        try {
            fileWriter.write(sb.toString());
        } finally {
            fileWriter.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0194  */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Integer call() {
        /*
            Method dump skipped, instruction units count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.CallableC0842iT0.call():java.lang.Integer");
    }
}
