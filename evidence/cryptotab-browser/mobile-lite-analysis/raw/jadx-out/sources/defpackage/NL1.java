package defpackage;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class NL1 extends cs1 {
    public boolean a = false;
    public final /* synthetic */ A81 b;

    public NL1(A81 a81) {
        this.b = a81;
    }

    @Override // defpackage.cs1
    public final void a(int i) {
        if (i == 0 && this.a) {
            this.a = false;
            this.b.h();
        }
    }

    @Override // defpackage.cs1
    public final void b(RecyclerView recyclerView, int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        this.a = true;
    }
}
