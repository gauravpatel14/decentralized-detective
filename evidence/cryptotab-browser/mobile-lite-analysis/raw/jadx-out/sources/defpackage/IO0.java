package defpackage;

import android.widget.SeekBar;
import androidx.mediarouter.app.d;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IO0 implements SeekBar.OnSeekBarChangeListener {
    public final AO0 t = new AO0(1, this);
    public final /* synthetic */ d u;

    public IO0(d dVar) {
        this.u = dVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            C0838iP0 c0838iP0 = (C0838iP0) seekBar.getTag();
            int i2 = d.I0;
            c0838iP0.h(i);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        d dVar = this.u;
        if (dVar.f0 != null) {
            dVar.d0.removeCallbacks(this.t);
        }
        dVar.f0 = (C0838iP0) seekBar.getTag();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        this.u.d0.postDelayed(this.t, 500L);
    }
}
