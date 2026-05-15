package defpackage;

import android.content.IntentFilter;
import android.media.AudioManager;
import android.util.Log;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Jg extends AbstractC0066Fg {
    public int d;
    public boolean e;
    public boolean[] f;
    public C0101Ig g;

    @Override // defpackage.AbstractC0066Fg
    public final void a() {
        this.b.b();
        if (this.e) {
            AbstractC1499tM.a.unregisterReceiver(this.g);
            this.g = null;
        }
    }

    @Override // defpackage.AbstractC0066Fg
    public final boolean[] b() {
        boolean[] zArr = (boolean[]) this.f.clone();
        if (zArr[1]) {
            zArr[4] = false;
            zArr[2] = false;
        } else if (zArr[4]) {
            zArr[2] = false;
        }
        return zArr;
    }

    @Override // defpackage.AbstractC0066Fg
    public final void c() {
        boolean z = AbstractC1499tM.a.checkSelfPermission("android.permission.BLUETOOTH") == 0;
        this.e = z;
        this.b.e(z);
        if (this.e) {
            IntentFilter intentFilter = new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
            C0101Ig c0101Ig = new C0101Ig(this);
            this.g = c0101Ig;
            AbstractC1499tM.d(AbstractC1499tM.a, c0101Ig, intentFilter);
        }
    }

    @Override // defpackage.AbstractC0066Fg
    public final boolean d() {
        return this.c.isSpeakerphoneOn();
    }

    @Override // defpackage.AbstractC0066Fg
    public final void f(int i) {
        int i2;
        if (i != 3) {
            j();
        } else if (this.e && (i2 = this.d) != 1 && i2 != 2) {
            AudioManager audioManager = this.c;
            if (audioManager.isBluetoothScoOn()) {
                this.d = 1;
            } else {
                this.d = 2;
                audioManager.startBluetoothSco();
            }
        }
        if (i == 0) {
            i(true);
            return;
        }
        if (i == 1) {
            i(false);
            return;
        }
        if (i == 2) {
            i(false);
        } else if (i != 3) {
            if (i != 4) {
                Log.e("cr_media", "Invalid audio device selection");
            } else {
                i(false);
            }
        }
    }

    @Override // defpackage.AbstractC0066Fg
    public final void g(boolean z) {
        if (z) {
            return;
        }
        j();
        C0056Eg c0056Eg = this.a;
        synchronized (c0056Eg.a) {
            c0056Eg.b = -1;
        }
    }

    @Override // defpackage.AbstractC0066Fg
    public final void h(int i, boolean z) {
        this.f[i] = z;
    }

    @Override // defpackage.AbstractC0066Fg
    public final void i(boolean z) {
        AudioManager audioManager = this.c;
        if (audioManager.isSpeakerphoneOn() == z) {
            return;
        }
        audioManager.setSpeakerphoneOn(z);
    }

    public final void j() {
        if (this.e) {
            int i = this.d;
            if (i == 1 || i == 2) {
                AudioManager audioManager = this.c;
                if (audioManager.isBluetoothScoOn()) {
                    this.d = 3;
                    audioManager.stopBluetoothSco();
                } else {
                    Log.e("cr_media", "Unable to stop BT SCO since it is already disabled");
                    this.d = 0;
                }
            }
        }
    }
}
