package defpackage;

import java.util.concurrent.Executor;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class L80 {
    public static final ThreadLocal a = new ThreadLocal();

    public static Executor a(CoreImpl coreImpl) {
        ThreadLocal threadLocal = a;
        Executor executor = (Executor) threadLocal.get();
        if (executor != null) {
            return executor;
        }
        K80 k80 = new K80(coreImpl);
        threadLocal.set(k80);
        return k80;
    }
}
