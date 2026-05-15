package defpackage;

/* JADX INFO: renamed from: Do2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0048Do2 {
    default AbstractC1867zo2 a(Class cls) {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }

    default AbstractC1867zo2 b(Class cls, C0533dW0 c0533dW0) {
        return a(cls);
    }

    default AbstractC1867zo2 c(iF iFVar, C0533dW0 c0533dW0) {
        return b(iFVar.a(), c0533dW0);
    }
}
