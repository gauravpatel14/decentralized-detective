package defpackage;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* JADX INFO: renamed from: mb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1102mb {
    public final EditText a;
    public final C1540u60 b;

    public C1102mb(EditText editText) {
        this.a = editText;
        this.b = new C1540u60(editText);
    }

    public final KeyListener a(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        this.b.getClass();
        if (keyListener instanceof A60) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new A60(keyListener);
    }

    public final void b(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, AbstractC0305Yp1.AppCompatTextView, i, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(AbstractC0305Yp1.AppCompatTextView_emojiCompatEnabled) ? typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.AppCompatTextView_emojiCompatEnabled, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            H60 h60 = this.b.b;
            if (h60.u != z) {
                h60.u = z;
                if (z) {
                    AbstractC1481t60.a();
                    throw null;
                }
            }
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final InputConnection c(InputConnection inputConnection) {
        C1540u60 c1540u60 = this.b;
        c1540u60.getClass();
        if (inputConnection == null) {
            return null;
        }
        return inputConnection instanceof C1712x60 ? inputConnection : new C1712x60(c1540u60.a, inputConnection);
    }
}
