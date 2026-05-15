package defpackage;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface b70 extends TextWatcher {
    @Override // android.text.TextWatcher
    default void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    default void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    default void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
