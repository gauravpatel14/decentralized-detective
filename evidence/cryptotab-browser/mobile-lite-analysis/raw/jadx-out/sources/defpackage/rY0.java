package defpackage;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class rY0 {
    public static final /* synthetic */ int b = 0;
    public final int a;

    static {
        new rY0("undefined");
        new rY0("undefined");
        new rY0("test");
    }

    public rY0(String str) {
        long j = 0;
        for (byte b2 : str.getBytes(StandardCharsets.UTF_8)) {
            j = ((j * 31) + ((long) b2)) % 138003713;
        }
        this.a = (int) j;
    }
}
