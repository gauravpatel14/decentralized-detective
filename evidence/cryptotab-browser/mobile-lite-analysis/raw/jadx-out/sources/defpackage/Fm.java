package defpackage;

import android.content.Context;
import org.chromium.components.background_task_scheduler.TaskInfo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Fm implements Q62 {
    public final Context a;
    public final TaskInfo b;
    public boolean c;
    public final /* synthetic */ Gm d;

    public Fm(Gm gm, Context context, TaskInfo taskInfo) {
        this.d = gm;
        this.a = context;
        this.b = taskInfo;
    }

    @Override // defpackage.Q62
    public final void a(O62 o62) {
        this.c = this.d.a.b(this.a, this.b);
    }

    @Override // defpackage.Q62
    public final void b(P62 p62) {
        this.c = this.d.a.b(this.a, this.b);
    }
}
