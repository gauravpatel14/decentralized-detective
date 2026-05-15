package defpackage;

import java.io.IOException;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.ResultAnd;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class gK implements InterfaceC0177Oq2 {
    public final /* synthetic */ hK t;

    public gK(hK hKVar) {
        this.t = hKVar;
    }

    @Override // defpackage.InterfaceC0177Oq2
    public final void a(int i) throws IOException {
        ResultAnd resultAndA;
        hK hKVar = this.t;
        hKVar.getClass();
        if (i != 0) {
            MojoException mojoException = new MojoException(i);
            hKVar.close();
            DJ dj = hKVar.x;
            if (dj != null) {
                dj.d(mojoException);
                return;
            }
            return;
        }
        do {
            try {
                resultAndA = hK.a(hKVar.u, hKVar.w);
            } catch (MojoException e) {
                hKVar.close();
                DJ dj2 = hKVar.x;
                if (dj2 != null) {
                    dj2.d(e);
                    return;
                }
                return;
            }
        } while (((Boolean) resultAndA.b).booleanValue());
        int i2 = resultAndA.a;
        if (i2 != 17) {
            MojoException mojoException2 = new MojoException(i2);
            hKVar.close();
            DJ dj3 = hKVar.x;
            if (dj3 != null) {
                dj3.d(mojoException2);
            }
        }
    }
}
