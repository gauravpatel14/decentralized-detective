package defpackage;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class XM2 implements Callable {
    public static final /* synthetic */ XM2 a = new XM2();

    @Override // java.util.concurrent.Callable
    public final Object call() {
        I33 i33 = new I33("internal.platform");
        i33.u.put("getVersion", new w33("getVersion"));
        return i33;
    }
}
