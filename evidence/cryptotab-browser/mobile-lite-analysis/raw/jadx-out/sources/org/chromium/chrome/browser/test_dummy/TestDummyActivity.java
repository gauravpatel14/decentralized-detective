package org.chromium.chrome.browser.test_dummy;

import defpackage.AbstractC1190o72;
import defpackage.CH;
import defpackage.Fa;
import defpackage.OE0;
import defpackage.fx0;
import defpackage.p72;
import defpackage.tU0;
import org.chromium.chrome.browser.test_dummy.TestDummyActivity;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class TestDummyActivity extends Fa {
    public static final /* synthetic */ int U = 0;

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (!CH.c().e("enable-test-dummy-module")) {
            finish();
            return;
        }
        OE0.h.a();
        tU0 tu0 = AbstractC1190o72.a;
        if (tu0.g()) {
            ((p72) tu0.b()).a().a(getIntent(), this);
        } else {
            tu0.e(new fx0() { // from class: m72
                @Override // defpackage.fx0
                public final void a(boolean z) {
                    int i = TestDummyActivity.U;
                    TestDummyActivity testDummyActivity = this.a;
                    testDummyActivity.getClass();
                    if (!z) {
                        throw new RuntimeException("Failed to install module");
                    }
                    ((p72) AbstractC1190o72.a.b()).a().a(testDummyActivity.getIntent(), testDummyActivity);
                }
            });
        }
    }
}
