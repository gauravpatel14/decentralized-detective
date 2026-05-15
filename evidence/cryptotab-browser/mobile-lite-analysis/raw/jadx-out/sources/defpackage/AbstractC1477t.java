package defpackage;

import java.util.Set;

/* JADX INFO: renamed from: t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1477t {
    public Object a(Class cls) {
        InterfaceC0988kn1 interfaceC0988kn1B = b(cls);
        if (interfaceC0988kn1B == null) {
            return null;
        }
        return interfaceC0988kn1B.get();
    }

    public abstract InterfaceC0988kn1 b(Class cls);

    public Set c(Class cls) {
        return (Set) d(cls).get();
    }

    public abstract InterfaceC0988kn1 d(Class cls);
}
