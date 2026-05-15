package defpackage;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import org.chromium.mojo.system.MojoException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FW implements DJ {
    public final Set t = Collections.newSetFromMap(new WeakHashMap());

    @Override // defpackage.DJ
    public final void d(MojoException mojoException) {
        Iterator it = this.t.iterator();
        while (it.hasNext()) {
            ((DJ) it.next()).d(mojoException);
        }
    }
}
