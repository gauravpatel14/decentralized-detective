package defpackage;

import android.widget.SeekBar;
import androidx.mediarouter.app.d;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HO0 extends dP0 {
    public final /* synthetic */ d a;

    public HO0(d dVar) {
        this.a = dVar;
    }

    @Override // defpackage.dP0
    public final void e(C1087mP0 c1087mP0, C0838iP0 c0838iP0) {
        this.a.t(true);
    }

    @Override // defpackage.dP0
    public final void h() {
        this.a.t(false);
    }

    @Override // defpackage.dP0
    public final void j(C0838iP0 c0838iP0) {
        d dVar = this.a;
        SeekBar seekBar = (SeekBar) dVar.k0.get(c0838iP0);
        int i = c0838iP0.p;
        int i2 = d.I0;
        if (seekBar == null || dVar.f0 == c0838iP0) {
            return;
        }
        seekBar.setProgress(i);
    }
}
