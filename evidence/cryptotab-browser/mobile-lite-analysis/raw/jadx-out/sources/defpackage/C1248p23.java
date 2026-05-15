package defpackage;

import android.os.Bundle;
import java.io.IOException;

/* JADX INFO: renamed from: p23, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1248p23 implements xN {
    public static final C1248p23 a = new C1248p23();

    @Override // defpackage.xN
    public final Object a(G62 g62) throws IOException {
        if (g62.k()) {
            return (Bundle) g62.h();
        }
        throw new IOException("SERVICE_NOT_AVAILABLE", g62.g());
    }
}
