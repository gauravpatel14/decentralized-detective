package defpackage;

import android.util.Pair;
import java.util.Iterator;
import java.util.LinkedList;
import org.chromium.base.task.PostTask;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class bz {
    public final LinkedList a = new LinkedList();
    public volatile boolean b;
    public final az c;

    public bz() {
        Object obj = PostTask.a;
        this.c = new az(this);
    }

    public final void a(Runnable runnable) {
        Object obj = PostTask.a;
        synchronized (this.a) {
            this.a.add(new Pair(7, runnable));
        }
    }

    public final void b(boolean z) {
        synchronized (this.a) {
        }
        if (this.a.isEmpty()) {
            return;
        }
        if (z) {
            PostTask.d(((Integer) ((Pair) this.a.peek()).first).intValue(), new Runnable() { // from class: Zy
                @Override // java.lang.Runnable
                public final void run() {
                    bz bzVar = this.t;
                    Iterator it = bzVar.a.iterator();
                    while (it.hasNext()) {
                        ((Runnable) ((Pair) it.next()).second).run();
                        if (bzVar.b) {
                            return;
                        }
                    }
                }
            });
        } else {
            PostTask.c(((Integer) ((Pair) this.a.peek()).first).intValue(), this.c);
        }
    }
}
