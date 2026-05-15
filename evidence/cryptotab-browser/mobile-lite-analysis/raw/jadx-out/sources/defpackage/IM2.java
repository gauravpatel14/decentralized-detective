package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IM2 {
    public static final EM2 a(Object obj, Object obj2) {
        EM2 em2B = (EM2) obj;
        EM2 em2 = (EM2) obj2;
        if (!em2.isEmpty()) {
            if (!em2B.t) {
                em2B = em2B.b();
            }
            em2B.i();
            if (!em2.isEmpty()) {
                em2B.putAll(em2);
            }
        }
        return em2B;
    }
}
