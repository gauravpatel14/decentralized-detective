package defpackage;

import org.chromium.components.background_task_scheduler.TaskInfo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class P62 implements TaskInfo.TimingInfo {
    public final /* synthetic */ int a = 0;
    public long b;
    public long c;
    public boolean d;
    public boolean e;

    public /* synthetic */ P62() {
    }

    @Override // org.chromium.components.background_task_scheduler.TaskInfo.TimingInfo
    public void a(Q62 q62) {
        q62.b(this);
    }

    public String toString() {
        switch (this.a) {
            case 1:
                StringBuilder sb = new StringBuilder("{intervalMs: ");
                sb.append(this.b);
                sb.append(", ");
                if (this.d) {
                    sb.append(", flexMs: ");
                    sb.append(this.c);
                    sb.append(", ");
                }
                sb.append("expiresAfterWindowEndTime (+flex): ");
                sb.append(this.e);
                sb.append("}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public P62(P62 p62) {
        this.b = p62.b;
        this.c = p62.c;
        this.d = p62.d;
        this.e = p62.e;
    }
}
