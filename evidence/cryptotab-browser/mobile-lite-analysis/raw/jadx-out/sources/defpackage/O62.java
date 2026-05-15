package defpackage;

import org.chromium.components.background_task_scheduler.TaskInfo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class O62 implements TaskInfo.TimingInfo {
    public final long a;
    public final long b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public O62(N62 n62) {
        this.a = n62.a;
        this.b = n62.b;
        this.c = n62.c;
        this.d = n62.d;
        this.e = n62.e;
    }

    @Override // org.chromium.components.background_task_scheduler.TaskInfo.TimingInfo
    public final void a(Q62 q62) {
        q62.a(this);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (this.c) {
            sb.append("windowStartTimeMs: ");
            sb.append(this.a);
            sb.append(", ");
        }
        if (this.d) {
            sb.append("windowEndTimeMs: ");
            sb.append(this.b);
            sb.append(", ");
        }
        sb.append("expiresAfterWindowEndTime (+flex): ");
        sb.append(this.e);
        sb.append("}");
        return sb.toString();
    }
}
